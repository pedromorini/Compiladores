/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.la.semantico;

import br.ufscar.dc.compiladores.la.semantico.TabelaDeSimbolos.TipoLA;
import static br.ufscar.dc.compiladores.la.semantico.TabelaDeSimbolos.TipoLA.Inteiro;
import static br.ufscar.dc.compiladores.la.semantico.TabelaDeSimbolos.TipoLA.Literal;
import static br.ufscar.dc.compiladores.la.semantico.TabelaDeSimbolos.TipoLA.Real;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class LAGeradorC extends LABaseVisitor<Void>{
    StringBuilder saida;
    TabelaDeSimbolos tabela;
    
    List<String> struct = new ArrayList<String>();
    List<TipoLA> structTipo = new ArrayList<TipoLA>();
    
    Boolean decRegistro = false;
    Boolean isRegistro = false;
    String nomeRegistro;
    
    public LAGeradorC(){
        saida = new StringBuilder();
        this.tabela = new  TabelaDeSimbolos();
    }
    
    // Método para vrificar o tipo do identificador
    public TipoLA verificarTipoVar(String tipo){
        
        switch(tipo){
            case "literal":
                return TabelaDeSimbolos.TipoLA.Literal;
            case "inteiro":
                return TabelaDeSimbolos.TipoLA.Inteiro;
            case "real":
                return TabelaDeSimbolos.TipoLA.Real;
            case "logico":
                return TabelaDeSimbolos.TipoLA.Logico;
            default:
                return TabelaDeSimbolos.TipoLA.Invalido;
        }
    }
    
    // Método para identificar o tipo em C que será escrito
    public String verificaTipo(String tipo){
        String ret = null;
        
        switch(tipo){
            case "inteiro":
                ret = "int";
                break;
            case "real": 
                ret = "real";
                break;
            case "literal":
                ret = "char";
                break;
            default:
                break;
        }
        
        return ret;
    }
    
    @Override
    public Void visitPrograma(LAParser.ProgramaContext ctx){
        
        // Includes
        saida.append("#include <stdio.h>\n");
        saida.append("#include <stdlib.h>\n");
        saida.append("\n");
        
        // Declarações
        ctx.declaracoes().decl_local_global().forEach(dec -> visitDecl_local_global(dec));
        
        saida.append("int main(){\n");
        
        // Corpo do programa
        ctx.corpo().declaracao_local().forEach(dec -> visitDeclaracao_local(dec));
        ctx.corpo().cmd().forEach(cmd -> visitCmd(cmd));
        
        // Fechamento da main
        saida.append("\treturn 0;\n");
        saida.append("}\n");
        
        return null;
    }
    
    @Override
    public Void visitDeclaracao_local(LAParser.Declaracao_localContext ctx){
        if(ctx.getText().startsWith("declare")){
            visitVariavel(ctx.variavel());
        }else if(ctx.getText().startsWith("constante")){
            saida.append("#define " + ctx.IDENT().getText() + " " + ctx.valor_constante().getText() + "\n");
        }else if(ctx.getText().startsWith("tipo")){
            saida.append("\ttypedef struct{\n");
            visitTipo(ctx.tipo());
            saida.append("\t} ");
            saida.append(ctx.IDENT().getText());
            saida.append(";\n");
        }      
        return null;
    }
    
    @Override
    public Void visitVariavel(LAParser.VariavelContext ctx) {
        
        TipoLA tipoLA = TipoLA.Invalido;
        String tipoVar = ctx.tipo().getText();
        String nomeVar;
        
        // no caso de ser ponteiro simplifica a verificação
        if(tipoVar.charAt(0) == '^'){
            tipoVar = tipoVar.substring(1);
        }
        
        // Verifica se é registro
        if(ctx.tipo().registro() == null){
           
            
            switch(tipoVar){
                case "inteiro":
     
                    tipoVar = "int";
                    tipoLA = TipoLA.Inteiro;
                    break;
                case "real":
             
                    tipoVar = "float";
                    tipoLA = TipoLA.Real;
                    break;
                case "literal":
               
                    tipoVar = "char";
                    tipoLA = TipoLA.Literal;
                    break;
                case "logico":
          
                    tipoLA = TipoLA.Logico;
                    break;
                default:
                    decRegistro = true;
                    break;
            }
            
            // No caso do tipo da variável não ser nenhum dos verificados acima
            if(decRegistro){
                for(Integer i = 0; i < struct.size(); i++){
                    tabela.adicionar(struct.get(i), structTipo.get(i)); //salva as infos da struct
                }
            }

            if(ctx.tipo().tipo_estendido() != null){
                if(ctx.tipo().tipo_estendido().getText().startsWith("^")){ //caso seja ponteiro
                    saida.append("\t" + tipoVar + "* ");
                }
                else{ // caso não seja ponteiro
                    saida.append("\t" + tipoVar + " ");
                }
            }
            else{
                saida.append("\t" + tipoVar + " ");
            }

            for (Integer i = 0; i < ctx.identificador().size(); i++){
                nomeVar = ctx.identificador(i).IDENT(0).getText();
                if(isRegistro == false){
                    tabela.adicionar(nomeVar, tipoLA);
                }
                else{
                    tabela.adicionar(nomeRegistro + "." + nomeVar, tipoLA);
                }
                
                saida.append(nomeVar);
                
                if(tipoLA == TipoLA.Literal){ //literal

                    saida.append("[80]");
                }
                
                if(ctx.identificador(0).dimensao() != null){ //vetor
                    saida.append(ctx.identificador(0).dimensao().getText());
                }
                
                if(i == ctx.identificador().size() - 1){ //ponto e virgula no ultimo
                    saida.append(";\n");
                }
                else{ //virgula para separa todos que não sejam os ultimos
                    saida.append(", ");
                }
            }
        }
        else{
            // é registro, então dá um append em todas as suas variaveis
            isRegistro = true;           
            saida.append("\tstruct {\n");
        
            nomeVar = ctx.identificador(0).IDENT(0).getText();
            nomeRegistro = nomeVar;  
            Integer qtdVar = ctx.tipo().registro().variavel().size();
            
            for(Integer i = 0; i < qtdVar; i++){
                saida.append("\t");
                visitVariavel(ctx.tipo().registro().variavel(i));
            } 
            isRegistro = false;            
            saida.append("\t} "+ nomeVar + ";\n\n");      
        }
        
        return null;
    }
    
    @Override
    public Void visitDeclaracao_global(LAParser.Declaracao_globalContext ctx) {

        if(ctx.getText().startsWith("procedimento")){
            // Se for procedimento adiciona o identificador dele na tabela 
            saida.append("void " + ctx.IDENT());
            tabela.adicionar(ctx.IDENT().getText(), TipoLA.Procedimento);
        }else{
            // Se for função adiciona o identificador dela na tabela
            saida.append(verificaTipo(ctx.tipo_estendido().getText()) + " " + ctx.IDENT());
            tabela.adicionar(ctx.IDENT().getText(), verificarTipoVar(ctx.tipo_estendido().getText()));
        }
        
        if(ctx.parametros() != null){
            String tipo = null;
            String nomeVar = "";
            
            // Encontra as variaveis parametros dos métodos
            for(LAParser.ParametroContext par: ctx.parametros().parametro()){
                
                tipo = verificaTipo(par.tipo_estendido().getText());
                
                for(LAParser.IdentificadorContext ident: par.identificador()){
                    nomeVar += ident.getText();
                    // Adiciona nas tabelas
                    tabela.adicionar(nomeVar, verificarTipoVar(par.tipo_estendido().getText()));
                }
            }

            if(tipo.equals("char")){
                tipo = "char*";
            }

            saida.append("(" + tipo + " " + nomeVar + "){\n");
        }
        
        // Chamada pra gerar o corpo do método
        ctx.declaracao_local().forEach(dec -> visitDeclaracao_local(dec));
        ctx.cmd().forEach(cmd -> visitCmd(cmd));

        saida.append("}\n\n");     

        return null;
    }

    @Override
    public Void visitCmdatribuicao(LAParser.CmdatribuicaoContext ctx) {
        
        // Verifica se é ponteiro
        if (ctx.getText().startsWith("^")) {
            saida.append("*" + ctx.identificador().getText() + " = " + ctx.expressao().getText() + ";\n");
        // Verifica se é um registro.
        } else if (ctx.identificador().getText().contains(".") && ctx.getText().contains("\"")) {
            saida.append("strcpy(" + ctx.identificador().getText() + "," + ctx.expressao().getText() + ");\n");
        // Verifica se é uma variável de um tipo básico.
        } else {
           saida.append(ctx.identificador().getText() + " = " + ctx.expressao().getText() + ";\n");
        }
        
        return null;
    }

    @Override
    public Void visitCmdse(LAParser.CmdseContext ctx) {
        
        saida.append("\tif(");
        
        // Gera o corpo da condicional
        visitExp_relacional(ctx.expressao().termo_logico(0).fator_logico(0).parcela_logica().exp_relacional());
        
        saida.append("){\n\t");
        visitCmd(ctx.cmd(0));
        saida.append("\t}\n");
        
        // Geração do else
        if (ctx.cmd().size() > 1) { 
            saida.append("\telse {\n\t");
            visitCmd(ctx.cmd(1));
            saida.append("\t}\n");
        }
        
        return null;
    }

    @Override
    public Void visitCmdleia(LAParser.CmdleiaContext ctx) {
        
        String nomeVar = ctx.identificador(0).IDENT(0).getText();
        TipoLA tipoVariavel = tabela.verificar(nomeVar);
        String aux = "";
        
        switch (tipoVariavel) {
            case Inteiro:
                aux = "%d";
                break;
            case Real:
                aux = "%f";
                break;
            default:
                break;
        }
        
        if (aux.isEmpty()) {
           saida.append("\tgets(" + nomeVar + ");\n"); // quando não é inteiro nem real é usado gets
        }else{
           saida.append("\tscanf(\"" + aux + "\", &" + nomeVar + ");\n");
        }
        
        return null;
    }

    @Override
    public Void visitCmdenquanto(LAParser.CmdenquantoContext ctx) {
        
        saida.append("\twhile(");
        
        // Gera a expressão do while
        visitExp_relacional(ctx.expressao().termo_logico(0).fator_logico(0).parcela_logica().exp_relacional());
        
        saida.append(") {\n");
        
        // Gera o corpo do while
        ctx.cmd().forEach(dec -> visitCmd(dec));
        
        saida.append("\t}\n");
        
        return null;
    }

    @Override
    public Void visitCmdfaca(LAParser.CmdfacaContext ctx) {
        
        // do while - é o enquanto ao contrário
        saida.append("\tdo{\n");
        
        // Gera o corpo do while
        ctx.cmd().forEach(dec -> visitCmd(dec));
        
        saida.append("\t}while(");
        
        // Gera a expressão do while
        visitExpressao(ctx.expressao());
        
        saida.append(");\n");
               
        return null;
    }

    @Override
    public Void visitCmdescreva(LAParser.CmdescrevaContext ctx) {
        
        // Itera a lista de expessões
        ctx.expressao().forEach(exp -> { 
            if (exp.termo_logico(0).fator_logico(0).parcela_logica().exp_relacional().exp_aritmetica(0) != null) {
            
                TipoLA tipoExpressao = LASemanticoUtils.verificarTipo(tabela, exp);
                String aux = "";
                
                // Verifica os especificadores
                switch (tipoExpressao) {
                    case Inteiro:
                        aux = "%d";
                        break;
                    case Real:
                        aux = "%f";
                        break;
                    case Literal:
                        aux = "%s";
                        break;
                    default:
                        break;
                }
                
                saida.append("\tprintf(");
                
                // Busca a expressão do printf
                if (!exp.getText().startsWith("\"")){
                    saida.append("\"" + aux + "\", ");
                    visitExp_aritmetica(exp.termo_logico(0).fator_logico(0).parcela_logica().exp_relacional().exp_aritmetica(0));
                }
                else{
                    visitExp_aritmetica(exp.termo_logico(0).fator_logico(0).parcela_logica().exp_relacional().exp_aritmetica(0));
                }
                saida.append(");\n");
            }
        });
        
        return null;
    }

    @Override
    public Void visitCmdcaso(LAParser.CmdcasoContext ctx) {
        
        saida.append("\tswitch( ");
        
        // Condição do switch
        visitExp_aritmetica(ctx.exp_aritmetica());
        
        saida.append(" ){\n");
        
        // Corpo dos cases
        ctx.selecao().item_selecao().forEach(dec -> visitItem_selecao(dec));
        
        saida.append("\tdefault:\n\t\tbreak;\n");
        saida.append("\t}\n");
        
        return null;
    }

    @Override
    public Void visitCmdpara(LAParser.CmdparaContext ctx) {
        
        saida.append("\tfor (");
        saida.append(ctx.IDENT() + " = ");
        
        visitExp_aritmetica(ctx.exp_aritmetica(0));
        
        saida.append("; " + ctx.IDENT() + " <= ");
        
        visitExp_aritmetica(ctx.exp_aritmetica(1));
        
        saida.append("; " + ctx.IDENT() + "++){\n");
        
        // Corpo do for
        ctx.cmd().forEach(dec -> visitCmd(dec));
        
        saida.append("\t}\n");
        
        return null;
    }
    
    @Override
    public Void visitCmdchamada(LAParser.CmdchamadaContext ctx){
        
        // Gera chamada do procedimento na main
        saida.append("\t" + ctx.IDENT() + "(");
        
        int cont = 0;
        
        for(LAParser.ExpressaoContext expr: ctx.expressao()){
            if(cont >= 1){
                saida.append(", ");
            }
            
            saida.append(expr.getText());
            cont++;
        }
        
        saida.append(");\n");
        
        return null;
    }
    
    @Override
    public Void visitCmdretorne(LAParser.CmdretorneContext ctx){
        
        // Gera o return dos métodos
        saida.append("\treturn ");
        visitExpressao(ctx.expressao());
        saida.append(";\n");
        
        return null;
    }

    @Override
    public Void visitItem_selecao(LAParser.Item_selecaoContext ctx) {

        // Gera o corpo do switch - cases
        Integer inicio = Integer.parseInt(ctx.constantes().numero_intervalo(0).NUM_INT(0).getText());
        if (ctx.constantes().numero_intervalo(0).NUM_INT(1) != null){
            Integer fim = Integer.parseInt(ctx.constantes().numero_intervalo(0).NUM_INT(1).getText());
            for (int i = inicio; i <= fim; i++){
                saida.append("\tcase ");
                saida.append(i);
                saida.append(":\n");
                for (LAParser.CmdContext cmd : ctx.cmd()) {
                    saida.append("\t");
                    visitCmd(cmd);
                    saida.append("\t\tbreak;\n");
                }
            }
        }
        else {
            saida.append("\tcase ");
            saida.append(ctx.constantes().numero_intervalo(0).NUM_INT(0).getText());
            saida.append(":\n");
            for (LAParser.CmdContext cmd : ctx.cmd()) {
                saida.append("\t");
                visitCmd(cmd);
                saida.append("\t\tbreak;\n");
            }
        }
        
        return null;
    }

    @Override
    public Void visitExp_aritmetica(LAParser.Exp_aritmeticaContext ctx) {
        
        visitTermo(ctx.termo(0));
        
        // Verifica operador da expressão_ari
        for (int i = 0; i < ctx.op1().size(); i++) {
            saida.append(" " + ctx.op1(i).getText() + " ");
            visitTermo(ctx.termo(i + 1));
        }
        
        return null;
    }
    
    @Override
    public Void visitTermo(LAParser.TermoContext ctx) {
        
        visitFator(ctx.fator(0));
        
        // Verifica operador do termo
        for (int i = 0; i < ctx.op2().size(); i++) {
            saida.append(" " + ctx.op2(i).getText() + " ");
            visitFator(ctx.fator(i + 1));
        }
        
        return null;
    }
    
    @Override
    public Void visitFator(LAParser.FatorContext ctx) {
        
        visitParcela(ctx.parcela(0));
        
        // verifica operador fator
        for (int i = 0; i < ctx.op3().size(); i++) {
            saida.append(" " + ctx.op3(i).getText() + " ");
            visitParcela(ctx.parcela(i + 1));
        }
        
        return null;
    }
    
    @Override
    public Void visitParcela(LAParser.ParcelaContext ctx) {
        
        if (ctx.parcela_nao_unario() != null){
            
            String aux = ctx.parcela_nao_unario().CADEIA().getText();
            saida.append(aux);
            
        }else if (ctx.parcela_unario() != null){
            
            if (ctx.parcela_unario().NUM_INT() != null) {
                saida.append(ctx.parcela_unario().NUM_INT().getText());
            } else if (ctx.parcela_unario().NUM_REAL() != null) {
                saida.append(ctx.parcela_unario().NUM_REAL().getText());
            } else if (ctx.parcela_unario().identificador() != null) {
                saida.append(ctx.parcela_unario().identificador().getText());            
            } else if (ctx.parcela_unario().IDENT() != null){
                saida.append(ctx.parcela_unario().getText()); //Gera a chama das funções
            }else{
                // Para verificar expressão dentro de expressão
                visitExpressao(ctx.parcela_unario().expressao(0));
            }
            
        }
        
        return null;
    }
    
    @Override
    public Void visitFator_logico(LAParser.Fator_logicoContext ctx){
        
        // Caso expressão seja invertida
        if ((ctx.getText().contains("nao"))) {
            saida.append("!");
        } 
        visitExp_relacional(ctx.parcela_logica().exp_relacional());
        
        return null;
    }

    @Override
    public Void visitExp_relacional(LAParser.Exp_relacionalContext ctx) {
        
        // Gera os operadores relacionais
        if(ctx.op_relacional(0) != null){
            saida.append(ctx.exp_aritmetica(0).getText() + " ");
            if(ctx.op_relacional(0).getText().equals("=")){
                saida.append("==");
            }
            else if(ctx.op_relacional(0).getText().equals("<>")){

                saida.append("!=");
            }
            else{
                saida.append(ctx.op_relacional(0).getText());
            }
            saida.append(" " + ctx.exp_aritmetica(1).getText());
        }
        else{ // entra aqui se não tiver operadores relacionais
            for (Integer i = 0; i < ctx.exp_aritmetica().size(); i++){
                saida.append("(");
                visitExp_aritmetica(ctx.exp_aritmetica(i));
                saida.append(")");
            }
        }
       
        return null;
    }

    @Override
    public Void visitOp_relacional(LAParser.Op_relacionalContext ctx) {
        
        String aux = "";
        switch (ctx.getText()) {
            case "=":
                aux = "==";
                break;
            case "<>":
                aux = "!=";
                break;
            case ">=":
                aux = ">=";
                break;
            case "<=":
                aux = "<=";
                break;
            case ">":
                aux = ">";
                break;
            case "<":
                aux = "<";
                break;
            default:
                break;
        }
        
        saida.append(" " + aux + " ");
        
        return null;
    }  
    
}
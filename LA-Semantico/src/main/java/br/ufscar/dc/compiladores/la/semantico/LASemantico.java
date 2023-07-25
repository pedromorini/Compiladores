/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.la.semantico;

import br.ufscar.dc.compiladores.la.semantico.TabelaDeSimbolos.TipoLA;
import java.util.ArrayList;
import java.util.HashMap;
import org.antlr.v4.runtime.Token;

/**
 *
 * @author Pedro
 */
public class LASemantico extends LABaseVisitor<Void>{
    TabelaDeSimbolos tabela;
    LASemanticoUtils utils;
    
    static Escopos escoposAninhados = new Escopos();
    static HashMap<String, ArrayList<TipoLA>> tabelaFunPro = new HashMap<>();
    HashMap<String, ArrayList<String>> tabelaRegistro = new HashMap<>();
    
    // Função para verificar compatibilidade para atribuição de valores reais e inteiros
    public boolean verificaRealInteiro(TabelaDeSimbolos.TipoLA tipoVar, TabelaDeSimbolos.TipoLA tipoExpr){
        if(tipoVar == TabelaDeSimbolos.TipoLA.Inteiro && 
          (tipoExpr == TabelaDeSimbolos.TipoLA.Inteiro || tipoExpr == TabelaDeSimbolos.TipoLA.Real) ||
           tipoVar == TabelaDeSimbolos.TipoLA.Real && 
          (tipoExpr == TabelaDeSimbolos.TipoLA.Inteiro || tipoExpr == TabelaDeSimbolos.TipoLA.Real)){
            return true;
        }else{
            return false;
        }
    }

    // Função para verificar o tipo da variavel
    public TipoLA verificarTipoVar(String tipo, HashMap registros){
        
        // no caso de ser ponteiro simplifica a verificação
        if(tipo.charAt(0) == '^'){
            tipo = tipo.substring(1);
        }
        
        // no caso do tipo estar na tabela de registros
        if(registros.containsKey(tipo)){
            return TabelaDeSimbolos.TipoLA.Registro;
        }
        
        switch(tipo){
            case "literal":
                return TabelaDeSimbolos.TipoLA.Literal;
            case "inteiro":
                return TabelaDeSimbolos.TipoLA.Inteiro;
            case "real":
                return TabelaDeSimbolos.TipoLA.Real;
            case "logico":
                return TabelaDeSimbolos.TipoLA.Logico;
            case "procedimento":
                return TabelaDeSimbolos.TipoLA.Procedimento;
            case "registro":
                return TabelaDeSimbolos.TipoLA.Registro;
            default:
                return TabelaDeSimbolos.TipoLA.Invalido;
        }
    }
    
    // Função para adicionar variável na tabela de simbolos
    public void adicionarVariavel(String nomeVar, String tipoVar, Token nomeToken, Token tipoToken, HashMap registros){
        TabelaDeSimbolos tabelaEscopo = escoposAninhados.obterEscopoAtual();
        TabelaDeSimbolos.TipoLA tipo = verificarTipoVar(tipoVar, registros);
        
        // Verifica se o tipo da variavel declarada é válido
        if(tipo == TabelaDeSimbolos.TipoLA.Invalido){
            utils.adicionarErroSemantico(tipoToken, "tipo "+tipoVar+" nao declarado");
        }
        
        //verifica se a variável já foi declarada
        if(!tabelaEscopo.existe(nomeVar)){
            tabelaEscopo.adicionar(nomeVar, tipo);
        }else{
            utils.adicionarErroSemantico(nomeToken, "identificador "+nomeVar+" ja declarado anteriormente");
        }
    }
    
    @Override
    public Void visitPrograma(LAParser.ProgramaContext ctx){
        tabela = new TabelaDeSimbolos();
        
        // verifica se o retorno esta sendo usao no escopo principal
        for(LAParser.CmdContext cmd: ctx.corpo().cmd()){
            if(cmd.cmdretorne() != null){
                utils.adicionarErroSemantico(cmd.getStart(), "comando retorne nao permitido nesse escopo");
            }
        }
        
        return super.visitPrograma(ctx);
    }
    
    @Override
    public Void visitDeclaracao_local(LAParser.Declaracao_localContext ctx){
        tabela = escoposAninhados.obterEscopoAtual();
        
        // Verifica se está ocorrendo uma declaração
        if(ctx.getText().startsWith("declare")){
            
            // Declaração de registro
            if(ctx.variavel().tipo().registro() != null){
                
                // Adiciona o registro e suas variaveis na tabela
                for(LAParser.IdentificadorContext ident: ctx.variavel().identificador()){
                    adicionarVariavel(ident.getText(), "registro", ident.getStart(), null, tabelaRegistro);
                
                    for(LAParser.VariavelContext var: ctx.variavel().tipo().registro().variavel()){
                        String tipoVar = var.tipo().getText();
                        
                        for(LAParser.IdentificadorContext identReg: var.identificador()){
                            adicionarVariavel(ident.getText() + "." + identReg.getText(), tipoVar, identReg.getStart(), var.tipo().getStart(), tabelaRegistro);
                        }
                    }
                }
            }else{ 
                String tipoVar = ctx.variavel().tipo().getText();
                
                if(tabelaRegistro.containsKey(tipoVar)){
                    ArrayList<String> variaveisRegistro = tabelaRegistro.get(tipoVar);
                    
                    
                    // Declaração das variaveis dentro do registro
                    for(LAParser.IdentificadorContext ident: ctx.variavel().identificador()){
                        String nomeVar = ident.IDENT().get(0).getText();
                        
                        if(tabela.existe(nomeVar) || tabelaRegistro.containsKey(nomeVar)){
                            utils.adicionarErroSemantico(ident.getStart(), "identificador " + nomeVar + " ja declarado anteriormente");
                        }else{
                            adicionarVariavel(nomeVar, "registro", ident.getStart(), ctx.variavel().tipo().getStart(), tabelaRegistro);
                        
                            for(int i = 0; i < variaveisRegistro.size(); i = i + 2){
                                adicionarVariavel(nomeVar + '.' + variaveisRegistro.get(i), variaveisRegistro.get(i+1), ident.getStart(), ctx.variavel().tipo().getStart(), tabelaRegistro);
                            }
                        }
                    }
                }else{
                    // Itera os identificadores para encontrar a variavel e adiciona-la na tabela de simbolos 
                    for(LAParser.IdentificadorContext ident: ctx.variavel().identificador()){
                        
                        // Declaração de função ou procedimento 
                        if(tabelaFunPro.containsKey(ident.getText())){
                            utils.adicionarErroSemantico(ident.getStart(), "identificador " + ident.getText() + " ja declarado anteriormente");
                        }else{
                            adicionarVariavel(ident.getText(), tipoVar, ident.getStart(), ctx.variavel().tipo().getStart(), tabelaRegistro);
                        }
                    }
                }
            }
        }else if(ctx.getText().startsWith("constante")){
            // no caso de ser constante
            adicionarVariavel(ctx.IDENT().getText(), ctx.tipo_basico().getText(), ctx.IDENT().getSymbol(), ctx.IDENT().getSymbol(), tabelaRegistro);
        
        }else{ // declaração de tipo - como uma struct
                    
            if(ctx.tipo().registro() != null){
                ArrayList<String> variaveisRegistro = new ArrayList<>();
                
                for(LAParser.VariavelContext var: ctx.tipo().registro().variavel()){
                    String tipoVar = var.tipo().getText();
                    
                    for(LAParser.IdentificadorContext ident: var.identificador()){
                        variaveisRegistro.add(ident.getText());
                        variaveisRegistro.add(tipoVar);
                    }
                }
                
                tabelaRegistro.put(ctx.IDENT().getText(), variaveisRegistro);
            }
        }
        
        return super.visitDeclaracao_local(ctx);
    }
    
    @Override
    public Void visitDeclaracao_global(LAParser.Declaracao_globalContext ctx){
        escoposAninhados.criarNovoEscopo();
        tabela = escoposAninhados.obterEscopoAtual();
        ArrayList<TipoLA> parametros = new ArrayList<TipoLA>();

        // Se for declaração de função
        if (ctx.getText().startsWith("funcao")) {
            
            // Adiciona o nome da função e seus paramentros na tabela
            for (LAParser.ParametroContext parametro : ctx.parametros().parametro()) {
                if (parametro.tipo_estendido().tipo_basico_ident().tipo_basico() != null) { 
                    for (LAParser.IdentificadorContext ident : parametro.identificador()) {
                        adicionarVariavel(ident.getText(), parametro.tipo_estendido().getText(), ident.getStart(), parametro.tipo_estendido().getStart(), tabelaRegistro);
                        parametros.add(verificarTipoVar(parametro.tipo_estendido().getText(), tabelaRegistro));
                    }
                }else { // No caso de ser registro
                    if (tabelaRegistro.containsKey(parametro.tipo_estendido().tipo_basico_ident().IDENT().getText())) {
                        for (LAParser.IdentificadorContext ident : parametro.identificador()) {
                            parametros.add(verificarTipoVar(parametro.tipo_estendido().tipo_basico_ident().IDENT().getText(), tabelaRegistro));
                        }
                    }
                }
            }
            
            parametros.add(verificarTipoVar(ctx.tipo_estendido().getText(), tabelaRegistro));
            tabelaFunPro.put(ctx.IDENT().getText(), parametros);

        }else { // Declaração de procedimento
            
            // Adiciona o nome do procedimento e seus paramentros na tabela
            for (LAParser.ParametroContext parametro : ctx.parametros().parametro()) {
                if (parametro.tipo_estendido().tipo_basico_ident().tipo_basico() != null) { // Tipo Básico
                    for (LAParser.IdentificadorContext ident : parametro.identificador()) {
                        adicionarVariavel(ident.getText(), parametro.tipo_estendido().getText(), ident.getStart(), parametro.tipo_estendido().getStart(), tabelaRegistro);
                        parametros.add(verificarTipoVar(parametro.tipo_estendido().getText(), tabelaRegistro));
                    }
                }
                else { // No caso de ser registro
                    if (tabelaRegistro.containsKey(parametro.tipo_estendido().tipo_basico_ident().IDENT().getText())) {
                        ArrayList<String> variaveis_registro = tabelaRegistro.get(parametro.tipo_estendido().tipo_basico_ident().IDENT().getText());
                        for (LAParser.IdentificadorContext ident : parametro.identificador()) {
                            parametros.add(verificarTipoVar(parametro.tipo_estendido().tipo_basico_ident().IDENT().getText(), tabelaRegistro));
                            for (int i = 0; i < variaveis_registro.size(); i = i + 2) {
                                adicionarVariavel(ident.getText() + '.' + variaveis_registro.get(i), variaveis_registro.get(i+1), ident.getStart(), ident.getStart(), tabelaRegistro);
                            }
                        }
                    }
                    else {// Não declarado
                        utils.adicionarErroSemantico(parametro.getStart(), "tipo não declarado");
                    }
                }
            }
            
            // Verifica erro de retorno
            for (LAParser.CmdContext comando : ctx.cmd()) {
                if (comando.cmdretorne() != null) {
                    utils.adicionarErroSemantico(comando.getStart(), "comando retorne nao permitido nesse escopo");
                }
            }
            tabelaFunPro.put(ctx.IDENT().getText(), parametros);
        }
        
        return super.visitDeclaracao_global(ctx);
    }
    
    @Override
    public Void visitCmd(LAParser.CmdContext ctx){
        tabela = escoposAninhados.obterEscopoAtual();
        
        if(ctx.cmdleia() != null){
            for(LAParser.IdentificadorContext ident: ctx.cmdleia().identificador()){
               
                // Verifica se a variável já foi declarada no momento da leitura
                if(!tabela.existe(ident.getText())){
                    utils.adicionarErroSemantico(ident.start, "identificador "+ident.getText()+" nao declarado");
                }
            }
        }else if(ctx.cmdescreva() != null){
            TabelaDeSimbolos.TipoLA tipoEsc;
            for(LAParser.ExpressaoContext expr: ctx.cmdescreva().expressao()){
                // Verifica o tipo da expressao no momento de escrever 
                tipoEsc = utils.verificarTipo(tabela, expr);
            }
        }else if(ctx.cmdenquanto() != null){
            
            // Verifica  otipo da expressao dentro do laço
            TabelaDeSimbolos.TipoLA tipoEnq = utils.verificarTipo(tabela, ctx.cmdenquanto().expressao());
        
        }else if(ctx.cmdse() != null){
            
            // Verifica  otipo da expressao dentro do condicional
            TabelaDeSimbolos.TipoLA tiposSe= utils.verificarTipo(tabela, ctx.cmdse().expressao());
            
        }else if(ctx.cmdatribuicao() != null){
            
            // Verifica o tipo da expressao
            TabelaDeSimbolos.TipoLA tipoExpr = utils.verificarTipo(tabela, ctx.cmdatribuicao().expressao());
            
            // Armazena o identificador
            String nomeVar = ctx.cmdatribuicao().identificador().getText();
            
            // Verifica se o tipo da expressao é válido
            if(tipoExpr != TabelaDeSimbolos.TipoLA.Invalido){
                
                // Verifica se a variavel existe na tabela de simbolos
                if(!tabela.existe(nomeVar)){
                    // Se a variavel existe na tabela e o tipo da expressão não é válido
                    utils.adicionarErroSemantico(ctx.cmdatribuicao().identificador().start, "identificador "+ctx.cmdatribuicao().identificador().getText()+" nao declarado");
                }else{
                    
                    // Armazena o tipo da variável
                    TabelaDeSimbolos.TipoLA tipoVar = utils.verificarTipo(tabela, nomeVar);
                    
                    if(!verificaRealInteiro(tipoVar, tipoExpr) && tipoVar != tipoExpr){
                        // Se a variável existe na tabela e a compatibilidade do tipo da variavel e da expressão é false
                        if(ctx.cmdatribuicao().getText().startsWith("^")){
                            utils.adicionarErroSemantico(ctx.cmdatribuicao().identificador().getStart(), "atribuicao nao compativel para ^" + ctx.cmdatribuicao().identificador().getText());
                        }else{
                            utils.adicionarErroSemantico(ctx.cmdatribuicao().identificador().getStart(), "atribuicao nao compativel para " + ctx.cmdatribuicao().identificador().getText());
                        }
                    }  
                }
            }
        }
        
        return super.visitCmd(ctx);
    }
    
}

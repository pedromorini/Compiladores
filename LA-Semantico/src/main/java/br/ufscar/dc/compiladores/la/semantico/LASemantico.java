/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.la.semantico;

import br.ufscar.dc.compiladores.la.semantico.TabelaDeSimbolos.TipoLA;
import org.antlr.v4.runtime.Token;

/**
 *
 * @author Pedro
 */
public class LASemantico extends LABaseVisitor<Void>{
    TabelaDeSimbolos tabela;
    LASemanticoUtils utils;
    static Escopos escoposAninhados = new Escopos();
    
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
    
    // Função para adicionar variável na tabela de simbolos
    public void adicionarVariavel(String nomeVar, String tipoVar, Token nomeToken, Token tipoToken){
        TabelaDeSimbolos tabelaEscopo = escoposAninhados.obterEscopoAtual();
        TabelaDeSimbolos.TipoLA tipo;
        
        // verifica qual tipo a variavel corresponde na tabela de simbolos
        switch(tipoVar){
            case "literal":
                tipo = TabelaDeSimbolos.TipoLA.Literal;
                break;
            case "inteiro":
                tipo = TabelaDeSimbolos.TipoLA.Inteiro;
                break;
            case "real":
                tipo = TabelaDeSimbolos.TipoLA.Real;
                break;
            case "logico":
                tipo = TabelaDeSimbolos.TipoLA.Logico;
                break;
            default:
                tipo = TabelaDeSimbolos.TipoLA.Invalido;
                break;
        }
        
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
        return super.visitPrograma(ctx);
    }
    
    @Override
    public Void visitDeclaracao_local(LAParser.Declaracao_localContext ctx){
        tabela = escoposAninhados.obterEscopoAtual();
        
        // Verifica se está ocorrendo uma declaração
        if(ctx.getText().startsWith("declare")){
            String tipoVar = ctx.variavel().tipo().getText();
            
            // Itera os identificadores para encontrar a variavel e adiciona-la na tabela de simbolos 
            for(LAParser.IdentificadorContext ident: ctx.variavel().identificador()){
                adicionarVariavel(ident.getText(), tipoVar, ident.getStart(), ctx.variavel().tipo().getStart());
            }
        }
        return super.visitDeclaracao_local(ctx);
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
                        utils.adicionarErroSemantico(ctx.cmdatribuicao().identificador().getStart(), "atribuicao nao compativel para " + ctx.cmdatribuicao().identificador().getText());
                    }  
                }
            }
        }
        
        return super.visitCmd(ctx);
    }
    
}

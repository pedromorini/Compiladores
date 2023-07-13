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
    
    public void adicionarVariavel(String nomeVar, String tipoVar, Token nomeToken, Token tipoToken){
        TabelaDeSimbolos tabelaEscopo = escoposAninhados.obterEscopoAtual();
        TabelaDeSimbolos.TipoLA tipo;
        
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
        
        if(tipo == TabelaDeSimbolos.TipoLA.Invalido){
            utils.adicionarErroSemantico(tipoToken, "tipo "+tipoVar+" nao declarado");
        }
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
        
        if(ctx.getText().startsWith("declare")){
            String tipoVar = ctx.variavel().tipo().getText();
            
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
                if(!tabela.existe(ident.getText())){
                    utils.adicionarErroSemantico(ident.start, "identificador "+ident.getText()+" nao declarado");
                }
            }
        }else if(ctx.cmdescreva() != null){
            TabelaDeSimbolos.TipoLA tipoEsc;
            for(LAParser.ExpressaoContext expr: ctx.cmdescreva().expressao()){
                tipoEsc = utils.verificarTipo(tabela, expr);
            }
        }else if(ctx.cmdenquanto() != null){
            TabelaDeSimbolos.TipoLA tipoEnq = utils.verificarTipo(tabela, ctx.cmdenquanto().expressao());
        }else if(ctx.cmdatribuicao() != null){
            TabelaDeSimbolos.TipoLA tipoExpr = utils.verificarTipo(tabela, ctx.cmdatribuicao().expressao());
            String nomeVar = ctx.cmdatribuicao().identificador().getText();
            
            if(tipoExpr != TabelaDeSimbolos.TipoLA.Invalido){
                if(!tabela.existe(nomeVar)){
                    utils.adicionarErroSemantico(ctx.cmdatribuicao().identificador().start, "identificador "+ctx.cmdatribuicao().identificador().getText()+" nao declarado");
                }else{
                    TabelaDeSimbolos.TipoLA tipoVar = utils.verificarTipo(tabela, nomeVar);
                    if(!verificaRealInteiro(tipoVar, tipoExpr) && tipoVar != tipoExpr){
                        utils.adicionarErroSemantico(ctx.cmdatribuicao().identificador().getStart(), "atribuicao nao compativel para " + ctx.cmdatribuicao().identificador().getText());
                    }  
                }
            }
        }
        
        return super.visitCmd(ctx);
    }
    
}

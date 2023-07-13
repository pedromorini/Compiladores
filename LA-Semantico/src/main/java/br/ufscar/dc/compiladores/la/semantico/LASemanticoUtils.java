/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.la.semantico;

import static br.ufscar.dc.compiladores.la.semantico.LASemantico.escoposAninhados;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;

/**
 *
 * @author Pedro
 */
public class LASemanticoUtils {
    public static List<String> errosSemanticos = new ArrayList<>();
    
    public static void adicionarErroSemantico(Token t, String mensagem){
        int linha = t.getLine();
        //int coluna = t.getCharPositionInLine();
        errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
    }
    
    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.ExpressaoContext ctx){
        TabelaDeSimbolos.TipoLA ret = null;
        for(var ta: ctx.termo_logico()){
            TabelaDeSimbolos.TipoLA aux = verficarTipo(tabela, ta);
            if(ret == null){
                ret = aux;
            }else if(ret != aux && aux != TabelaDeSimbolos.TipoLA.Invalido){
                adicionarErroSemantico(ctx.start, "Expressao "+ctx.getText()+" contem tipos incompativeis");
                //return TabelaDeSimbolos.TipoLA.Invalido;
                return aux;
            }
        }
        return ret;
    }

    public static TabelaDeSimbolos.TipoLA verficarTipo(TabelaDeSimbolos tabela, LAParser.Termo_logicoContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;
        for(var fa: ctx.fator_logico()){
            TabelaDeSimbolos.TipoLA aux = verficarTipo(tabela, fa);
            if(ret == null){
                ret = aux;
            }else if(ret != aux && aux != TabelaDeSimbolos.TipoLA.Invalido){
                //return TabelaDeSimbolos.TipoLA.Invalido;
                return aux;
            }
        }
        return ret;    
    }

    public static TabelaDeSimbolos.TipoLA verficarTipo(TabelaDeSimbolos tabela, LAParser.Fator_logicoContext ctx) {
        return verificarTipo(tabela, ctx.parcela_logica());    
    }

    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.Parcela_logicaContext ctx) {
        if(ctx.exp_relacional() != null){
            return verificarTipo(tabela, ctx.exp_relacional());
        }else{
            return TabelaDeSimbolos.TipoLA.Logico;
        }
    }

    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.Exp_relacionalContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;
        for(var er: ctx.exp_aritmetica()){
            TabelaDeSimbolos.TipoLA aux = verficarTipo(tabela, er);
            if(ret == null){
                ret = aux;
            }else if(ret != aux && aux != TabelaDeSimbolos.TipoLA.Invalido){
                //return TabelaDeSimbolos.TipoLA.Invalido;
                return aux;
            }else{
                return TabelaDeSimbolos.TipoLA.Logico;
            }
        }
        return ret;    
    }

    public static TabelaDeSimbolos.TipoLA verficarTipo(TabelaDeSimbolos tabela, LAParser.Exp_aritmeticaContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;
        for(var ea: ctx.termo()){
            TabelaDeSimbolos.TipoLA aux = verficarTipo(tabela, ea);
            if(ret == null){
                ret = aux;
            }else if(ret != aux && aux != TabelaDeSimbolos.TipoLA.Invalido){
                //return TabelaDeSimbolos.TipoLA.Invalido;
                return aux;
            }
        }
        return ret;    
    }

    public static TabelaDeSimbolos.TipoLA verficarTipo(TabelaDeSimbolos tabela, LAParser.TermoContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;
        for(var ta: ctx.fator()){
            TabelaDeSimbolos.TipoLA aux = verficarTipo(tabela, ta);
            if(ret == null){
                ret = aux;
            }else if(ret != aux && aux != TabelaDeSimbolos.TipoLA.Invalido){
                //return TabelaDeSimbolos.TipoLA.Invalido;
                return aux;
            }
        }
        return ret;    
    }

    public static TabelaDeSimbolos.TipoLA verficarTipo(TabelaDeSimbolos tabela, LAParser.FatorContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;
        for(var ta: ctx.parcela()){
            TabelaDeSimbolos.TipoLA aux = verficarTipo(tabela, ta);
            if(ret == null){
                ret = aux;
            }else if(ret != aux && aux != TabelaDeSimbolos.TipoLA.Invalido){
                //return TabelaDeSimbolos.TipoLA.Invalido;
                return aux;
            }
        }
        return ret;    
    }

    public static TabelaDeSimbolos.TipoLA verficarTipo(TabelaDeSimbolos tabela, LAParser.ParcelaContext ctx) {
        if(ctx.parcela_unario() != null){
            return verificarTipo(tabela, ctx.parcela_unario());
        }else{
            return verificarTipo(tabela, ctx.parcela_nao_unario());
        }
    }

    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.Parcela_unarioContext ctx) {
        if(ctx.NUM_INT() != null){
            return TabelaDeSimbolos.TipoLA.Inteiro;
        }else if(ctx.NUM_REAL() != null){
            return TabelaDeSimbolos.TipoLA.Real;
        }else if(ctx.IDENT() != null){
            return TabelaDeSimbolos.TipoLA.Literal;
        }else if(ctx.identificador() != null){
            String nomeVar = ctx.identificador().getText();
            
            if(tabela.existe(nomeVar)){
                return tabela.verificar(nomeVar);
            }else{
                TabelaDeSimbolos aux = escoposAninhados.percorrerEscopoAninhados().get(LASemantico.escoposAninhados.percorrerEscopoAninhados().size() - 1);
                if(!tabela.existe(nomeVar)){
                    adicionarErroSemantico(ctx.start, "identificador "+ctx.getText()+" nao declarado");
                    return TabelaDeSimbolos.TipoLA.Invalido;
                }else{
                    return aux.verificar(nomeVar);
                }
            }
        }else{
            return verificarTipo(tabela, ctx.expressao(0));
        }
    }

    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.Parcela_nao_unarioContext ctx) {
        if(ctx.CADEIA() != null){
            return TabelaDeSimbolos.TipoLA.Literal;
        }else{
            if(tabela.existe(ctx.identificador().getText())){
                return tabela.verificar(ctx.identificador().getText());
            }else{
                adicionarErroSemantico(ctx.start, "identificador "+ctx.getText()+" nao declarado");
                return TabelaDeSimbolos.TipoLA.Invalido;
            }
        }
    }

    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, String nomeVar){
        return tabela.verificar(nomeVar);
    }
    
}

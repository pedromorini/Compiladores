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
    
    // Cria a ista para armazenar os erros semânticos
    public static List<String> errosSemanticos = new ArrayList<>();
    
    // Função para adicionar erros na lista
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
                //retorna o tipo da expressão
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
                //retorna o tipo do termo lógico
                return aux;
            }
        }
        return ret;    
    }
    
    // retorna o tipo do fator lógico
    public static TabelaDeSimbolos.TipoLA verficarTipo(TabelaDeSimbolos tabela, LAParser.Fator_logicoContext ctx) {
        return verificarTipo(tabela, ctx.parcela_logica());    
    }

    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.Parcela_logicaContext ctx) {
        if(ctx.exp_relacional() != null){
            // retorna o tipo da parcela lógica
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
                //retorna o tipo da expressão relacional
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
                //retorna o tipo da expressão aritmetica
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
                //retorna o tipo to termo
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
                //retorna o tipo do fator
                return aux;
            }
        }
        return ret;    
    }
    
    // retorna o tipo da parcela 
    public static TabelaDeSimbolos.TipoLA verficarTipo(TabelaDeSimbolos tabela, LAParser.ParcelaContext ctx) {
        if(ctx.parcela_unario() != null){
            return verificarTipo(tabela, ctx.parcela_unario());
        }else{
            return verificarTipo(tabela, ctx.parcela_nao_unario());
        }
    }

    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.Parcela_unarioContext ctx) {
        // Verifica se a parcela é inteira
        if(ctx.NUM_INT() != null){
            return TabelaDeSimbolos.TipoLA.Inteiro;
        
        // Verifica se a parcela é real
        }else if(ctx.NUM_REAL() != null){
            return TabelaDeSimbolos.TipoLA.Real;
            
        // Verifica se a parcela é um literal
        }else if(ctx.IDENT() != null){
            return TabelaDeSimbolos.TipoLA.Literal;
            
        // Verifica se é uma variável
        }else if(ctx.identificador() != null){
            String nomeVar = ctx.identificador().getText();
            
            if(tabela.existe(nomeVar)){
                // retorna o tipo da variável se ea existe
                return tabela.verificar(nomeVar);
            }else{
                TabelaDeSimbolos aux = escoposAninhados.percorrerEscopoAninhados().get(LASemantico.escoposAninhados.percorrerEscopoAninhados().size() - 1);
                if(!tabela.existe(nomeVar)){
                    adicionarErroSemantico(ctx.start, "identificador "+ctx.getText()+" nao declarado");
                    return TabelaDeSimbolos.TipoLA.Invalido;
                }else{
                    // Retorna a verificação do tipo da variável em outro escopo
                    return aux.verificar(nomeVar);
                }
            }
        }else{
            return verificarTipo(tabela, ctx.expressao(0));
        }
    }

    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.Parcela_nao_unarioContext ctx) {
        
        // Verifica se a variaivel é literal
        if(ctx.CADEIA() != null){
            return TabelaDeSimbolos.TipoLA.Literal;
        }else{
            // Verifica se a variavel existe
            if(tabela.existe(ctx.identificador().getText())){
                
                // Verifica o tipo da variável
                return tabela.verificar(ctx.identificador().getText());
            }else{
                adicionarErroSemantico(ctx.start, "identificador "+ctx.getText()+" nao declarado");
                return TabelaDeSimbolos.TipoLA.Invalido;
            }
        }
    }

    // Verifica o tipo da variável na tabela
    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, String nomeVar){
        return tabela.verificar(nomeVar);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.lcheat;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.BitSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

/**
 *
 * @author Pedro
 */
public class ErrorListener implements ANTLRErrorListener {

    FileOutputStream saida;
    
    // Variavel lógica para validar apenas um erro
    Boolean erro = false;
    
    public ErrorListener(FileOutputStream saida) {
        this.saida = saida;    
    }
    
    @Override
    public void	reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
        // Não será necessário para o T2, pode deixar vazio
    }
    
    @Override
    public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
        // Não será necessário para o T2, pode deixar vazio
    }

    @Override
    public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
        // Não será necessário para o T2, pode deixar vazio
    }

    @Override
    public void	syntaxError(Recognizer<?,?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        Token t = (Token) offendingSymbol; //token que gerou erro
        String token = t.getText();
        
        if ("<EOF>".equals(token)){
            token = "EOF";
        }

        // Se ainda não houver ocorrido nenhum erro sintático ele o escreve
        if (!erro){
            try {
                saida.write(("Linha "+line+": erro sintatico proximo a "+token+"\n").getBytes());
                erro = true;
            } catch (IOException ex) {
                Logger.getLogger(ErrorListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

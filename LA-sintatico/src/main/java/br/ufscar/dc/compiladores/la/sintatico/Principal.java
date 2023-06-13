/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.la.sintatico;

import java.io.FileOutputStream;
import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

/**
 *
 * @author Pedro
 */
public class Principal {
    public static void main(String args[]) throws IOException{
        
        CharStream cs = CharStreams.fromFileName(args[0]);
        FileOutputStream saida = new FileOutputStream(args[1]);
        LALexer lexer = new LALexer(cs);
        Boolean erroLexico = false;
        
        Token t = null;
        while((t=lexer.nextToken()).getType() != Token.EOF){
            
            String verificaToken = LALexer.VOCABULARY.getDisplayName(t.getType());
            String token = "'" + t.getText() + "'"; 
                
            if(verificaToken.equals("IDENT")   || 
               verificaToken.equals("CADEIA")  ||    
               verificaToken.equals("NUM_INT") ||
               verificaToken.equals("NUM_REAL")){
                    
                token = verificaToken;
                    
            }else if(verificaToken.equals("SIMBOLOS_DESCONHECIDOS")){
                saida.write(("Linha " + t.getLine() + ": " + t.getText() + " - simbolo nao identificado\n").getBytes());
                erroLexico = true;
            }else if(verificaToken.equals("COMENTARIO_ERRADO")){
                saida.write(("Linha " + t.getLine() + ": " + "comentario nao fechado\n").getBytes());
                erroLexico = true;
            }else if(verificaToken.equals("CADEIA_ERRADA")){
                saida.write(("Linha " + t.getLine() + ": cadeia literal nao fechada\n").getBytes());
                erroLexico = true;
            } 
        }
        
        if(!erroLexico){
            cs.seek(0);
            LALexer lexer2 = new LALexer(cs);
            CommonTokenStream tokens = new CommonTokenStream(lexer2);
            LAParser parser = new LAParser(tokens);
            LAErrorListener mcel = new LAErrorListener(saida);
                
            parser.removeErrorListeners();
            parser.addErrorListener(mcel);
            parser.programa();
        }
        saida.write(("Fim da compilacao\n").getBytes());
        saida.close();
    }
}

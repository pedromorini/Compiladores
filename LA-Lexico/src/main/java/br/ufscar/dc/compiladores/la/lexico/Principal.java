package br.ufscar.dc.compiladores.la.lexico;

import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import java.io.FileOutputStream;

/**
 *
 * @author Pedro
 */
public class Principal {
    public static void main(String args[]) throws IOException{
        
        try(FileOutputStream saida = new FileOutputStream(args[1])){
            
            CharStream cs = CharStreams.fromFileName(args[0]);
            LALexer lex = new LALexer(cs);

            Token t = null;

            while((t = lex.nextToken()).getType() != Token.EOF){
                String verificaToken = LALexer.VOCABULARY.getDisplayName(t.getType());
                String token = "'" + t.getText() + "'"; 
                
                if(verificaToken.equals("IDENT")   || 
                   verificaToken.equals("CADEIA")  ||    
                   verificaToken.equals("NUM_INT") ||
                   verificaToken.equals("NUM_REAL")){
                    
                    token = verificaToken;
                    
                }else if(verificaToken.equals("SIMBOLOS_DESCONHECIDOS")){
                    saida.write(("Linha " + t.getLine() + ": " + t.getText() + " - simbolo nao identificado\n").getBytes());
                    saida.close();
                }else if(verificaToken.equals("COMENTARIO_ERRADO")){
                    saida.write(("Linha " + t.getLine() + ": " + "comentario nao fechado\n").getBytes());
                    saida.close();
                }else if(verificaToken.equals("CADEIA_ERRADA")){
                    saida.write(("Linha " + t.getLine() + ": cadeia literal nao fechada\n").getBytes());
                    saida.close();
                }
                
                saida.write(("<" + "'" + t.getText() + "'" + "," + token + ">\n").getBytes());
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

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
        
        // Tenta criar o arquivo de saída
        try(FileOutputStream saida = new FileOutputStream(args[1])){
            
            // Le o arquivo de entrada
            CharStream cs = CharStreams.fromFileName(args[0]);
            LALexer lex = new LALexer(cs);

            Token t = null;

            while((t = lex.nextToken()).getType() != Token.EOF){
                
                // String para verificar a qual regra o token pertence
                String verificaToken = LALexer.VOCABULARY.getDisplayName(t.getType());
                
                // String que recebe o proprio lexema
                String token = "'" + t.getText() + "'"; 
                
                // Se o token pertencer a alguma dessas regras
                if(verificaToken.equals("IDENT")   || 
                   verificaToken.equals("CADEIA")  ||    
                   verificaToken.equals("NUM_INT") ||
                   verificaToken.equals("NUM_REAL")){
                    
                    // Atribui o valor do tipo da regra para a string token
                    token = verificaToken;
                    
                // Tratamento de erros
                }else if(verificaToken.equals("SIMBOLOS_DESCONHECIDOS")){
                    
                    // Se houver um simbolodesconhecido o analisador imprime esse símbolo e a mensagem de erro correspondente
                    saida.write(("Linha " + t.getLine() + ": " + t.getText() + " - simbolo nao identificado\n").getBytes());
                    saida.close();
                    
                }else if(verificaToken.equals("COMENTARIO_ERRADO")){
                    
                    // Mensagem no caso do comentario nao ser fechado
                    saida.write(("Linha " + t.getLine() + ": " + "comentario nao fechado\n").getBytes());
                    saida.close();
                    
                }else if(verificaToken.equals("CADEIA_ERRADA")){
                    
                    // Mensagem no caso da cadeia não ser fechada
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.ufscar.dc.compiladores.lcd;

import br.ufscar.dc.compiladores.lcd.LCDLexer;
import br.ufscar.dc.compiladores.lcd.LCDParser;
import br.ufscar.dc.compiladores.lcd.LCDParser.ProgramaContext;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        LCDLexer lexer = new LCDLexer(cs);

        // Verifica se erro é léxico
        Boolean erroLexico = false;

        Token t = null;
        
        while((t=lexer.nextToken()).getType() != Token.EOF){

            // String para verificar a qual regra o token pertence
            String verificaToken = LCDLexer.VOCABULARY.getDisplayName(t.getType());

            // String que recebe o proprio lexema
            String token = "'" + t.getText() + "'";

            // Verificação de erro léxico
            if(verificaToken.equals("CADEIA") ||
               verificaToken.equals("IDENT")){

                // Atribui o valor do tipo da regra para a string token
                token = verificaToken;

            // Tratamento de erros léxicos
            }else if(verificaToken.equals("SIMBOLOS_DESCONHECIDOS")){

                // Se houver um simbolodesconhecido o analisador imprime esse símbolo e a mensagem de erro correspondente
                saida.write(("Linha " + t.getLine() + ": " + t.getText() + " - simbolo nao identificado\n").getBytes()); 
                saida.close();
                erroLexico = true;

            }else if(verificaToken.equals("CADEIA_ERRADA")){

                // Mensagem no caso da cadeia não ser fechada
                saida.write(("Linha " + t.getLine() + ": cadeia literal nao fechada\n").getBytes()); 
                saida.close();
                erroLexico = true;
                
            }
            //saida.write(("<" + "'" + t.getText() + "'" + "," + token + ">\n").getBytes());
        }
          
        // Se o erro não for léxico
        if(!erroLexico){
            
            // aponta o leitor para o nicio do arquivo
            cs.seek(0);
            
            // cria um novo lexer para análise sintática
            LCDLexer lexer2 = new LCDLexer(cs);
            CommonTokenStream tokens = new CommonTokenStream(lexer2);
            
            // Criando um parser e um listener para os erros sintáticos
            LCDParser parser = new LCDParser(tokens);
            ErrorListener mcel = new ErrorListener(saida);
              
            // Remove listener default
            parser.removeErrorListeners();
            
            // Adiciona o listener criado em LAErrorListener
            parser.addErrorListener(mcel);
            
            // Verifica possiveis erros semânticos
            ProgramaContext arvore = parser.programa();
            LCDSemantico lasem = new LCDSemantico();
            lasem.visitPrograma(arvore);
            
            if(LCDSemantico.errosSemanticos.isEmpty()){
                
                //Chama o gerador pssando como parametro a instancia do semantico
                LCDGerador gera = new LCDGerador(lasem);
                gera.visitPrograma(arvore);
                
                try(PrintWriter pw = new PrintWriter(args[1])){
                    pw.print(gera.saida.toString());
                }

            }else{

                // Cria uma lista contendo os erros semanticos
                List<String> ErrosSemanticos = LCDSemantico.errosSemanticos;

                // Itera sobre a lista exibindos erros semanticos
                for(var es: ErrosSemanticos){
                    saida.write((es + "\n").getBytes());
                }
                saida.write(("Fim da compilacao\n").getBytes());
            }
            
        }

        saida.close();
    }
    
}
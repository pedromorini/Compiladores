package br.ufscar.dc.compiladores.la.semantico;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pedro
 */
public class Principal {
    public static void main(String args[]) throws IOException{
        CharStream cs = CharStreams.fromFileName(args[0]);
        FileOutputStream saida = new FileOutputStream(args[1]);
        LALexer lexer = new LALexer(cs);

        // Verifica se erro é léxico
        Boolean erroLexico = false;

        Token t = null;

        while((t=lexer.nextToken()).getType() != Token.EOF){

            // String para verificar a qual regra o token pertence
            String verificaToken = LALexer.VOCABULARY.getDisplayName(t.getType());

            // String que recebe o proprio lexema
            String token = "'" + t.getText() + "'";

            // Verificação de erro léxico
            if(verificaToken.equals("IDENT")   ||
               verificaToken.equals("CADEIA")  ||
               verificaToken.equals("NUM_INT") ||
               verificaToken.equals("NUM_REAL")){

                // Atribui o valor do tipo da regra para a string token
                token = verificaToken;

            // Tratamento de erros léxicos
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
        }

        // Se o erro não for léxico
        if(!erroLexico){

            // aponta o leitor para o nicio do arquivo
            cs.seek(0);

            // cria um novo lexer para análise sintática
            LALexer lexer2 = new LALexer(cs);
            CommonTokenStream tokens = new CommonTokenStream(lexer2);

            // Criando um parser e um listener para os erros sintáticos
            LAParser parser = new LAParser(tokens);
            LAErrorListener mcel = new LAErrorListener(saida);

            // Remove listener default
            parser.removeErrorListeners();

            // Adiciona o listener criado em LAErrorListener
            parser.addErrorListener(mcel);

            // Verifica possiveis erros semânticos
            LASemantico lasem = new LASemantico();
            lasem.visitPrograma(parser.programa());
            
            // Cria uma lista contendo os erros semanticos
            List<String> ErrosSemanticos = LASemanticoUtils.errosSemanticos;
            
            // Itera sobre a lista exibindos erros semanticos
            for(var es: ErrosSemanticos){
                saida.write((es + "\n").getBytes());
            }
        }

        saida.write(("Fim da compilacao\n").getBytes());
        saida.close();

    }
}

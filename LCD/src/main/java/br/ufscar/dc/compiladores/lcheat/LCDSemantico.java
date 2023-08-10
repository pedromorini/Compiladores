/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.lcheat;

import br.ufscar.dc.compiladores.lcheat.TabelaDeSimbolos.TipoLCheat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.antlr.v4.runtime.Token;

/**
 *
 * @author Pedro
 */
public class LCDSemantico extends LCDBaseVisitor<Void>{
    
    TabelaDeSimbolos tabela; // Tabela de simbolos
    HashMap<String, ArrayList<String>> listaCheats = new HashMap<>(); // Lista com os valores dos cheats
    HashMap<String, ArrayList<String>> listaFases = new HashMap<>(); // Lista com os nomes das fases
    
    boolean info = false;
    
    // Cria a ista para armazenar os erros semânticos
    public static List<String> errosSemanticos = new ArrayList<>();
    
    // Função para adicionar erros na lista
    public static void adicionarErroSemantico(Token t, String mensagem){
        int linha = t.getLine();
        errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
    }
 
    @Override
    public Void visitPrograma(LCDParser.ProgramaContext ctx){
        tabela = new TabelaDeSimbolos();
        
        // Verifica se as informações do jogo já foram declaradas
        if(ctx.getText().startsWith("nome")){
            if(info){
                adicionarErroSemantico(ctx.getStart(), "info ja declarada");
            }
        }
        
        return super.visitPrograma(ctx);
    }
    
    @Override
    public Void visitInfo(LCDParser.InfoContext ctx){
        info = true; // Para verificar informações
        return super.visitInfo(ctx);
    }
    
    @Override
    public Void visitCheat(LCDParser.CheatContext ctx){
        
        // Verifica se o nome da variavel já existe na tabela
        if(!tabela.existe(ctx.IDENT().getText())){ 
            
            ArrayList<String> valoresCheat = new ArrayList<>();
            valoresCheat.add(ctx.CADEIA().getText());
            
            // Adiciona os códigos do cheat se houver
            for(LCDParser.CodigoContext cod: ctx.codigo()){
                valoresCheat.add(cod.getText());
            }
                
            if(listaCheats.isEmpty()){ // Para quando a tabela esta vazia
                listaCheats.put(ctx.IDENT().getText(), valoresCheat);  
                tabela.adicionar(ctx.IDENT().getText(), TipoLCheat.Cheat); 
            }else{
                for(String c: listaCheats.keySet()){ // Itera o conjunto de chaves da lista de cheats
                    
                    // Verifica se o nome do cheat ja existe na lista
                    if(!listaCheats.get(c).contains(valoresCheat.get(0))){ 
                        
                        List<String> valoresSemIndice0 = valoresCheat.subList(1, valoresCheat.size()); 
                        boolean diferente = false;
                        
                        // verifica se os códigos do cheat ja existem na lista
                        for(String b: valoresSemIndice0){
                            if(!listaCheats.get(c).contains(b)){
                                diferente = true;
                            }
                        }
                        
                        // Adicioan na tabela na lista
                        if(diferente){
                            listaCheats.put(ctx.IDENT().getText(), valoresCheat);  
                            tabela.adicionar(ctx.IDENT().getText(), TipoLCheat.Cheat); 
                        }else{
                            adicionarErroSemantico(ctx.IDENT().getSymbol(), " 1 cheat ja declarado");
                        }
                 
                    }else{
                        adicionarErroSemantico(ctx.IDENT().getSymbol(), " 2 cheat ja declarado");
                    } 
                }
            }
                 
        }else{
            adicionarErroSemantico(ctx.IDENT().getSymbol(), ctx.IDENT().getText() + " 3 cheat ja declarado");
        }
        
        return super.visitCheat(ctx);
    }
    
    @Override
    public Void visitFase(LCDParser.FaseContext ctx){
        if(!tabela.existe(ctx.IDENT().getText())){ // Verifica se o nome da variavel ja existe
            
            ArrayList<String> nomesFases = new ArrayList<>();
            
            if(!nomesFases.contains(ctx.CADEIA().getText())){ // Verifica se o nome da fase ja existe na lista
                nomesFases.add(ctx.CADEIA().getText());
                listaFases.put(ctx.IDENT().getText(), nomesFases);  
                tabela.adicionar(ctx.IDENT().getText(), TipoLCheat.Fase);
            }else{
                adicionarErroSemantico(ctx.IDENT().getSymbol(), " 1 fase ja declarada");
            }
            
        }else{
            adicionarErroSemantico(ctx.IDENT().getSymbol(), " fase ja declarada");
        }
        
        return super.visitFase(ctx);
    }
    
    @Override
    public Void visitInstrucoes(LCDParser.InstrucoesContext ctx){
        for(LCDParser.InstrucaoContext instr: ctx.instrucao()){
            if(instr.IDENT() != null){
                if(!tabela.existe(instr.IDENT().getText())){ // Verifica se a variavel chamada existe
                    adicionarErroSemantico(instr.IDENT().getSymbol(), instr.IDENT().getText() + " nao declarado");
                }else{
                    if(instr.INDICE() != null){ // Verifica se tem indice
                        if(tabela.verificar(instr.IDENT().getText()) == TipoLCheat.Fase){ // Se tem indice não pode ser uma fase
                            adicionarErroSemantico(instr.IDENT().getSymbol(), "chamada nao compativel para " + instr.IDENT().getText());
                        }else{                     
                            int indice = Integer.parseInt(instr.INDICE().getText());
                            if(indice > listaCheats.get(instr.IDENT().getText()).size() - 1){ // Verifica se o valor do indice é compativel
                                adicionarErroSemantico(instr.IDENT().getSymbol(), "valor do indice nao compativel");
                            }
                        }
                    }
                }
            }
        }

        return super.visitInstrucoes(ctx);
    }
 
}

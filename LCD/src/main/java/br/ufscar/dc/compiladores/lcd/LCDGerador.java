/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.lcd;

import br.ufscar.dc.compiladores.lcd.LCDBaseVisitor;
import br.ufscar.dc.compiladores.lcd.LCDParser;
import br.ufscar.dc.compiladores.lcd.TabelaDeSimbolos.TipoLCD;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Pedro
 */
public class LCDGerador extends LCDBaseVisitor<Void>{
    
    StringBuilder saida;
    TabelaDeSimbolos tabela;
    HashMap<String, ArrayList<String>> listaCheats;
    HashMap<String, ArrayList<String>> listaFases;
    
    // Metodo construtor recebe a instancia do semantico, isso facilita as chamadas dos identificadores
    public LCDGerador(LCDSemantico lasem){ 
        saida = new StringBuilder();
        this.listaCheats = lasem.listaCheats;
        this.listaFases = lasem.listaFases;
        this.tabela = lasem.tabela;
    }
    
    public String reduzNome(String nome){ // Metodo para retirar as aspas das cadeias
        nome = nome.substring(1);
        nome = nome.substring(0, nome.length() - 1);
        return nome;
    }
    
    @Override
    public Void visitPrograma(LCDParser.ProgramaContext ctx){ 
        // Gera a maior parte do HTML exibindo as infos do jogo e chamando as declarações
        saida.append(
                "<!DOCTYPE html>" +
                "\n<html lang=\"pt-br\">" +
                "\n\t<head>" +
                "\n\t\t<title>Linguagem Detonados</title>" +
                "\n\t\t<style>" +
                "\n\t\t\tbody {" +
                "\n\t\t\t\tfont-family: Arial, sans-serif;" +
                "\n\t\t\t\tbackground-color: #1e1e1e;" +
                "\n\t\t\t\tcolor: white;" +
                "\n\t\t\t}" +                
                "\n\t\t\th1 {" +
                "\n\t\t\t\tmargin: 0;" +
                "\n\t\t\t\tpadding: 5px;" +
                "\n\t\t\t}" +
                "\n\t\t\th4 {" +
                "\n\t\t\t\tmargin-bottom: 5px;" +
                "\n\t\t\t\tmargin-top: 0;" +
                "\n\t\t\t}" +
                "\n\t\t\tp {" +
                "\n\t\t\t\tmargin: 0;" +
                "\n\t\t\t}" +
                "\n\t\t\t.image-container {" +
                "\n\t\t\t\tmax-width: auto;" +
                "\n\t\t\t\toverflow: hidden;" +
                "\n\t\t\t}" +
                "\n\t\t\t.image-container img {" +
                "\n\t\t\t\twidth: auto;" +
                "\n\t\t\t\theight: auto;" +
                "\n\t\t\t}" +
                "\n\t\t\t.item {" +
                "\n\t\t\t\twidth: auto; /* Alterado para ocupar metade da largura da janela */" +
                "\n\t\t\t\tfloat: left; /* Adicionado para colocar os itens lado a lado */" +
                "\n\t\t\t\tpadding: 10px;" +
                "\n\t\t\t}" +
                "\n\t\t\t.linhas {" +
                "\n\t\t\t\tdisplay: flex;" +
                "\n\t\t\t\tflex-direction: column;" +
                "\n\t\t\t}" +
                "\n\t\t\t.tabs {" +
                "\n\t\t\t\tdisplay: flex;" +
                "\n\t\t\t\tborder-bottom: 1px solid #ccc;" +
                "\n\t\t\t\tpadding: 0;" +
                "\n\t\t\t\tlist-style: none;" +
                "\n\t\t\t}" +
                "\n\t\t\t.tab {" +
                "\n\t\t\t\tflex: 1;" +
                "\n\t\t\t\tpadding: 10px 15px;" +
                "\n\t\t\t\tcursor: pointer;" +
                "\n\t\t\t\ttext-align: center;" +
                "\n\t\t\t\tbackground-color: #f2f2f2;" +
                "\n\t\t\t\tborder-right: 1px solid #ccc;" +
                "\n\t\t\t\tcolor: #1e1e1e;" +
                "\n\t\t\t}" +
                "\n\t\t\t.tab:last-child {" +
                "\n\t\t\t\tborder-right: none;" +
                "\n\t\t\t}" +
                "\n\t\t\t.tab.active {" +
                "\n\t\t\t\tbackground-color: #ccc;" +
                "\n\t\t\t}" +
                "\n\t\t\t.tab-content {" +
                "\n\t\t\t\tdisplay: none;" +
                "\n\t\t\t\tpadding: 20px;" +
                "\n\t\t\t\tborder: 1px solid #ccc;" +
                "\n\t\t\t\tborder-top: none;" +
                "\n\t\t\t}" +
                "\n\t\t\t.tab-content.active {" +
                "\n\t\t\t\tdisplay: block;" +
                "\n\t\t\t}" +        
                "\n\t\t</style>" +
                "\n\t</head>" +
                "\n\t<body>" +
                "\n\t\t<ul class=\"tabs\">" +
                "\n\t\t\t<li class=\"tab active\" onclick=\"openTab(event, 'content1')\">PS1</li>" +
                "\n\t\t\t<li class=\"tab\" onclick=\"openTab(event, 'content2')\">PS2</li>" +
                "\n\t\t</ul>" +
                "\n\t\t<div id=\"content1\" class=\"tab-content active\">"     
        );
        
        // Se o tipo do console for ps1 declara o jogo na aba ps1
        if(ctx.info().tipo().getText().equals("ps1")){
            visitInfo(ctx.info());
            visitDeclaracoes(ctx.declaracoes());
            saida.append("\n\t\t\t</div>");
        }
        
        saida.append(
                "\n\t\t</div>" +
                "\n\t\t<div id=\"content2\" class=\"tab-content\">"
        );

        // Se o tipo do console for ps1 declara o jogo na aba ps2
        if(ctx.info().tipo().getText().equals("ps2")){    
            visitInfo(ctx.info());
            visitDeclaracoes(ctx.declaracoes());
            saida.append("\n\t\t\t</div>");
        }
        
        // Script das abas
        saida.append(
                "\n\t\t</div>" +
                "\n\t\t<script>" +
                "\n\t\t\tfunction openTab(evt, tabName) {" +
                "\n\t\t\t\tvar i, tabContent, tab;" +
                "\n\t\t\t\ttabContent = document.getElementsByClassName(\"tab-content\");" +
                "\n\t\t\t\tfor (i = 0; i < tabContent.length; i++) {" +
                "\n\t\t\t\t\ttabContent[i].classList.remove(\"active\");" +
                "\n\t\t\t\t}" +
                "\n\t\t\t\ttab = document.getElementsByClassName(\"tab\");" +
                "\n\t\t\t\tfor (i = 0; i < tab.length; i++) {" +
                "\n\t\t\t\t\ttab[i].classList.remove(\"active\");" +
                "\n\t\t\t\t}" +
                "\n\t\t\t\tdocument.getElementById(tabName).classList.add(\"active\");" +
                "\n\t\t\t\tevt.currentTarget.classList.add(\"active\");" +
                "\n\t\t\t}" +
                "\n\t\t</script>" +
                "\n\t</body>" +
                "\n</html>"
        );
        
        return null;
    }
    
    @Override
    public Void visitInfo(LCDParser.InfoContext ctx){ // Declara as informações do jogo
        saida.append(
                "\n\t\t\t<div class=\"item\">" +
                "\n\t\t\t\t<div class=\"imagem-container\">" +
                "\n\t\t\t\t\t<img src =" + ctx.CADEIA(1) + ">" +
                "\n\t\t\t\t</div>" +
                "\n\t\t\t</div>" +
                "\n\t\t\t<div class=\"linhas\">" +
                "\n\t\t\t\t<h1>" + reduzNome(ctx.CADEIA(0).getText()) + " - " + ctx.tipo().getText() + "</h1>"
        ); 
        
        
        return null;
    }
    
    @Override
    public Void visitDeclaracoes(LCDParser.DeclaracoesContext ctx){
        
        // Chama as declarações dos cheats
        saida.append("\n\t\t\t<h2 style=\"margin-left: 10px; margin-bottom: 5px\">Cheats - Dicas - Truques - Codigos</h2>");
        ctx.cheat().forEach(cheat -> visitCheat(cheat));
        
        // Chama as declarações das fases
        saida.append("\n\t\t\t<h2 style=\"margin-left: 10px; margin-bottom: 5px\">Fases</h2>");
        ctx.fase().forEach(fs -> visitFase(fs));
        
        return null;
    }
    
    @Override
    public Void visitCheat(LCDParser.CheatContext ctx){
        
        saida.append("\n\t\t\t<div class=\"item\">");
        saida.append("\n\t\t\t\t<h4 id=\"" + ctx.IDENT().getText() + "\">" + reduzNome(ctx.CADEIA().getText()) + "</h4>");
        
        if(ctx.instrucoes() != null){ // Verifica se o cheat possui instrucoes e chama elas
            saida.append("\n\t\t\t\t");
            saida.append("<p>");
            visitInstrucoes(ctx.instrucoes());
            saida.append("</p>");
        }
        
        saida.append("\n\t\t\t</div>");
        
        return null;
    }
    
    @Override
    public Void visitFase(LCDParser.FaseContext ctx){
        
        saida.append("\n\t\t\t");
        saida.append("<div class=\"item\">");
        saida.append("\n\t\t\t\t");
        saida.append("<h4 id=\"" + ctx.IDENT().getText() + "\">" + reduzNome(ctx.CADEIA().getText()) + "</h4>");
        
        saida.append("\n\t\t\t\t");
        saida.append("<p>");
        visitInstrucoes(ctx.instrucoes());
        saida.append("</p>");
        
        saida.append("\n\t\t\t");
        saida.append("</div>");
        
        return null;
    }
    
    @Override
    public Void visitInstrucoes(LCDParser.InstrucoesContext ctx){
        
        for(LCDParser.InstrucaoContext instr: ctx.instrucao()){
            
            if(instr.CADEIA() != null){    
                saida.append(reduzNome(instr.CADEIA().getText()));         
            }else{ 
                if(instr.INDICE() != null){ // Se tem indice então é um cheaat, faz a chamada na lista dos cheats
                    int indice = Integer.parseInt(instr.INDICE().getText());
                    if(indice == 0){
                        saida.append(reduzNome(listaCheats.get(instr.IDENT().getText()).get(indice)));
                    }else{
                        saida.append(listaCheats.get(instr.IDENT().getText()).get(indice));
                    }
                }else{
                    // Se não tem indice pode ser tanto cheat quanto fase porque significa que estão chamando o nome armazenado
                    if(tabela.verificar(instr.IDENT().getText()) == TipoLCD.Cheat){
                        saida.append("<a href=\"#" + instr.IDENT().getText() + "\">" + reduzNome(listaCheats.get(instr.IDENT().getText()).get(0)) + "</a>");
                    }else{
                        saida.append("<a href=\"#" + instr.IDENT().getText() + "\">" + reduzNome(listaFases.get(instr.IDENT().getText()).get(0)) + "</a>");
                    }
                }
            }
            
        }

        return null;
    }
}
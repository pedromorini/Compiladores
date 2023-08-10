/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.lcheat;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pedro
 */
public class TabelaDeSimbolos {
    public enum TipoLCheat{
        Fase,
        Cheat,
        Invalido
    }
    
    class EntradaTabelaDeSimbolos{
        String nome;
        TipoLCheat tipo;
        
        private EntradaTabelaDeSimbolos(String nome, TipoLCheat tipo){
            this.nome = nome;
            this.tipo = tipo;
        }
    }
    
    private final Map<String, EntradaTabelaDeSimbolos> tabela;
    
    public TabelaDeSimbolos(){
        this.tabela = new HashMap<>();
    }
    
    public void adicionar(String nome, TipoLCheat tipo){
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, tipo));
    }
    
    public boolean existe(String nome){
        return tabela.containsKey(nome);
    }
    
    public TipoLCheat verificar(String nome){
        return tabela.get(nome).tipo;
    }
}

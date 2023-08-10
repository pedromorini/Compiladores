/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.lcd;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pedro
 */
public class TabelaDeSimbolos {
    public enum TipoLCD{
        Fase,
        Cheat,
        Invalido
    }
    
    class EntradaTabelaDeSimbolos{
        String nome;
        TipoLCD tipo;
        
        private EntradaTabelaDeSimbolos(String nome, TipoLCD tipo){
            this.nome = nome;
            this.tipo = tipo;
        }
    }
    
    private final Map<String, EntradaTabelaDeSimbolos> tabela;
    
    public TabelaDeSimbolos(){
        this.tabela = new HashMap<>();
    }
    
    public void adicionar(String nome, TipoLCD tipo){
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, tipo));
    }
    
    public boolean existe(String nome){
        return tabela.containsKey(nome);
    }
    
    public TipoLCD verificar(String nome){
        return tabela.get(nome).tipo;
    }
}

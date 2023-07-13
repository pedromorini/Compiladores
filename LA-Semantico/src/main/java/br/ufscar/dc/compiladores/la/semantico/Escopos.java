/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.la.semantico;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class Escopos {
    private LinkedList<TabelaDeSimbolos> pilhaDeTabelas;
    
    public Escopos(){
        pilhaDeTabelas = new LinkedList<>();
        criarNovoEscopo();
    }
    
    public void criarNovoEscopo(){
        pilhaDeTabelas.push(new TabelaDeSimbolos());
    }
    
    public TabelaDeSimbolos obterEscopoAtual(){
       return pilhaDeTabelas.peek(); 
    }
    
    public List<TabelaDeSimbolos> percorrerEscopoAninhados(){
        return pilhaDeTabelas;
    }
    
    public void abandonarEscopo(){
        pilhaDeTabelas.pop();
    }
    
}

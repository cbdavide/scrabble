/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import modelo.Diccionario;

/**
 *
 * @author david
 */
public class Verificador {
    
    private Diccionario diccionario;
    
    public void setDiccionario(Diccionario d){
        this.diccionario = d;
    }
    
    public Verificador(Diccionario d){
        this.diccionario = d;
    }
    
    public boolean verify(String word){
        return this.diccionario.searchWord(word);
    }
    
}

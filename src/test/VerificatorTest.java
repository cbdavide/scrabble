/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import modelo.Diccionario;
import modelo.DiccionarioES;
import controlador.Verificador;

/**
 *
 * @author david
 */
public class VerificatorTest {
    public static void main(String[] args){
        Diccionario d = new DiccionarioES();
        Verificador v = new Verificador(d);
        if(v.verify("AÑOS"))
            System.out.println("La palabra existe!!");
        else
            System.out.println("La palabra NO! existe");
        char l = 209;
        
        System.out.println((char)209);
    }
}

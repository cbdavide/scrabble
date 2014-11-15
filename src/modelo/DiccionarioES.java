/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.File;

/**
 *
 * @author david
 */
public class DiccionarioES extends Diccionario{
    
    @Override
    protected void selectFile(char firstLetter){
        this.file = new File("src/data/es/"+firstLetter+".txt");
    }
    
}

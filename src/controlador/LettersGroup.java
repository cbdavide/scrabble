/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public abstract class LettersGroup {
    
    protected ArrayList<Letter> letters;
    
    public ArrayList<Letter> getLetters(){
        return this.letters;
    }
    
    protected void assign(int nTimes,String letter,int value){
        for(int i=0;i<nTimes;i++){
            Letter temp = new Letter();
            temp.setSymbol(letter);
            temp.setValue(value);
            letters.add(temp);
        }
    }
    
    protected abstract void assignation();
}

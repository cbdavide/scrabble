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
public class Dealer {
    
    protected LettersGroup lettersGroup;
    protected ArrayList<Letter> letters;
    
    public Dealer(LettersGroup lg){
        this.lettersGroup = lg;
        asignLetters();
    }
    /**
     * Assign letters of the LettersGroup to the local
     * Arraylist letters
     */
    protected final void asignLetters(){
        letters = lettersGroup.getLetters();
    }
    
    /**
     * This method fill a hand giving it
     * the letters that it needs
     * @param h Hand that is going to be filled
     */    
    public void fillHand(Hand h){
        boolean cond = true;
        
        while(cond){
            Letter randomLetter = randomLetter();
            
            if(h.addLetter(randomLetter))
                turnOffLetter(randomLetter);
            else
                cond = false;
                
        }            
    }
    
    /**
     * Selects a letter which is on
     */
    private Letter randomLetter(){
        boolean cond = true;
        Letter temp = null;
        
        while(cond){
            int random = (int)(Math.random() * (getSizeLetters()));

            if(isLetterOn(letters.get(random))){
                cond = false;
                temp = letters.get(random);
            }
            
        }        
        return temp;
    }
    
    private int getSizeLetters(){
        return letters.toArray().length;
    }
    
    private boolean isLetterOn(Letter l){
        return l.isOn();
    }
    
    private void turnOffLetter(Letter l){
        l.toogleLeter(false);
    }   
       
}

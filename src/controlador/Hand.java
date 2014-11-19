/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Hand implements Serializable {

    private ArrayList<Letter> letters;
    private final int LENGTH = 7;

    public Hand() {
        letters = new ArrayList<>();
    }
    
    public void setLetters(ArrayList<Letter> l){
        this.letters = l;
    }

    public boolean addLetter(Letter l) {

        if (letters.toArray().length < this.LENGTH) {
            letters.add(l);
            return true;
        } else {
            return false;
        }
    }

    public void removeLetter(Letter l) {
        int index = letters.indexOf(l);
        letters.remove(index);
    }

    public Letter getLetter(int index) {
        return letters.get(index);
    }

    public ArrayList<Letter> getetters() {
        return this.letters;
    }

}

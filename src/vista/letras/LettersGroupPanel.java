/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.letras;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import controlador.Letter;
import controlador.LettersGroup;

/**
 *
 * @author david
 */
public class LettersGroupPanel extends JPanel{
    
    private LettersGroup lettersGroup;
    private ArrayList<GraficLetter> grfLetters;
    private GridLayout layout;
    
    private final int COLS = 5;
    private final int ROWS;

    
    public LettersGroupPanel(LettersGroup lg){
        this.lettersGroup = lg;
        ROWS = getSizePanel();
        grfLetters = new ArrayList<>();
        configLayout();
    }
    
    private void configLayout(){
        layout = new GridLayout(ROWS,COLS);
        setLayout(layout);
    }
    
    public void addGrfLetters(){
        this.removeAll();
        updateUI();
        for(GraficLetter l : grfLetters){
            add(l);
        }
    }
    
    private int getSizePanel(){
        int size;
        size = lettersGroup.getLetters().toArray().length + 1;
        return size/COLS;
    }
    
    public void join(){
        grfLetters = new ArrayList<>();
        for(Letter l : lettersGroup.getLetters()){
            grfLetters.add(new GraficLetter(l));
        }
    }
    
    public void setLettersGroup(LettersGroup l){
        this.lettersGroup = l;
    }    
}

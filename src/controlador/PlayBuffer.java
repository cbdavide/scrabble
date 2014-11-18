/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.util.ArrayList;
import vista.board.Board;
import vista.hand.GraficHand;
import vista.letras.GraficLetter;

/**
 *
 * @author david
 */
public class PlayBuffer {
    
    private final ArrayList<GraficLetter> newLetters;
    private final ArrayList<GraficLetter> olderLetters;
    
    private final Board board;
    private final GraficHand graficHand;
    
    public PlayBuffer(Board b, GraficHand g){
        newLetters = new ArrayList<>();
        olderLetters = new ArrayList<>();
        this.board = b;
        this.graficHand = g;
    }
    
    public GraficHand getGraficHand(){
        return this.graficHand;
    }
    
    public Board getBoard(){
        return this.board;
    }
    
    public void addLetter(GraficLetter gl){
        newLetters.add(gl);
    }
    
    public void returnLetters(){
        for(GraficLetter gl : newLetters){
            board.removeLetter(gl);
        }
        newLetters.removeAll(newLetters);
        graficHand.addLetters();
        graficHand.addGraficLetterListener();
    }
    
}

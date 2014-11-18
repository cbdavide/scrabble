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

    public PlayBuffer(Board b, GraficHand g) {
        newLetters = new ArrayList<>();
        olderLetters = new ArrayList<>();
        this.board = b;
        this.graficHand = g;
    }

    public GraficHand getGraficHand() {
        return this.graficHand;
    }

    public Board getBoard() {
        return this.board;
    }

    public void addLetter(GraficLetter gl) {
        newLetters.add(gl);
    }

    public void returnLetters() {
        for (GraficLetter gl : newLetters) {
            board.removeLetter(gl);
        }
        newLetters.removeAll(newLetters);
        graficHand.addLetters();
        graficHand.addGraficLetterListener();
    }
    
    public String armarPalabra(){
        
        int[] posPrimerLetraPuesta = board.getPos(newLetters.get(0));
        boolean isRow = isRow(posPrimerLetraPuesta[0]);
        boolean isCol = isCol(posPrimerLetraPuesta[1]);
        
        if(!isRow && !isCol){
            return null;
        }
        
        if(isRow){
           int row = posPrimerLetraPuesta[0]; 
            System.out.println("f"+board.getColFirstLetter(row, newLetters));
            System.out.println("l"+board.getColLastLetter(row, newLetters));
            
        }else if(isCol){
            int col = posPrimerLetraPuesta[1];
            System.out.println("f"+board.getRowFirsLetter(col, newLetters));
            System.out.println("l"+board.getRowLastLetter(col, newLetters));
        }
        
        return "Hola";
    }

    /**
     * Esta función verifica que todas las letras se encuentren en la misma fila
     *
     * @param row Fila que se va a evaluar.
     * @return boolean respuesta
     */
    private boolean isRow(int row) {

        for (GraficLetter gl : newLetters) {

            if (board.getPos(gl)[0] != row) {
                return false;
            }
        }

        return true;
    }

    /**
     * Esta función verifica que todas las letras se encuentren en la misma
     * columna.
     * 
     * @param col Columna que se va a evaluar
     * @return boolean respuesta
     */
    private boolean isCol(int col) {

        for (GraficLetter gl : newLetters) {
            
            if(board.getPos(gl)[1] != col){
                return false;
            }
        }
        
        return true;
    }

}

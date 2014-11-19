/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import vista.board.Board;
import vista.board.LetterContainer;
import vista.hand.GraficHand;
import vista.letras.GraficLetter;

/**
 *
 * @author david
 */
public class PlayBuffer implements Serializable{

    private final ArrayList<GraficLetter> newLetters;
    private ArrayList<GraficLetter> palabra;
    private ArrayList<LetterContainer> leterContainers;

    private final Board board;
    private final GraficHand graficHand;

    private final BoardAnalyzer boardAnalyzer;

    public PlayBuffer(Board b, GraficHand g) {
        newLetters = new ArrayList<>();
        palabra = new ArrayList<>();
        this.board = b;
        this.graficHand = g;
        boardAnalyzer = new BoardAnalyzer(board);
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

    public Object[] armarPalabra() {

        int[] posPrimerLetraPuesta = boardAnalyzer.getPos(newLetters.get(0));
        boolean isRow = isRow(posPrimerLetraPuesta[0]);
        boolean isCol = isCol(posPrimerLetraPuesta[1]);

        if (!isRow && !isCol) {
            return null;
        }

        if (isRow) {
            int row = posPrimerLetraPuesta[0];
            int colF = boardAnalyzer.getColFirstLetter(row, newLetters);
            int colL = boardAnalyzer.getColLastLetter(row, newLetters);
            palabra = boardAnalyzer.getLetrasPalabraH(row, colF, colL);
            leterContainers = boardAnalyzer.getLetterContainerH(row, colF, colL);

        } else if (isCol) {
            int col = posPrimerLetraPuesta[1];
            int rowF = boardAnalyzer.getRowFirsLetter(col, newLetters);
            int rowL = boardAnalyzer.getRowLastLetter(col, newLetters);
            palabra = boardAnalyzer.getLetrasPalabraV(col, rowF, rowL);
            leterContainers = boardAnalyzer.getLetterContainerV(col, rowF, rowL);
        }

        if (palabra == null) {
            return null;
        }

        String word = word(palabra);
        int puntos = puntaje(palabra,leterContainers);
        
        Object[] x = {word,puntos};
        
        return x;
    }

    private int puntaje(ArrayList<GraficLetter> palabra, ArrayList<LetterContainer> cajas) {
        int puntaje = 0;
        int i = 0;
        for (GraficLetter gl : palabra) {

            if (!cajas.get(i).isFullWord()) {
                puntaje += gl.getLetter().getValue() * cajas.get(i).getValue();
            } else {
                puntaje += gl.getLetter().getValue() * 1;
            }
            i++;
        }
        //DW TW
        for(LetterContainer lc : cajas){
            if(lc.isFullWord())
                puntaje *= lc.getValue();
        }

        return puntaje;
    }

    private String word(ArrayList<GraficLetter> letras) {
        StringBuilder word = new StringBuilder();
        for (GraficLetter gl : palabra) {
            word.append(gl.getLetter().getSymbol());
        }
        return word.toString();
    }

    /**
     * Esta función verifica que todas las letras se encuentren en la misma fila
     *
     * @param row Fila que se va a evaluar.
     * @return boolean respuesta
     */
    private boolean isRow(int row) {

        for (GraficLetter gl : newLetters) {

            if (boardAnalyzer.getPos(gl)[0] != row) {
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

            if (boardAnalyzer.getPos(gl)[1] != col) {
                return false;
            }
        }

        return true;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.board;

import controlador.PlayBuffer;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import vista.letras.GraficLetter;

/**
 *
 * @author david
 */
public class Board extends JPanel implements Serializable {

    private LetterContainer[][] boxes;

    public static final int COLS = 15;
    public static final int ROWS = 15;

    public Board() {
        boxes = new LetterContainer[ROWS][COLS];
        configLayout();
        setBorder(BorderFactory.createLineBorder(new Color(02, 153, 153), 3));
    }

    private void configLayout() {
        setLayout(new GridLayout(ROWS, COLS, 0, 0));
    }

    public void setPlayBuffer(PlayBuffer pb) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                boxes[i][j].setPlayBuffer(pb);
            }
        }
    }

    public void removeLetter(GraficLetter gl) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (boxes[i][j].getGraficLetter() == gl) {
                    boxes[i][j].setGraficLetter(null);
                    boxes[i][j].addLabel();
                    break;
                }
            }
        }
    }

    public void setLetterContainer(LetterContainer[][] boxes) {
        this.boxes = boxes;
    }

    public LetterContainer getBox(int i, int j) {
        return boxes[i][j];
    }

    public LetterContainer[][] getBoxes() {
        return this.boxes;
    }

    public void addBoxes() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                add(boxes[i][j]);
            }
        }
    }

    public void updateBoard() {
        updateUI();
    }

}

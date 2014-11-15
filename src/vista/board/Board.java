/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.board;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class Board extends JPanel implements Serializable{

    private LetterContainer[][] boxes;

    private final int COLS = 15;
    private final int ROWS = 15;

    public Board() {
        boxes = new LetterContainer[ROWS][COLS];
        configLayout();
        setBorder(BorderFactory.createLineBorder(new Color(02, 153, 153), 3));
    }

    private void configLayout() {
        setLayout(new GridLayout(ROWS, COLS, 0, 0));
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

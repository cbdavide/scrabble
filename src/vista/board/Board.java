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

    public void setPlayBuffer(PlayBuffer pb) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                boxes[i][j].setPlayBuffer(pb);
            }
        }
    }

    /**
     * Obtener la posición i,j de una latra.
     *
     * @param gl Letra que se va a buscar
     * @return posición de la letra
     */
    public int[] getPos(GraficLetter gl) {
        int[] NULL = {-1, -1};
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (boxes[i][j].getGraficLetter() == gl) {
                    int pos[] = {i, j};
                    return pos;
                }
            }
        }
        return NULL;
    }

    /**
     * Encontrar la columna en donde se encuentra la primera letra. Se usa en
     * caso de que la palabra sea horizontal.
     *
     * @param row Fila en la que se va a buscar
     * @param letras Letras que se van a comparar
     * @return Columna de la primera letra
     */
    public int getColFirstLetter(int row, ArrayList<GraficLetter> letras) {

        for (int j = 0; j < COLS; j++) {

            for (GraficLetter gl : letras) {

                if (boxes[row][j].getGraficLetter() == gl) {
                    j = letraColumnaAnterior(row, j);
                    return j;
                }
            }
        }
        return -1;
    }

    public int getColLastLetter(int row, ArrayList<GraficLetter> letras) {

        for (int j = (COLS - 1); j >= 0; j--) {

            for (GraficLetter gl : letras) {
                if (boxes[row][j].getGraficLetter() == gl) {
                    j = letraColumnaPosterior(row, j);
                    return j;
                }
            }
        }
        return -1;
    }

    /**
     * Encontrar la fila en donde se encuentra la primera letra. Se usa en caso
     * de que la palabra sea vertical.
     *
     * @param col Fila en la que se va a buscar
     * @param letras Letras que se van a comparar
     * @return Columna de la primera letra
     */
    public int getRowFirsLetter(int col, ArrayList<GraficLetter> letras) {

        for (int i = 0; i < ROWS; i++) {

            for (GraficLetter gl : letras) {

                if (boxes[i][col].getGraficLetter() == gl) {
                    i = letraFilaAnterior(i, col);
                    return i;
                }
            }
        }
        return -1;
    }

    public int getRowLastLetter(int col, ArrayList<GraficLetter> letras) {

        for (int i = (ROWS - 1); i >= 0; i--) {

            for (GraficLetter gl : letras) {

                if (boxes[i][col].getGraficLetter() == gl) {
                    i = letraFilaPosterior(i,col);
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Determinar si hay alguna letra puesta anteriormente.
     *
     * @param row Fila
     * @para col columna
     * @return colomna posicion de la primera letra anterior (PUESTA EN OTRO
     * TURNO)
     */
    private int letraColumnaAnterior(int row, int col) {
        while (true) {
            if (col > 0) {
                if (boxes[row][col - 1].getGraficLetter() != null) {
                    col--;
                } else {
                    return col;
                }
            } else {
                return col;
            }
        }
    }

    private int letraColumnaPosterior(int row, int col) {
        while (true) {
            if (col < (COLS - 1)) {
                if (boxes[row][col + 1].getGraficLetter() != null) {
                    col++;
                } else {
                    return col;
                }
            } else {
                return col;
            }
        }
    }

    /**
     * Determinar si hay alguna letra puesta anteriormente.
     *
     * @param row Fila
     * @para col columna
     * @return fila posicion de la primera letra anterior (PUESTA EN OTRO TURNO)
     */
    private int letraFilaAnterior(int row, int col) {
        while (true) {
            if (row > 0) {
                if (boxes[row - 1][col].getGraficLetter() != null) {
                    row--;
                } else {
                    return row;
                }
            } else {
                return row;
            }
        }
    }

    private int letraFilaPosterior(int row, int col) {
        while (true) {
            if (row < (ROWS - 1)) {
                if (boxes[row + 1][col].getGraficLetter() != null) {
                    row++;
                } else {
                    return row;
                }
            } else {
                return row;
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

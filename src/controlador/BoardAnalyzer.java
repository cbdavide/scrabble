/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import vista.board.Board;
import vista.board.LetterContainer;
import vista.letras.GraficLetter;

/**
 *
 * @author david
 */
public class BoardAnalyzer {

    private final Board board;

    private final LetterContainer[][] boxes;

    public BoardAnalyzer(Board b) {
        this.board = b;
        boxes = board.getBoxes();
    }

    /**
     * Obtener la posición i,j de una latra.
     *
     * @param gl Letra que se va a buscar
     * @return posición de la letra
     */
    public int[] getPos(GraficLetter gl) {
        int[] NULL = {-1, -1};
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLS; j++) {
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

        for (int j = 0; j < Board.COLS; j++) {

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

        for (int j = (Board.COLS - 1); j >= 0; j--) {

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

        for (int i = 0; i < Board.ROWS; i++) {

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

        for (int i = (Board.ROWS - 1); i >= 0; i--) {

            for (GraficLetter gl : letras) {

                if (boxes[i][col].getGraficLetter() == gl) {
                    i = letraFilaPosterior(i, col);
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
            if (col < (Board.COLS - 1)) {
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
            if (row < (Board.ROWS - 1)) {
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

    /**
     * Obtener las letras que conforman una palabra vertical.
     *
     * @param row Fila en la que se encuentra la palabra
     * @param colIn Columna en la que inicia la palabra
     * @param colLast Columna en la que finaliza la palabra
     * @return Letras que conforman la palabra
     */
    public ArrayList<GraficLetter> getLetrasPalabraH(int row, int colIn, int colLast) {
        ArrayList<GraficLetter> temp = new ArrayList<>();

        for (int j = colIn; j <= colLast; j++) {
            if (boxes[row][j].getGraficLetter() != null) {
                temp.add(boxes[row][j].getGraficLetter());
            } else {
                return null;
            }
        }

        return temp;
    }

    public ArrayList<GraficLetter> getLetrasPalabraV(int col, int rowIn, int rowLast) {
        ArrayList<GraficLetter> temp = new ArrayList<>();

        for (int i = rowIn; i <= rowLast; i++) {
            if (boxes[i][col].getGraficLetter() != null) {
                temp.add(boxes[i][col].getGraficLetter());
            } else {
                return null;
            }
        }

        return temp;
    }

    public ArrayList<LetterContainer> getLetterContainerV(int col, int rowIn, int rowLast) {
        ArrayList<LetterContainer> temp = new ArrayList<>();
        for (int i = rowIn; i <= rowLast; i++) {
            temp.add(boxes[i][col]);
        }
        return temp;
    }

    public ArrayList<LetterContainer> getLetterContainerH(int row, int colIn, int colLast) {
        ArrayList<LetterContainer> temp = new ArrayList<>();

        for (int j = colIn; j <= colLast; j++) {
            temp.add(boxes[row][j]);
        }

        return temp;
    }

}

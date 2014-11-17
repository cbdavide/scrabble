/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import controlador.Letter;
import java.awt.GridLayout;
import javax.swing.JFrame;
import vista.board.LetterContainer;
import vista.board.SimpleLetterContainer;
import vista.letras.GraficLetter;

/**
 *
 * @author david
 */
public class DragTest {
    public static void main(String[]args){
        JFrame frame = new JFrame("DragTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout());
        Letter l = new Letter();
        l.setSymbol("A");
        l.setValue(1);
        GraficLetter letter = new GraficLetter(l);
        letter.addDraggableMouseListener();
        //
        LetterContainer lC = new SimpleLetterContainer();
        frame.add(letter);
        frame.add(lC);
        frame.pack();
        frame.setVisible(true);
    }
}

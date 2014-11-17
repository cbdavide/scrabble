/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import javax.swing.JFrame;
import controlador.ENLettersGroup;
import controlador.ESLettersGroup;
import controlador.LettersGroup;
import vista.letras.LettersGroupPanel;

/**
 *
 * @author david
 */
public class GraficLettersGroupTest {
    public static void main(String[]args){
        LettersGroup lg = new ESLettersGroup();
        lg.getLetters().get(10).toogleLeter(false);
        lg.getLetters().get(3).toogleLeter(false);
        lg.getLetters().get(50).toogleLeter(false);
        LettersGroup lg2 = new ENLettersGroup();
        JFrame frame = new JFrame("Test LettersGroupPanel");
        LettersGroupPanel panel = new LettersGroupPanel(lg);
        frame.add(panel);
        panel.join();
        panel.addGrfLetters();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);         
    }
    
}

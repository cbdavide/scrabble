/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import javax.swing.JFrame;
import controlador.Dealer;
import controlador.ESLettersGroup;
import controlador.Hand;
import controlador.Letter;
import controlador.LettersGroup;
import vista.letras.GraficLetter;
import vista.hand.PanelHand;

/**
 *
 * @author david
 */
public class GraficHandTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("TestClassicBoard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LettersGroup lg = new ESLettersGroup();
        Dealer ganstaDealer = new Dealer(lg);
        Hand h1 = new Hand();
        ganstaDealer.fillHand(h1);
        ArrayList<GraficLetter> graficLetters = new ArrayList<>();
        for (Letter l : h1.getetters()) {
            GraficLetter temp = new GraficLetter(l);
            temp.paintClientLetter();
            graficLetters.add(temp);
        }
        PanelHand graficHand = new PanelHand();
        graficHand.setLetters(graficLetters);
        graficHand.addLetters();
        frame.add(graficHand);
        frame.pack();        
        frame.setVisible(true);
    }
}

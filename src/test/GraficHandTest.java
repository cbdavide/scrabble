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
import vista.ListenerLetraBoard;
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
        Hand h2 = new Hand();
        ganstaDealer.fillHand(h2);
        System.out.println("H1");
        for(Letter l : h1.getetters()){
            System.out.print(l.getSymbol());
        }
        System.out.println("");
        System.out.println("H2");
        for(Letter l : h2.getetters()){
            System.out.print(l.getSymbol());
        }
        System.out.println("");
        ListenerLetraBoard lb = new ListenerLetraBoard();
        PanelHand graficHand = new PanelHand(lb);
        graficHand.setHand(h1);
        graficHand.addLetters();
        frame.add(graficHand);
        frame.pack();        
        frame.setVisible(true);
        graficHand.setHand(h2);
        graficHand.addLetters();
        graficHand.addGraficLetterListener();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.awt.GridLayout;
import javax.swing.JFrame;
import vista.board.LetterContainerFactory;

/**
 *
 * @author david
 */
public class LetterContainerTest {
    
    public static void main(String[]args){
        JFrame grame = new JFrame();
        grame.setLayout(new GridLayout());
        grame.setTitle("LetterContainerTest");
        grame.add(LetterContainerFactory.createStartLetterContainer());
        grame.add(LetterContainerFactory.createTWLetterContainer());
        grame.add(LetterContainerFactory.createDWLetterContainer());
        grame.add(LetterContainerFactory.createTLLetterContainer());
        grame.add(LetterContainerFactory.createDLLetterContainer());
        grame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        grame.pack();
        grame.setVisible(true);
    }
    
}

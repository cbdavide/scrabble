/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import controlador.Letter;
import javax.swing.JFrame;
import vista.board.Board;
import vista.board.BoardBuilder;
import vista.board.BoardDirector;
import vista.board.ClassicBoardBuilder;
import vista.letras.GraficLetter;

/**
 *
 * @author david
 */
public class ClassicBoardTest {
    
    public static void main(String[]args){
        JFrame frame = new JFrame();
        frame.setTitle("TestClassicBoard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /**Board Par*/
        Board board = new Board();
        BoardBuilder builder = new ClassicBoardBuilder();
        BoardDirector director = new BoardDirector(builder);
        director.construct();
        board.setLetterContainer(director.getLetterContainers());
        board.addBoxes();
        frame.add(board);
        frame.pack();
        frame.setVisible(true);
        Board b2 = new Board();
        BoardBuilder builder2 = new ClassicBoardBuilder();
        BoardDirector director2 = new BoardDirector(builder2);
        board.setLetterContainer(director2.getLetterContainers());
        board.addBoxes();
        Letter l = new Letter();
        l.setSymbol("A");
        l.setValue(5);
        //board.getBox(7, 7).setGraficLetter(new GraficLetter(l));
    }
    
}

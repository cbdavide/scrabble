/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import javax.swing.JFrame;
import vista.board.Board;
import vista.board.BoardBuilder;
import vista.board.BoardDirector;
import vista.board.ClassicBoardBuilder;

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
    }
    
}

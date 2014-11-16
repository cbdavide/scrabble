/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controlador.ESLettersGroup;
import controlador.Letter;
import controlador.LettersGroup;
import controlador.servidor.Game;
import modelo.Diccionario;
import modelo.DiccionarioES;
import vista.board.Board;
import vista.board.BoardBuilder;
import vista.board.BoardDirector;
import vista.board.ClassicBoardBuilder;

/**
 *
 * @author david
 */
public class InitiationProtocolServerTest {

    public static void main(String[] agrs) {
        System.out.println("InitiantionProtocolTest(Server)");
        //Diccionario
        Diccionario diccionario = new DiccionarioES();
        //Board Par
        Board board = new Board();
        BoardBuilder builder = new ClassicBoardBuilder();
        BoardDirector director = new BoardDirector(builder);
        director.construct();
        board.setLetterContainer(director.getLetterContainers());
        board.addBoxes();
        LettersGroup lg = new ESLettersGroup();
        //*******************************************************
        int nJugadores = 4;
        Game g = new Game(nJugadores, lg,board,diccionario);
        g.initiationProtocol();
        for (Letter l : lg.getLetters()) {
            if (l.isOn()) {
                System.out.print(l.getSymbol() + " ");
            } else {
                System.out.print("- ");
            }
        }
        g.gameLoopProtocol();
    }
}

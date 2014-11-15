/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Color;
import java.util.ArrayList;
import controlador.Dealer;
import controlador.ESLettersGroup;
import controlador.Hand;
import controlador.Letter;
import controlador.LettersGroup;
import vista.letras.GraficLetter;
import vista.playerInfo.PlayerInfoGroupPanel;
import vista.playerInfo.PlayerInfoPanel;
import vista.board.Board;
import vista.board.BoardBuilder;
import vista.board.BoardDirector;
import vista.board.ClassicBoardBuilder;
import vista.hand.PanelHand;
import vista.window.ClientWindow;

/**
 *
 * @author david
 */
public class ClientWindowTest {

    public static void main(String[] args) {

        //Board part
        Board board = new Board();
        BoardBuilder builder = new ClassicBoardBuilder();
        BoardDirector director = new BoardDirector(builder);
        director.construct();
        board.setLetterContainer(director.getLetterContainers());
        board.addBoxes();
        //Players part 
        PlayerInfoGroupPanel players = new PlayerInfoGroupPanel();
        players.addPlayer(new PlayerInfoPanel("David"));
        players.addPlayer(new PlayerInfoPanel("Esteban"));
        players.addPlayer(new PlayerInfoPanel("Castelblanco"));
        players.addPlayer(new PlayerInfoPanel("Benavides"));
        players.buildPanel();

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
        
        ClientWindow window = new ClientWindow(board, players,graficHand);
        window.getContentPane().setBackground(new Color(153, 51, 51));
        window.buildFrame();
        window.pack();
        window.setVisible(true);
    }
}

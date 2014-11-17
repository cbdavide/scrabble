/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Color;
import controlador.Dealer;
import controlador.ESLettersGroup;
import controlador.Hand;
import controlador.LettersGroup;
import controlador.PlayBuffer;
import vista.ListenerBotones;
import vista.playerInfo.PlayerInfoGroupPanel;
import vista.playerInfo.PlayerInfoPanel;
import vista.board.Board;
import vista.board.BoardBuilder;
import vista.board.BoardDirector;
import vista.board.ClassicBoardBuilder;
import vista.hand.GraficHand;
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
        players.addPlayer(new PlayerInfoPanel("Player 1",10));
        players.addPlayer(new PlayerInfoPanel("Player 2",20));
        players.addPlayer(new PlayerInfoPanel("Player 3",100));
        players.addPlayer(new PlayerInfoPanel("Player 4",200));
        players.buildPanel();
        //Hand
        LettersGroup lg = new ESLettersGroup();
        Dealer ganstaDealer = new Dealer(lg);
        Hand h1 = new Hand();
        ganstaDealer.fillHand(h1);
        GraficHand graficHand = new GraficHand();
        graficHand.setHand(h1);
        graficHand.addLetters();
        graficHand.addGraficLetterListener();
        //PlayBuffer
        PlayBuffer playBuffer = new PlayBuffer(board,graficHand);
        //BotonesListener
        ListenerBotones listenerBotones = new ListenerBotones();
        listenerBotones.setPlayBuffer(playBuffer);
        
        graficHand.addBotonListener(listenerBotones);
        board.setPlayBuffer(playBuffer);
        ClientWindow window = new ClientWindow(board, players,graficHand);
        window.getContentPane().setBackground(new Color(153, 51, 51));
        window.buildFrame();
        window.pack();
        window.setVisible(true);
    }
}

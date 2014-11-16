/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.cliente;

import java.awt.Color;
import java.util.ArrayList;
import controlador.Hand;
import controlador.Letter;
import vista.ListenerLetraBoard;
import vista.letras.GraficLetter;
import vista.hand.PanelHand;
import vista.window.ClientWindow;

/**
 *
 * @author david
 */
public class Control {

    private final Partida partida;
    private final ClientWindow window;
    private final ClientPlayer player;
    
    private final ListenerLetraBoard listenerLetraBoard;
    
    public Control() {
        //Pedir Nombre 
        listenerLetraBoard = new ListenerLetraBoard();
        partida = new Partida("David");
        partida.initiationProtocol();
        player = partida.getPlayer();
        window = new ClientWindow(partida.getBoard(), partida.getPlayersInfo(), buildHand());
        window.getContentPane().setBackground(new Color(153, 51, 51));
        window.buildFrame();
        window.pack();
        window.setVisible(true);
    }

    private PanelHand buildHand() {
        PanelHand panel = new PanelHand(listenerLetraBoard);
        ClientPlayer player_temp = partida.getPlayer();
        Hand h = player_temp.getHand();
        panel.setHand(h);
        panel.addLetters();
        return panel;

    }

    public static void main(String[] args) {
        new Control();
    }

}

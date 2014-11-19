/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.cliente;

import java.awt.Color;
import vista.hand.GraficHand;
import vista.window.ClientWindow;

/**
 *
 * @author david
 */
public class Control {

    private final Partida partida;
    private final ClientWindow window;
    private final ClientPlayer player;

    public Control() {
        //Pedir Nombre 
        partida = new Partida("Player1");
        partida.initiationProtocol();
        player = partida.getPlayer();
        window = new ClientWindow(partida.getBoard(), partida.getPlayersInfo(), buildHand());
        window.getContentPane().setBackground(new Color(153, 51, 51));
        window.buildFrame();
        window.pack();
        window.setVisible(true);
        partida.gameLoopProtocol();
    }

    private GraficHand buildHand() {
        return partida.getGraficHand();

    }

    public static void main(String[] args) {
        new Control();
    }

}

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
import controlador.cliente.ClientPlayer;
import vista.letras.GraficLetter;
import vista.playerInfo.PlayerInfoGroupPanel;
import vista.playerInfo.PlayerInfoPanel;
import vista.board.Board;
import vista.hand.PanelHand;
import vista.window.ClientWindow;

/**
 *
 * @author david
 */
public class Control {

    private final Partida partida;
    private ClientWindow window;

    public Control() {
        //Pedir Nombre 
        partida = new Partida("Felipe");
        partida.initiationProtocol();
        window = new ClientWindow(buildBoard(), buildPlayers(), buildHand());
        window.getContentPane().setBackground(new Color(153, 51, 51));
        window.buildFrame();
        window.pack();
        window.setVisible(true);
    }

    private PanelHand buildHand() {
        PanelHand panel = new PanelHand();
        ClientPlayer player = partida.getPlayer();
        Hand h = player.getHand();
        ArrayList<GraficLetter> letras = new ArrayList<>();
        for (Letter l : h.getetters()) {
            GraficLetter temp = new GraficLetter(l);
            temp.addMouseAdapter(new ListenerLetraBoard());
            temp.paintClientLetter();
            letras.add(temp);
        }
        panel.setLetters(letras);
        panel.addLetters();
        return panel;

    }

    private Board buildBoard() {
        return partida.getPlayer().getBoard();
    }

    private PlayerInfoGroupPanel buildPlayers() {
        PlayerInfoGroupPanel panelPlayers = new PlayerInfoGroupPanel();
        panelPlayers.addPlayer(new PlayerInfoPanel(partida.getPlayer().getName()));
        for (PlayerInfoPanel panel : partida.getPlayers()) {
            panelPlayers.addPlayer(panel);
        }
        panelPlayers.buildPanel();
        return panelPlayers;
    }

    public static void main(String[] args) {
        new Control();
    }

}

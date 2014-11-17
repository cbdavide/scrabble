/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.window;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.datatransfer.DataFlavor;
import javax.swing.JComponent;
import javax.swing.JFrame;
import vista.playerInfo.PlayerInfoGroupPanel;
import vista.board.Board;
import vista.hand.GraficHand;
import vista.letras.GraficLetter;

/**
 *
 * @author david
 */
public class ClientWindow extends JFrame {

    private final Board board;
    private final PlayerInfoGroupPanel players;
    private GraficHand panelHand;

    private GridBagLayout layout;
    private GridBagConstraints gbc;

    private static DataFlavor dataFlavor = null;

    public ClientWindow(Board b, PlayerInfoGroupPanel players, GraficHand hand) {
        super("Screbble");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        configLayout();
        this.board = b;
        this.players = players;
        this.panelHand = hand;
        this.setResizable(false);
    }

    public static DataFlavor getDataFlavor() {

        if (dataFlavor == null) {
                dataFlavor = new DataFlavor(GraficLetter.class,"GraficLetter");
        }
        return dataFlavor;
    }

    public void setPanelHand(GraficHand ph) {
        this.panelHand = ph;
    }

    private void configLayout() {
        layout = new GridBagLayout();
        gbc = new GridBagConstraints();
        setLayout(layout);
    }

    public void buildFrame() {
        gbc.insets = new Insets(35, 20, 5, 0);
        addComponent(0, 0, 1, 2, GridBagConstraints.NONE, 1.0, 1.0, board);
        gbc.insets = new Insets(0, 35, 10, 0);
        addComponent(0, 2, 1, 1, GridBagConstraints.NONE, 1.0, 1.0, panelHand);
        gbc.insets = new Insets(0, 0, 0, 0);
        addComponent(1, 1, 1, 1, GridBagConstraints.NONE, 0.3, 0.2, players);
    }

    private void addComponent(int x, int y, int w, int h, int fill,
            double wx, double wy, JComponent component) {
        //Posición del componente                                         
        gbc.gridx = x;
        gbc.gridy = y;
        //"Tamaño" del componente                                         
        gbc.gridwidth = w;
        gbc.gridheight = h;
        // Ajustar Componente                                             
        gbc.fill = fill;
        //Relacion del ajuste (1 en x, 1 en y)                           
        gbc.weightx = wx;
        gbc.weighty = wy;
        layout.setConstraints(component, gbc);
        add(component);
    }

}

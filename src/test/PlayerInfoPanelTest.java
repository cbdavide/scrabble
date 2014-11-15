/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.awt.GridLayout;
import javax.swing.JFrame;
import vista.playerInfo.PlayerInfoGroupPanel;
import vista.playerInfo.PlayerInfoPanel;

/**
 *
 * @author david
 */
public class PlayerInfoPanelTest {
    
        public static void main(String[]args){
         
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout());
        frame.setTitle("PlayerInfoTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PlayerInfoPanel panel = new PlayerInfoPanel("David");
        //panel.setPoints(100);
        PlayerInfoPanel panel2 = new PlayerInfoPanel("Esteban");
        panel.setPoints(50);
        PlayerInfoGroupPanel panelCompuesto = new PlayerInfoGroupPanel();
        panelCompuesto.addPlayer(panel);
        panelCompuesto.addPlayer(panel2);
        panelCompuesto.buildPanel();
        frame.add(panelCompuesto);
        panelCompuesto.setPlayerInfoPanel(1, true);
        
        frame.pack();
        frame.setVisible(true);
    }
    
}

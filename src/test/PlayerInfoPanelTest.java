/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import controlador.PlayersInfoManager;
import java.awt.GridLayout;
import javax.swing.JFrame;

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
        PlayersInfoManager playersInfo = new PlayersInfoManager();
        playersInfo.addPlayer("David", 10);
        playersInfo.addPlayer("Felipe", 10);
        playersInfo.addPlayer("Anthony", 20);
        playersInfo.buildPanel();
        frame.add(playersInfo.getPlayersInfo());        
        frame.pack();
        frame.setVisible(true);
        playersInfo.getPlayerInfo(0).setState(true);
        playersInfo.getPlayerInfo(0).setPoints(100);
    }
    
}

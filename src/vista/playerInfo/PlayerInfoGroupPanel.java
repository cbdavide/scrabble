/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.playerInfo;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class PlayerInfoGroupPanel extends JPanel{
    
    private final ArrayList<PlayerInfoPanel> players;
    
    private GridBagLayout layout;
    private GridBagConstraints gbc;
    
    public PlayerInfoGroupPanel(){
        players = new ArrayList<>();
        configLayout();
    }
    
    public void setPlayerInfoPanel(int i,boolean b){
        PlayerInfoPanel temp = players.get(i);
        temp.setState(b);
        temp.paintPanel();
    }
    
    private void configLayout(){
        layout = new GridBagLayout();
        gbc = new GridBagConstraints();
        setLayout(layout);
    }
    
    public void addPlayer(PlayerInfoPanel panel){
        players.add(panel);
    }
    
    public void buildPanel(){
        int i = 0;
        for(PlayerInfoPanel panel : players){
            addComponent(0,i,1,1,GridBagConstraints.BOTH,0.5,0.5,panel);
            i++;
        }        
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

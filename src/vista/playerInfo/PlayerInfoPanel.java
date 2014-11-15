/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.playerInfo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author david
 */
public class PlayerInfoPanel extends JPanel {

    private JLabel name;
    private JLabel labelPoints;
    private JLabel points;

    private GridBagLayout layout;
    private GridBagConstraints gbc;
    
    private Font nameFont; 
    private Font pointFont;

    private boolean isOn;

    public PlayerInfoPanel(String name) {
        panelConfig();
        layoutConfig();
        createLabels(name);
        fontsConfig();
        labelsConfig();
        addLabels();
        isOn = false;
    }
    
    public void setState(boolean b){
        this.isOn = b;
    }
    
    private void fontsConfig(){
        nameFont = new Font("Open Sans Extrabold",Font.BOLD,20);
        pointFont = new Font("Open Sans Semibold",Font.BOLD,15);
    }
    
    private void labelsConfig(){
        name.setFont(nameFont);
        labelPoints.setFont(pointFont);
        points.setFont(pointFont);
    }
    
    private void panelConfig(){
        setPreferredSize(new Dimension(150,70));
        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        paintPanel();
    }
    
    public final void paintPanel(){
        
        if(this.isOn){
            setBackground(new Color(255,153,0));
        }
        else{
          setBackground(new Color(102,153,153));
        }
        updatePanel();
    }

    private void layoutConfig(){
        layout = new GridBagLayout();
        gbc = new GridBagConstraints();
        setLayout(layout);
    }
    
    private void createLabels(String s) {
        name = new JLabel(s);
        labelPoints = new JLabel("Puntos: ");
        points = new JLabel("0");
    }

    public void setPoints(int points) {
        this.points.setText(String.valueOf(points));
    }

    private void addLabels() {
        gbc.insets = new Insets(15,10,5,0);
        addComponent(0,0,2,1,GridBagConstraints.BOTH,0.5,0.5,name);
        gbc.insets = new Insets(0,10,15,-10);
        addComponent(0,1,1,1,GridBagConstraints.BOTH,0.5,0.5,labelPoints);
        gbc.insets = new Insets(0,-20,15,0);
        addComponent(1,1,1,1,GridBagConstraints.BOTH,0.5,0.5,points);
    }

    public final void updatePanel() {
        this.updateUI();
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

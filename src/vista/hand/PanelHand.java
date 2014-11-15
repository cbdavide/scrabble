/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.hand;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import vista.letras.GraficLetter;
import modelo.ImageLoader;

/**
 *
 * @author david
 */
public class PanelHand extends JPanel {

    private ArrayList<GraficLetter> letters;
    
    private JButton send;

    private GridBagLayout layout;
    private GridBagConstraints gbc;

    public PanelHand() {
        configLayout();
        configButton();
    }
    
    private void configButton(){
        ImageLoader imgLoader = new ImageLoader();
        send = new JButton();
        send.setIcon(new ImageIcon(imgLoader.loadImage("/img/cheack.png")));
        send.setPreferredSize(new Dimension(40,45));
    }

    public ArrayList<GraficLetter> getLetters() {
        return this.letters;
    }

    public void setLetters(ArrayList<GraficLetter> leters) {
        this.letters = leters;
    }
    
    public void addLetters() {
        removeAll();
        int i = 0;
        for (GraficLetter l : letters) {
            addComponent(i, 0, 1, 1, GridBagConstraints.BOTH, 1.0, 1.0, l);
            i++;
        }
        //gbc.ipadx = 0;
        addComponent(i,0,1,1,GridBagConstraints.NONE,1.0,1.0,send);
        updateUI();
    }

    private void addComponent(int x, int y, int w, int h, int fill,
            double wx, double wy, JComponent component) {
        gbc.ipadx = 5;
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

    private void configLayout() {
        layout = new GridBagLayout();
        gbc = new GridBagConstraints();
        setLayout(layout);
    }

}

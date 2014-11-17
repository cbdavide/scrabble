/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.hand;

import controlador.Hand;
import controlador.Letter;
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
import vista.ListenerLetraBoard;

/**
 *
 * @author david
 */
public class GraficHand extends JPanel {

    private Hand hand;
    private ArrayList<GraficLetter> letters;

    private JButton send;

    private GridBagLayout layout;
    private GridBagConstraints gbc;

    private final ListenerLetraBoard listenerLetraBoard;

    public GraficHand(ListenerLetraBoard listenerLetra) {
        this.listenerLetraBoard = listenerLetra;
        configLayout();
        configButton();
    }

    public Hand getLetters() {
        return this.hand;
    }

    public void setHand(Hand h) {
        this.hand = h;
    }
    
    public void addGraficLetterListener(){
        for(GraficLetter l : letters){
            l.addMouseAdapter(listenerLetraBoard);
        }
    }
    
    public void removeLetterListener(){
        for(GraficLetter l : letters){
            l.removeMouseAdapter(listenerLetraBoard);
        }
    }

    public void addLetters() {
        removeAll();
        updateGraficLetters();
        int i = 0;
        for (GraficLetter l : letters) {
            addComponent(i, 0, 1, 1, GridBagConstraints.NONE, 1.0, 1.0, l);
            i++;
        }
        addComponent(i, 0, 1, 1, GridBagConstraints.NONE, 1.0, 1.0, send);
        updateUI();
    }

    private void configButton() {
        ImageLoader imgLoader = new ImageLoader();
        send = new JButton();
        send.setIcon(new ImageIcon(imgLoader.loadImage("/img/cheack.png")));
        send.setPreferredSize(new Dimension(40, 40));
        letters = new ArrayList<>();
    }

    private void updateGraficLetters() {
        letters = new ArrayList<>();
        for (Letter l : hand.getetters()) {
            GraficLetter temp = new GraficLetter(l);
            temp.paintClientLetter();
            letters.add(temp);

        }
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

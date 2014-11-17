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
import vista.ListenerBotones;

/**
 *
 * @author david
 */
public class GraficHand extends JPanel {

    private Hand hand;
    private ArrayList<GraficLetter> letters;

    private JButton send;
    private JButton undo;

    private GridBagLayout layout;
    private GridBagConstraints gbc;

    public GraficHand() {
        configLayout();
        configButtons();
    }

    public Hand getLetters() {
        return this.hand;
    }

    public void setHand(Hand h) {
        this.hand = h;
    }

    public void removeLetter(GraficLetter gl) {
        letters.remove(gl);
    }

    public void addLetter(GraficLetter gl) {
        letters.add(gl);
    }
    
    public void addBotonListener(ListenerBotones listener){
        send.addActionListener(listener);
        undo.addActionListener(listener);
    }
    
    public void removeBotonListener(ListenerBotones litener){
        send.addActionListener(litener);
        undo.addActionListener(litener);
    }

    public void addGraficLetterListener() {
        for (GraficLetter l : letters) {
            l.addDraggableMouseListener();
        }
    }

    public void decreaseLettersSize() {
        for (GraficLetter l : letters) {
            l.decreaseLetterSize();
        }
    }

    public void growUpLettersSize() {
        for (GraficLetter l : letters) {
            l.growUpLetters();
        }
    }

    public void removeLetterListener() {
        for (GraficLetter l : letters) {
            l.removeDraggableMouseListener();
        }
    }

    /**
     * Se utiliza cuando se le quita o se le agrega una letra a la mano por
     * parte del cliente.
     */
    public void updateLetters() {
        removeAll();
        addComponent(0,0,1,1,GridBagConstraints.NONE,1.0,1.0,undo);
        int i = 1;
        for (GraficLetter gl : letters) {
            addComponent(i, 0, 1, 1, GridBagConstraints.NONE, 1.0, 1.0, gl);
            i++;
        }
        addComponent(i, 0, 1, 1, GridBagConstraints.NONE, 1.0, 1.0, send);
        updateUI();
    }

    /**
     * Se llama cuando se recibe la mano actualizada por parte del servidor.
     */
    public void addLetters() {
        removeAll();
        updateGraficLetters();
        addComponent(0,0,1,1,GridBagConstraints.NONE,1.0,1.0,undo);
        int i = 1;
        for (GraficLetter l : letters) {
            addComponent(i, 0, 1, 1, GridBagConstraints.NONE, 1.0, 1.0, l);
            i++;
        }
        addComponent(i, 0, 1, 1, GridBagConstraints.NONE, 1.0, 1.0, send);
        updateUI();
    }

    private void configButtons() {
        ImageLoader imgLoader = new ImageLoader();
        send = new JButton();
        send.setIcon(new ImageIcon(imgLoader.loadImage("/img/cheack.png")));
        send.setPreferredSize(new Dimension(40, 40));
        send.setActionCommand("send");
        letters = new ArrayList<>();
        undo = new JButton();
        undo.setIcon(new ImageIcon(imgLoader.loadImage("/img/undo.png")));
        undo.setPreferredSize(new Dimension(40,40));
        undo.setActionCommand("undo");
    }

    /**
     * Este metodo se utiliza cuando se recibe la mano actualizada por parte del
     * servidor.
     */
    private void updateGraficLetters() {
        letters = new ArrayList<>();
        for (Letter l : hand.getetters()) {
            GraficLetter temp = new GraficLetter(l,this);
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

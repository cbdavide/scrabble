/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.letras;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controlador.Letter;
import vista.ListenerLetraBoard;

/**
 *
 * @author david
 */
public class GraficLetter extends JPanel {

    private final Letter letter;

    private JLabel charLabel;
    private JLabel pointLabel;

    private final Font CHAR_FONT;
    private final Font POINT_FONT;

    private Color textColorON;
    private Color backgroundColorON;

    private Color textColorOFF;
    private Color backgroundColorOFF;

    private GridBagLayout layout;
    private GridBagConstraints gbc;
    
    private MouseAdapter mouseAdapter;
    
    public GraficLetter(Letter l) {
        this.letter = l;
        //Fonts
        CHAR_FONT = new Font("Open Sans Extrabold", Font.BOLD, 18);
        POINT_FONT = new Font("SansSerif", Font.BOLD, 9);
        //Color
        assignColor();
        loadComponents();
        configLayout();
        paintLetter();
        addComponents();
        setBorder(BorderFactory.createRaisedBevelBorder());
    }
    
    public void addMouseAdapter(ListenerLetraBoard listener){
        addMouseListener(listener);
    }
    
    public void removeMouseAdapter(ListenerLetraBoard listener){
        removeMouseListener(listener);
    }
    
    public Letter getLetter(){
        return this.letter;
    }

    private void configLayout() {
        layout = new GridBagLayout();
        setLayout(layout);
        gbc = new GridBagConstraints();
    }

    private void loadComponents() {
        charLabel = new JLabel(letter.getSymbol());
        charLabel.setFont(CHAR_FONT);
        pointLabel = new JLabel("" + letter.getValue());
        pointLabel.setFont(POINT_FONT);
    }

    private void assignColor() {
        textColorON = new Color(22, 113, 53);
        backgroundColorON = new Color(255, 255, 250);
        textColorOFF = new Color(153, 153, 153);
        backgroundColorOFF = new Color(230, 230, 230);
    }

    private void paintLetter() {
        if (letter.isOn()) {
            charLabel.setForeground(textColorON);
            pointLabel.setForeground(textColorON);
            setBackground(backgroundColorON);
        } else {
            charLabel.setForeground(textColorOFF);
            pointLabel.setForeground(textColorOFF);
            setBackground(backgroundColorOFF);

        }
    }

    public void paintClientLetter() {
        charLabel.setForeground(textColorON);
        pointLabel.setForeground(textColorON);
        setBackground(backgroundColorON);
    }

    private void addComponents() {
        gbc.insets = new Insets(5, 15, 0, 5);
        addComponent(0, 0, 2, 1, GridBagConstraints.BOTH, 1.0, 1.0, charLabel);
        gbc.insets = new Insets(0, 30, 0, 0);
        addComponent(0, 2, 1, 1, GridBagConstraints.BOTH, 0.5, 0.5, pointLabel);
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

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
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controlador.Letter;
import java.awt.Dimension;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.io.Serializable;
import vista.DragAndDropTransferHandler;
import vista.DraggableMouseListener;
import vista.hand.GraficHand;
import vista.window.ClientWindow;

/**
 *
 * @author david
 */
public class GraficLetter extends JPanel implements Transferable, Serializable {
    
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

    private final DraggableMouseListener draggableListener;
    
    private final GraficHand graficHand;
    
    public GraficLetter(Letter l,GraficHand gf) {
        this.letter = l;
        this.graficHand = gf;
        setPreferredSize(new Dimension(40, 40));
        draggableListener = new DraggableMouseListener();
        setTransferHandler(new DragAndDropTransferHandler());
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
    
    public void decreaseLetterSize(){
        setPreferredSize(new Dimension(35,35));
        charLabel.setFont(new Font("Open Sans Extrabold", Font.BOLD, 15));
    }
    
    public void growUpLetters(){
        setPreferredSize(new Dimension(40,40));
        charLabel.setFont(CHAR_FONT);
    }

    public Letter getLetter() {
        return this.letter;
    }

    private void configLayout() {
        layout = new GridBagLayout();
        setLayout(layout);
        gbc = new GridBagConstraints();
    }

    private void loadComponents() {
        charLabel = new JLabel(letter.getSymbol(), JLabel.CENTER);
        charLabel.setFont(CHAR_FONT);
        pointLabel = new JLabel(String.valueOf(letter.getValue()), JLabel.RIGHT);
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
        gbc.insets = new Insets(5, 4, 0, 4);
        addComponent(0, 0, 2, 1, GridBagConstraints.BOTH, 1.0, 1.0, charLabel);
        gbc.insets = new Insets(-5, 10, 0, 5);
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

    public void addDraggableMouseListener() {
        addMouseListener(draggableListener);
    }

    public void removeDraggableMouseListener() {
        removeMouseListener(draggableListener);
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        DataFlavor[] flavors = {null};
        flavors[0] = ClientWindow.getDataFlavor();
        return flavors;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor df) {
        DataFlavor flavor = ClientWindow.getDataFlavor();
        return flavor.equals(df);
    }

    @Override
    public Object getTransferData(DataFlavor df) {
        DataFlavor thisFlavor;

        thisFlavor = ClientWindow.getDataFlavor();

        if (thisFlavor != null && df.equals(thisFlavor)) {
            graficHand.removeLetter(this);
            graficHand.updateLetters();
            return GraficLetter.this;
        }

        return null;
    }

}

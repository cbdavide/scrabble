/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.board;

import controlador.PlayBuffer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.dnd.DropTarget;
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import vista.DragAndDropTransferHandler;
import vista.LetterContainerTargetListener;
import vista.letras.GraficLetter;

/**
 *
 * @author david
 */
public abstract class LetterContainer extends JPanel implements Serializable{

    protected final JLabel label;
    protected final int value;
    protected final boolean fullWord;
    
    protected LetterContainerTargetListener letterContainerTargetListener;
    
    private GraficLetter letter;

    public LetterContainer(int value, boolean fullWord) {
        setPreferredSize(new Dimension(35,35));
        letterContainerTargetListener = new LetterContainerTargetListener(this);
        setTransferHandler(new DragAndDropTransferHandler());
        setDropTarget(new DropTarget(LetterContainer.this,letterContainerTargetListener));
        label = new JLabel();
        this.value = value;
        this.fullWord = fullWord;
        configBorder();
    }
    
    public void setPlayBuffer(PlayBuffer pb){
        this.letterContainerTargetListener.setPlayBuffer(pb);
    }
    
    public void removePlayBuffer(){
        letterContainerTargetListener.setPlayBuffer(null);
    }
    
    public void setGraficLetter(GraficLetter l){
        this.letter = l;
    }
    
    public GraficLetter getGraficLetter(){
        return this.letter;
    }

    private void configBorder() {
        setBorder(new LineBorder(new Color(102,153,153)) {
            @Override
            public Insets getBorderInsets(Component c, Insets insets) {
                return new Insets(-5, 10, 10, 10);
            }
        });
    }

    public int getValue() {
        return this.value;
    }

    public boolean isFullWord() {
        return this.fullWord;
    }

    public void addLabel() {
        removeAll();
        if(letter == null)
            add(label);
        else
            add(letter);
        updateUI();
    }

    protected abstract void setLabelBackground();

}

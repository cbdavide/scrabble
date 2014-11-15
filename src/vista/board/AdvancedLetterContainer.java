/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.board;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author david
 */
public class AdvancedLetterContainer extends LetterContainer{
    
    private ImageIcon icon;
    
    public AdvancedLetterContainer(Image i,int value,boolean fullWord){
        super(value,fullWord);
        icon = new ImageIcon(i);
        setLabelBackground();
        addLabel();
    }
    
    @Override
    protected final void setLabelBackground(){
        label.setIcon(icon);
    }
    
}

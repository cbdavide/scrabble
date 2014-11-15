/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.board;

import java.awt.Color;

/**
 *
 * @author david
 */
public class SimpleLetterContainer extends LetterContainer {
    
    private final Color BACKGROUND_COLOR = new Color(62,147,90);
    
    public SimpleLetterContainer(){
        super(1,true);
        setLabelBackground();
        addLabel();
    }
        
    @Override
    protected final void setLabelBackground(){
        setBackground(BACKGROUND_COLOR);
    }
}

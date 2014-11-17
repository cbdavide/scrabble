/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.PlayBuffer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author david
 */
public class ListenerBotones implements ActionListener {

    private PlayBuffer playBuffer;

    public ListenerBotones() {
    }
    
    public void setPlayBuffer(PlayBuffer playBuffer){
        this.playBuffer = playBuffer;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "send":
                break;
            case "undo":
                playBuffer.returnLetters();
                break;
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.PlayBuffer;
import controlador.cliente.ClientPlayer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author david
 */
public class ListenerBotones implements ActionListener {

    private PlayBuffer playBuffer;
    private ClientPlayer player;

    public ListenerBotones() {
    }
    
    public void setPlayBuffer(PlayBuffer playBuffer){
        this.playBuffer = playBuffer;
    }
    
    public void setPlayer(ClientPlayer player){
        this.player = player;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "send":
                Object[] respuesta = playBuffer.armarPalabra();
                String palabra = (String)respuesta[0];
                int puntaje = (Integer)respuesta[1];
                player.sendWord(palabra);
                player.sendInt(puntaje);
                break;
            case "undo":
                playBuffer.returnLetters();
                break;
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.cliente;

import controlador.Hand;
import controlador.Player;
import controlador.PlayerComunications;
import vista.board.Board;

/**
 *
 * @author david
 */
public class ClientPlayer extends Player {

    
    public ClientPlayer(PlayerComunications pc) {
        super(pc);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendName() {
        output.writeString(this.name);
    }

    public void setPoint(int point) {
        this.points = point;
    }

    public void setHand(Hand h) {
        this.hand = h;
    }

    public void setState(boolean b) {
        this.state = b;
    }

    public void sendWord(String word) {
        output.writeString(word);
    }

    public boolean getResponse() {
        return input.readBoolean();
    }
    
}

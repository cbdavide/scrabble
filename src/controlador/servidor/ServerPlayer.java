/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servidor;

import controlador.Player;
import controlador.PlayerComunications;
import vista.board.Board;

/**
 *
 * @author david
 */
public class ServerPlayer extends Player {

    public ServerPlayer(PlayerComunications pc) {
        super(pc);
    }

    public void askName() {
        this.name = input.readString();
    }

    public void askPoint() {
        this.points = input.readInt();
    }

    public void askState() {
        this.state = input.readBoolean();
    }

    public String askWord() {
        return input.readString();
    }

    public void sendResponse(boolean b) {
        output.writeBoolean(b);
    }

}

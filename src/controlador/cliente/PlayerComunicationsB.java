/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.cliente;

import controlador.Input;
import controlador.Output;
import java.io.IOException;
import java.net.Socket;
import controlador.PlayerComunications;
import vista.Consola;

/**
 *
 * @author david
 */
public final class PlayerComunicationsB extends PlayerComunications {

    public PlayerComunicationsB(Socket s) {
        super(s);
        createStreams();
    }

    @Override
    public void createStreams() {
        try {
            input = new Input(socket.getInputStream());
            output = new Output(socket.getOutputStream());
        } catch (IOException ex) {
            Consola.consola(ex.getMessage());
        }
    }

}

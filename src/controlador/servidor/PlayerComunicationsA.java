/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servidor;

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
public final class PlayerComunicationsA extends PlayerComunications {

    public PlayerComunicationsA(Socket s) {
        super(s);
        createStreams();
    }

    @Override
    public void createStreams() {
        try {
            output = new Output(socket.getOutputStream());
            input = new Input(socket.getInputStream());
        } catch (IOException ex) {
            Consola.consola(ex.getMessage());
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.Socket;
import vista.Consola;

/**
 *
 * @author david
 */
public abstract class PlayerComunications {

    protected final Socket socket;

    protected Output output;
    protected Input input;
    
    public PlayerComunications(Socket s) {
        this.socket = s;
    }

    public Output getOutput(){
        return this.output;
    }
    
    public Input getInput(){
        return this.input;
    }

    public abstract void createStreams();

    public void closeStreams() {
        try {
            output.close();
            input.close();
            socket.close();
        } catch (IOException e) {
            Consola.consola("No se pudo cerrar ¬¬");
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.cliente;

import java.io.IOException;
import java.net.Socket;
import controlador.PlayerComunications;
import vista.Consola;

/**
 *
 * @author david
 */
public class Cliente {

    private Socket socket;
    private final int PORT = 4000;
    private final String SERVER_IP = "localhost";

    private final PlayerComunications comunications;

    public Cliente() {
        crearSocket();
        comunications = new PlayerComunicationsB(socket);

    }

    public PlayerComunications getComunications() {
        return this.comunications;
    }

    public final void crearSocket() {
        try {
            socket = new Socket(SERVER_IP, PORT);
        } catch (IOException ex) {
            Consola.consola("No se pudo conectar ¬¬");
        }
    }

    public final void closeSocket() {
        try {
            socket.close();
            Consola.consola("El cliente se desconecto...");
        } catch (IOException e) {
            Consola.consola(e.getMessage());
        }
    }
}

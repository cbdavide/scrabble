/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import controlador.PlayerComunications;
import vista.Consola;

/**
 *
 * @author david
 */
public class Server {
    
    private final int PORT = 4000;
    private final int nplayers;

    private ServerSocket server;
    private final ArrayList<PlayerComunications> players;

    private static int contador;

    public Server(int nPlayers) {
        this.nplayers = nPlayers;
        contador = 1;
        players = new ArrayList<>();
        crearSocket();
        escuchar();
        //closeSocket();
    }
    
    public final ArrayList<PlayerComunications> getPLayers(){
        return this.players;
    }
    
    public final void escuchar() {
        boolean cond = contador < nplayers+1;
        while (cond) {
            try {
                Socket socket_temp = server.accept();
                PlayerComunications player = new PlayerComunicationsA(socket_temp);
                players.add(player);
                Consola.consola("Se conecto el jugador N° " + contador);
                contador++;
            } catch (IOException e) {
                Consola.consola("No se creo el socket ¬¬");
            }
            cond = contador < nplayers +1;
        }
        Consola.consola("Jugadores Completos!!");
    }

    public final void crearSocket() {
        try {
            server = new ServerSocket(PORT);
            Consola.consola("Esperando jugadores...");
        } catch (IOException ex) {
            Consola.consola("No se pudo crear el servidor ¬¬");
        }
    }

    public final void closeSocket() {
        try {
            server.close();
            Consola.consola("El servidor se cerro...");
        } catch (IOException e) {
            Consola.consola("No se pudo cerrar el servidor ¬¬"); 
        }
    }
}

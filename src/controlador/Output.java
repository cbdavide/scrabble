/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import vista.Consola;
import vista.board.Board;
import vista.playerInfo.PlayerInfoGroupPanel;

/**
 *
 * @author david
 */
public class Output {

    private ObjectOutputStream oos;

    public Output(OutputStream os) {
        createOutput(os);
    }

    public void writeBoolean(boolean b) {
        try {
            oos.writeBoolean(b);
            oos.flush();
        } catch (IOException ex) {
            Consola.consola("Problema al enviar el booleano ¬¬");
        }
    }

    public void writeObject(Object o) {
        try {
            oos.writeObject(o);
            oos.flush();
        } catch (IOException ex) {
            Consola.consola("Problema al enviar el objeto ¬¬");
        }
    }

    public void writeHand(Hand h) {
        try {
            oos.writeObject(h);
            oos.flush();
        } catch (IOException ex) {
            Consola.consola("Trouble sending hand ¬¬");
        }
    }

    public void writeString(String txt) {
        try {
            oos.writeUTF(txt);
            oos.flush();
        } catch (IOException e) {
            Consola.consola("Problema al enviar el texto ¬¬");
        }
    }

    public void writeBoard(Board b) {
        try {
            oos.writeObject(b);
            oos.flush();
        } catch (IOException e) {
            Consola.consola("Problema al enviar la board ¬¬");
            e.printStackTrace();
        }
    }

    public void writeInt(int i) {
        try {
            oos.writeInt(i);
            oos.flush();
        } catch (IOException ex) {
            Consola.consola("Problema al enviar int");
        }
    }
    
    public void writePlayersInfo(PlayerInfoGroupPanel playersInfo){
        try{
            oos.writeObject(playersInfo);
            oos.flush();
        }catch(IOException ex){
            Consola.consola("Problema al enviar PlayersInfo");
        }
    }
    
    public void close() {
        try {
            oos.close();
        } catch (IOException ex) {
            Consola.consola("Problema al cerrar ¬¬");
        }
    }

    private void createOutput(OutputStream os) {
        try {
            oos = new ObjectOutputStream(os);
        } catch (IOException ex) {
            Consola.consola("Output problem ¬¬");
        }
    }
}

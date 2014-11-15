/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import vista.Consola;
import vista.board.Board;

/**
 *
 * @author david
 */
public class Input {

    private ObjectInputStream ois;

    public Input(InputStream is) {
        createInput(is);
    }

    private void createInput(InputStream is) {
        try {
            ois = new ObjectInputStream(is);
        } catch (IOException ex) {
            Consola.consola("Problema al crear InputStream");
        }
    }

    public String readString() {
        try {
            return ois.readUTF();
        } catch (IOException ex) {
            Consola.consola("Problema al leer texto ¬¬");
            return null;
        }
    }

    public int readInt() {
        try {
            return ois.readInt();
        } catch (IOException ex) {
            Consola.consola("Problema al leer int ¬¬");
            return -1000;
        }
    }

    public boolean readBoolean() {
        try {
            return ois.readBoolean();
        } catch (IOException ex) {
            Consola.consola("Problema al leer bol ¬¬");
            return false;
        }
    }

    public Object readObject() {
        try {
            return ois.readObject();
        } catch (IOException ex) {
            Consola.consola("Problema al leer Object ¬¬");
            return null;
        } catch (ClassNotFoundException ex) {
            Consola.consola("Class not found ¬¬");
            return null;
        }
    }

    public Hand readHand() {
        try {
            return (Hand) ois.readObject();
        } catch (IOException ex) {
            Consola.consola("Trouble readind a hand!!");
            return null;
        } catch (ClassNotFoundException ex) {
            Consola.consola("Class not found ¬¬");
            return null;
        }
    }

    public Board readBoard() {
        try {
            return (Board) ois.readObject();
        } catch (IOException ex) {
            Consola.consola("Trouble readind the board!");
            return null;
        } catch (ClassNotFoundException ex) {
            Consola.consola("Class not found ¬¬");
            return null;
        }
    }

    public void close() {
        try {
            ois.close();
        } catch (IOException ex) {
            Consola.consola("Problema al cerrar ¬¬");
        }
    }

}

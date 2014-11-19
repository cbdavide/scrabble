/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.board.Board;
import vista.board.LetterContainer;
import vista.playerInfo.PlayerInfoGroupPanel;

/**
 *
 * @author david
 */
public abstract class Player {

    protected String name;
    protected int points;
    protected boolean state;

    protected Hand hand;

    protected Input input;
    protected Output output;

    protected final PlayerComunications comunication;

    public Player(PlayerComunications pc) {
        this.comunication = pc;
        createIO();
        hand = new Hand();
    }

    public String getName() {
        return this.name;
    }

    public int getPoint() {
        return this.points;
    }

    public void sendPoint() {
        output.writeInt(this.points);
    }

    public Hand getHand() {
        return this.hand;
    }

    public void sendHand() {
        output.writeHand(this.hand);
    }

    public void askHand() {
        this.hand = input.readHand();
    }

    public Hand readHand() {
        return input.readHand();
    }

    public void sendHand(Hand h) {
        output.writeHand(h);
    }

    public boolean getState() {
        return this.state;
    }

    public void sendState() {
        output.writeBoolean(this.state);
    }

    public void sendString(String s) {
        output.writeString(s);
    }

    public void sendInt(int i) {
        output.writeInt(i);
    }

    public void sendBoolean(boolean b) {
        output.writeBoolean(b);
    }

    public String readString() {
        return input.readString();
    }

    public int readInt() {
        return input.readInt();
    }

    public boolean readBoolean() {
        return input.readBoolean();
    }

    public PlayerInfoGroupPanel readPlayersInfo() {
        return input.readPlayersInfo();
    }

    public void sendPlayersInfo(PlayerInfoGroupPanel playersInfo) {
        output.writePlayersInfo(playersInfo);
    }

    public void sendLetterContainer(LetterContainer[][] c) {
        output.writeLetterContainer(c);
    }
    
    public LetterContainer[][] readLetterContainer(){
        return input.readLetterContainer();
    }

    public Board askBoard() {
        return input.readBoard();
    }

    public void sendBoard(Board b) {
        output.writeBoard(b);
    }

    private void createIO() {
        input = comunication.getInput();
        output = comunication.getOutput();
    }
}

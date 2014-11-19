/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.cliente;

import controlador.Hand;
import controlador.PlayBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.ListenerBotones;
import vista.board.Board;
import vista.hand.GraficHand;
import vista.letras.GraficLetter;
import vista.playerInfo.PlayerInfoGroupPanel;
import vista.playerInfo.PlayerInfoPanel;

/**
 *
 * @author david
 */
public class Partida {

    private final Cliente cliente;
    private final ClientPlayer player;

    private Board board;
    private PlayerInfoGroupPanel playersInfo;
    private final GraficHand graficHand;

    private final ListenerBotones listenerBotones;

    //Juagdor conectado
    private boolean stillOn;

    //Jugada
    private boolean isMoving;

    public Partida(String name) {
        cliente = new Cliente();
        player = new ClientPlayer(cliente.getComunications());
        player.setName(name);
        player.setPoint(0);
        graficHand = new GraficHand();
        this.stillOn = true;
        this.isMoving = true;
        listenerBotones = new ListenerBotones();
    }

    public GraficHand getGraficHand() {
        return this.graficHand;
    }

    public final void updateGraficHand() {
        graficHand.setHand(player.getHand());
        graficHand.addLetters();
    }

    public PlayerInfoGroupPanel getPlayersInfo() {
        return this.playersInfo;
    }

    public Board getBoard() {
        return this.board;
    }

    //Va en la parte del jugador
    public void endMove() {
        this.isMoving = false;
    }

    public void turnOff() {
        this.stillOn = false;
    }

    public ClientPlayer getPlayer() {
        return this.player;
    }

    public void initiationProtocol() {
        player.sendName();
        player.sendPoint();
        this.playersInfo = player.readPlayersInfo();
        this.board = player.askBoard();
        refreshHand();
        updateGraficHand();
    }

    public void gameLoopProtocol() {
        int elegido = -1;
        boolean turn;
        boolean move;
        PlayerInfoPanel playerInfo;
        PlayBuffer playBuffer;
        while (stillOn) {
            turn = player.readBoolean();
            elegido = player.readInt();
            playersInfo.turnOffPlayers();
            playerInfo = playersInfo.getPlayerInfo(elegido);
            playerInfo.setState(true);
            if (turn) {
                graficHand.addGraficLetterListener();
                playBuffer = new PlayBuffer(board, graficHand);
                listenerBotones.setPlayer(player);
                listenerBotones.setPlayBuffer(playBuffer);
                graficHand.addBotonListener(listenerBotones);
                board.setPlayBuffer(playBuffer);
                move = true;
                while (move) {
                    System.out.println("Here");
                    move = !player.readBoolean();
                    System.out.println(move);
                }
                //board.removePlayBuffer();
                graficHand.removeBotonListener(listenerBotones);
                graficHand.removeLetterListener();
                graficHand.removeCoreLetters();
                //Enviar mano, recargarla, recibirla, actualizarla
                player.sendHand(graficHand.getHand());
                Hand h = player.readHand();
                graficHand.setHand(h);
                graficHand.addLetters();
                //Enviar tablero
                player.sendLetterContainer(board.getBoxes());
            }
            this.board.setLetterContainer(player.readLetterContainer());
            board.addBoxes();
            /*GraficLetter temporali = board.getBox(7, 7).getGraficLetter();
            System.out.println(temporali.getLetter().getSymbol());
            System.out.println("Recibido");*/
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Partida.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            int temp_pla = player.readInt();
            int point = player.readInt();
            point += playersInfo.getPlayerInfoPoints(temp_pla);
            playersInfo.setPlayerInfoPoint(temp_pla, point);
        }

    }

    public void refreshHand() {
        player.sendHand();
        player.askHand();
    }

}

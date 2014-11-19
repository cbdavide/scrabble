/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.cliente;

import controlador.Hand;
import controlador.PlayBuffer;
import vista.ListenerBotones;
import vista.board.Board;
import vista.hand.GraficHand;
import vista.playerInfo.PlayerInfoGroupPanel;

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

        while (stillOn) {

            boolean isMyTurn = player.readBoolean();
            int xx = player.readInt();
            System.out.println(xx);
            //Ilumina casilla de el legido
            //playersInfo.turnOffPlayers();
            System.out.println(xx);
            playersInfo.setPlayerInfoState(xx, true);

            if (isMyTurn) {
                System.out.println("My turn");
                //Añadir listener a la mano
                graficHand.addGraficLetterListener();
                //Buffer de jugada
                PlayBuffer playBuffer = new PlayBuffer(board, graficHand);
                //Configurar listenerBotones
                listenerBotones.setPlayBuffer(playBuffer);
                listenerBotones.setPlayer(player);
                graficHand.addBotonListener(listenerBotones);
                board.setPlayBuffer(playBuffer);
                while (isMoving) {
                    //La palabra se enviaria desde otra parte
                    boolean answer = player.getResponse();
                    System.out.println(answer);

                    if (answer) {
                        isMoving = false;
                    }

                }
                player.sendHand();
                //player.askHand();
                Hand h = player.readHand();
                graficHand.setHand(h);
                graficHand.addLetters();
                //Enviar Board actualizada
                //player.sendBoard(this.board);
                graficHand.removeBotonListener(listenerBotones);
                graficHand.removeLetterListener();
                System.out.println("End of My turn");

            } else {
                System.out.println("Not My turn");
            }

        }

    }

    public void refreshHand() {
        player.sendHand();
        player.askHand();
    }

}

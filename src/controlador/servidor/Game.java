/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servidor;

import java.util.ArrayList;
import java.util.Collections;
import controlador.Dealer;
import controlador.LettersGroup;
import modelo.Diccionario;
import controlador.Verificador;
import controlador.PlayerComunications;
import controlador.PlayersInfoManager;
import vista.board.Board;

/**
 *
 * @author david
 */
public class Game {

    private final Server server;
    private final ArrayList<ServerPlayer> players;

    private Board board;
    private final LettersGroup lettersGroup;
    private final Dealer dealer;
    private final PlayersInfoManager playersInfo;
    private final Verificador verificador;

    private boolean gameStillOn;

    private static int turn = -1;

    public Game(int nPlayers, LettersGroup lg, Board board, Diccionario diccionario) {
        server = new Server(nPlayers);
        players = loadPlayers(shufflePlayers());
        this.lettersGroup = lg;
        this.dealer = new Dealer(lg);
        this.board = board;
        this.verificador = new Verificador(diccionario);
        playersInfo = new PlayersInfoManager();
        gameStillOn = true;
    }
    
    public ArrayList<ServerPlayer> getPlayers(){
        return this.getPlayers();
    }

    private void turno() {
        if (turn < players.toArray().length) {
            if (turn != 0) {
                turn++;
            }
        } else {
            turn = 0;
        }
    }

    public void finishGame() {
        gameStillOn = false;
    }

    public LettersGroup getLettersGroup() {
        return this.lettersGroup;
    }

    public void initiationProtocol() {
        askNP();
        buildPlayersInfo();
        sendPlayersInfo();
        sendBoard();
        sendFirstHand();
    }

    public void gameLoopProtocol() {
        while (gameStillOn) {
            turno();
            //Notificar a que usuario le toca jugar
            for (ServerPlayer player : players) {

                if (players.indexOf(player) == turn) {
                    player.sendBoolean(true);
                } else {
                    player.sendBoolean(false);
                }
                player.sendString(players.get(turn).getName());
            }
            //Sera falsa cuando el jugador termine la jugada
            boolean cond_temp = true;
            ServerPlayer actualPlayer = players.get(turn);
            while (cond_temp) {
                String word = actualPlayer.askWord();
                //Verificar que la palabra existe
                boolean wordExist = verificador.verify(word);
                //Enviar resultado
                actualPlayer.sendResponse(wordExist);

                cond_temp = actualPlayer.readBoolean();
            }

            this.board = actualPlayer.askBoard();

        }
    }

    private ArrayList<PlayerComunications> shufflePlayers() {
        ArrayList<PlayerComunications> comunications = server.getPLayers();
        Collections.shuffle(comunications);
        return comunications;
    }

    private void sendBoard() {
        for (ServerPlayer p : players) {
            p.sendBoard(board);
        }
    }

    private void sendFirstHand() {
        for (ServerPlayer p : players) {
            p.askHand();
            dealer.fillHand(p.getHand());
            p.sendHand();
        }
    }

    private void askNP() {
        for (ServerPlayer p : players) {
            p.askName();
            p.askPoint();
        }
    }
    
    private void buildPlayersInfo(){
        for(ServerPlayer p : players){
            playersInfo.addPlayer(p.getName(), p.getPoint());
        }
        playersInfo.buildPanel();
    }

    private void sendPlayersInfo() {
        for(ServerPlayer p : players){
            p.sendPlayersInfo(playersInfo.getPlayersInfo());
        }
    }

    private ArrayList<ServerPlayer> loadPlayers(ArrayList<PlayerComunications> pC) {
        ArrayList<ServerPlayer> temp = new ArrayList<>();

        for (PlayerComunications pc : pC) {
            temp.add(new ServerPlayer(pc));
        }

        return temp;
    }

}

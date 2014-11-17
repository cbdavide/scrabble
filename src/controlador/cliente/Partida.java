/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.cliente;

import vista.ListenerLetraBoard;
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
    }
    
    public GraficHand getGraficHand(){
        return this.graficHand;
    }
    
    public final void updateGraficHand(){
        graficHand.setHand(player.getHand());
        graficHand.addLetters();
    }
    
    public PlayerInfoGroupPanel getPlayersInfo(){
        return this.playersInfo;
    }
    
    public Board getBoard(){
        return this.board;
    }
    
    //Va en la parte del jugador
    public void endMove(){
        this.isMoving = false;
    }
    
    public void turnOff(){
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
    
    public void gameLoopProtocol(){
        
        while(stillOn){
            
            boolean isMyTurn = player.readBoolean();
            int i = player.readInt();
            //Ilumina casilla de el legido
            playersInfo.setPlayerInfoState(i, true);
            
            if(isMyTurn){
                //Añadir listener a la mano
                graficHand.addGraficLetterListener();
                //Añadir listener a la board
                while(isMoving){
                    //La palabra se enviaria desde otra parte
                    boolean answer = player.getResponse();
                    if(answer){
                        endMove();
                        player.sendBoolean(false);
                    }else{
                        player.sendBoolean(true);
                    }
                }
                //Enviar Board actualizada
                player.sendBoard(this.board);
                
            }
            
        }
        
    }

    public void refreshHand() {
        player.sendHand();
        player.askHand();
    }

}

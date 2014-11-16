/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.cliente;

import vista.board.Board;
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
    
    //Juagdor conectado
    private boolean stillOn;
    
    //Jugada
    private boolean isMoving;


    public Partida(String name) {
        cliente = new Cliente();
        player = new ClientPlayer(cliente.getComunications());
        player.setName(name);
        player.setPoint(0);
        this.stillOn = true;
        this.isMoving = true;
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
    }
    
    public void gameLoopProtocol(){
        
        while(stillOn){
            
            boolean isMyTurn = player.readBoolean();
            String choosenOne = player.readString();
            //Iluminar casilla de el legido
            
            if(isMyTurn){
                //Añadir listener a la mano
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

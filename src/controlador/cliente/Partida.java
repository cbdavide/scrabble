/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.cliente;

import java.util.ArrayList;
import controlador.cliente.ClientPlayer;
import vista.playerInfo.PlayerInfoPanel;

/**
 *
 * @author david
 */
public class Partida {

    private final Cliente cliente;
    private final ClientPlayer player;
    
    //Juagdor conectado
    private boolean stillOn;
    
    //Jugada
    private boolean isMoving;
    
    private final ArrayList<PlayerInfoPanel> players;

    public Partida(String name) {
        cliente = new Cliente();
        player = new ClientPlayer(cliente.getComunications());
        player.setName(name);
        player.setPoint(0);
        players = new ArrayList<>();
        this.stillOn = true;
        this.isMoving = true;
    }
    
    public void endMove(){
        this.isMoving = false;
    }
    
    public void turnOff(){
        this.stillOn = false;
    }
    
    public ArrayList<PlayerInfoPanel> getPlayers(){
        return this.players;
    }

    public ClientPlayer getPlayer() {
        return this.player;
    }

    public void initiationProtocol() {
        player.sendName();
        player.sendPoint();
        readPlayersNames();
        player.askBoard();
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
                player.sendBoard();
                
            }
            
        }
        
    }

    public void refreshHand() {
        player.sendHand();
        player.askHand();
    }

    private void readPlayersNames() {
        String str;
        int i;
        boolean cond = true;
        while (cond) {

            str = player.readString();
            i = player.readInt();

            cond = !str.equals("empty") && i != -1000;

            if (cond) {
                PlayerInfoPanel tem_player = new PlayerInfoPanel(str);
                tem_player.setPoints(i);
                players.add(tem_player);
            }
        }
    }

}

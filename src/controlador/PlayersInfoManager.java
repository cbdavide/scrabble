/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.playerInfo.PlayerInfoGroupPanel;
import vista.playerInfo.PlayerInfoPanel;

/**
 *
 * @author david
 */
public class PlayersInfoManager {

    private final PlayerInfoGroupPanel playersInfo;

    public PlayersInfoManager() {
        playersInfo = new PlayerInfoGroupPanel();
    }

    public PlayerInfoGroupPanel getPlayersInfo() {
        return this.playersInfo;
    }

    public void addPlayer(String name, int points) {
        playersInfo.addPlayer(new PlayerInfoPanel(name, points));
    }
    
    public void buildPanel(){
        playersInfo.buildPanel();
    }
    
    public PlayerInfoPanel getPlayerInfo(int i){
        return playersInfo.getPlayerInfo(i);
    }

}

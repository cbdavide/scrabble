/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import controlador.cliente.Partida;
import controlador.Hand;
import controlador.Letter;
import controlador.Player;
import vista.ListenerLetraBoard;

/**
 *
 * @author david
 */
public class InitiationProtocolClientTest {
    
    public static void main(String[]args){
        System.out.println("InitiationProtocolTest(Cient)");
        Partida partida = new Partida("Esteban", new ListenerLetraBoard());
        partida.initiationProtocol();
        Player p = partida.getPlayer();
        Hand h = p.getHand();
        for(Letter l : h.getetters()){
            System.out.print(l.getSymbol()+" ");
            
        }
    }
    
}

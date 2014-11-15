/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import vista.letras.GraficLetter;
import vista.board.LetterContainer;

/**
 *
 * @author david
 */
public class ListenerLetraBoard extends MouseAdapter{
    
    private static int counter = 0;
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() instanceof GraficLetter){
            if(counter == 0){
                GraficLetter letraObtenida = (GraficLetter)e.getSource();
                letraObtenida.setBorder(BorderFactory.createLineBorder(Color.YELLOW,2));
                System.out.println("Se obtuvo una letra");
                counter = 1;
            }else{
                System.out.println("No se pueden seleccionar más letras");
            }
        }else if(e.getSource() instanceof LetterContainer){
            if(counter == 1){
                System.out.println("Se obtuvo un letter container");
                counter = 0;
            }else{
                System.out.println("No se pueden seleccionar más casillas");
            }
        }
    }
}

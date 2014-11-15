/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.util.ArrayList;
import java.util.Iterator;
import controlador.Dealer;
import controlador.ESLettersGroup;
import controlador.Hand;
import controlador.Letter;
import controlador.LettersGroup;

/**
 *
 * @author david
 */
public class RepartidorLetrasTest {
    
    public static void main(String[]args){
        
        LettersGroup lg = new ESLettersGroup();
        Dealer ganstaDealer = new Dealer(lg);
        
        System.out.println("Gansta Letters");
        printONLetters(lg.getLetters());
        
        Hand h1 = new Hand();
        ganstaDealer.fillHand(h1);
        
        System.out.println("Gansta Letters");
        printONLetters(lg.getLetters());
        
        System.out.println("H1 Letters");
        printLetters(h1.getetters());
        
        Hand h2 = new Hand();
        ganstaDealer.fillHand(h2);
        System.out.println("Gansta Letters");
        printONLetters(lg.getLetters());
        
        System.out.println("H2 Letters");
        printLetters(h2.getetters());
        
        //Eliminar fichas de h1 y re - cargarlo
        /*h1.removeLetter(0);
        h1.removeLetter(5);*/
        
        System.out.println("H1 Letters");
        printLetters(h1.getetters());
        
        ganstaDealer.fillHand(h1);
        System.out.println("Gansta Letters");
        printONLetters(lg.getLetters());
        
        System.out.println("H1 Letters");
        printLetters(h1.getetters());
        
        System.out.println("H2 Letters");
        printLetters(h2.getetters());
        ganstaDealer.fillHand(h2);
        System.out.println("H2 Letters");
        printLetters(h2.getetters());
        
    }
    
    public static void printONLetters(ArrayList<Letter>letras){
        Iterator i = letras.iterator();
        
        while(i.hasNext()){
            Letter l = (Letter)i.next();
            if(l.isOn()){
                System.out.print(l.getSymbol()+" ");
            }else
                System.out.print("- ");
        }
        
        System.out.println("");
        
    }
    
    public static void printLetters(ArrayList<Letter>letras){
        Iterator i = letras.iterator();
        
        while(i.hasNext()){
            Letter l = (Letter)i.next();
            //if(l.isOn()){
                System.out.print(l.getSymbol()+" ");
            //}
        }
        
        System.out.println("");
        
    }
    
}

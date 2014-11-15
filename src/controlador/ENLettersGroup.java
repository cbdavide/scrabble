/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class ENLettersGroup extends LettersGroup{
    
    public ENLettersGroup(){
        letters = new ArrayList<>();
        assignation();
    }
        
    @Override
    protected final void assignation(){
        assign(2," ",0);
        assign(9,"A",1);
        assign(2,"B",3);
        assign(2,"C",3);
        assign(4,"D",2);
        assign(12,"E",1);
        assign(2,"F",4);
        assign(3,"G",2);
        assign(2,"H",4);
        assign(9,"I",1);
        assign(1,"J",8);
        assign(1,"K",5);
        assign(4,"L",1);
        assign(2,"M",3);
        assign(6,"N",1);
        assign(8,"O",1);
        assign(2,"P",3);
        assign(1,"Q",10);
        assign(6,"R",1);
        assign(4,"S",1);
        assign(6,"T",1);
        assign(4,"U",1);
        assign(2,"V",4);
        assign(2,"W",4);
        assign(1,"X",8);
        assign(2,"Y",4);
        assign(1,"Z",10);
    }
}

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
public class ESLettersGroup extends LettersGroup{
    
    
    public ESLettersGroup(){
        letters = new ArrayList<>();
        assignation();
    }       
    
    @Override
    protected final void assignation(){
        assign(2," ",0);
        assign(12,"A",1);
        assign(2,"B",3);
        assign(4,"C",3);
        assign(1,"CH",5);
        assign(5,"D",2);
        assign(12,"E",1);
        assign(1,"F",4);
        assign(2,"G",2);
        assign(2,"H",4);
        assign(6,"I",1);
        assign(1,"J",8);
        assign(4,"L",1);
        assign(1,"LL",8);
        assign(2,"M",3);
        assign(5,"N",1);
        assign(1,"Ñ",8);
        assign(9,"O",1);
        assign(2,"P",3);
        assign(1,"Q",5);
        assign(5,"R",1);
        assign(1,"RR",8);
        assign(6,"S",1);
        assign(4,"T",1);
        assign(5,"U",1);
        assign(1,"V",4);
        assign(1,"X",8);
        assign(1,"Y",4);
        assign(1,"Z",10);
    }
    
}

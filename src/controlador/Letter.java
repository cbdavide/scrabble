/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.Serializable;

/**
 *
 * @author david
 */
public class Letter implements Serializable{
    
    private String symbol;
    private int value;
    private boolean isOn;
    
    public Letter(){
        this.isOn = true;
    }
    
    public String getSymbol(){
        return this.symbol;
    }
    
    public int getValue(){
        return this.value;
    }
    
    public boolean isOn(){
        return this.isOn;
    }
    
    public void setSymbol(String symbol){
        this.symbol = symbol;
    }
    
    public void setValue(int value){
        this.value = value;
    }
    
    public void toogleLeter(boolean b){
        this.isOn = b;
    }
}

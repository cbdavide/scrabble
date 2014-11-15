/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author david
 */
public abstract class Diccionario {
    
    protected File file;
    
    protected FileReader fr;
    protected BufferedReader buffer;
    
    private void loadFile(){
        loadFileReader();
        loadBufferedReader();
    }
    
    private void loadFileReader(){
        try{
            fr = new FileReader(file);
        }catch(FileNotFoundException ex){
            System.out.println("Error creando FileReader");                
        }
    }
    
    private void loadBufferedReader(){
        buffer = new BufferedReader(fr);
    }
    
        
    /**
     * This method must be overwritten.
     * This method charge of select the file corresponding
     * of the letter where the word could be founded.
     * 
     * @param firstLetter char The first letter of the word to be searched
     */
    protected abstract void selectFile(char firstLetter);
    
    public boolean searchWord(String word){
        selectFile(word.charAt(0));
        loadFile();
        return readFile(word);
    }
    
    private boolean readFile(String word){
        boolean result = false;
        String temp;
        try{
            while((temp = buffer.readLine()) != null){
                if(temp.equals(word)){
                    result = true;
                    break;
                }
            }
        }catch(IOException ex){
            System.out.println("End of File!!");
        }finally{
            closeStreams();
        }
        return result;
    }
    
    private void closeStreams(){
        try{
            buffer.close();
            fr.close();
        }catch(IOException ex){
            System.out.println("Problema al cerrar streams");
        }
    }
    
}

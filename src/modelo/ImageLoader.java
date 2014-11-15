/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 * This class load Images to use in the app
 * e.g icons for a LetterContainer object
 * @author david
 */
public class ImageLoader {
     
    /**
     * This method read a image from the computer
     * @param filePath path of the image
     * @return Image ready for use
     */
    public Image loadImage(String filePath){
        Image temp;
        InputStream is = getClass().getResourceAsStream(filePath);
        temp = read(is);
        return temp;
    }
    
    private Image read(InputStream is){
        Image temp = null;
        try{
            temp = ImageIO.read(is);
        }catch(IOException e){
            //Change this
            System.out.println(e.getMessage());
        }finally{
            closeStream(is);
        }
        return temp;
    }
    
    private void closeStream(InputStream is){
        try{
            is.close();
        }catch(IOException ex){
            //Change this
            System.out.println(ex.getMessage());
        }
    }
    
}

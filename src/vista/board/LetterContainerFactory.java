/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.board;

import java.awt.Image;
import modelo.ImageLoader;

/**
 *
 * @author david
 */
public class LetterContainerFactory {
    
    private static final ImageLoader imageLoader = new ImageLoader();
    
    public static LetterContainer createSimpleLeterContainer(){
        return new SimpleLetterContainer();
    }
    
    public static LetterContainer createStartLetterContainer(){
        Image i = imageLoader.loadImage("/img/star.png");
        return new AdvancedLetterContainer(i,2,true);
    }
    
    public static LetterContainer createTWLetterContainer(){
        Image i = imageLoader.loadImage("/img/tw.png");
        return new AdvancedLetterContainer(i,3,true);
    }
    
    public static LetterContainer createDWLetterContainer(){
        Image i = imageLoader.loadImage("/img/dw.png");
        return new AdvancedLetterContainer(i,2,true);
    }
    
    public static LetterContainer createTLLetterContainer(){
        Image i = imageLoader.loadImage("/img/tl.png");
        return new AdvancedLetterContainer(i,3,false);
    }
    
    public static LetterContainer createDLLetterContainer(){
        Image i = imageLoader.loadImage("/img/dl.png");
        return new AdvancedLetterContainer(i,2,false);
    }
    
}

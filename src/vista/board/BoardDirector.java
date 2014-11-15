/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.board;

/**
 *
 * @author david
 */
public class BoardDirector {
    
    private final BoardBuilder builder;
    
    public BoardDirector(BoardBuilder bd){
        this.builder = bd;
    }
    
    public void construct(){
        builder.buildStarLetterContainer();
        builder.buildSimpleLettersContairner();
        builder.buildTWLetterContainers();
        builder.buildDWLetterContainers();
        builder.buildTLLetterContainers();
        builder.buildDLLetterContainers();
    }
    
    public LetterContainer[][] getLetterContainers(){
        return builder.geLetterContainers();
    }   
    
    
}

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
public interface BoardBuilder {
    
    public void buildStarLetterContainer();
    public void buildSimpleLettersContairner();
    public void buildTWLetterContainers();
    public void buildDWLetterContainers();
    public void buildDLLetterContainers();
    public void buildTLLetterContainers();
    
    public LetterContainer[][] geLetterContainers();
    
}

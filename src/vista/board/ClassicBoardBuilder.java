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
public class ClassicBoardBuilder implements BoardBuilder{
    
    private final LetterContainer[][] boxes;
    
    private final int ROWS = 15;
    private final int COLS = 15;
    
    public ClassicBoardBuilder(){
        boxes = new LetterContainer[ROWS][COLS];
    }

    @Override
    public void buildStarLetterContainer() {
        boxes[7][7] = LetterContainerFactory.createStartLetterContainer();
    }

    @Override
    public void buildSimpleLettersContairner() {
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(boxes[i][j] == null)
                    boxes[i][j] = LetterContainerFactory.createSimpleLeterContainer();
            }
        }        
    }

    @Override
    public void buildTWLetterContainers() {
        boxes[0][0] = LetterContainerFactory.createTWLetterContainer();
        boxes[0][7] = LetterContainerFactory.createTWLetterContainer();
        boxes[0][14] = LetterContainerFactory.createTWLetterContainer();
        boxes[7][0] = LetterContainerFactory.createTWLetterContainer();
        boxes[7][14] = LetterContainerFactory.createTWLetterContainer();
        boxes[14][0] = LetterContainerFactory.createTWLetterContainer();
        boxes[14][7] = LetterContainerFactory.createTWLetterContainer();
        boxes[14][14] = LetterContainerFactory.createTWLetterContainer();
    }

    @Override
    public void buildDWLetterContainers() {
        boxes[1][1] = LetterContainerFactory.createDWLetterContainer();
        boxes[1][13] = LetterContainerFactory.createDWLetterContainer();
        boxes[2][2] = LetterContainerFactory.createDWLetterContainer();
        boxes[2][12] = LetterContainerFactory.createDWLetterContainer();
        boxes[3][3] = LetterContainerFactory.createDWLetterContainer();
        boxes[3][11] = LetterContainerFactory.createDWLetterContainer();
        boxes[4][4] = LetterContainerFactory.createDWLetterContainer();
        boxes[4][10] = LetterContainerFactory.createDWLetterContainer();
        boxes[10][4] = LetterContainerFactory.createDWLetterContainer();
        boxes[10][10] = LetterContainerFactory.createDWLetterContainer();
        boxes[11][3] = LetterContainerFactory.createDWLetterContainer();
        boxes[11][11] = LetterContainerFactory.createDWLetterContainer();
        boxes[12][2] = LetterContainerFactory.createDWLetterContainer();
        boxes[12][12] = LetterContainerFactory.createDWLetterContainer();
        boxes[13][1] = LetterContainerFactory.createDWLetterContainer();
        boxes[13][13] = LetterContainerFactory.createDWLetterContainer();
    }

    @Override
    public void buildDLLetterContainers() {
       boxes[0][3] = LetterContainerFactory.createDLLetterContainer();
       boxes[0][11] = LetterContainerFactory.createDLLetterContainer();
       boxes[2][6] = LetterContainerFactory.createDLLetterContainer();
       boxes[2][8] = LetterContainerFactory.createDLLetterContainer();
       boxes[3][0] = LetterContainerFactory.createDLLetterContainer();
       boxes[3][7] = LetterContainerFactory.createDLLetterContainer();
       boxes[3][14] = LetterContainerFactory.createDLLetterContainer();
       boxes[6][2] = LetterContainerFactory.createDLLetterContainer();
       boxes[6][6] = LetterContainerFactory.createDLLetterContainer();
       boxes[6][8] = LetterContainerFactory.createDLLetterContainer();
       boxes[6][12] = LetterContainerFactory.createDLLetterContainer();
       boxes[7][3] = LetterContainerFactory.createDLLetterContainer();
       boxes[7][11] = LetterContainerFactory.createDLLetterContainer();
       boxes[8][2] = LetterContainerFactory.createDLLetterContainer();
       boxes[8][6] = LetterContainerFactory.createDLLetterContainer();
       boxes[8][8] = LetterContainerFactory.createDLLetterContainer();
       boxes[8][12] = LetterContainerFactory.createDLLetterContainer();
       boxes[11][0] = LetterContainerFactory.createDLLetterContainer();
       boxes[11][7] = LetterContainerFactory.createDLLetterContainer();
       boxes[11][14] = LetterContainerFactory.createDLLetterContainer();
       boxes[12][6] = LetterContainerFactory.createDLLetterContainer();
       boxes[12][8] = LetterContainerFactory.createDLLetterContainer();
       boxes[14][3] = LetterContainerFactory.createDLLetterContainer();
       boxes[14][11] = LetterContainerFactory.createDLLetterContainer();
    }

    @Override
    public void buildTLLetterContainers() {
        boxes[1][5] = LetterContainerFactory.createTLLetterContainer();
        boxes[1][9] = LetterContainerFactory.createTLLetterContainer();
        boxes[5][1] = LetterContainerFactory.createTLLetterContainer();
        boxes[5][5] = LetterContainerFactory.createTLLetterContainer();
        boxes[5][9] = LetterContainerFactory.createTLLetterContainer();
        boxes[5][13] = LetterContainerFactory.createTLLetterContainer();
        boxes[9][1] = LetterContainerFactory.createTLLetterContainer();
        boxes[9][5] = LetterContainerFactory.createTLLetterContainer();
        boxes[9][9] = LetterContainerFactory.createTLLetterContainer();
        boxes[9][13] = LetterContainerFactory.createTLLetterContainer();
        boxes[13][5] = LetterContainerFactory.createTLLetterContainer();
        boxes[13][9] = LetterContainerFactory.createTLLetterContainer();
    }

    @Override
    public LetterContainer[][] geLetterContainers() {
        return this.boxes;
    }
    
}

package view.block;
/**
 *
 *
 * Bloco pintado com número, bloco real do jogo.
 */
public class ColoredBlock extends ExtendableBlock {   
    
    private int number;
    private int BLOCK_LABEL_SIZE = 85;

    public ColoredBlock (int number, int x, int y) {
        super("/assets/"+number+".png", x, y);
        setSize(BLOCK_LABEL_SIZE, BLOCK_LABEL_SIZE);
        this.number = number;
    }
    
    public int getNumber() {
        return number;
    }
}

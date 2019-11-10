package view.block;

import java.awt.Container;
import view.animator.block.BlockAnimator;
import view.animator.block.animation.CombinedBlockAnimation;

/**
 *
 * @author marcelo
 */
public class BlockHolder extends ExtendableBlock {

    private ColoredBlock block;
    private Container board;
    private BlockAnimator animator;

    public BlockHolder (int x, int y, Container board) {
        // Manda seu X e Y para a classe pai para setar sua posição na board
        super(x, y);
        this.board = board;
        this.board.add(this);
        
        this.animator = BlockAnimator.getInstance(board);
    }

    // método para instanciar um novo block dado um número
    public ColoredBlock createBlock(int number, boolean isCombined) {
        block = new ColoredBlock(number, this.getX(), this.getY());
        
        board.add(block);
        board.repaint();
        
        if (isCombined) {
            animator.animateCombinedBlock(block);
        } else {
            animator.animateRandomBlock(block);
        }
        return block;
    }
    
    public void setBlock(ColoredBlock block) {
        this.block = block;
        this.block.setLocation(this.getX(), this.getY());
    }
    
    public ColoredBlock getBlock() {
        return block;
    }
    
    // Dettatch block do holder mas não da board
    public ColoredBlock removeBlock() {       
        ColoredBlock b = block;
        block = null;
        return b;
    }
    
    // Remove block do holder e da board
    public ColoredBlock purgeBlock() {
        ColoredBlock b = block;
        board.remove(b);
        board.revalidate();
        board.repaint();
        block = null;
        return b;
    }
    
    public boolean hasBlock(){
        return block != null;
    }
}

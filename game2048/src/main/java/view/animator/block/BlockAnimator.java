package view.animator.block;

import java.awt.Container;
import view.animator.block.animation.CombinedBlockAnimation;
import view.animator.block.animation.RandomBlockAnimation;
import view.block.ColoredBlock;

/**
 *
 * @author marcelo
 */
public class BlockAnimator {
    
    private static BlockAnimator instance;
    private Container board;
    
    private BlockAnimator(Container board) {
        this.board = board;
    }
    
    public static BlockAnimator getInstance(Container board) {
        if (instance == null)
            instance = new BlockAnimator(board);
        return instance;
    }
    
    public void animateRandomBlock(ColoredBlock block) {
        new RandomBlockAnimation(block, this.board);
    }
    
    public void animateCombinedBlock(ColoredBlock block) {
        new CombinedBlockAnimation(block, this.board);
    }
}

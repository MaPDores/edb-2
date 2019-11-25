package listeners;

import view.block.BlockHolder;

/**
 *
 * @author marcelo
 */
public abstract class ExtendableListener {

    protected BlockHolder[][] holders;
    
    public ExtendableListener (BlockHolder[][] holders) {
        this.holders = holders;
    }
}

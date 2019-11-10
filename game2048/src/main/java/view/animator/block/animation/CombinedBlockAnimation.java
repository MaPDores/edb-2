package view.animator.block.animation;

import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import view.animator.extendable.ExtendableAnimation;
import view.block.ColoredBlock;
import view.utils.ImageFactory;

/**
 *
 * @author marcelo
 */
public final class CombinedBlockAnimation extends ExtendableAnimation {
    // Variáveis de construção
    private ColoredBlock block;
    private Icon icon;
    private ImageFactory imgFactory = ImageFactory.getInstance();
    
    // Variáveis de animação
    private int i = 0;
    private double x = 1;
    private boolean isExpanding = true;
    
    public CombinedBlockAnimation (ColoredBlock block, Container board) {
        super(5, board);
        start(block);
    }
    
    public void start(ColoredBlock block) {
        this.block = block;
        this.icon = block.getIcon();
        start();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (x >= 1.3)
            isExpanding = false;

        if (isExpanding) {
            x += 0.01;
        }
        else if (x != 1) {
            x -= 0.01;
        } else {
            this.timer.stop();
        }
        System.out.println("X:"+x+" count:"+i++);
        resize();
        panel.repaint();
    }
    
    private void resize() {
        block.setIcon(imgFactory.createResizedImageIcon((ImageIcon) this.icon, (int) (this.icon.getIconWidth() * x),(int) (this.icon.getIconHeight() * x)));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public final class RandomBlockAnimation extends ExtendableAnimation  {
    // Variáveis de construção
    private ColoredBlock block;
    private Icon icon;
    private ImageFactory imgFactory = ImageFactory.getInstance();
    
    // Variáveis de animação
    private double x = 0.01d;
    
    public RandomBlockAnimation (ColoredBlock block, Container board) {
        super(2, board);
        start(block);
    }
    
    public void start(ColoredBlock block) {
        this.block = block;
        this.icon = block.getIcon();
        start();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (x >= 1d) {
            timer.stop();
        } else {
            x += 0.01;
            resize();
            panel.repaint();
        }
    }
    
    private void resize() {
        block.setIcon(imgFactory.createResizedImageIcon((ImageIcon) this.icon, (int) (this.icon.getIconWidth() * x),(int) (this.icon.getIconHeight() * x)));
    }

}

package listeners;

import controller.BoardController;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.block.BlockHolder;

/**
 *
 * @author marcelo
 */
public class GameMouseListener extends ExtendableListener implements MouseListener {
    private static int clickX, clickY, releaseX, releaseY;
    public GameMouseListener (BlockHolder[][] holders) {
        super(holders);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    clickX = e.getX();
    clickY = e.getY();       
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
   public void mouseReleased(MouseEvent e) {
       boolean hasMoved = false;
       try {
           int xVariation, yVariation;
           releaseX = e.getX();
           releaseY = e.getY();
           xVariation = (releaseX - clickX);
           yVariation = (releaseY - clickY);
           if (xVariation > 0 && yVariation < 0) {
               yVariation = (yVariation * (-1));
               if (xVariation > yVariation) {
                   System.out.println("Movimentacao nao detectada, tente novamente");
               } else {
                   hasMoved = BoardController.moveUp(holders);
                   yVariation = (yVariation * (-1));
               }
           }
           if (xVariation > 0 && yVariation > 0) {
               if (xVariation > yVariation) {
                   hasMoved = BoardController.moveRight(holders);
               } else {
                   hasMoved = BoardController.moveDown(holders);
               }
           }
           if (xVariation < 0 && yVariation > 0) {
               xVariation = (xVariation * (-1));
               if (xVariation > yVariation) {
                   hasMoved = BoardController.moveLeft(holders);
               } else {
                   System.out.println("Movimentacao nao detectada, tente novamente");
               }
           }
           if (hasMoved)
               BoardController.createRandom(holders);
       } catch (java.lang.NullPointerException me) {
           me.printStackTrace();
       }
   }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
}

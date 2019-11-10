package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import controller.BoardController;
import view.block.BlockHolder;

/**
 *
 * @author marcelo
 * 
 * Classe que ouve as Teclas do Teclado e executa os comandos.
 */
public class GameKeyListener extends ExtendableListener implements KeyListener {
    
    public GameKeyListener (BlockHolder[][] holders) {
        super(holders);
    }
    
    @Override
        /* NOT WORKING PROPERLY */
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        boolean hasMoved = false;
        if(ke.getKeyCode() == KeyEvent.VK_W || ke.getKeyCode() == KeyEvent.VK_UP){
            hasMoved = BoardController.moveUp(holders);
        }
        if(ke.getKeyCode() == KeyEvent.VK_A || ke.getKeyCode() == KeyEvent.VK_LEFT){
            hasMoved = BoardController.moveLeft(holders);
        }
        if(ke.getKeyCode() == KeyEvent.VK_S || ke.getKeyCode() == KeyEvent.VK_DOWN){
            hasMoved = BoardController.moveDown(holders);
        }
        if(ke.getKeyCode() == KeyEvent.VK_D || ke.getKeyCode() == KeyEvent.VK_RIGHT){
            hasMoved = BoardController.moveRight(holders);
        }
        if(ke.getKeyCode() == KeyEvent.VK_SPACE){
            BoardController.easterEgg(holders);
        }
        if (hasMoved)
            BoardController.createRandom(holders);       
    }

    @Override
    public void keyReleased(KeyEvent ke) {}
    
}

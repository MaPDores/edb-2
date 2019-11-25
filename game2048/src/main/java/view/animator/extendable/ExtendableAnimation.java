package view.animator.extendable;

import java.awt.Container;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author marcelo
 */
public abstract class ExtendableAnimation implements ActionListener {
    
    protected Timer timer;
    protected Container panel;
    protected int speed;
    
    public ExtendableAnimation (int speed, Container panel) {
        this.panel = panel;
        this.speed = speed;
    }
    
    protected void start() {
        this.timer = createNewTimer();
        this.timer.start();
    }
    protected Timer createNewTimer() {
        Timer timer = null;
        try {
            timer = new Timer(this.speed, this);
        } catch (Exception e) {
            System.out.println("You didn't gave a value to speed or implements ActionListener");
        }
        return timer;
    }

    public int getDelayPerEvent() {
        return speed;
    }

    public void setDelayPerEvent(int speed) {
        this.speed = speed;
    }
}

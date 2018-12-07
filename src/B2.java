import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;


public class B2 extends JPanel implements KeyListener {


/*
    Image newBack;
    Toolkit kit = Toolkit.getDefaultToolkit();


    public void paintComponent(Graphics comp) {
        Graphics2D comp2D = (Graphics2D)comp;
        if (newBack != null)
            comp2D.drawImage(newBack, 0, 0, this);
    }

*/
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){

            System.out.println("Zmiana tla");
            setBackground(Color.black);

            //newBack = kit.getImage("plaza.jpg");
        }


        repaint();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}

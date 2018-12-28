package las;

import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class TloPanel extends JPanel implements KeyListener{
    Toolkit kit = Toolkit.getDefaultToolkit();
    Image back;
    Image newBack;


    TloPanel() {
        super();
        setBackground(Color.white);
        back = kit.getImage("lasBG.png");
    }

    public void paintComponent(Graphics comp) {
        Graphics2D comp2D = (Graphics2D)comp;
        if (back != null)
            comp2D.drawImage(back, 0, 0, this);
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
        System.out.println("Zmiana tla");
        setBackground(Color.black);
        newBack = kit.getImage("plaza.jpg");

        }
        repaint();
    }


    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }
}

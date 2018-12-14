package las;

import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

public class TloPanel extends JPanel implements KeyListener{
    Toolkit kit = Toolkit.getDefaultToolkit();
    Image back;
    Image newBack;
    static ImageIcon active;


    TloPanel() {
        super();
        setBackground(Color.white);
        back = kit.getImage("las.jpg");
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
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


}

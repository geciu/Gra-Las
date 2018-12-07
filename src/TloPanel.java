import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

public class TloPanel extends JPanel implements KeyListener{
    Image back;
    Image newBack;
    static ImageIcon active;
    Toolkit kit = Toolkit.getDefaultToolkit();

    TloPanel() {
        super();
        setBackground(Color.white);
        back = kit.getImage("las.jpg");
        newBack = kit.getImage("plaza.jpg");
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
        back=newBack;}
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }
}

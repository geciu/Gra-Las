import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

public class TloPanel extends JPanel implements KeyListener{
    Image back;
    Image Pik1;
    static ImageIcon active;
    Toolkit kit = Toolkit.getDefaultToolkit();

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
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Zmiana tla");
        setBackground(Color.black);
        //back = kit.getImage("plaza.jpg");
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}

package las;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {

    private BufferedImage image;
    JButton przycisk;
    TloPanel panel = new TloPanel();

    Window(String nazwa) {
        super(nazwa); //metoda super wywołuje konstruktor nadklasy
        setResizable(false);
        setSize(1024, 768);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(1, 1, 15, 15));
        pane.add(panel);
        setContentPane(panel);
        TloPanel act = new TloPanel();
        addKeyListener(act);
        act.addKeyListener(new TloPanel());
        show();
        }
}

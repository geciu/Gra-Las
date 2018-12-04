import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
        setContentPane(pane);
        show();

        przycisk = new JButton("Dalej");
        przycisk.setLayout(new FlowLayout());
        add(przycisk/*, BorderLayout.SOUTH*/);
        przycisk.setSize(1, 1);
        przycisk.setLocation(200,10);
        przycisk.addActionListener(new B1());

    }



}

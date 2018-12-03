import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {

    Window(String nazwa) {
        super(nazwa); //metoda super wywołuje konstruktor nadklasy
        setResizable(false);
        setSize(1024, 768);

        JPanel obrazPanel = new ObrazPanel();
        add(obrazPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        setResizable(false);
        setSize(1024, 768);


    }
}

package las;

import javax.swing.*;

public class Okno extends JFrame {

    Okno(String nazwa) {
        super(nazwa); //metoda super wywołuje konstruktor nadklasy
        setResizable(false);
        setSize(1024, 768);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

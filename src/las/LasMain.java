package las;

import javax.swing.*;

public class LasMain extends JComponent{


    public static void main(String[] args) {
        System.out.println("Witaj w grze Las!");
        Window w = new Window(" ");
        //w.setContentPane(new JLabel(new ImageIcon("las.jpg")));
        w.setSize(1024, 768);
        w.setVisible(true);

    }
}

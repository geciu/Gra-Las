import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;


import com.brackeen.javagamebook.graphics.*;

public class LasMain extends JComponent{


    public static void main(String[] args) {
        System.out.println("Witaj w grze Las!");




        Window w = new Window(" ");
        w.setContentPane(new JLabel(new ImageIcon("las.jpg")));
        w.setVisible(true);

    }
}

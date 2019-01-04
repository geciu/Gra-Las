package las;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.util.Date;
import java.util.TimerTask;

public class LasMain extends JFrame{

    private JPanel contentPane;
    private String[] images = {"tlo1.png", "tlo2.png", "tlo3.png", "tlo4.png", "tlo5.png",
                                "tlo6.png", "tlo7.png", "tlo8.png", "tlo9.png", "tlo10.png"};

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run() {
                try{
                    LasMain frame = new LasMain();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });


    }

    public LasMain(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 15, 1024, 768);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPhoto = new JLabel("");
        lblPhoto.setBorder(new LineBorder(new Color(0,0,0)));
        lblPhoto.setBounds(0,0,1024,768);
        contentPane.add(lblPhoto);

        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int n = (int) Math.floor(Math.random() *10);
                String image = images[n];
                lblPhoto.setIcon(new ImageIcon("src\\images\\" + image));
            }
        });
        timer.start();
        Music song = new Music();
        song.playMusic();





    }
}
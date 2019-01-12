package las;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class LasMain {

    public static void main(String[] args) {


        int szerokoscEkranu;
        int wysokoscEkranu;
        int graSzerokosc;
        int graWysokosc;


        szerokoscEkranu=Toolkit.getDefaultToolkit().getScreenSize().width;
        wysokoscEkranu=Toolkit.getDefaultToolkit().getScreenSize().height;
        graSzerokosc =szerokoscEkranu;;
        graWysokosc=wysokoscEkranu;

        Muzyka muzyka = new Muzyka();
        GameWindow okno = new GameWindow(graSzerokosc, graWysokosc,(int) (szerokoscEkranu-graSzerokosc)/2, (int)(wysokoscEkranu-graWysokosc)/2);


        muzyka.playMusic("sounds/PayDay.wav");
    }

}

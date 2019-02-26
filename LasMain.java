package las;

import javax.swing.*;
import java.awt.Toolkit;

/** Główna klasa programu.
 * Celem gry jest nauka nazw roślin. Gra polega na strzelaniu do roślin
 * Za trafienie rośliny leśnej dostajemy +1pkt, natomiast za trafienie innej rosliny -1.
 * W 1. etapie użytkownik uczy się nazw roślin.
 * Kolejne etapy poprawiają koordynację wzrokowo-ruchową.
 * Aby utrudnić grę wprowadzono skalowanie rozmiarów roślin oraz
 * nadano różne rozmairy poruszających się ikon*/

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

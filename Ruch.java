package las;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;


/** Klasa modelująca ruch obiektu */
public class Ruch {
    /** Początkowa współrzędna x obiektu */
    public int x;
    /** Początkowa współrzędna y obiektu */
    public int y;
    /** Aktualna współrzędna x obiektu */
    public int currX;
    /** Aktualna współrzędna y obiektu */
    public int currY;
    /** Szerokość ikony obiektu  */
    public int szer;
    /** Wysokość ikony obiektu */
    public int wys;
    /** Rodzaj obiektu  - indeks z tablicy rosliny*/
    public int rodzaj;
    /** Krok przesunięcia obiektu z dołu do góry */
    public int krok;
    /** Częstotliwość funkcji sinus*/
    public double frekwencja;
    /** Szerokość pola graficznego */
    public int sWidth;
    /** Wysokość pola graficznego */
    public int sHeight;
    /** Czy trafiono obiekt */
    public boolean traf;
    /** Ikona obiektu - obiekt*/
    public Image icon;

    /** Konstruktor - ustawienie parametrów obiektu, wylosowanie koloru obiektu */
    public Ruch(int x, int y, int ampl, double freq, Image[] images){
        this.x=x;
        this.y=y;
        currX=x;
        currY=y;
        sWidth=1024;
        sHeight=768;
        this.krok = 6;
        traf =false;
        //this.frekwencja =freq;

        /** Funkcja matematyczna losująca rodzaj rośliny */
        rodzaj =(int)(0.4+Math.random()*images.length);
        if(rodzaj >=images.length) rodzaj =images.length-1;
        icon=images[rodzaj];
        szer =icon.getWidth(null);
        wys =icon.getHeight(null);

    }


    /** Główna metoda opisująca ruch obrazka. Odpowiedzilna za obliczanie pozycji oraz symulację ruchu*/
    public void calculatePathPos(int mode){
        if (!Obrazy.levelPause) {
            int tmpX = 0;
            switch (mode) {
                /** Poruszanie liniowe, poziom 0*/
                case 0:
                    currY = currY + krok;
                    if (currY > sHeight) {
                        currY = 0;
                    }
                    tmpX = 0;
                    currX = x + tmpX;
                    break;

                 /** Poruszanie liniowe, poziom 1 */
                case 1:
                    currY = currY + krok;
                    if (currY > sHeight) {
                        currY = 0;
                    }
                    tmpX = 0;
                    currX = x + tmpX;
                    break;

                 /** Poruszanie liniowe, poziom 2 */
                case 2:
                    currY = currY + krok;
                    if (currY > sHeight) {
                        currY = 0;
                    }
                    tmpX = 0;
                    currX = x + tmpX;
                    break;
                default:
                    break;
            }
        }
    }



    /** Metoda opisująca zdarzenia w momencie trafienia rołśiny - zmiana statusu oraz dźwięk trafienia*/
    public void setHit(){
        if(!traf){
            traf =true;
            playMusic("sounds/trafiony.wav");
        }
    }


    /** Metoda odpowiedzilna za odtwarzanie dźwięku z pliku */
    public static void playMusic(String filepath){
        InputStream music;

        try {
            music = new FileInputStream(new File(filepath));
            AudioStream audios = new AudioStream(music);
            AudioPlayer.player.start(audios);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
    }


    /** Metoda dzięki której możliwe jest ustawienie pozycji */
    public void setPosition(int cX, int cY){
        currX=cX;
        currY=cY;
    }

    /** Metoda ustawiająca rozmiar pola graficznego */
    public void setScreenSize(int gWidth, int gHeight){
        sWidth=gWidth;
        sHeight=gHeight;
    }

    /** Metoda  ustawiająca pozycję y obiektu */
    public void setYPos(int cY){
        currY=cY;
    }

    /** Metoda pobierająca pozycję obiektu (X,Y) */
    public Point getPosition(){
        return new Point(currX,currY);
    }


    /** Metoda, która sprawdza, czy "strzał" trafił obrazek. Zwraca wartość true w przypadku, gdy obraz zawiera punkt*/
    public boolean containsPoint(int x, int y){
        scaleWidthHeight((double)sHeight);
        if(x>=currX && x<currX+ szer){
            if(y>=(sHeight-currY) && y<(sHeight-currY+ wys)){
                return true;
            }
        }

        return false;
    }

    /** Metoda odpowiedzilna za skalowanie poruszającego się obrazu */
    public void scaleWidthHeight(double scale){
    szer =(int)(icon.getWidth(null)*(1.0-currY/scale));
    wys =(int)(icon.getHeight(null)*(1.0-currY/scale));
 }
}

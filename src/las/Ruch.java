package las;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


/**
 * Klasa modelująca przemieszczający się obiekt
 */
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

    /** Krok przesunięcia obiektu z dołu do góry */
    public int krok;
    /** Kąt w funkcji sinus*/
    private double angle;
    /** Amplituda w funkcji sinus*/
    public int amplituda;
    /** Częstotliwość funkcji sinus*/
    public double frekwencja;
    /** Kolor obiektu  - indeks z tablicy rosliny*/
    public int rodzaj;
    /** Omega 2Pi*f */
    public final static double w=2*Math.PI;
    /** Szerokość pola graficznego*/
    public int sWidth;
    /** Wysokość pola graficznego*/
    public int sHeight;

    /** Czy trafiono obiekt */
    public boolean traf;
    /** Ikona obiektu - obiekt*/
    public Image icon;

    /**
     * Konstruktor - ustawienie parametrów obiektu, wylosowanie koloru obiektu
     * @param x początkowa współrzędna x
     * @param y początkowa współrzędna y
     * @param ampl amplituda sinus (ruch obiektu)
     * @param freq częstotliwość w funkcji sinus
     * @param images tablica ikon z obiektami
     */
    public Ruch(int x, int y, int ampl, double freq, Image[] images){
        this.x=x;
        this.y=y;
        currX=x;
        currY=y;
        this.krok =10;
        //sWidth=1024;
        //sHeight=768;
        traf =false;

        this.amplituda =ampl;
        this.frekwencja =freq;
        //losujemy kolor obiektu
        rodzaj =(int)(0.4+Math.random()*images.length);
        if(rodzaj >=images.length) rodzaj =images.length-1;
        icon=images[rodzaj];
        szer =icon.getWidth(null);
        wys =icon.getHeight(null);
        //ustawiamy pulsację w funkcji sinus 2 Pi f
        setOmega(this.frekwencja);


    }
    /**
     * kiedy obiekt zostanie trafiony - nowy status oraz dźwięk trafienia
     */
    public void setHit(){
        if(!traf){
            traf =true;
            playSound(new File("sounds/trafiony.wav"));
        }
    }

    /** Ustaw pozycję obiektu */
    public void setPosition(int cX, int cY){
        currX=cX;
        currY=cY;
    }

    /**Ustaw rozmiar pola graficznego*/
    public void setScreenSize(int gWidth, int gHeight){
        sWidth=gWidth;
        sHeight=gHeight;
    }

    /**Ustaw pozycję y obiektu*/
    public void setYPos(int cY){
        currY=cY;
    }//setYPos()

    /**Pobierz pozycję obiektu*/
    public Point getPosition(){
        return new Point(currX,currY);
    }//getPosition()

    /**Ustaw 2 Pi f*/
    public void setOmega(double freq){
        angle=w*freq;
    }//setOmega()

    /**Metoda obliczania pozycji obiektu - symulacja ruchu*/
    public void calculatePathPos(int mode){
        if (!Obrazy.levelPause) {
            int tmpX = 0;
            switch (mode) {
                case 0: //statycznie
                    //currY = (int) (sHeight * Math.random());
                    //currX = (int) (sWidth * Math.random());
                    currY = currY + krok;
                    if (currY > sHeight) {
                        currY = 0;
                    }
                    tmpX = 0;
                    currX = x + tmpX;
                    break;
                case 1: //liniowo
                    currY = currY + krok;
                    if (currY > sHeight) {
                        currY = 0;
                    }
                    tmpX = 0;
                    currX = x + tmpX;
                    break;
                case 2://sinus
                    currY = currY + krok;
                    if (currY > sHeight) {
                        currY = 0;
                    }
                    tmpX = (int) (amplituda * Math.sin(angle * currY));
                    currX = x + tmpX;
                    break;
                default:
                    break;
            }
        }
    }//calculatePathPos()

    /**
     * Funkcja określająca czy określone współrzędne*/
    public boolean containsPoint(int x, int y){
        scaleWidthHeight((double)sHeight);
        if(x>=currX && x<currX+ szer){
            if(y>=(sHeight-currY) && y<(sHeight-currY+ wys)){
                return true;
            }
        }

        return false;
    }

    /**
     * Skalowanie rozmiaru obrazu
     *
     * wraz z ruchem z dołu w górę
     * @param scale
     */
    public void scaleWidthHeight(double scale){
        szer =(int)(icon.getWidth(null)*(1.0-currY/scale));
        wys =(int)(icon.getHeight(null)*(1.0-currY/scale));
    }//scaleWidthHeight()


    /**
     * Funkcja odtwarzania dźwięku z pliku
     * @param f - obiekt klasy File reprezentujący ścieżkę do pliku MP3
     */
    public static synchronized void playSound(final File f) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(f);
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }//playSound()


}

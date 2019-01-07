package las;

import java.awt.*;
import javax.swing.ImageIcon;

public class Obrazy {
    /**  Dopuszczalny czas gry   */
    public static long GAME_TIME=Long.MAX_VALUE;
    /**  Liczba poziomów gry   */
    public final static long NO_LEVELS=2;
    /**   Czas rozgrywki na jednym poziomie [s] */
    public final static int LEVEL_TIME_LIMIT=20;
    /**  Ilość obiektów za które przyznaje się punkty ujemne = ilość pierwszych indeksów w tabeli rosliny */
    public final static int MAX_INDEX_WRONG_OBJ = 9;
    /**   Ostatnio trafiony indeks */
    public static int lastHit=0;
    /**  Obraz tła   */
    public static Image bgImage;
    /**  Obraz ikony Menu   */
    public static Image menuImage;
    /**  Obraz ikony Menu powrotu do gry  */
    public static Image menuGameImage;
    /**  Obraz ikony logo   */
    public static Image logoImage;
    /** Obraz ikony kursora - tarcza*/
    public static Image cursorImage;
    /**  Tablica obiektów pierwszego planu   */
    public static Image[] rosliny;
    /**  Zmienna stanu określającam czy jest przerwa w grze   */
    public static boolean pause=false;
    /** Zmienna stanu określająca czy wybrano menu*/
    public static boolean levelPause=false;
    /** Zmienna pomocnicza określająca początkowy czas gry */
    public static long startTime;
    /** Zmienna pomocnicza określająca czas ukończenia aktualnego poziomu */
    public static double levelTime;
    /** Zmienna pomocnicza określająca aktualny poziom gry */
    public static int MoveMODE=0;
    /** Zmienna pomocnicza określająca status ukończenia gry */
    public static boolean end=false;
    /** Zmienna pomocnicza określająca maksymalną liczę obiektów pierwszego planu */
    public static int noOfObjects=12;
    /** Szerokość pola graficznego gry */
    //public static int gWidth=1024;
    public static int gWidth= Toolkit.getDefaultToolkit().getScreenSize().width;
    /** Wysokość pola graficznego gry */
    //public static int gHeight=768;
    public static int gHeight=Toolkit.getDefaultToolkit().getScreenSize().height;

    /**
     * Metoda ładowania początkowych zasobów gry
     */
    public static void loadInitialImages() {

        //bgImage = loadImage("images/lasBG.jpg");
        menuImage=loadImage("images/menu.png");
        menuGameImage=loadImage("images/gra.jpg");
        logoImage=loadImage("images/logo.png");
        cursorImage=loadImage("images/stokrotka.png");


        rosliny = new Image[18];
        if (MoveMODE==0){
            bgImage = loadImage("images/lasBG.jpg");
            rosliny[0] = loadImage("images0/anturium.png");
            rosliny[1] = loadImage("images0/dalia.png");
            rosliny[2] = loadImage("images0/gozdzik.png");
            rosliny[3] = loadImage("images0/hiacynt.png");
            rosliny[4] = loadImage("images0/stokrotka.png");
            rosliny[5] = loadImage("images0/margaretka.png");
            rosliny[6] = loadImage("images0/róża.png");
            rosliny[7] = loadImage("images0/róża 2.png");
            rosliny[8] = loadImage("images0/aspidistra_wyniosla.png");
            rosliny[9] = loadImage("images0/jukka.png");
            rosliny[10] = loadImage("images0/brzoza.png");
            rosliny[11] = loadImage("images0/dab.png");
            rosliny[12] = loadImage("images0/klon.png");
            rosliny[13] = loadImage("images0/wierzba.png");
            rosliny[14] = loadImage("images0/przebisnieg.png");
            rosliny[15] = loadImage("images0/przylaszczka.png");
            rosliny[16] = loadImage("images0/sasanka.png");
            rosliny[17] = loadImage("images0/siodemczak_lesny.png");

        }
        else {
            bgImage = loadImage("images/lasBG.jfif");
            rosliny[0] = loadImage("images/anturium.png");
            rosliny[1] = loadImage("images/dalia.png");
            rosliny[2] = loadImage("images/gozdzik.png");
            rosliny[3] = loadImage("images/hiacynt.png");
            rosliny[4] = loadImage("images/stokrotka.png");
            rosliny[5] = loadImage("images/margaretka.png");
            rosliny[6] = loadImage("images/róża.png");
            rosliny[7] = loadImage("images/róża 2.png");
            rosliny[8] = loadImage("images/aspidistra_wyniosla.png");
            rosliny[9] = loadImage("images/jukka.png");
            rosliny[10] = loadImage("images/brzoza.png");
            rosliny[11] = loadImage("images/dab.png");
            rosliny[12] = loadImage("images/klon.png");
            rosliny[13] = loadImage("images/wierzba.png");
            rosliny[14] = loadImage("images/przebisnieg.png");
            rosliny[15] = loadImage("images/przylaszczka.png");
            rosliny[16] = loadImage("images/sasanka.png");
            rosliny[17] = loadImage("images/siodemczak_lesny.png");
        }

    }//koniec loadInitialImages()

    /**
     * Metoda pobierania obiektu klasy Image na podstawie ścieżki
     * dostepu podanej jako String
     */
    public static Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }//koniec loadImage();

}

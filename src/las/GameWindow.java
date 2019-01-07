package las;

import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Okno główne gry.
 */
public class GameWindow extends JFrame{

    public GameWindow(int width, int height, int x, int y){
        super();
        setSize(width, height);
        setLocation(x,y);
        setResizable(false);
        setUndecorated(true);
        initGUI(width,height);
        setVisible(true);
        animationLoop();
    }//koniec GameWindow()


    /**
     * Utwórz interfejs graficzny użytkownika
     * @param width szerokość okna
     * @param height wysokość okna
     */
    private void initGUI(int width, int height){
        setLayout(new GridLayout(1,1)); //ustaw rozkład
        //ustaw zasoby i parametry początkowe
        Obrazy.loadInitialImages();
        Toolkit tk = Toolkit.getDefaultToolkit();
        //ustaw kursor myszki w kształcie tarczy
        Cursor tCursor = tk.createCustomCursor(Obrazy.cursorImage, new Point(10,10), "Target Cursor");
        setCursor(tCursor);
        //((Component)screen.getFullScreenWindow()).setCursor(tCursor);
        add(new GamePanel(width,height)); //dodaj panel gry zawierający grafikę i akcję
    }//koniec initGUI()

    /**
     * Główna pętla gry - takt animacji (w procesie dalszej edukacji
     * można używać wątków czy klasy Timer)
     */
    private void animationLoop() {
        //pobierz liczbę milisekund od daty referencyjnej (w ms)
        Obrazy.startTime = System.currentTimeMillis();
        long currTime = Obrazy.startTime;

        while (currTime - Obrazy.startTime < Obrazy.GAME_TIME) {
            long elapsedTime = System.currentTimeMillis() - currTime;
            //licz czas gry
            currTime += elapsedTime;
            repaint();

            try {
                Thread.sleep(80);
            } catch (InterruptedException ex) {System.out.println("Wyjątek: "+ex);      }
        }//koniec while
    }//koniec animationLoop()

}
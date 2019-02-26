package las;

import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;

/** Klasa odpowiadajaca za obsluge okna gry i glownej petli programu */
public class GameWindow extends JFrame{


    /** Konstruktor klasy, ustawienie parametrów */
    public GameWindow(int width, int height, int x, int y){
        super();
        setSize(width, height);
        setUndecorated(true);
        initGUI(width,height);
        setVisible(true);
        animationLoop();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(x,y);
        setResizable(false);
    }

    /** Metoda zawierająca główną pętle gry */
    private void animationLoop() {
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
        }
    }

    /** Metoda, która tworzy interfejs użytkownika */
    private void initGUI(int width, int height){

        /** Ustawienie layout'u */
        setLayout(new GridLayout(1,1));

        /** Ustawienie parametrów i zasobów początkowych */
        Obrazy.loadInitialImages();
        Toolkit tk = Toolkit.getDefaultToolkit();

        /** Ustawienie ikony kursora (kwiatek) */
        Cursor tCursor = tk.createCustomCursor(Obrazy.cursorImage, new Point(10,10), "Cursor");
        setCursor(tCursor);

        /** Utworzenie nowego panelu */
        add(new GamePanel(width,height));
    }
}
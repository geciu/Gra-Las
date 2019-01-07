package las;

import java.awt.Toolkit;


public class LasMain {

    public static void main(String[] args) {

        //int gameWidth=1024;
        //int gameHeight=768;

        int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
        int gameWidth=screenWidth;
        int gameHeight=screenHeight;

        //GameWindow gw=new GameWindow(gameWidth,gameHeight, 0, 0);
        GameWindow gw=new GameWindow(gameWidth, gameHeight,(int) (screenWidth-gameWidth)/2, (int)(screenHeight-gameHeight)/2);

        Muzyka song = new Muzyka();
        song.playMusic();
    }
}
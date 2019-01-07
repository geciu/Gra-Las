package las;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
    /** Szerokość pola graficznego gry*/
    public int sWidth;
    /** Wysokość pola graficznego gry*/
    public int sHeight;
    /** Liczba roślin w linii*/
    public int objectsInLine;
    /** Przesunięcie pomiędzy liniami z obiektami*/
    public int przesuniecie;
    /** Obiekt reprezentujący status gry*/
    public Punkty stan;
    /** Wysokość paska menu*/
    public int pasek;
    /** Czcionki stosowane w Menu*/
    public Font menu_czcionka;
    /** Czcionki stosowane jako alert w polu gry*/
    public Font alert_czcionka;
    /** Tablica obiektów pierwszego planu*/
    private Ruch[] Rosliny;


    public GamePanel(int width, int height){

        stan =new Punkty();
        stan.reset();
        menu_czcionka =new Font("Dialog",Font.BOLD,36);
        alert_czcionka =new Font("Dialog",Font.BOLD,92);

        this.sWidth=width;
        this.sHeight=height;
        pasek =50;

        objectsInLine=4;
        przesuniecie =sHeight/(Obrazy.noOfObjects/objectsInLine);
        Rosliny =new Ruch[Obrazy.noOfObjects];

        restartGame();

        /* Obsługa zdarzeń myszki*/
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                if(me.getX()>(sWidth-250) && me.getY()>(sHeight- pasek)){
                    Obrazy.pause=!Obrazy.pause;
                    return;
                }
                if(me.getX()<300 && me.getY()>(sHeight- pasek)){
                    if(Obrazy.pause){
                        System.exit(1);
                    }
                }
                if(me.getX()>500 && me.getX()<800 && me.getY()>(sHeight- pasek)){
                    //Nowa gra
                    if(Obrazy.pause){
                        //Obrazy.MoveMODE=1;
                        Obrazy.MoveMODE=0;
                        Obrazy.end=false;
                        stan.reset();
                        Obrazy.levelPause=false;
                        Obrazy.bgImage = Obrazy.loadImage("images/lasBG.jpg");
                        restartGame();
                        repaint();
                    }else{
                        //Nowy poziom
                        if(Obrazy.levelPause){
                            //Czy dostępny jest kolejny poziom
                            if (Obrazy.MoveMODE<= Obrazy.NO_LEVELS){
                                Obrazy.MoveMODE++;
                                stan.time+= Obrazy.levelTime;
                                Obrazy.levelPause=false;
                                Obrazy.bgImage = Obrazy.loadImage("images/lasBG.jfif");
                                Obrazy.loadInitialImages();
                                stan.nextLevel();
                                restartGame();
                            }else{
                                //koniec poziomów = koniec gry
                                Obrazy.end=true;
                                stan.time+= Obrazy.levelTime;
                                Obrazy.pause=true;
                            }
                            repaint();
                        }
                    }
                }

                for(int i = 0; i< Rosliny.length; i++){
                    if(me.getY()<(sHeight- pasek)){
                        if(Rosliny[i].containsPoint(me.getX(), me.getY())){
                            if(!Rosliny[i].traf){
                                if (Obrazy.MoveMODE>0) {
                                    Rosliny[i].setHit();
                                }
                                Obrazy.lastHit=Rosliny[i].rodzaj;
                                if (Rosliny[i].rodzaj >Obrazy.MAX_INDEX_WRONG_OBJ) {
                                    stan.points++; }
                                else {
                                    stan.points--; }
                            }
                        }
                    }
                }
            }//koniec mouseClicked()
        });


    }


    @Override
    protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        g.drawImage(Obrazy.bgImage, 0, 0, null);

        //Na tle obiektu pierwszego planu
        for(int i = 0; i< Rosliny.length; i++){
            Rosliny[i].calculatePathPos(Obrazy.MoveMODE);
            //if(!Rosliny[i].traf)
            if((!Rosliny[i].traf) && (!Obrazy.levelPause)) {
                g.drawImage(Rosliny[i].icon, Rosliny[i].currX, sHeight - Rosliny[i].currY, (int) (Rosliny[i].icon.getWidth(null) * (1.0 - Rosliny[i].currY / (double) sHeight)), (int) (Rosliny[i].icon.getHeight(null) * (1.0 - Rosliny[i].currY / (double) sHeight)), null);
            }
        }

        //Ustaw kolor dolnego paska Menu i narysuj pasek
        g.setColor(Color.BLACK);
        g.fillRect(0, sHeight- pasek, sWidth, pasek);
        //Ustaw kolor domyślny
        g.setColor(Color.white);
        //Ustaw czcionki do wypełnienia paska Menu
        g.setFont(menu_czcionka);

        //Jeśli już wybrano Menu narysuj stosowną wersję paska Menu
        if(Obrazy.pause){
            g.drawImage(Obrazy.menuGameImage,sWidth-150,sHeight- pasek -10,null);
            g.setColor(Color.red);
            g.drawString("KONIEC GRY!",10,sHeight-10);
            g.setColor(Color.white);
            g.drawString("O GRZE...",300, sHeight-10);
            g.drawString("NOWA GRA!",550, sHeight-10);

            //if(Obrazy.end){ //Czy wszystkie poziomy skończone - koniec gry
            if (Obrazy.MoveMODE >= Obrazy.NO_LEVELS){
                g.setColor(Color.RED);
                //g.drawString("KONIEC?",500, sHeight-10);
                g.setFont(alert_czcionka);
                DecimalFormat df = new DecimalFormat("#.##");
                g.drawString("KONIEC GRY! ",170, sHeight/2);
                g.drawString("CZAS RAZEM="+df.format(stan.time)+"s",10, sHeight/2+100);
                g.setColor(Color.white);
                g.setFont(menu_czcionka);
            }
            //Nie wybranu nic z menu - pokaż poziom i stan punktów w trakcie gry
        }else{
            g.drawString("POZIOM:",10, sHeight-10);

            g.drawString(""+ stan.level,200, sHeight-10);
            if (Obrazy.MoveMODE>0) {
                g.drawString("PUNKTY:",300, sHeight-10);}
            else { g.drawString("CZAS NA NAUKĘ",300, sHeight-10);}
            if (!Obrazy.levelPause) {
                g.drawString("" + (System.currentTimeMillis() - Obrazy.startTime) / 1000, 850, sHeight - 10);
                //g.drawString(" " + Obrazy.rosliny[Obrazy.lastHit].getProperty("src", null), 900, sHeight - 10);
                if (Obrazy.lastHit>0) {
                    if (Obrazy.lastHit < Obrazy.MAX_INDEX_WRONG_OBJ) {
                        g.drawString(":(", 950, sHeight - 10);
                    } else {
                        g.drawString(":)", 950, sHeight - 10);
                    }
                }
            }
            // Czy ukończono poziom - wskazano wszystkie obiekty pozciomu
            //long stopTime = System.currentTimeMillis();
            Obrazy.levelTime=(System.currentTimeMillis()- Obrazy.startTime)/1000.0;

            if((stan.points== Obrazy.noOfObjects) || (Obrazy.levelTime>Obrazy.LEVEL_TIME_LIMIT)) {
                if(!Obrazy.levelPause){
                    long stopTime = System.currentTimeMillis();
                    Obrazy.levelTime=(stopTime- Obrazy.startTime)/1000.0;
                    Obrazy.levelPause=true;
                }
                g.setColor(Color.RED);
                g.drawString("GRASZ DALEJ?",500, sHeight-10);
                g.setFont(alert_czcionka);
                DecimalFormat df = new DecimalFormat("#.##");
                // g.drawString("WYGRANA:"+df.format(Obrazy.levelTime)+"s",150, sHeight/2);
                if (Obrazy.MoveMODE>0) {
                    g.drawString("TWOJE PUNKTY: " + df.format(stan.points) + "", 150, sHeight / 2);
                }
                g.setColor(Color.white);
                g.setFont(menu_czcionka);
                //Jak nie zmień punkty
            }else
            if (Obrazy.MoveMODE>0) {
                g.drawString(""+ stan.points,500, sHeight-10);
                //narysuj ikonę z napisem Menu
                g.drawImage(Obrazy.menuImage,sWidth-150,sHeight- pasek -10,null);}
        }
        //narysuj ikonę z logo
        g.drawImage(Obrazy.logoImage,sWidth-180,sHeight- pasek +15,null);

    }//

    /**
     * Restart gry - ustawienia parametrów oraz obiektów pierwszego planu
     *
     */
    private void restartGame(){
        stan.resetPoints();
        Obrazy.startTime=System.currentTimeMillis();
        Obrazy.lastHit=0;
        Obrazy.pause=false;
        int offset=sWidth/objectsInLine;
        int inLine=0;
        int yLine=0;
        for(int i = 0; i< Obrazy.noOfObjects; i++){

            Rosliny[i]=new Ruch((((inLine%objectsInLine)+1)*offset)- Obrazy.rosliny[(i% Obrazy.rosliny.length)].getWidth(null),0,100,0.0025, Obrazy.rosliny);
            Rosliny[i].setScreenSize(sWidth, sHeight);

            if(inLine>=objectsInLine){
                yLine++;
                inLine%=objectsInLine;
            }
            inLine++;
            Rosliny[i].setYPos(yLine* przesuniecie *-1);
        }//koniec for i

    }//koniec restartGame()


}

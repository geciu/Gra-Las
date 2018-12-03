import java.awt.*;

public class LasMain {


    public static void main(String[] args) {
        System.out.println("Witaj w grze Las!");

/*
        Window w = new Window(" ");
        Button b = new Button("Dalej");
        w.add(b);
        b.setSize(300, 100);
        w.setVisible(true);
*/


        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Window("Witaj w grze Las!");
                new ActionFrame();
            }
        });
    }

}

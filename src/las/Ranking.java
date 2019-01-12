package las;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import las.Punkty;

/** Klasa odpowiadająca za ranking */
public class Ranking extends JPanel {

    private String Gracz = "";
    Scanner scan= new Scanner(System.in);
    String imie= scan.nextLine();

    Punkty pkt = new Punkty();

    private void rankingGry() {
        //Gracz = "Gracz: " + imie + " "
                // "Punkty: " +  + " " +

                JOptionPane.showMessageDialog(null, "" + Gracz, "Podsumowanie gry",
                        JOptionPane.INFORMATION_MESSAGE);

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("Ranking.txt", true));
            writer.write(Gracz);
        } catch (IOException e) {
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
            }
        }

        setVisible(false);
    }


}
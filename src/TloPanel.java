import java.awt.*;
import javax.swing.*;
import java.util.*;

public class TloPanel extends JPanel {
    Image back;

    TloPanel() {
        super();
        setBackground(Color.black);
        Toolkit kit = Toolkit.getDefaultToolkit();

        back = kit.getImage("las.jpg");
    }

    public void paintComponent(Graphics comp) {
        Graphics2D comp2D = (Graphics2D)comp;
        if (back != null)
            comp2D.drawImage(back, 0, 0, this);
    }
}

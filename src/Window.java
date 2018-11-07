import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    Window(String nazwa) {
        super(nazwa); //metoda super wywołuje konstruktor nadklasy
        setResizable(false);
        setSize(400, 400);

    }
}

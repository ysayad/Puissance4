import javax.swing.*;
import java.awt.*;

public class Test extends JPanel {

    public Test () {
        this.setPreferredSize();
    }
    public void slide(Circle c) {
        while (true) {
            PointerInfo a = MouseInfo.getPointerInfo();
            Point b = a.getLocation();
            int x = (int) b.getX();
            System.out.println(x);
            c.slide(x);
        }
    }
}

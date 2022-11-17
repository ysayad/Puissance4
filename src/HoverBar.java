import javax.swing.*;
import java.awt.*;

public class HoverBar extends JPanel {
    
    public HoverBar () {
        this.setPreferredSize(new Dimension(600, 120));

    }

    public void slide(int x){
        Graphics2D brush = (Graphics2D) getGraphics();
        super.paintComponent(brush);
        brush.setColor(CustomColor.DARK_GRAY);
        brush.setStroke(new BasicStroke(10));
        if (x > 50 && x < 550) {
            brush.fillOval(x - 40, 20, 50, 50);
            // brush.setColor(CustomColor.GRAY);
            // brush.drawLine(x - 15, 90 , x - 15, 110);
            // brush.drawLine(x - 15, 110, x - 30, 100);
            // brush.drawLine(x - 15, 110, x, 100);

        } 
        
 
     } 
}

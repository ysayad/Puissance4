import javax.swing.*;
import java.awt.*;

public class Circle extends JComponent {
    private int x;
    private int y;
    private int radius;
    private Color color;

    public Circle(int x, int y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics brush = g.create();

        if (this.isOpaque()) {
            brush.setColor(this.getBackground());
            brush.fillRect(0, 0, this.getWidth(), this.getHeight());
        }

        brush.setColor(this.color);
        brush.fillOval(this.x, this.y, this.radius, this.radius);
    }
}
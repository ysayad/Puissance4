import javax.swing.*;
import java.awt.*;

public class Circle extends JPanel {
    private int radius;
    private int[][] board;

    /**
     * Constructor for objects of class Circle
     * @param radius the radius of the circle
     * @param board matrice of the board
     */
    public Circle(int radius, int[][] board) {
        this.radius = radius;
        this.board = board;
    }

    /**
     * Paints the circle
     * @param g the graphics object
     *<br>
     *Draws the circles on the board, with color according to the value of the cell
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics brush = g.create();
        super.paintComponent(brush);

        if (this.isOpaque()) {
            brush.setColor(this.getBackground());
            brush.fillRect(0, 0, this.getWidth(), this.getHeight());
        }

        for (int r = 0 ; r < 6; r++) {
            for (int c = 0 ; c < 7; c++) {
                if (this.board[r][c] == 0) {
                    brush.setColor(Color.LIGHT_GRAY);
                    brush.fillOval((c * 75) + 50, (r * 75) + 50, this.radius, this.radius);
                } else if (this.board[r][c] == 1) {
                    brush.setColor(Color.RED);
                    brush.fillOval((c * 75) + 50, (r * 75) + 50, this.radius, this.radius);
                } else if (this.board[r][c] == 2) {
                    brush.setColor(Color.YELLOW);
                    brush.fillOval((c * 75) + 50, (r * 75) + 50, this.radius, this.radius);
                }
            }
        }

    }
}
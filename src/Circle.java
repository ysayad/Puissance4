import javax.swing.*;
import java.awt.*;

public class Circle extends JComponent {
    private int radius;
    private int[][] board;

    public Circle(int radius, int[][] board) {
        this.radius = radius;
        this.board = board;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics brush = g.create();

        if (this.isOpaque()) {
            brush.setColor(this.getBackground());
            brush.fillRect(0, 0, this.getWidth(), this.getHeight());
        }

        for (int r = 0  r < this.board.length; r++) {
            for (int c = 0  c < this.board[r].length; c++) {
                if (this.board[r][c] == 0) {
                    brush.setColor(Color.LIGHT_GRAY);
                    brush.fillOval((r * 75) + 50, (c * 75) + 50, this.radius, this.radius);
                } else if (this.board[r][c] == 1) {
                    brush.setColor(Color.RED);
                    brush.fillOval((r * 75) + 50, (c * 75) + 50, this.radius, this.radius);
                } else if (this.board[r][c] == 2) {
                    brush.setColor(Color.YELLOW);
                    brush.fillOval((r * 75) + 50, (c * 75) + 50, this.radius, this.radius);
                }
            }
        }

    }
}
import javax.swing.*;
import java.awt.*;

public class Circle extends JPanel {
    private int radius;
    private Jeu jeu;
    private int colonne;
    private int colNum;
    private int rowNum;
    Graphics brush;

    /**
     * Constructor for objects of class Circle
     * @param radius the radius of the circle
     */
    public Circle(int radius, Jeu jeu) {
        this.setPreferredSize(new Dimension(600, 520));
        this.radius = radius;
        this.jeu = jeu;
        this.colNum = this.jeu.grille[0].length;
        this.rowNum = this.jeu.grille.length;
        this.setBackground(Color.BLUE);

    }

    public int  getcolonne(){
        return this.colonne;

    }

    /**
     * Paints the circle
     * @param g the graphics object
     *<br>
     *Draws the circles on the board, with color according to the value of the cell
     */
    @Override
    protected void paintComponent(Graphics g) {
        this.brush = g.create();

        super.paintComponent(this.brush);

        if (this.isOpaque()) {
            this.brush.setColor(this.getBackground());
            this.brush.fillRect(0, 0, this.getWidth(), this.getHeight());

        }

        for (int r = 0 ; r < rowNum; r++) {
            for (int c = 0 ; c < colNum; c++) {
                switch (jeu.grille[r][c]) {
                    case 0:
                        this.brush.setColor(Color.WHITE);
                        break;

                    case 1:
                        this.brush.setColor(Color.RED);
                        break;

                    case 2:
                        this.brush.setColor(Color.YELLOW);
                        break;

                    case 3:
                        this.brush.setColor(Color.GREEN);
                        break;

                }
                this.brush.fillOval((c * 75) + 50, (r * 75) + 50, this.radius, this.radius);
                this.brush.setColor(Color.DARK_GRAY);
                this.brush.drawOval((c * 75) + 50, (r * 75) + 50, this.radius, this.radius);

            }

        }

    }
}
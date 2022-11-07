import javax.swing.*;
import java.awt.*;

public class Circle extends JPanel {
    private int radius;
    private Jeu jeu;
    private int colonne;
    Graphics brush;

    /**
     * Constructor for objects of class Circle
     * @param radius the radius of the circle
     */
    public Circle(int radius, Jeu jeu) {
        this.radius = radius;
        this.jeu = jeu;
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

        for (int r = 0 ; r < 6; r++) {
            for (int c = 0 ; c < 7; c++) {
                if (jeu.grille[r][c] == 0) {
                    this.colonne = c;
                    this.brush.setColor(Color.LIGHT_GRAY);
                    this.brush.fillOval((c * 75) + 50, (r * 75) + 50, this.radius, this.radius);
                    addMouseListener(new CircleListener(this.brush,this.colonne, jeu));
                } else if (jeu.grille[r][c] == 1) {
                    this.brush.setColor(Color.RED);
                    this.brush.fillOval((c * 75) + 50, (r * 75) + 50, this.radius, this.radius);
                } else if (jeu.grille[r][c] == 2) {
                    this.brush.setColor(Color.YELLOW);
                    this.brush.fillOval((c * 75) + 50, (r * 75) + 50, this.radius, this.radius);
                }
            }
        }

    }
}
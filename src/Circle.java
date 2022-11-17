import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Circle extends JPanel {
    private int radius;
    private Jeu jeu;
    private int colonne;
    private int colNum;
    private int rowNum;
    // private Test hoverCircle = new Test();


    /**
     * Constructor for objects of class Circle
     * @param radius the radius of the circle
     */
    public Circle(int radius, Jeu jeu) {
        this.setPreferredSize(new Dimension(620, 540));
        this.radius = radius;
        this.jeu = jeu;
        this.colNum = this.jeu.grille[0].length;
        this.rowNum = this.jeu.grille.length;
        
        
        



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
        Graphics brush = g.create();
        Graphics2D brush2D = (Graphics2D) brush;

        super.paintComponent(brush);

        if (this.isOpaque()) {
            brush.setColor(this.getBackground());
            brush.fillRect(0, 0, this.getWidth(), this.getHeight());

        }

        brush2D.setColor(CustomColor.DARK_GRAY);
        RoundRectangle2D shadow = new RoundRectangle2D.Double(10, 10, 600, 520, 50, 50);
        brush2D.fill(shadow);
        brush2D.setColor(CustomColor.LIGHT_GRAY);
        RoundRectangle2D rect = new RoundRectangle2D.Double(0, 0, 600, 520, 50, 50);
        brush2D.draw(rect);
        brush2D.fill(rect);
        

        for (int r = 0 ; r < rowNum; r++) {
            for (int c = 0 ; c < colNum; c++) {
                switch (jeu.grille[r][c]) {
                    case 0:
                        brush.setColor(CustomColor.WHITE);
                        break;

                    case 1:
                        brush.setColor(CustomColor.RED);
                        break;

                    case 2:
                        brush.setColor(CustomColor.YELLOW);
                        break;

                    case 3:
                        brush.setColor(CustomColor.GREEN);
                        break;

                }
                brush.fillOval((c * 75) + 50, (r * 75) + 50, this.radius, this.radius);
                brush.setColor(CustomColor.DARK_GRAY);
                brush.drawOval((c * 75) + 50, (r * 75) + 50, this.radius, this.radius);

            }

        }

    }

    
}
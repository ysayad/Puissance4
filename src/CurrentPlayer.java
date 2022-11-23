import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 *Current player is the class that is in charge of drawing the current player token
 * @author Kamil Mardaci
 * @author Yannis Bouarroudj
 * @author Etann De Sousa Alves
 * @author Youcef Sayad
 * @version 1.0
 */
public class CurrentPlayer extends JPanel{
    
    private final Jeu jeu;

    /**
     * Constructor of the currentPlayer
     * @param jeu the game
     */
    public CurrentPlayer (Jeu jeu) {
        this.setPreferredSize(new Dimension(160, 210));
        this.jeu = jeu;
        
    }

    /**
     * This method draws the current player token
     * @param g the graphics object
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D brush = (Graphics2D) g.create();

        if (this.isOpaque()) {
            brush.setColor(this.getBackground());
            brush.fillRect(0, 0, this.getWidth(), this.getHeight());

        }

        RoundRectangle2D shadow = new RoundRectangle2D.Double(7, 7, 150, 200, 50, 50);
        brush.setColor(CustomColor.DARK_GRAY);
        brush.fill(shadow);

        RoundRectangle2D rect = new RoundRectangle2D.Double(0, 0, 150, 200, 50, 50);
        brush.setColor(CustomColor.LIGHT_GRAY);
        brush.draw(rect);
        brush.fill(rect);

        brush.setColor(CustomColor.DARK_GRAY);
        brush.setFont(new Font("Arial", Font.BOLD, 20));
        brush.drawString("Joueur " + this.jeu.getNextPlayer(), 30, 50);

        switch (this.jeu.getNextPlayer()) {
            case 1 :
                brush.setColor(CustomColor.RED);
                break;

            case 2 :
                brush.setColor(CustomColor.YELLOW);
                break;

            case 3 :
                brush.setColor(CustomColor.GREEN);
                break;

            default :
                brush.setColor(CustomColor.WHITE);
                break;

        }

        brush.fillOval(40, 90, 70, 70);
        brush.setColor(CustomColor.DARK_GRAY);
        brush.drawOval(40, 90, 70, 70);

    }

}

import javax.swing.*;
import java.awt.*;

/**
 *HoverBar is the class that creates the hover bar
 * @author Kamil Mardaci
 * @author Yannis Bouarroudj
 * @author Etann De Sousa Alves
 * @author Youcef Sayad
 * @version 1.0
 */
public class HoverBar extends JPanel {
    private final Jeu jeu;

    /**
     * Create the panel for the hover bar
     * @param jeu the game
     */
    public HoverBar (Jeu jeu) {
        this.setPreferredSize(new Dimension(600, 120));
        this.jeu = jeu;

    }

    /**
     * This method take a position and draw a circle on it
     * @param x the position of the mouse
     */
    public void slide(int x){
        Graphics2D brush = (Graphics2D) getGraphics();
        super.paintComponent(brush);
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
        brush.setStroke(new BasicStroke(10));
        if (x > 50 && x < 550) {
            brush.fillOval(x - 40, 20, 50, 50);

        } 
        
 
     } 
}

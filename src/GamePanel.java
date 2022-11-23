import javax.swing.*;
import java.awt.*;;

/**
 *GamePanel is the class that creates the game panel
 * @author Kamil Mardaci
 * @author Yannis Bouarroudj
 * @author Etann De Sousa Alves
 * @author Youcef Sayad
 * @version 1.0
 */
public class GamePanel extends JPanel{

    /**
     * The GamePanel constructor
     * @param mode the game mode
     * @param window the frame
     */
    public GamePanel(int mode, JFrame window){
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        Jeu jeu = new Jeu(mode);
        CircleListener listener = new CircleListener(jeu, window); 

        this.setLayout(gbl);
        gbc.gridy = 3;
        gbc.gridx = 5;
        this.add(jeu.getGridCircle(), gbc);
        gbc.gridy = 3;
        gbc.gridx = 7;
        this.add(jeu.getCurrentPlayer(), gbc);
        gbc.gridy = 2;
        gbc.gridx = 5;
        this.add(jeu.getHoverBar(), gbc);
        jeu.getGridCircle().addMouseListener(listener);
        jeu.getGridCircle().addMouseMotionListener(listener);

    }

}

import javax.swing.*;
import java.awt.*;;

public class GamePanel extends JPanel{
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

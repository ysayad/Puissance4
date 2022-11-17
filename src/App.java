import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        JFrame window = new JFrame("Puissance 4");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.setSize(1920, 1080);
        window.setLocation(0, 0);

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        Jeu jeu = new Jeu(4);
        JPanel panneau = new JPanel();
        panneau.setLayout(gbl);
        panneau.add(jeu.getGridCircle(), gbc);
        panneau.add(jeu.getCurrentPlayer(), gbc);

        window.add(panneau);

        CircleListener listener = new CircleListener(jeu);
        jeu.getGridCircle().addMouseListener(listener);

        window.setVisible(true);
        Test t = new Test();

        t.slide(jeu.getGridCircle());

    }

}

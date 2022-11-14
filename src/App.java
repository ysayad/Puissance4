import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        JFrame window = new JFrame("Puissance 4");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1920, 1080);
        window.setLocation(0, 0);

        Jeu jeu = new Jeu(4);
        JPanel panneau = new JPanel();
        panneau.setLayout(new GridBagLayout());
        panneau.add(jeu.gridCircle);

        window.add(panneau);

        CircleListener listener = new CircleListener(jeu);
        jeu.gridCircle.addMouseListener(listener);

        window.setVisible(true);

    }

}

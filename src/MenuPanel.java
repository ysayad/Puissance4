import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

/**
 *MenuPanel is the class that creates the menu panel
 * @author Kamil Mardaci
 * @author Yannis Bouarroudj
 * @author Etann De Sousa Alves
 * @author Youcef Sayad
 * @version 1.0
 */
public class MenuPanel extends Box {

    /**
     *
     * @param window the frame
     */
    public MenuPanel (JFrame window) {
        super(BoxLayout.Y_AXIS);

        JPanel menu = new MenuDraw();
        MenuListener e = new MenuListener(window);
        JPanel logo = new JPanel();
        JLabel image = new JLabel("Puissance 4");
        try {
            BufferedImage icon = ImageIO.read(Objects.requireNonNull(getClass().getResource("/res/logo2.png")));
            image = new JLabel(new ImageIcon(icon));
        } catch (Exception ex) {
            System.out.println("Image not found");

        }


        menu.setOpaque(false);
        logo.setLayout(new BorderLayout());
        logo.add(image, BorderLayout.CENTER);
        logo.setOpaque(false);

        Dimension expectedDimension = new Dimension(700, 600);
        menu.setPreferredSize(expectedDimension);
        menu.setMaximumSize(expectedDimension);
        menu.setMinimumSize(expectedDimension);

        JButton jouer = new JButton("Jouer");
        JButton jouer_multi= new JButton("Jouer à trois");
        JButton rules = new JButton("Règles");
        JButton feedback = new JButton("Donnez votre avis !");
        JButton sortir = new JButton("Quitter");

        jouer.addActionListener(e); 
        jouer_multi.addActionListener(e); 
        rules.addActionListener(e); 
        feedback.addActionListener(e); 
        sortir.addActionListener(e);

        Dimension taille = new Dimension(350,40);

        sortir.setFocusPainted(false);
        jouer_multi.setFocusPainted(false);
        rules.setFocusPainted(false);
        feedback.setFocusPainted(false);
        jouer.setFocusPainted(false);

        jouer.setForeground(Color.WHITE);
        jouer_multi.setForeground(Color.WHITE);
        rules.setForeground(Color.WHITE);
        feedback.setForeground(Color.WHITE);
        sortir.setForeground(Color.WHITE);

        jouer.setBackground(CustomColor.BLUE);
        jouer_multi.setBackground(CustomColor.BLUE);
        rules.setBackground(CustomColor.BLUE);
        feedback.setBackground(CustomColor.BLUE);
        sortir.setBackground(CustomColor.BLUE);

        jouer.setPreferredSize(taille);
        jouer_multi.setPreferredSize(taille);
        rules.setPreferredSize(taille);
        feedback.setPreferredSize(taille);
        sortir.setPreferredSize(taille);

        
        Dimension d = new Dimension(700, 10);
        menu.add(Box.createRigidArea(new Dimension(700, 70)));
        menu.add(logo);
        menu.add(Box.createRigidArea(new Dimension(700, 80)));
        menu.add(jouer);
        menu.add(Box.createRigidArea(d));
        menu.add(jouer_multi);
        menu.add(Box.createRigidArea(d));
        menu.add(rules);
        menu.add(Box.createRigidArea(d));
        menu.add(feedback);
        menu.add(Box.createRigidArea(d));
        menu.add(sortir);

        this.add(Box.createVerticalGlue());
        this.add(menu);
        this.add(Box.createVerticalGlue());
        
    }

}

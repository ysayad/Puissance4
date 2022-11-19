import java.awt.*;
import javax.swing.*;

public class menu {
    public static void main(String[] args) {

        JFrame frame = new JFrame(); // Gestion de la fenetre
        JPanel menu = new menu_draw();
        menu_listener e = new menu_listener(frame);
        JPanel logo = new JPanel();
        JLabel image = new JLabel(new ImageIcon("logo2.png")); // Image jeu squelette

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
        JButton sortir = new JButton("Quitter");
        

        jouer.addActionListener(e); 
        jouer_multi.addActionListener(e); 
        rules.addActionListener(e); 
        sortir.addActionListener(e);

        Dimension taille = new Dimension(350,40);

        sortir.setFocusPainted(false);
        jouer_multi.setFocusPainted(false);
        rules.setFocusPainted(false);
        jouer.setFocusPainted(false);

        jouer.setForeground(Color.WHITE);
        jouer_multi.setForeground(Color.WHITE);
        rules.setForeground(Color.WHITE); // Gestion front-end des boutons
        sortir.setForeground(Color.WHITE);

        jouer.setBackground(new Color(5, 40, 127));
        jouer_multi.setBackground(new Color(5, 40, 127));
        rules.setBackground(new Color(5, 40, 127));
        sortir.setBackground(new Color(5, 40, 127));

        jouer.setPreferredSize(taille);
        jouer_multi.setPreferredSize(taille);
        rules.setPreferredSize(taille);
        sortir.setPreferredSize(taille);

        

        menu.add(Box.createRigidArea(new Dimension(700, 70)));
        menu.add(logo);
        menu.add(Box.createRigidArea(new Dimension(700, 120)));
        menu.add(jouer);
        menu.add(Box.createRigidArea(new Dimension(700, 10))); // Implementation des éléments dans la fenetre avec boxlayout
        menu.add(jouer_multi);
        menu.add(Box.createRigidArea(new Dimension(700, 10)));  
        menu.add(rules);
        menu.add(Box.createRigidArea(new Dimension(700, 10)));
        menu.add(sortir);

        Box box = new Box(BoxLayout.Y_AXIS);
        box.add(Box.createVerticalGlue());
        box.add(menu);
        box.add(Box.createVerticalGlue());
        
        
        frame.add(box);
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.GRAY);

        frame.setVisible(true);
    }
}

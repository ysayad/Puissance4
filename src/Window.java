import javax.swing.*;
import java.awt.*;

/**
 *Window is the class that creates the main window
 * @author Kamil Mardaci
 * @author Yannis Bouarroudj
 * @author Etann De Sousa Alves
 * @author Youcef Sayad
 * @version 1.0
 */
public class Window extends JFrame {
    private final CardLayout cardLayout = new CardLayout();
    private final GamePanel gamePanel4 = new GamePanel(4, this);
    private final GamePanel gamePanel3 = new GamePanel(3, this);
    private final MenuPanel menuPanel = new MenuPanel(this);

    /**
     * Create the window
     */
    public Window() {
        this.setTitle("Puissance 4");
        this.setSize(1920, 1080);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(cardLayout);
        this.add(menuPanel, "menuPanel");
        this.add(gamePanel4, "gamePanel4");
        this.add(gamePanel3, "gamePanel3");
        this.setResizable(false);
        

    }
}

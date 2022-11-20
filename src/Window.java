import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    CardLayout cardLayout = new CardLayout();
    GamePanel gamePanel4 = new GamePanel(4, this);
    GamePanel gamePanel3 = new GamePanel(3, this);
    MenuPanel menuPanel = new MenuPanel(this);

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

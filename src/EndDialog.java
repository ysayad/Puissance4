import javax.swing.*;
import java.awt.*;


public class EndDialog extends JDialog {
    public EndDialog(JFrame window){
        super(window, "Fin de partie");
        this.setSize(new Dimension(300, 300));
        this.setLocation(window.getX()/2, window.getY()/2);
        JLabel label = new JLabel("Fin de la partie");
        this.add(label);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

}

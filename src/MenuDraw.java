import javax.swing.JPanel;
import java.awt.*;
import java.awt.Color;

/**
 *MenuDraw is the class that draws the menu
 * @author Kamil Mardaci
 * @author Yannis Bouarroudj
 * @author Etann De Sousa Alves
 * @author Youcef Sayad
 * @version 1.0
 */
public class MenuDraw extends JPanel {
  /**
   *
   * @param g the graphics object
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics panel = g.create();

    if (this.isOpaque()) {
      panel.setColor(this.getBackground());
      panel.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());

    }

    panel.setColor(Color.LIGHT_GRAY);
    panel.fillRoundRect(0, 0, this.getWidth()-1, this.getHeight()-1, 50, 50);
    panel.setColor(Color.BLUE);
    panel.drawRoundRect(0,0,this.getWidth()-1,this.getHeight()-2,50,50);

  }

}
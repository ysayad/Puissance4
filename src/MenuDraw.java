import javax.swing.JPanel;
import java.awt.*;
import java.awt.Color;
 
public class MenuDraw extends JPanel {
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
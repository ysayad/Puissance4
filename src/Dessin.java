import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;


public class Dessin extends JComponent {
    String type;
    public Dessin(String type){
        this.type = type;
    }





    @Override
    protected void paintComponent(Graphics pinceau) {
        Graphics secondPinceau = pinceau.create();
        if (this.type == "fond_du_jeu") {
            int x = 30;
            int y = 50;
            int width = 420;
            int height = 120;
            int arcWidth = 20;
            int arcHeight = 20;

            secondPinceau.fillRect(x, y, width, height );
        }
        if (this.type == "fond_du_jeu" ) {
            int x = 30;
            int y = 50;
            int width = 420;
            int height = 120;
            int arcWidth = 20;
            int arcHeight = 20;

            secondPinceau.fillRect(x, y, width, height );
        }

    }


}
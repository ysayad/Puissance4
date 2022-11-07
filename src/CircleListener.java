import java.awt.*;
import java.awt.event.*;
public class CircleListener implements MouseListener{
    Graphics circle;
    Jeu jeu;
    int colonne;

    public CircleListener(Graphics circle,int colonne, Jeu jeu) {
        this.circle = circle;
        this.jeu = jeu;
        this.colonne = colonne;
    }


    public void mouseClicked(MouseEvent e) {
        this.jeu.ajout(this.colonne);
        this.jeu.test.repaint();
        System.out.println(this.colonne);
    }
    public void mouseEntered(MouseEvent e) {
        System.out.println("ENTERED HEHEH");
        System.out.println(this.colonne);

    }
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
}
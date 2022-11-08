import java.awt.*;
import java.awt.event.*;
public class CircleListener implements MouseListener{

    Jeu jeu;

    public CircleListener(Jeu jeu) {

        this.jeu = jeu;
    }


    public void mouseClicked(MouseEvent e) {
        int x=e.getX();

        for (int j = 0 ; j<7 ;j+=1 ){

        if (x>(j * 75) + 50 && x<((j+1) * 75) + 50){
            this.jeu.ajout(j);
        }

        }

        if (this.jeu.verif_gagner_p3()!=-1){
            this.jeu.ecranfin();
            this.jeu.fenetre.removeMouseListener(this);
        }

        this.jeu.test.repaint();
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
}
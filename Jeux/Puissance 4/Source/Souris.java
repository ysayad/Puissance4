import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Souris extends JFrame implements MouseListener{
  Menu menu;
  int ligne;
  int colonne;
  public Souris(Menu menu){
      this.menu = menu;
      this.ligne = this.menu.choix.ligne;
      this.colonne = this.menu.choix.colonne;
  }
  public void mouseClicked(MouseEvent e) {
    if (this.menu.click == 0 && this.menu.menu == 1){
      this.menu.fenetre.dispose();
    }

    if (this.menu.click == 1){
      this.menu.fenetre.dispose();
      Main.choix(menu.click);
    }

    if (this.menu.click == 2){
      this.menu.fenetre.dispose();
      Main.choix(menu.click);
    }


    if (this.menu.test == 3){
      this.ligne-=1;
      this.menu.choix.ligne = this.ligne;
      this.menu.bouton = Integer.toString(this.ligne);
    }
    if (this.menu.test==4){
      this.ligne+=1;
      this.menu.choix.ligne = this.ligne;
      this.menu.bouton = Integer.toString(this.ligne);

    }
    if (this.menu.test==5){
      this.colonne-=1;
      this.menu.choix.colonne = this.colonne;
      this.menu.bouton = Integer.toString(this.ligne);
    }
    if (this.menu.test==6){
      this.colonne+=1;
      this.menu.choix.colonne = this.colonne;
      this.menu.bouton = Integer.toString(this.ligne);
    }

  }
  public void mouseEntered(MouseEvent e) {
    if (this.menu.test != 1 && this.menu.test != 2 || this.menu.menu == 1) {
      this.menu.setClick(true);
    }
    this.menu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
  }
  public void mouseExited(MouseEvent e) {
    this.menu.setClick(false);
  }
  public void mousePressed(MouseEvent e) {
  }
  public void mouseReleased(MouseEvent e) {
  }
}
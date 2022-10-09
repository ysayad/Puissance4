import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;



public class Case extends JComponent {
    int val;
    JFrame fenetre;
    Grille grille;
    int ligne;
    int colonne;
    private int stat = 1;
    public Case(int val, JFrame fenetre,int ligne, int colonne, Grille grille){
        this.fenetre=fenetre;
        this.val = val;
        this.colonne = colonne;
        this.ligne = ligne;
        this.grille = grille;

    addMouseListener(new CaseListener(this));
    }


    public void setClick(int stat){
        if ( this.stat != 0 ) {
            this.stat += stat;
        }
        if ( stat == 0 ){
            this.stat=0;
        }

        if (this.stat == 3){
            this.grille.compteur += 1;

        }


        if (this.stat > 3){
            this.stat = 1;
            this.grille.compteur -=1;
        }
        if (stat==-1) {
            this.stat=-1;
        }


        this.repaint();
        this.val = this.stat;



    }

    @Override
    protected void paintComponent(Graphics pinceau) {
        Graphics secondPinceau = pinceau.create();

        if (this.stat == -1) {
            secondPinceau.setColor(Color.RED);
            secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
            Image mshi = new ImageIcon("../Image/z.png").getImage();
            secondPinceau.drawImage(mshi, 0, 0,this.getWidth(),this.getHeight(), null);


        }

        if (this.stat == 0) {
            secondPinceau.setColor(Color.GRAY);
            secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
            secondPinceau.setColor(Color.GREEN);
            if (this.grille.jeu[ligne][colonne] != 0) {
                if (this.grille.jeu[ligne][colonne] == -1){
                    Image mshi = new ImageIcon("../Image/z.png").getImage();
                    secondPinceau.drawImage(mshi, 0, 0,this.getWidth(),this.getHeight(), null);
                }else {
                    secondPinceau.drawString(Integer.toString(this.grille.jeu[ligne][colonne]), this.getWidth() / 2 - (5 / 2), this.getHeight() / 2);
                }
            }
        }

        if (this.stat == 1) {
            secondPinceau.setColor(Color.DARK_GRAY);
            secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
            secondPinceau.setColor(Color.GREEN);
        }

        if (this.stat == 2) {
            secondPinceau.setColor(Color.DARK_GRAY);
            secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
            secondPinceau.setColor(Color.GREEN);
            secondPinceau.drawString("?", this.getWidth() / 2 - (5 / 2), this.getHeight() / 2);

        }

        if (this.stat == 3) {
            Image mshi = new ImageIcon("../Image/flag.png").getImage();
            secondPinceau.drawImage(mshi, 0, 0,this.getWidth(),this.getHeight(), null);

        }



    }

}
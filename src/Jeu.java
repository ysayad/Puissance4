import java.util.*;
import java.util.List;

public class Jeu {
    int[][] grille;
    private List<Integer> playerList = new LinkedList<Integer>();
    private int player = 3;
    private int playerRemaining = playerList.size();
    Circle gridCircle;
    private int mode = 3;
    private int colNum = 7;
    private int rowNum = 6;
    

    public Jeu() {
        this.playerList.add(1);
        this.playerList.add(2);
        this.playerList.add(3);

        this.grille = new int[rowNum][colNum];

        for (int i = 0 ; i < rowNum ; i += 1 ) {
            for (int j = 0 ; j < colNum ; j += 1 ){
                this.grille[i][j]=0;
            }

        }

        this.gridCircle = new Circle(50, this);

    }


    public void repaint(){
        this.gridCircle.repaint();

    }


    public void ajout(int num_colonne) {
        for (int i = rowNum - 1; i >= 0 ; i--) {
            if (this.grille[i][num_colonne] == 0) {
                this.grille[i][num_colonne] = this.player;
                break;

            }

        }

    }


    public void affiche_matrice(){
        for (int i = 0 ; i < 6 ; i += 1 ) {
            for (int j = 0 ; j < 7 ; j += 1 ){
                System.out.print(this.grille[i][j]);
            }
            System.out.println("");

        }
    }


    public boolean verif (int player, int mode){
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if (col <= colNum - mode) {
                    switch (mode) {
                        case 3:
                            if (this.grille[row][col] == player && this.grille[row][col + 1] == player && this.grille[row][col + 2] == player) {
                                return true;
                            }
                            break;

                        case 4:
                            if (this.grille[row][col] == player && this.grille[row][col + 1] == player && this.grille[row][col + 2] == player && this.grille[row][col + 3] == player) {
                                return true;
                            }
                            break;

                    }     

                }

                if (row <= rowNum - mode) {
                    switch (mode) {
                        case 3:
                            if (this.grille[row][col] == player && this.grille[row + 1][col] == player && this.grille[row + 2][col] == player) {
                                return true;
                            }
                            break;

                        case 4:
                            if (this.grille[row][col] == player && this.grille[row + 1][col] == player && this.grille[row + 2][col] == player && this.grille[row + 3][col] == player) {
                                return true;
                            }
                            break;

                    }

                }
                
                if (row <= rowNum - mode && col <= colNum - mode) {
                    switch (mode) {
                        case 3:
                            if (this.grille[row][col] == player && this.grille[row + 1][col + 1] == player && this.grille[row + 2][col + 2] == player) {
                                return true;
                            }
                            break;

                        case 4:
                            if (this.grille[row][col] == player && this.grille[row + 1][col + 1] == player && this.grille[row + 2][col + 2] == player && this.grille[row + 3][col + 3] == player) {
                                return true;
                            }
                            break;

                    }

                }

                if (row <= rowNum - mode && col >= colNum - mode) {
                    switch (mode) {
                        case 3:
                            if (this.grille[row][col] == player && this.grille[row + 1][col - 1] == player && this.grille[row + 2][col - 2] == player) {
                                return true;
                            }
                            break;

                        case 4:
                            if (this.grille[row][col] == player && this.grille[row + 1][col - 1] == player && this.grille[row + 2][col - 2] == player && this.grille[row + 3][col - 3] == player) {
                                return true;
                            }
                            break;

                    }

                }

            }

        }

        return false;
        
    }


    public void switchPlayer () {
        int index = this.playerList.indexOf(this.player);
        if (index == this.playerList.size() - 1) {
            this.player = this.playerList.get(0);
            
        } else {
            this.player = this.playerList.get(index + 1);

        }

    }

    public void removePlayer () {
        this.playerList.remove(this.player-1);
        this.playerRemaining--;

    }


    public int getPlayer() {
        return player;
    
    }

    public int getPlayerRemaining() {
        return playerRemaining;
    
    }


    public int getMode() {
        return mode;
    
    }

    public void setMode (int n) {
        this.mode = n;
    
    }


}
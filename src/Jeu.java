import java.util.*;

public class Jeu {
    int[][] grille;
    private List<Integer> playerList = new LinkedList<>(List.of(1,2,3));
    private int player = 3;
    private int playerRemaining = playerList.size();
    Circle gridCircle;
    private int mode = 3;
    private int colNum = 7;
    private int rowNum = 6;
    

    public Jeu() {
        this.grille = new int[rowNum][colNum];

        for (int i = 0 ; i < rowNum ; i++ ) {
            for (int j = 0 ; j < colNum ; j++){
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
        for (int i = 0 ; i < 6 ; i++) {
            for (int j = 0 ; j < 7 ; j++){
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

                if (row <= rowNum - mode && col >= mode - 1) {
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

    public void removePlayerToken (int player) {
        int emptySpace = 0;

        for (int i = 0 ; i < rowNum ; i++ ) {
            for (int j = 0 ; j < colNum ; j++){
                if (this.grille[i][j] == player) {
                    this.grille[i][j] = 0;
                    emptySpace++;

                }

            }

        }

        for (int e = 0 ; e < emptySpace ; e++) {
            for (int i = rowNum - 1 ; i > 0 ; i--) {
                for (int j = 0 ; j < colNum ; j++) {
                    if (this.grille[i][j] == 0) {
                        this.grille[i][j] = this.grille[i-1][j];
                        this.grille[i-1][j] = 0;
                    }
                    
                }

            }

        }

    }

}
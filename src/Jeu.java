import java.util.*;

public class Jeu {
    int[][] grille;
    private List<Integer> playerList = new LinkedList<>(Arrays.asList(1,2,3));
    private List<Integer> nextPlayerList = new LinkedList<>(Arrays.asList(2,3,1));
    private int player = 3;
    private int nextPlayer = 1;
    private int playerRemaining = playerList.size();
    private Circle gridCircle;
    private CurrentPlayer currentPlayer = new CurrentPlayer(this);
    private int mode = 3;
    private int colNum = 7;
    private int rowNum = 6;
    private boolean finished = false;
    private ArrayList scoreboard = new ArrayList();
    

    public Jeu(int mode) {
        this.grille = new int[rowNum][colNum];
        this.mode = mode;

        if (this.mode == 4) {
            this.playerList = new LinkedList<>(Arrays.asList(1,2));
            this.nextPlayerList = new LinkedList<>(Arrays.asList(2,1));
            this.playerRemaining = playerList.size();
        }

        for (int i = 0 ; i < rowNum ; i++ ) {
            for (int j = 0 ; j < colNum ; j++){
                this.grille[i][j]=0;
            }

        }

        this.gridCircle = new Circle(50, this);

    }

    public void addToScoreboard(int val){
        this.scoreboard.add(Integer.toString(val));
    }
    public ArrayList getScoreboard(){
        return this.scoreboard;
    }

    public void repaint(){
        this.gridCircle.repaint();

    }


    public void ajout(int num_colonne) {
        if (this.grille[0][num_colonne] == 0) {
            this.switchPlayer();
        }
        for (int i = rowNum - 1; i >= 0 ; i--) {
            if (this.grille[i][num_colonne] == 0) {
                this.grille[i][num_colonne] = this.player;
                break;

            }

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
        if (this.playerList.equals(this.nextPlayerList)) {
            int temp = this.nextPlayerList.get(0);
            this.nextPlayerList.set(0, this.nextPlayerList.get(1));
            this.nextPlayerList.set(1, temp);
        }

        int index = this.playerList.indexOf(this.player);
        if (index == this.playerList.size() - 1) {
            this.player = this.playerList.get(0);
            this.nextPlayer = this.nextPlayerList.get(0);
            
        } else {
            this.player = this.playerList.get(index + 1);
            this.nextPlayer = this.nextPlayerList.get(index + 1);

        }
        this.currentPlayer.repaint();

    }

    
    public void removePlayer () {
        this.playerList.remove(this.player-1);
        this.playerRemaining--;
        this.nextPlayerList.remove(this.nextPlayerList.indexOf(this.player));
        System.out.println(nextPlayerList);

    }


    public int getPlayer() {
        return player;
    
    }

    public int getNextPlayer() {
        return nextPlayer;
    
    }

    public List<Integer> getPlayerList () {
        return this.playerList;
    
    }

    public List<Integer> getNextPlayerList () {
        return this.nextPlayerList;
    
    }


    public int getPlayerRemaining() {
        return playerRemaining;
    
    }

    public boolean finished() {
        return this.finished;
    
    }

    public void setFinished() {
        this.finished = !this.finished;
    
    }


    public int getMode() {
        return mode;
    
    }

    public void setMode (int n) {
        this.mode = n;
    
    }

    public Circle getGridCircle() {
        return this.gridCircle;
    
    }

    public CurrentPlayer getCurrentPlayer() {
        return this.currentPlayer;
    
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
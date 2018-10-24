package TicTacToe;

import java.util.Random;

public class Board {
    private Marker[][] board;

    public Board(){
        board = new Marker[3][3];
        this.Clear();
    }

    public Board(Marker[][] board){
        this.board = board;
    }

    public boolean place(Marker marker , int row, int col){
        if(board[row][col]==Marker.EMPTY){
            board[row][col]=marker;
            return true;
        }
        else{
            return false;
        }

    }

    public void draw(){
        System.out.println("0  1   2\n");
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(j<2)
                    System.out.print(board[i][j]+" | ");
                else
                    System.out.print(board[i][j]);
            }
            System.out.println();
            if(i<2)
            System.out.println("-+-+-+-+-+-+-");
        }
    }

    public boolean isWinner(Marker marker){
        boolean row_winner = false;
        boolean col_winner = false;
        boolean dia_winner = false;

        if(board[0][0]==marker&&board[0][1]==marker&&board[0][2]==marker || 
            board[1][0]==marker&&board[1][1]==marker&&board[1][2]==marker   ||
            board[2][0]==marker&&board[2][1]==marker&&board[2][2]==marker){
                             row_winner=true;
        } else if(board[0][0]==marker&&board[1][0]==marker&&board[2][0]==marker ||
                     board[0][1]==marker&&board[1][1]==marker&&board[2][1]==marker   ||
                     board[0][2]==marker&&board[1][2]==marker&&board[2][2]==marker){
                            col_winner=true;
        } else if(board[0][0]==marker&&board[1][1]==marker&&board[2][2]==marker ||
                     board[0][2]==marker&&board[1][1]==marker&&board[2][0]==marker){
                            dia_winner=true;
        }

        return row_winner || col_winner || dia_winner;
    }

    public int count(Marker marker){
        int count = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i][j]==marker) {
                    count++;
                }
            }
        }
        return count;
    }

    public void byComputer() {
        Random rand = new Random();
        int count = count(Marker.X);

        if (count == 1) {
            int row, col;                                                                //for placing the first O
            if (board[1][1] == Marker.EMPTY) {
                place(Marker.O, 1, 1);
            } else {
                do {
                    row = rand.nextInt(3);
                    col = rand.nextInt(3);
                } while (board[row][col] != Marker.EMPTY);
                place(Marker.O, row, col);
            }
        } else if (count == 2) {                                                                  //for placing the second O
            int row, col;
            if (board[0][0] == Marker.X && board[0][1] == Marker.X && board[0][2] == Marker.EMPTY) {                        //check for adjacent Xs
                place(Marker.O, 0, 2);
            } else if (board[0][0] == Marker.X && board[1][0] == Marker.X && board[2][0] == Marker.EMPTY) {
                place(Marker.O, 2, 0);
            } else if (board[0][0] == Marker.X && board[1][1] == Marker.X && board[2][2] == Marker.EMPTY) {
                place(Marker.O, 2, 2);
            } else if (board[1][0] == Marker.X && board[1][1] == Marker.X && board[1][2] == Marker.EMPTY) {
                place(Marker.O, 1, 2);
            } else if (board[2][0] == Marker.X && board[1][0] == Marker.X && board[0][0] == Marker.EMPTY) {
                place(Marker.O, 0, 0);
            } else if (board[2][0] == Marker.X && board[1][1] == Marker.X && board[0][2] == Marker.EMPTY) {
                place(Marker.O, 0, 2);
            } else if (board[2][0] == Marker.X && board[2][1] == Marker.X && board[2][2] == Marker.EMPTY) {
                place(Marker.O, 2, 2);
            } else if (board[2][1] == Marker.X && board[1][1] == Marker.X && board[0][1] == Marker.EMPTY) {
                place(Marker.O, 0, 1);
            } else if (board[2][2] == Marker.X && board[2][1] == Marker.X && board[2][0] == Marker.EMPTY) {
                place(Marker.O, 2, 0);
            } else if (board[2][2] == Marker.X && board[1][1] == Marker.X && board[0][0] == Marker.EMPTY) {
                place(Marker.O, 0, 0);
            } else if (board[2][2] == Marker.X && board[1][2] == Marker.X && board[0][2] == Marker.EMPTY) {
                place(Marker.O, 0, 2);
            } else if (board[1][2] == Marker.X && board[1][1] == Marker.X && board[1][0] == Marker.EMPTY) {
                place(Marker.O, 1, 0);
            } else if (board[0][2] == Marker.X && board[0][1] == Marker.X && board[0][0] == Marker.EMPTY) {
                place(Marker.O, 0, 0);
            } else if (board[0][2] == Marker.X && board[1][1] == Marker.X && board[2][0] == Marker.EMPTY) {
                place(Marker.O, 2, 0);
            } else if (board[0][2] == Marker.X && board[1][2] == Marker.X && board[2][2] == Marker.EMPTY) {
                place(Marker.O, 2, 2);
            } else if (board[0][1] == Marker.X && board[1][1] == Marker.X && board[2][1] == Marker.EMPTY) {
                place(Marker.O, 2, 1);
            } else if (board[0][0] == Marker.X && board[0][2] == Marker.X && board[0][1] == Marker.EMPTY) {         //check alternate Xs
                place(Marker.O, 0, 1);
            } else if (board[0][0] == Marker.X && board[2][0] == Marker.X && board[1][0] == Marker.EMPTY) {
                place(Marker.O, 1, 0);
            } else if (board[0][0] == Marker.X && board[2][2] == Marker.X && board[1][1] == Marker.EMPTY) {
                place(Marker.O, 1, 1);
            } else if (board[2][0] == Marker.X && board[2][2] == Marker.X && board[2][1] == Marker.EMPTY) {
                place(Marker.O, 2, 1);
            } else if (board[2][0] == Marker.X && board[0][2] == Marker.X && board[1][1] == Marker.EMPTY) {
                place(Marker.O, 1, 1);
            } else if (board[2][2] == Marker.X && board[0][2] == Marker.X && board[1][2] == Marker.EMPTY) {
                place(Marker.O, 1, 2);
            } else if (board[0][1] == Marker.O || board[2][1] == Marker.O || board[1][2] == Marker.O || board[1][0] == Marker.O) {          //check for Os
                if (board[1][1] == Marker.EMPTY) {
                    place(Marker.O, 1, 1);
                } else {
                    do {
                        row = rand.nextInt(3);
                        col = rand.nextInt(3);
                    } while (board[row][col] != Marker.EMPTY);
                    place(Marker.O, row, col);
                }
            } else if (board[0][0] == Marker.O || board[2][0] == Marker.O && board[1][0] == Marker.EMPTY) {
                place(Marker.O, 1, 0);
            } else if (board[0][0] == Marker.O || board[0][2] == Marker.O && board[0][1] == Marker.EMPTY) {
                place(Marker.O, 0, 1);
            } else if (board[0][2] == Marker.O || board[2][2] == Marker.O && board[1][2] == Marker.EMPTY) {
                place(Marker.O, 1, 2);
            } else if (board[2][2] == Marker.O || board[2][0] == Marker.O && board[2][1] == Marker.EMPTY) {
                place(Marker.O, 2, 1);
            }
        } else if (count >= 3) {
            int row, col;
            if (board[0][0] == Marker.O && board[0][1] == Marker.O && board[0][2] == Marker.EMPTY) {                        //try to win
                place(Marker.O, 0, 2);
            } else if (board[0][0] == Marker.O && board[1][0] == Marker.O && board[2][0] == Marker.EMPTY) {
                place(Marker.O, 2, 0);
            } else if (board[0][0] == Marker.O && board[1][1] == Marker.O && board[2][2] == Marker.EMPTY) {
                place(Marker.O, 2, 2);
            } else if (board[1][0] == Marker.O && board[1][1] == Marker.O && board[1][2] == Marker.EMPTY) {
                place(Marker.O, 1, 2);
            } else if (board[2][0] == Marker.O && board[1][0] == Marker.O && board[0][0] == Marker.EMPTY) {
                place(Marker.O, 0, 0);
            } else if (board[2][0] == Marker.O && board[1][1] == Marker.O && board[0][2] == Marker.EMPTY) {
                place(Marker.O, 0, 2);
            } else if (board[2][0] == Marker.O && board[2][1] == Marker.O && board[2][2] == Marker.EMPTY) {
                place(Marker.O, 2, 2);
            } else if (board[2][1] == Marker.O && board[1][1] == Marker.O && board[0][1] == Marker.EMPTY) {
                place(Marker.O, 0, 1);
            } else if (board[2][2] == Marker.O && board[2][1] == Marker.O && board[2][0] == Marker.EMPTY) {
                place(Marker.O, 2, 0);
            } else if (board[2][2] == Marker.O && board[1][1] == Marker.O && board[0][0] == Marker.EMPTY) {
                place(Marker.O, 0, 0);
            } else if (board[2][2] == Marker.O && board[1][2] == Marker.O && board[0][2] == Marker.EMPTY) {
                place(Marker.O, 0, 2);
            } else if (board[1][2] == Marker.O && board[1][1] == Marker.O && board[1][0] == Marker.EMPTY) {
                place(Marker.O, 1, 0);
            } else if (board[0][2] == Marker.O && board[0][1] == Marker.O && board[0][0] == Marker.EMPTY) {
                place(Marker.O, 0, 0);
            } else if (board[0][2] == Marker.O && board[1][1] == Marker.O && board[2][0] == Marker.EMPTY) {
                place(Marker.O, 2, 0);
            } else if (board[0][2] == Marker.O && board[1][2] == Marker.O && board[2][2] == Marker.EMPTY) {
                place(Marker.O, 2, 2);
            } else if (board[0][1] == Marker.O && board[1][1] == Marker.O && board[2][1] == Marker.EMPTY) {
                place(Marker.O, 2, 1);
            } else if (board[0][0] == Marker.O && board[0][2] == Marker.O && board[0][1] == Marker.EMPTY) {         //check alternate Os
                place(Marker.O, 0, 1);
            } else if (board[0][0] == Marker.O && board[2][0] == Marker.O && board[1][0] == Marker.EMPTY) {
                place(Marker.O, 1, 0);
            } else if (board[0][0] == Marker.O && board[2][2] == Marker.O && board[1][1] == Marker.EMPTY) {
                place(Marker.O, 1, 1);
            } else if (board[2][0] == Marker.O && board[2][2] == Marker.O && board[2][1] == Marker.EMPTY) {
                place(Marker.O, 2, 1);
            } else if (board[2][0] == Marker.O && board[0][2] == Marker.O && board[1][1] == Marker.EMPTY) {
                place(Marker.O, 1, 1);
            } else if (board[2][2] == Marker.O && board[0][2] == Marker.O && board[1][2] == Marker.EMPTY) {
                place(Marker.O, 1, 2);
            }else if (board[0][0] == Marker.X && board[0][1] == Marker.X && board[0][2] == Marker.EMPTY) {                        //try not to lose
                place(Marker.O, 0, 2);
            } else if (board[0][0] == Marker.X && board[1][0] == Marker.X && board[2][0] == Marker.EMPTY) {
                place(Marker.O, 2, 0);
            } else if (board[0][0] == Marker.X && board[1][1] == Marker.X && board[2][2] == Marker.EMPTY) {
                place(Marker.O, 2, 2);
            } else if (board[1][0] == Marker.X && board[1][1] == Marker.X && board[1][2] == Marker.EMPTY) {
                place(Marker.O, 1, 2);
            } else if (board[2][0] == Marker.X && board[1][0] == Marker.X && board[0][0] == Marker.EMPTY) {
                place(Marker.O, 0, 0);
            } else if (board[2][0] == Marker.X && board[1][1] == Marker.X && board[0][2] == Marker.EMPTY) {
                place(Marker.O, 0, 2);
            } else if (board[2][0] == Marker.X && board[2][1] == Marker.X && board[2][2] == Marker.EMPTY) {
                place(Marker.O, 2, 2);
            } else if (board[2][1] == Marker.X && board[1][1] == Marker.X && board[0][1] == Marker.EMPTY) {
                place(Marker.O, 0, 1);
            } else if (board[2][2] == Marker.X && board[2][1] == Marker.X && board[2][0] == Marker.EMPTY) {
                place(Marker.O, 2, 0);
            } else if (board[2][2] == Marker.X && board[1][1] == Marker.X && board[0][0] == Marker.EMPTY) {
                place(Marker.O, 0, 0);
            } else if (board[2][2] == Marker.X && board[1][2] == Marker.X && board[0][2] == Marker.EMPTY) {
                place(Marker.O, 0, 2);
            } else if (board[1][2] == Marker.X && board[1][1] == Marker.X && board[1][0] == Marker.EMPTY) {
                place(Marker.O, 1, 0);
            } else if (board[0][2] == Marker.X && board[0][1] == Marker.X && board[0][0] == Marker.EMPTY) {
                place(Marker.O, 0, 0);
            } else if (board[0][2] == Marker.X && board[1][1] == Marker.X && board[2][0] == Marker.EMPTY) {
                place(Marker.O, 2, 0);
            } else if (board[0][2] == Marker.X && board[1][2] == Marker.X && board[2][2] == Marker.EMPTY) {
                place(Marker.O, 2, 2);
            } else if (board[0][1] == Marker.X && board[1][1] == Marker.X && board[2][1] == Marker.EMPTY) {
                place(Marker.O, 2, 1);
            } else if (board[0][0] == Marker.X && board[0][2] == Marker.X && board[0][1] == Marker.EMPTY) {         //check alternate Xs
                place(Marker.O, 0, 1);
            } else if (board[0][0] == Marker.X && board[2][0] == Marker.X && board[1][0] == Marker.EMPTY) {
                place(Marker.O, 1, 0);
            } else if (board[0][0] == Marker.X && board[2][2] == Marker.X && board[1][1] == Marker.EMPTY) {
                place(Marker.O, 1, 1);
            } else if (board[2][0] == Marker.X && board[2][2] == Marker.X && board[2][1] == Marker.EMPTY) {
                place(Marker.O, 2, 1);
            } else if (board[2][0] == Marker.X && board[0][2] == Marker.X && board[1][1] == Marker.EMPTY) {
                place(Marker.O, 1, 1);
            } else if (board[2][2] == Marker.X && board[0][2] == Marker.X && board[1][2] == Marker.EMPTY) {
                place(Marker.O, 1, 2);
            }else{
                do{
                    row = rand.nextInt(3);
                    col = rand.nextInt(3);
                }while(board[row][col]!=Marker.EMPTY);
                place(Marker.O,row,col);
            }
        }
    }
    private void Clear(){
        for(int i = 0; i<3; i++){
            for(int j=0; j<3; j++){
                board[i][j]=Marker.EMPTY;
            }
        }
    }

}

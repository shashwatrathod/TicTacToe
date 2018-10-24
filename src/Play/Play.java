package Play;
import TicTacToe.*;
import java.util.Scanner;

public class Play {
    public static void main(String[] args){
        Board board = new Board();
        Scanner scan = new Scanner(System.in);
        int row,col;
        int i=0;


        System.out.println("Enter player one name: ");
        String p1 =  scan.next();

        System.out.println(p1+" is : X\nComputer is : O");
        board.draw();
        do{
            if (!board.isWinner(Marker.X) &&
                    !board.isWinner(Marker.O)) {

                if (i <= 9) {
                    System.out.println("\n\n" + p1 + "'s turn: ");
                    System.out.println("Enter row: ");
                    row = scan.nextInt();
                    System.out.println("Enter column:  ");
                    col = scan.nextInt();
                    board.place(Marker.X, row, col);
                    board.draw();
                    i++;
                }
            }
            if(i<=9){
                if (!board.isWinner(Marker.X) &&
                        !board.isWinner(Marker.O)) {
                    System.out.println("\n\nComputer's turn: ");
                    board.byComputer();
                    board.draw();
                    i++;
                } else {
                    break;
                }
            }
            else
                break;

        }while(!board.isWinner(Marker.X)||!board.isWinner(Marker.O));

        if(i>9){
            System.out.println("Draw!");
        }
        if(board.isWinner(Marker.X)){
            System.out.println("Congratulations! "+p1+" won! ");
        } else if(board.isWinner(Marker.O)){
            System.out.println("Aww! Computer won");
        }
    }
}

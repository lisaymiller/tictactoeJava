import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        TicTacToeClass game = new TicTacToeClass();

        System.out.println(
                "\nWelcome to Lisa's game of Tic Tac Toe in Java! \nThe rules are simple, three X's in a row win. \nLet's get started!");

        game.displayBoard();

        // TODO: throw catches for only ints between 0-2
        System.out.println("Please enter the row you would like to place your X");
        int rowChoice = scan.nextInt();
        System.out.println("Please enter the column you would like to place your X");
        int coloumnChoice = scan.nextInt();

        game.playMove('X', rowChoice, coloumnChoice);

        game.displayBoard();

        scan.close();

    }
}
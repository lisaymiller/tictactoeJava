import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) throws InterruptedException {

        Scanner scan = new Scanner(System.in);
        TicTacToeClass game = new TicTacToeClass();

        boolean gameOn = true;

        System.out.println("\nWelcome to Lisa's game of Tic Tac Toe in Java!");

        Thread.sleep(2000);
        System.out.println("The rules are simple, three X's in a row win.");

        Thread.sleep(2000);
        System.out.println("Let's get started!");

        Thread.sleep(1000);
        game.displayBoard();

        do {
            // TODO: make sure computer cannot place turn in same place that user did or
            // vice versa
            // TODO: winner method
            // TODO: game over when board full
            // TODO: confirm everything in test file
            Thread.sleep(1000);
            System.out.println("Please enter the row you would like to place your X");
            int rowChoice = scan.nextInt();

            System.out.println("Please enter the column you would like to place your X");
            int coloumnChoice = scan.nextInt();

            if (game.isValid(rowChoice, coloumnChoice) == false) {
                System.out.println("Please enter a valid choice");
                continue;

            } else if (game.isValid(rowChoice, coloumnChoice) == true) {
                game.playMove('X', rowChoice, coloumnChoice);
            }

            Thread.sleep(1000);
            game.displayBoard();

            System.out.println("Computer's turn!");

            game.playMove('O', (int) (Math.random() * 3), (int) (Math.random() * 3));
            Thread.sleep(1000);
            game.displayBoard();

            if (game.isFull() == true) {
                Thread.sleep(1000);
                System.out.println("Game over! Board is full.");
                System.out.println("Would you like to play again? Y/N");
                String tryAgain = scan.nextLine();
                if (tryAgain.charAt(0) == 'y' || tryAgain.charAt(0) == 'Y') {
                    continue; // TODO: reset board
                } else {
                    break;
                }
            }
        } while (gameOn = true);

        scan.close();

    }

}
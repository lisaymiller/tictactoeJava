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

        do {
            Thread.sleep(1000);
            game.displayBoard();

            Thread.sleep(1000);
            System.out.println("Please enter the row you would like to place your X");
            int rowChoice = scan.nextInt();

            System.out.println("Please enter the column you would like to place your X");
            int columnChoice = scan.nextInt();

            if (game.isValid(rowChoice, columnChoice) == false) {
                System.out.println("Please enter a valid choice");
                continue;
            } else if (game.playerAt(rowChoice, columnChoice) != ' ') {
                System.out.println("Please pick an empty location");
                continue;
            } else if (game.isValid(rowChoice, columnChoice) == true) {
                game.playMove('X', rowChoice, columnChoice);
            }

            Thread.sleep(500);
            game.displayBoard();

            if (game.isWinner('X') == true) {
                System.out.println("Congradulations! You won!");
                System.out.println("Would you like to play again? Y/N");
                String tryAgain = scan.next();
                if (tryAgain.charAt(0) == 'y' || tryAgain.charAt(0) == 'Y') {
                    continue; // TODO: reset board
                } else {
                    break;
                }
            }

            Thread.sleep(1000);
            System.out.println("Computer's turn!");

            // trying to keep computer from chosing a spot that's already taken, not sure
            // how to implement
            if (game.playerAt(game.computerRowChoice(), game.computerColumnChoice()) == ' ') {
                game.playMove('O', game.computerRowChoice(), game.computerColumnChoice());
            } else if (game.playerAt(game.computerRowChoice(), game.computerColumnChoice()) != ' ') {
                continue;
            }

            if (game.isWinner('O') == true) {
                System.out.println("Sorry, you lost... :(");
                System.out.println("Want to try again? Y/N");
                String tryAgain = scan.next();
                if (tryAgain.charAt(0) == 'y' || tryAgain.charAt(0) == 'Y') {
                    continue; // TODO: reset board
                } else {
                    break;
                }
            }

            if (game.isCat() == true) {
                Thread.sleep(1000);
                System.out.println("Game over! Board is full.");
                System.out.println("Would you like to play again? Y/N");
                String tryAgain = scan.next();
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
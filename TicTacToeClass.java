public class TicTacToeClass {
    // Instance Variables
    private char[][] board;
    private int turns;

    private char p;
    private int r;
    private int c;

    // Constructors
    public TicTacToeClass() {
        board = new char[3][3];
        turns = 0;

        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                board[r][c] = ' ';
    }

    // Accessor Methods

    public boolean isWinner(char p) {
        for (int r = 0; r < 3; r++) {
            if (p == board[r][0] && p == board[r][1] && p == board[r][2])
                return true;
        }
        for (int c = 0; c < 3; c++) {
            if (p == board[0][c] && p == board[1][c] && p == board[2][c])
                return true;
        }
        if (p == board[0][2] && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        } else if (p == board[0][0] && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (turns >= 9) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isCat() {
        if (isFull() && !isWinner('X') && !isWinner('O')) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValid(int r, int c) {
        if (0 <= r && r <= 2 && 0 <= c && c <= 2)
            return true;
        else
            return false;
    }

    public int numTurns() {
        return turns;
    }

    public char playerAt(int r, int c) {
        if (isValid(r, c))
            return board[r][c];
        else
            return '@';
    }

    public int computerRowChoice() {
        int choice = (int) (Math.random() * 3);
        return choice;
    }

    public int computerColumnChoice() {
        return (int) (Math.random() * 3);
    }

    public void displayBoard() {
        System.out.println("");
        System.out.println("     0 1 2 ");
        System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("");

    }

    // Modifiers
    public void playMove(char p, int r, int c) {
        this.board[r][c] = p;
        turns++;
    }

}
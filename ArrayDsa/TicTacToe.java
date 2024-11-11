public class TicTacToe {
    public static final int X = 1, O = -1;  // Players
    public static final int EMPTY = 0;      // Empty cell
    private int[][] board = new int[3][3];  // Game board
    private int player;                     // Current player

    // Constructor to initialize the game
    public TicTacToe() {
        clearBoard(); // Start with a clear board
    }

    // Clears the board and sets the first player to 'X'
    public void clearBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = EMPTY;  // Set each cell to EMPTY
        player = X; // Set the first player to 'X'
    }

    // Places a mark at position (i, j)
    public void putMark(int i, int j) throws IllegalArgumentException {
        if ((i < 0) || (i > 2) || (j < 0) || (j > 2))
            throw new IllegalArgumentException("Invalid board position");
        if (board[i][j] != EMPTY)
            throw new IllegalArgumentException("Board position occupied");
        board[i][j] = player;       // Place the mark for the current player
        player = -player;           // Switch players (O = -X)
    }

    // Checks if the current board configuration is a win for the given player
    public boolean isWin(int mark) {
        return ((board[0][0] + board[0][1] + board[0][2] == mark * 3) || // Row 0
                (board[1][0] + board[1][1] + board[1][2] == mark * 3) || // Row 1
                (board[2][0] + board[2][1] + board[2][2] == mark * 3) || // Row 2
                (board[0][0] + board[1][0] + board[2][0] == mark * 3) || // Column 0
                (board[0][1] + board[1][1] + board[2][1] == mark * 3) || // Column 1
                (board[0][2] + board[1][2] + board[2][2] == mark * 3) || // Column 2
                (board[0][0] + board[1][1] + board[2][2] == mark * 3) || // Diagonal
                (board[2][0] + board[1][1] + board[0][2] == mark * 3));  // Reverse diagonal
    }

    // Determines the winner: X (1), O (-1), or 0 for a tie
    public int winner() {
        if (isWin(X))
            return X;
        else if (isWin(O))
            return O;
        else
            return 0;
    }

    // Provides a string representation of the board
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (board[i][j]) {
                    case X: sb.append("X"); break;
                    case O: sb.append("O"); break;
                    case EMPTY: sb.append(" "); break;
                }
                if (j < 2) sb.append("|"); // Column boundary
            }
            if (i < 2) sb.append("\n-----\n"); // Row boundary
        }
        return sb.toString();
    }

    // Test run of a simple game
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        
        // Sample moves by players X and O
        game.putMark(1, 1); game.putMark(0, 2);
        game.putMark(2, 2); game.putMark(0, 0);
        game.putMark(0, 1); game.putMark(2, 1);
        game.putMark(1, 2); game.putMark(1, 0);
        game.putMark(2, 0);

        // Print final board and game outcome
        System.out.println(game);
        int winningPlayer = game.winner();
        String[] outcome = {"O wins", "Tie", "X wins"};
        System.out.println(outcome[1 + winningPlayer]);
    }
}

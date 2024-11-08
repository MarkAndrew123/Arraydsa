
public void add(GameEntry e) {
    int newScore = e.getScore();

    // Check if the new entry e is a high score
    if (numEntries < board.length || newScore > board[numEntries - 1].getScore()) {
        if (numEntries < board.length) {
            // if there's still room, increment the number of entries
            numEntries++;
        }
        // Shift any lower scores rightward to make room for the new entry
        int j = numEntries - 1;
        while (j > 0 && board[j - 1].getScore() < newScore) {
            board[j] = board[j - 1];   // shift entry from j-1 to j
            j--;                       // move to the next lower position
        }
        // Insert the new entry into its correct position
        board[j] = e;
    }
}

// Optionally, you can add a method to print the scoreboard for testing
public void printBoard() {
    for (int i = 0; i < numEntries; i++) {
        System.out.println("Rank " + (i + 1) + ": " + board[i].getName() + " - " + board[i].getScore());
    }
}
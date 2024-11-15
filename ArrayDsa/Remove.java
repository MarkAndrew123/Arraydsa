Remove and return the high score at index i.
 
public GameEntry remove(int i) throws IndexOutOfBoundsException {
    if (i < 0 || i >= numEntries) // Check if index is valid
        throw new IndexOutOfBoundsException("Invalid index: " + i);
    
    GameEntry temp = board[i]; // Save the object to be removed

    // Shift elements left to fill the gap left by the removed score
    for (int j = i; j < numEntries - 1; j++)
        board[j] = board[j + 1];
    
    board[numEntries - 1] = null; // Null out the old last score
    numEntries--; // Decrease the number of entries
    
    return temp; // Return the removed entry
}
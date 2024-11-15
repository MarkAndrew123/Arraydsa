// where weve implemented the sorting algorithm in a more verbose manner in different classes , we can achieve it in an easier way using 
// a simple sort algorithm

public static void insertionSort(char[] data) {
    int n = data.length;  // Step 1 :let's say data.length = 5 ,we assign those 5 values to n , so we can work with
    // it in the for loop 
    for (int k = 1; k < n; k++) {  // Step 2 start the checking from 1 because intitally array index starts from 
        // 0 so we start with the first index , then we confirm by looping from k to k = n-1
        char cur = data[k];  // Step 3
        int j = k;  // Step 4 j is initialized to k, meaning it starts at the position of cur.
        // This variable j will be used to find the correct position for cur as we shift elements to the right.
        while (j > 0 && data[j - 1] > cur) {  // Step 5
            data[j] = data[j - 1];  // Step 6
            j--;  // Step 7
        }
        data[j] = cur;  // Step 8
    }
}
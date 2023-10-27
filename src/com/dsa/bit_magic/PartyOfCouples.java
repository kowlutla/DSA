package com.dsa.bit_magic;

/**
 * In a party of N people, each person is denoted by an integer. Couples are
 * represented by the same number. Find out the only single person in the party
 * of couples.
 */
public class PartyOfCouples {
    
    // Function to find the only single person in the party of couples
    static int findSingle(int N, int arr[]) {
        int result = 0;
        // Using XOR operation to find the single person in the party
        for (int i = 0; i < N; i++) {
            result = result ^ arr[i];
        }
        // Returning the single person's identifier
        return result;
    }

    // Main method to test the findSingle functionality
    public static void main(String[] args) {
        // Example array representing the people in the party
        int[] arr = { 1, 2, 3, 4, 1, 2, 3 };
        int N = arr.length; // Storing the length of the array
        int singlePerson = findSingle(N, arr); // Finding the single person using the findSingle method
        System.out.println("The single person in the party is: " + singlePerson); // Printing the single person's identifier
    }
}

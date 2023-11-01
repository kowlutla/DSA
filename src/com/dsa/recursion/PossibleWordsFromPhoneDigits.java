package com.dsa.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a keypad as shown in the diagram, and an N digit number which is
 * represented by array a[ ], the task is to list all words which are possible
 * by pressing these numbers.
 */
public class PossibleWordsFromPhoneDigits {

    // Function to find list of all words possible by pressing given numbers.
    static ArrayList<String> possibleWords(int a[], int N) {
        // Creating a map representing the phone keypad
        Map<Integer, String> keypad = new HashMap<>();
        keypad.put(2, "abc");
        keypad.put(3, "def");
        keypad.put(4, "ghi");
        keypad.put(5, "jkl");
        keypad.put(6, "mno");
        keypad.put(7, "pqrs");
        keypad.put(8, "tuv");
        keypad.put(9, "wxyz");

        // Creating an array to store characters corresponding to the input digits
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = keypad.get(a[i]);
        }
        // ArrayList to store the possible words
        ArrayList<String> result = new ArrayList<>();
        String current = "";
        int index = 0;
        // Calling the recursive helper function to find all possible words
        possibleWords(arr, current, index, N, result);
        return result;
    }

    // Helper function to generate all possible words using recursion
    private static void possibleWords(String[] arr, String current, int index, int N, ArrayList<String> result) {

        // Base case: if the index reaches the length of the input array, add the current word to the result
        if (index == N) {
            result.add(current);
            return;
        }

        // Iterate through each character corresponding to the current digit and generate possible words
        for (int i = 0; i < arr[index].length(); i++) {
            possibleWords(arr, current + arr[index].charAt(i), index + 1, N, result);
        }
    }
    
 // Main method for testing the PossibleWordsFromPhoneDigits class
    public static void main(String[] args) {
        int[] inputDigits = {2, 3, 4}; // Example input digits
        int N = inputDigits.length;

        // Calling the possibleWords method to get the list of possible words
        ArrayList<String> words = possibleWords(inputDigits, N);

        // Printing the list of possible words
        System.out.println("Possible Words:");
        for (String word : words) {
            System.out.println(word);
        }
    }
}

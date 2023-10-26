package com.dsa.bit_magic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a string S, Find all the possible subsequences of the String in
 * lexicographically-sorted order.
 */
public class PowerSet {

    // Function to find all possible subsequences of the string in lexicographically-sorted order
    public List<String> AllPossibleStrings(String s) {
        // Initialize an ArrayList to store the result
        ArrayList<String> result = new ArrayList<>();
        // Calculate the total number of subsequences
        long powerSet = (long) Math.pow(2, s.length());
        // Iterate through all the subsequences
        for (long counter = 1; counter < powerSet; counter++) {
            // Create a StringBuffer to store the current subsequence
            StringBuffer sb = new StringBuffer();
            // Build the subsequence based on the set bits in the counter
            for (int index = 0; index < s.length(); index++) {
                if ((counter & (1 << index)) != 0) {
                    sb.append(s.charAt(index));
                }
            }
            // Add the subsequence to the result list
            result.add(sb.toString());
        }
        // Sort the result list lexicographically
        Collections.sort(result);

        // Return the sorted list of subsequences
        return result;
    }

    // Main method to test the AllPossibleStrings functionality
    public static void main(String[] args) {
        // Example usage
        PowerSet powerSet = new PowerSet();
        String s = "abcd";
        List<String> result = powerSet.AllPossibleStrings(s);
        System.out.println("All possible subsequences of the string in lexicographically-sorted order:");
        for (String subsequence : result) {
            System.out.print(subsequence + " ");
        }
    }
}

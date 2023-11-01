package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Collections;

/**
 * You are given a string. You need to print the lexicographically sorted
 * power-set of the string. Note: The string s contains lowercase letter of
 * alphabet.
 */
public class PowerSetUsingRecursion {

    // Method to generate the power set of a given string
    static ArrayList<String> powerSet(String s) {
        // Create an ArrayList to store the result
        ArrayList<String> result = new ArrayList<>();
        // Call the helper function to generate the power set
        powerSet(s, "", 0, result);
        return result;
    }

    // Recursive helper function to generate the power set
    static void powerSet(String s, String current, int index, ArrayList<String> result) {

        // If the index reaches the end of the string, add the current subset to the result
        if (index == s.length()) {
            result.add(current);
            return;
        }

        // Recursively generate subsets by either including or excluding the current character
        powerSet(s, current, index + 1, result); // Exclude the current character
        powerSet(s, current + s.charAt(index), index + 1, result); // Include the current character
    }

    // Main method to test the PowerSetUsingRecursion functionality
    public static void main(String[] args) {
        // Example string
        String s = "abc";
        // Get the power set of the string using the powerSet method
        ArrayList<String> powerSet = powerSet(s);
        Collections.sort(powerSet);
        // Print the lexicographically sorted power set of the string
        System.out.println("Power set of the string " + s + " is: " + powerSet);
    }
}

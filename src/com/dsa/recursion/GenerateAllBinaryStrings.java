/**
 * 	Given an integer N , Print all binary strings of size N which do not contain consecutive 1s.

	A binary string is that string which contains only 0 and 1.
	
	Example 1:
	Input:
	N = 3
	Output:
	000 , 001 , 010 , 100 , 101
	Explanation:
	None of the above strings contain consecutive 1s. 
	"110" is not an answer as it has '1's occuring consecutively.
 */
package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBinaryStrings {

    // Method to generate binary strings of length 'n'
    public static List<String> generateBinaryStrings(int n) {
        List<String> result = new ArrayList<>(); // Initialize the result list
        int index = 0; // Start index for generating binary strings
        String s = ""; // Initialize an empty string
        int lastUsed = 0; // Last used digit (0 or 1)
        generateBinaryStrings(n, index, lastUsed, s, result); // Call the helper method
        return result; // Return the generated binary strings
    }

    // Helper method to generate binary strings recursively
    private static void generateBinaryStrings(int n, int index, int lastUsed, String s, List<String> result) {
        if (index == n) { // If reached the desired length 'n'
            result.add(s); // Add the generated binary string to the result list
            return;
        }

        if (lastUsed == 0) { // If last used digit was 0
            generateBinaryStrings(n, index + 1, 0, s + "0", result); // Recursively append '0'
            generateBinaryStrings(n, index + 1, 1, s + "1", result); // Recursively append '1'
        } else { // If last used digit was 1
            generateBinaryStrings(n, index + 1, 0, s + "0", result); // Recursively append '0'
        }
    }

    // Main method to demonstrate generating binary strings
    public static void main(String[] args) {
        int n = 4; // Length of binary strings to generate
        
        List<String> binaryStrings = generateBinaryStrings(n); // Generate binary strings
        
        // Display the generated binary strings
        System.out.println("Generated Binary Strings(Without Consecutive 1's) of Length " + n + ":");
        for (String binaryString : binaryStrings) {
            System.out.println(binaryString);
        }
    }
}

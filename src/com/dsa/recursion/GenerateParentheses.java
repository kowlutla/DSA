/**
 * Given an integer N representing the number of pairs of parentheses, 
 * the task is to generate all combinations of well-formed(balanced) parentheses.
	
	Example 1:
	Input:
	N = 3
	Output:
	((()))
	(()())
	(())()
	()(())
	()()()
 */
package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    // Method to generate all valid parentheses combinations for 'n' pairs
    public List<String> AllParenthesis(int n) {
        List<String> result = new ArrayList<>(); // Initialize the result list
        String s = ""; // Initialize an empty string
        int left = 0, right = 0; // Track counts of left and right parentheses
        AllParenthesis(left, right, n, s, result); // Call the helper method
        return result; // Return the generated valid parentheses combinations
    }

    // Helper method to generate valid parentheses combinations recursively
    private void AllParenthesis(int left, int right, int n, String s, List<String> result) {
        if (left == n && right == n) { // If reached the desired number of parentheses pairs
            result.add(s); // Add the generated parentheses combination to the result list
            return;
        }

        // Check for invalid counts of left and right parentheses
        if (right > left || right > n || left > n) {
            return; // Invalid counts, return without further processing
        }

        s = s + "("; // Add '('
        AllParenthesis(left + 1, right, n, s, result); // Recursively generate combinations
        s = s.substring(0, s.length() - 1); // Backtrack by removing the last character '('

        s = s + ")"; // Add ')'
        AllParenthesis(left, right + 1, n, s, result); // Recursively generate combinations
        s = s.substring(0, s.length() - 1); // Backtrack by removing the last character ')'
    }

    // Main method to demonstrate generating valid parentheses combinations
    public static void main(String[] args) {
        GenerateParentheses parentheses = new GenerateParentheses(); // Create an instance
        int n = 3; // Number of pairs of parentheses
        
        List<String> validParentheses = parentheses.AllParenthesis(n); // Generate parentheses combinations
        
        // Display the generated valid parentheses combinations
        System.out.println("Valid Parentheses Combinations for " + n + " pairs:");
        for (String parenthesesCombination : validParentheses) {
            System.out.println(parenthesesCombination);
        }
    }
}

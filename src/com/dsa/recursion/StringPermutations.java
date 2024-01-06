/**
 * 	Given a string S. The task is to find all permutations (need not be different) of a given string.

	Note: return the permutations in lexicographically increasing order.
	
	Example 1:
	
	Input:
	S = AAA
	Output: AAA AAA AAA AAA AAA AAA
	Explanation: There are total 6 permutations, as given in the output.
	Example 2:
	
	Input:
	S = ABSG
	Output: ABGS ABSG AGBS AGSB ASBG ASGB
	BAGS BASG BGAS BGSA BSAG BSGA GABS
	GASB GBAS GBSA GSAB GSBA SABG SAGB
	SBAG SBGA SGAB SGBA
	Explanation: There are total 24 permutations, as given in the output.
 */
package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Collections;

public class StringPermutations {

    // Method to generate string permutations
    public ArrayList<String> permutation(String S) {
        ArrayList<String> result = new ArrayList<>(); // Initialize the result list
        int index = 0; // Start index for permutations
        permutation(S, index, result); // Call the helper method
        Collections.sort(result); // Sort the generated permutations
        return result; // Return the sorted permutations
    }

    // Helper method to generate permutations recursively
    private void permutation(String S, int index, ArrayList<String> result) {
        if (index == S.length()) { // If reached the end of string
            result.add(S); // Add the generated permutation to the result list
            return;
        }

        for (int i = index; i < S.length(); i++) {
            S = swap(i, index, S); // Swap characters to explore different permutations
            permutation(S, index + 1, result); // Recursively generate permutations
            S = swap(i, index, S); // Backtrack by restoring the original order
        }
    }

    // Utility method to swap characters in the string
    private String swap(int index1, int index2, String s) {
        char[] c = s.toCharArray();
        char temp = c[index1];
        c[index1] = c[index2];
        c[index2] = temp;
        return new String(c);
    }

    // Main method to demonstrate generating string permutations
    public static void main(String[] args) {
        StringPermutations stringPermutation = new StringPermutations(); // Create an instance of StringPermutations class
        String inputString = "abcd"; // Example input string
        
        ArrayList<String> permutations = stringPermutation.permutation(inputString); // Generate permutations
        
        // Display the generated permutations
        System.out.printf("String Permutations Of \"%s\" : \n", inputString);
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }
}


/**
 *  Given a string s, find the longest palindromic subsequence's length in s.

	A subsequence is a sequence that can be derived from another sequence by
	deleting some or no elements without changing the order of the remaining elements.
	
	Example 1:
	Input: s = "bbbab"
	Output: 4
	Explanation: One possible longest palindromic subsequence is "bbbb".

	Example 2:
	Input: s = "cbbd"
	Output: 2
	Explanation: One possible longest palindromic subsequence is "bb".
 */
package com.dsa.dynamic_programming;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP28LongestPalindromicSubsequence {

    // Method to find the length of the longest palindromic subsequence
    public static int longestPalindromeSubseq(String s) {
        // Find the longest common subsequence between 's' and its reverse
        return lcs(s, new StringBuffer(s).reverse().toString());
    }

    // Helper method to find the length of the longest common subsequence between two strings
    private static int lcs(String s, String t) {
        // Initialize an array to store the lengths of the current row of the DP table
        int[] prev = new int[t.length() + 1];

        // Initialize the first row of the DP table with zeros
        for (int index1 = 0; index1 <= t.length(); index1++) {
            prev[index1] = 0;
        }

        // Fill the DP table using a bottom-up approach
        for (int index1 = 1; index1 <= s.length(); index1++) {
            // Create a new array to store the current row of the DP table
            int[] current = new int[t.length() + 1];
            for (int index2 = 1; index2 <= t.length(); index2++) {
                if (s.charAt(index1 - 1) == t.charAt(index2 - 1)) {
                    // If characters match, increment the length of the common subsequence by 1
                    current[index2] = 1 + prev[index2 - 1];
                } else {
                    // If characters don't match, take the maximum length of common subsequence from the previous row
                    current[index2] = Math.max(prev[index2], current[index2 - 1]);
                }
            }
            // Update the previous row for the next iteration
            prev = current;
        }

        // Return the length of the longest common subsequence
        return prev[t.length()];
    }
    
	public static void main(String[] args) {
		// Example input
		String s = "bbbab";
		// Find the length of the longest palindromic subsequence
		int longestPalindromicSubseqLength = longestPalindromeSubseq(s);
		// Print the length of the longest palindromic subsequence
		System.out.println("Length of Longest Palindromic Subsequence: " + longestPalindromicSubseqLength);
	}

}

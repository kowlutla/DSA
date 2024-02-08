/**
 * 
 	You are given two strings ‘s1’ and ‘s2’.
	Return the longest common subsequence of these strings.
	If there’s no such string, return an empty string. 
	If there are multiple possible answers, return any such string.
	
	Note:
	Longest common subsequence of string ‘s1’ and ‘s2’ is the longest subsequence of ‘s1’ 
	that is also a subsequence of ‘s2’. A ‘subsequence’ of ‘s1’ is a string that can be
	formed by deleting one or more (possibly zero) characters from ‘s1’.

	Example:
	Input: ‘s1’  = “abcab”, ‘s2’ = “cbab”
	Output: “bab”

	Explanation:
	“bab” is one valid longest subsequence present in both strings ‘s1’ , ‘s2’.
 */
package com.dsa.dynamic_programming;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP26PrintLongestCommonSubSequence {
	// Method to find the Longest Common Subsequence (LCS) of two strings
	public static String findLCS(int n, int m, String s, String t) {
		// Create a DP table to store the lengths of LCS
		int[][] dp = new int[s.length() + 1][t.length() + 1];

		// Initialize the first row and column of the DP table with zeros
		for (int index1 = 0; index1 <= s.length(); index1++) {
			dp[index1][0] = 0;
		}

		for (int index2 = 0; index2 <= t.length(); index2++) {
			dp[0][index2] = 0;
		}

		// Fill the DP table using a bottom-up approach
		for (int index1 = 1; index1 <= s.length(); index1++) {
			for (int index2 = 1; index2 <= t.length(); index2++) {
				if (s.charAt(index1 - 1) == t.charAt(index2 - 1)) {
					// If characters match, increment the LCS length by 1
					dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
				} else {
					// Otherwise, take the maximum of the lengths of the LCS
					// from previous cells
					dp[index1][index2] = Math.max(dp[index1 - 1][index2],
							dp[index1][index2 - 1]);
				}
			}
		}

		// Traverse the DP table to find the actual LCS
		int index1 = s.length();
		int index2 = t.length();
		String str = ""; // Variable to store the LCS
		while (index1 > 0 && index2 > 0) {
			if (s.charAt(index1 - 1) == t.charAt(index2 - 1)) {
				// If characters match, append the character to the LCS and move
				// diagonally upwards
				str = s.charAt(index1 - 1) + str;
				index1--;
				index2--;
			} else if (dp[index1][index2 - 1] > dp[index1 - 1][index2]) {
				// If the left cell has a greater value, move left
				index2--;
			} else {
				// Otherwise, move upwards
				index1--;
			}
		}
		return str; // Return the LCS
	}
	
	public static void main(String[] args) {
		// Example inputs
		String s = "ABCBDAB";
		String t = "BDCAB";

		// Find the Longest Common Subsequence (LCS)
		String lcs = findLCS(s.length(), t.length(), s, t);

		// Print the LCS
		System.out.println("Longest Common Subsequence (LCS): " + lcs);
	}
}
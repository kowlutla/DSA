/**
 * 	A Subsequence of a string is the string that is obtained by deleting 0 or more letters from the string and
  	keeping the rest of the letters in the same order.
	
	We are given two strings, 'str' and 'sub'.
	Find the number of subsequences of 'str' which are equal to 'sub'.
	Since the answer can be very large, print it modulo 10 ^ 9 + 7.
	Example :
	Input: 'str' = “brootgroot” and 'sub' = “brt”
	
	Output: 3
	Explanation: The following subsequences formed by characters at given indices (0-based) of 'str' are equal to 'sub' :
	str[0] = ‘b’, str[1] = ‘r’, str[4] = ‘t’
	str[0] = ‘b’, str[1] = ‘r’, str[9] = ‘t’
	str[0] = ‘b’, str[6] = ‘r’, str[9] = ‘t’
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP32DistinctSubsequences {

	// Method using recursion to find distinct subsequences
	public static int distinctSubsequencesRecursion(String str, String sub) {
		// Calling the helper function with initial parameters
		return distinctSubsequencesRecursion(str, sub, str.length() - 1,
				sub.length() - 1);
	}

	// Recursive helper function
	private static int distinctSubsequencesRecursion(String str, String sub,
			int index1, int index2) {
		// Base cases
		if (index2 < 0) {
			return 1; // If subsequence is found, return 1
		}
		if (index1 < 0) {
			return 0; // If substring is exhausted but subsequence is not found, return 0
		}

		// If characters match, we can either include or exclude the character
		// from str
		if (str.charAt(index1) == sub.charAt(index2)) {
			int consider = distinctSubsequencesRecursion(str, sub, index1 - 1,
					index2 - 1);
			int notConsider = distinctSubsequencesRecursion(str, sub,
					index1 - 1, index2);
			return consider + notConsider; // Summing up the possibilities
		} else {
			// If characters don't match, we exclude the character from str
			return distinctSubsequencesRecursion(str, sub, index1 - 1, index2);
		}
	}

	// Method using memoization to find distinct subsequences
	public static int distinctSubsequencesMemoization(String str, String sub) {
		// Creating a memoization table
		int[][] dp = new int[str.length() + 1][sub.length() + 1];
		for (int[] d : dp) {
			Arrays.fill(d, -1);
		}
		// Calling the helper function with initial parameters and passing the memoization table
		return distinctSubsequencesMemoization(str, sub, str.length(),
				sub.length(), dp);
	}

	// Memoization helper function
	private static int distinctSubsequencesMemoization(String str, String sub,
			int index1, int index2, int[][] dp) {
		// Base cases
		if (index2 == 0) {
			return 1;
		}
		if (index1 == 0) {
			return 0;
		}
		// If the result is already computed, return it
		if (dp[index1][index2] != -1) {
			return dp[index1][index2];
		}

		// If characters match, we can either include or exclude the character
		// from str
		if (str.charAt(index1 - 1) == sub.charAt(index2 - 1)) {
			int consider = distinctSubsequencesMemoization(str, sub, index1 - 1,
					index2 - 1, dp);
			int notConsider = distinctSubsequencesMemoization(str, sub,
					index1 - 1, index2, dp);
			return dp[index1][index2] = consider + notConsider; // Memoizing the result and returning
		} else {
			// If characters don't match, we exclude the character from str
			return dp[index1][index2] = distinctSubsequencesMemoization(str,
					sub, index1 - 1, index2, dp);
		}
	}

	// Method using tabulation to find distinct subsequences
	public static int distinctSubsequencesTabulation(String str, String sub) {
		// Creating a tabulation table
		int[][] dp = new int[str.length() + 1][sub.length() + 1];
		// Initializing the first column (when sub is empty)
		for (int index1 = 0; index1 <= str.length(); index1++) {
			dp[index1][0] = 1;
		}
		// Initializing the first row (when str is empty)
		for (int index2 = 1; index2 <= sub.length(); index2++) {
			dp[0][index2] = 0;
		}
		// Filling up the table
		for (int index1 = 1; index1 <= str.length(); index1++) {
			for (int index2 = 1; index2 <= sub.length(); index2++) {
				if (str.charAt(index1 - 1) == sub.charAt(index2 - 1)) {
					int consider = dp[index1 - 1][index2 - 1];
					int notConsider = dp[index1 - 1][index2];
					dp[index1][index2] = consider + notConsider;
				} else {
					dp[index1][index2] = dp[index1 - 1][index2];
				}
			}
		}
		return dp[str.length()][sub.length()];
	}

	// Method using space optimization to find distinct subsequences
	public static int distinctSubsequencesSpaceOptimization(String str, String sub) {
		// Creating arrays for previous and current rows of the table
		int[] prev = new int[sub.length() + 1];
		prev[0] = 1; // Base case when sub is empty

		for (int index1 = 1; index1 <= str.length(); index1++) {
			int[] current = new int[sub.length() + 1];
			current[0] = 1; // Base case when sub is empty
			for (int index2 = 1; index2 <= sub.length(); index2++) {
				if (str.charAt(index1 - 1) == sub.charAt(index2 - 1)) {
					int consider = prev[index2 - 1];
					int notConsider = prev[index2];
					current[index2] = consider + notConsider;
				} else {
					current[index2] = prev[index2];
				}
			}
			prev = current; // Update the previous row for the next iteration
		}
		return prev[sub.length()]; // The result is stored in the last element of the previous row
	}
	
	public static void main(String[] args) {
		String str = "rabbbit";
		String sub = "rabbit";

		// Test distinctSubsequencesRecursion method
		int countRecursion = distinctSubsequencesRecursion(str, sub);
		System.out.println("Distinct subsequences (Recursion): " + countRecursion);

		// Test distinctSubsequencesMemoization method
		int countMemoization = distinctSubsequencesMemoization(str, sub);
		System.out.println("Distinct subsequences (Memoization): " + countMemoization);

		// Test distinctSubsequencesTabulation method
		int countTabulation = distinctSubsequencesTabulation(str, sub);
		System.out.println("Distinct subsequences (Tabulation): " + countTabulation);

		// Test distinctSubsequencesSpaceOptimization method
		int countSpaceOptimization = distinctSubsequencesSpaceOptimization(str, sub);
		System.out.println("Distinct subsequences (Space Optimization): " + countSpaceOptimization);
	}
}

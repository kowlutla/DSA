/**
 * 	Given two strings text1 and text2, return the length of their longest common subsequence. 
 	If there is no common subsequence, return 0.

	A subsequence of a string is a new string generated from the original string with some characters
	 (can be none) deleted without changing the relative order of the remaining characters.
	
	For example, "ace" is a subsequence of "abcde".
	A common subsequence of two strings is a subsequence that is common to both strings.
	
	 
	
	Example 1:
	
	Input: text1 = "abcde", text2 = "ace" 
	Output: 3  
	Explanation: The longest common subsequence is "ace" and its length is 3.

	Example 2:
	Input: text1 = "abc", text2 = "abc"
	Output: 3
	Explanation: The longest common subsequence is "abc" and its length is 3.

	Example 3:
	Input: text1 = "abc", text2 = "def"
	Output: 0
	Explanation: There is no such common subsequence, so the result is 0.
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP25LongestCommonSubsequence {

	public static int lcsRecursion(String s, String t) {
		return lcsRecursion(s.length(), t.length(), s, t);
	}

	private static int lcsRecursion(int index1, int index2, String s,
			String t) {
		if (index1 == 0 || index2 == 0) {
			return 0;
		}

		if (s.charAt(index1 - 1) == t.charAt(index2 - 1)) {
			return 1 + lcsRecursion(index1 - 1, index2 - 1, s, t);
		}

		return Math.max(lcsRecursion(index1 - 1, index2, s, t),
				lcsRecursion(index1, index2 - 1, s, t));
	}

	public static int lcsMemoization(String s, String t) {
		int[][] dp = new int[s.length() + 1][t.length() + 1];
		for (int d[] : dp) {
			Arrays.fill(d, -1);
		}
		return lcsMemoization(s.length(), t.length(), s, t, dp);
	}

	private static int lcsMemoization(int index1, int index2, String s, String t, int[][] dp) {
		if (index1 == 0 || index2 == 0) {
			return 0;
		}

		if (dp[index1][index2] != -1) {
			return dp[index1][index2];
		}
		if (s.charAt(index1 - 1) == t.charAt(index2 - 1)) {
			return 1 + lcsMemoization(index1 - 1, index2 - 1, s, t, dp);
		}

		return dp[index1][index2] = Math.max(lcsMemoization(index1 - 1, index2, s, t, dp),
				lcsMemoization(index1, index2 - 1, s, t, dp));
	}
	
	public static int lcsTabulation(String s, String t) {
		int[][] dp = new int[s.length() + 1][t.length() + 1];
		for (int index1 = 0; index1 <= s.length(); index1++) {
			dp[index1][0] = 0;
		}

		for (int index2 = 0; index2 <= t.length(); index2++) {
			dp[0][index2] = 0;
		}

		for (int index1 = 1; index1 <= s.length(); index1++) {
			for (int index2 = 1; index2 <= t.length(); index2++) {
				if (s.charAt(index1 - 1) == t.charAt(index2 - 1)) {
					dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
				} else {
					dp[index1][index2] = Math.max(dp[index1 - 1][index2],
							dp[index1][index2 - 1]);
				}
			}
		}

		return dp[s.length()][t.length()];
	}
	
	public static int lcsSpaceOptimization(String s, String t) {
		int[] prev = new int[t.length() + 1];
		for (int index1 = 0; index1 <= t.length(); index1++) {
			prev[0] = 0;
		}

		for (int index1 = 1; index1 <= s.length(); index1++) {
			int[] current = new int[t.length() + 1];
			for (int index2 = 1; index2 <= t.length(); index2++) {
				if (s.charAt(index1 - 1) == t.charAt(index2 - 1)) {
					current[index2] = 1 + prev[index2 - 1];
				} else {
					current[index2] = Math.max(prev[index2],
							current[index2 - 1]);
				}
			}
			prev = current;
		}

		return prev[t.length()];
	}
	public static void main(String[] args) {
        String s = "abcdaf";
        String t = "acbcf";

        // Test lcsRecursion
        System.out.println("Testing lcsRecursion:");
        System.out.println("Result: " + lcsRecursion(s, t));

        // Test lcsMemoization
        System.out.println("\nTesting lcsMemoization:");
        System.out.println("Result: " + lcsMemoization(s, t));

        // Test lcsTabulation
        System.out.println("\nTesting lcsTabulation:");
        System.out.println("Result: " + lcsTabulation(s, t));

        // Test lcsSpaceOptimization
        System.out.println("\nTesting lcsSpaceOptimization:");
        System.out.println("Result: " + lcsSpaceOptimization(s, t));
    }
}

/**
 * 	Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' 
  	where:
	'?' Matches any single character.
	'*' Matches any sequence of characters (including the empty sequence).
	The matching should cover the entire input string (not partial).
	
	Example 1:
	Input: s = "aa", p = "a"
	Output: false
	Explanation: "a" does not match the entire string "aa".

	Example 2:
	Input: s = "aa", p = "*"
	Output: true
	Explanation: '*' matches any sequence.

	Example 3:
	Input: s = "cb", p = "?a"
	Output: false
	Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class Dp34WildcardPatternMatching {

	public static boolean wildcardMatchingRecursion(String pattern, String text) {
		return wildcardMatchingRecursion(pattern, text, pattern.length(),text.length());
	}

	private static boolean wildcardMatchingRecursion(String pattern,
			String text, int pIndex, int tIndex) {

		if (pIndex == 0 && tIndex == 0) {
			return true;
		}

		if (pIndex == 0 && tIndex != 0) {
			return false;
		}

		if (tIndex == 0 && pIndex > 0) {
			return isAllStars(pattern, pIndex - 1);
		}

		if (pattern.charAt(pIndex - 1) == text.charAt(tIndex - 1)
				|| pattern.charAt(pIndex - 1) == '?') {
			return wildcardMatchingRecursion(pattern, text, pIndex - 1,
					tIndex - 1);
		} else {
			if (pattern.charAt(pIndex - 1) == '*') {
				return wildcardMatchingRecursion(pattern, text, pIndex,
						tIndex - 1)
						|| wildcardMatchingRecursion(pattern, text, pIndex - 1,
								tIndex);
			} else {
				return false;
			}
		}
	}

	public static boolean wildcardMatchingMemoization(String pattern,
			String text) {
		int[][] dp = new int[pattern.length() + 1][text.length() + 1];
		for (int[] d : dp) {
			Arrays.fill(d, -1);
		}
		return wildcardMatchingMemoization(pattern, text, pattern.length(),
				text.length(), dp) == 1 ? true : false;
	}
	private static int wildcardMatchingMemoization(String pattern, String text,
			int pIndex, int tIndex, int[][] dp) {

		if (pIndex == 0 && tIndex == 0) {
			return 1;
		}

		if (pIndex == 0 && tIndex != 0) {
			return 0;
		}

		if (tIndex == 0 && pIndex > 0) {
			return isAllStars(pattern, pIndex - 1) == true ? 1 : 0;
		}

		if (dp[pIndex][tIndex] != -1) {
			return dp[pIndex][tIndex];
		}

		if (pattern.charAt(pIndex - 1) == text.charAt(tIndex - 1)
				|| pattern.charAt(pIndex - 1) == '?') {
			return dp[pIndex][tIndex] = wildcardMatchingMemoization(pattern,
					text, pIndex - 1, tIndex - 1, dp);
		} else {
			if (pattern.charAt(pIndex - 1) == '*') {
				return dp[pIndex][tIndex] = (wildcardMatchingMemoization(
						pattern, text, pIndex, tIndex - 1, dp) == 1
								? true
								: false || wildcardMatchingMemoization(pattern,
										text, pIndex - 1, tIndex, dp) == 1
												? true
												: false) == true ? 1 : 0;
			} else {
				return 0;
			}
		}
	}

	public static boolean wildcardMatchingTabulation(String p, String s) {
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

		dp[0][0] = true;

		for (int pIndex = 1; pIndex <= p.length(); pIndex++) {
			dp[0][pIndex] = isAllStars(p, pIndex - 1);
		}

		for (int sIndex = 1; sIndex <= s.length(); sIndex++) {
			dp[sIndex][0] = false;
		}

		for (int sIndex = 1; sIndex <= s.length(); sIndex++) {
			for (int pIndex = 1; pIndex <= p.length(); pIndex++) {
				if (s.charAt(sIndex - 1) == p.charAt(pIndex - 1)
						|| p.charAt(pIndex - 1) == '?') {
					dp[sIndex][pIndex] = dp[sIndex - 1][pIndex - 1];
				} else {
					if (p.charAt(pIndex - 1) == '*') {
						dp[sIndex][pIndex] = dp[sIndex - 1][pIndex]
								|| dp[sIndex][pIndex - 1];
					} else {
						dp[sIndex][pIndex] = false;
					}
				}
			}
		}
		return dp[s.length()][p.length()];
	}

	private static boolean isAllStars(String S1, int i) {
		for (int j = 0; j <= i; j++) {
			if (S1.charAt(j) != '*')
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
        String pattern = "a*d?b";
        String text = "adcb";

        // Test wildcardMatchingRecursion method
        boolean recursionResult = wildcardMatchingRecursion(pattern, text);
        System.out.println("Wildcard matching (Recursion): " + recursionResult);

        // Test wildcardMatchingMemoization method
        boolean memoizationResult = wildcardMatchingMemoization(pattern, text);
        System.out.println("Wildcard matching (Memoization): " + memoizationResult);

        // Test wildcardMatchingTabulation method
        boolean tabulationResult = wildcardMatchingTabulation(pattern, text);
        System.out.println("Wildcard matching (Tabulation): " + tabulationResult);
    }
}

/**
 * 	Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

	You have the following three operations permitted on a word:
	Insert a character
	Delete a character
	Replace a character
	
	Example 1:
	Input: word1 = "horse", word2 = "ros"
	Output: 3
	Explanation: 
	horse -> rorse (replace 'h' with 'r')
	rorse -> rose (remove 'r')
	rose -> ros (remove 'e')

	Example 2:
	Input: word1 = "intention", word2 = "execution"
	Output: 5
	Explanation: 
	intention -> inention (remove 't')
	inention -> enention (replace 'i' with 'e')
	enention -> exention (replace 'n' with 'x')
	exention -> exection (replace 'n' with 'c')
	exection -> execution (insert 'u')
	
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP33EditDistance {

	public static int editDistanceRecursion(String word1, String word2) {
		return editDistanceRecursion(word1, word2, word1.length() , word2.length());
	}

	private static int editDistanceRecursion(String s1, String s2, int index1, int index2) {

		// if s1 is exhausted then we need to make index2+1 insertions to s1
		if (index1 == 0) {
			return index2 ;
		}

		// if s2 is exhausted then we need to make index1+1 deletions to s1
		if (index2 == 0) {
			return index1;
		}
		// if both characters are same then don't need to do anything
		if (s1.charAt(index1-1) == s2.charAt(index2-1)) {
			return editDistanceRecursion(s1, s2, index1 - 1, index2 - 1);
		} else {
			// remove current character from s1
			int remove = 1 + editDistanceRecursion(s1, s2, index1 - 1, index2);
			// insert current character to s1
			int insert = 1 + editDistanceRecursion(s1, s2, index1, index2 - 1);
			// replace current character of s1 with current character of s2
			int replace = 1
					+ editDistanceRecursion(s1, s2, index1 - 1, index2 - 1);
			// take minimum of all three operations
			return Math.min(remove, Math.min(insert, replace));
		}
	}

	public static int editDistanceMemoization(String word1, String word2) {
		int dp[][] = new int[word1.length()+1][word2.length()+1];
		for (int[] d : dp) {
			Arrays.fill(d, -1);
		}
		return editDistanceMemoization(word1, word2, word1.length(),
				word2.length(), dp);
	}

	private static int editDistanceMemoization(String s1, String s2, int index1,
			int index2, int[][] dp) {

		// if s1 is exhausted then we need to make index2+1 insertions to s1
		if (index1 == 0) {
			return index2 + 1;
		}

		// if s2 is exhausted then we need to make index1+1 deletions to s1
		if (index2 == 0) {
			return index2 + 1;
		}

		if (dp[index1][index2] != -1) {
			return dp[index1][index2];
		}

		// if both characters are same then don't need to do anything
		if (s1.charAt(index1-1) == s2.charAt(index2-1)) {
			return dp[index1][index2] = editDistanceMemoization(s1, s2, index1 - 1, index2 - 1, dp);
		} else {
			// remove current character from s1
			int remove = 1 + editDistanceMemoization(s1, s2, index1 - 1, index2, dp);
			// insert current character to s1
			int insert = 1 + editDistanceMemoization(s1, s2, index1, index2 - 1, dp);
			// replace current character of s1 with current character of s2
			int replace = 1 + editDistanceMemoization(s1, s2, index1 - 1, index2 - 1, dp);
			// take minimum of all three operations
			return dp[index1][index2] = Math.min(remove,
					Math.min(insert, replace));
		}
	}
	
	public static int editDistanceTabulation(String s1, String s2) {

		int dp[][] = new int[s1.length() + 1][s2.length() + 1];

		//if s2 is exhausted(deletions needed)
		for (int index1 = 0; index1 <= s1.length(); index1++) {
			dp[index1][0] = index1;
		}

		//if s1 is exhausted (insertions needed)
		for (int index2 = 0; index2 <= s2.length(); index2++) {
			dp[0][index2] = index2;
		}

		for (int index1 = 1; index1 <= s1.length(); index1++) {
			for (int index2 = 1; index2 <= s2.length(); index2++) {
				// if both characters are same then don't need to do anything
				if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1)) {
					dp[index1][index2] = dp[index1 - 1][index2 - 1];
				} else {
					// remove current character from s1
					int remove = 1 + dp[index1 - 1][index2];
					// insert current character to s1
					int insert = 1 + dp[index1][index2 - 1];
					// replace current character of s1 with current character of s2
					int replace = 1 + dp[index1 - 1][index2 - 1];
					// take minimum of all three operations
					dp[index1][index2] = Math.min(remove, Math.min(insert, replace));
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}
	
	public static int editDistanceSpaceOptimization(String s1, String s2) {

		int prev[] = new int[s2.length() + 1];

		//if s1 is exhausted (insertions needed)
		for (int index2 = 0; index2 <= s2.length(); index2++) {
			prev[index2] = index2;
		}

		for (int index1 = 1; index1 <= s1.length(); index1++) {
			int [] current = new int[s2.length()+1];
			//s2 is exhausted then we need index1 deletions 
			current[0] = index1;
			for (int index2 = 1; index2 <= s2.length(); index2++) {
				// if both characters are same then don't need to do anything
				if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1)) {
					current[index2] = prev[index2 - 1];
				} else {
					// remove current character from s1
					int remove = 1 + prev[index2];
					// insert current character to s1
					int insert = 1 + current[index2 - 1];
					// replace current character of s1 with current character of s2
					int replace = 1 + prev[index2 - 1];
					// take minimum of all three operations
					current[index2] = Math.min(remove, Math.min(insert, replace));
				}
			}
			prev = current;
		}
		return prev[s2.length()];
	}
	
	public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";

        // Test editDistanceRecursion method
        int countRecursion = editDistanceRecursion(word1, word2);
        System.out.println("Edit distance (Recursion): " + countRecursion);

        // Test editDistanceMemoization method
        int countMemoization = editDistanceMemoization(word1, word2);
        System.out.println("Edit distance (Memoization): " + countMemoization);

        // Test editDistanceTabulation method
        int countTabulation = editDistanceTabulation(word1, word2);
        System.out.println("Edit distance (Tabulation): " + countTabulation);

        // Test editDistanceSpaceOptimization method
        int countSpaceOptimization = editDistanceSpaceOptimization(word1, word2);
        System.out.println("Edit distance (Space Optimization): " + countSpaceOptimization);
    }
}

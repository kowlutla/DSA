/**
 * 	Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
	For Example:
	ab: Number of insertions required is 1. bab or aba
	aa: Number of insertions required is 0. aa
	abcd: Number of insertions required is 3. dcbabcd
	
	
	Example 1:
	
	Input: str = "abcd"
	Output: 3
	Explanation: Inserted character marked
	with bold characters in dcbabcd
	Example 2:
	
	Input: str = "aa"
	Output: 0
	Explanation:"aa" is already a palindrome.
 */
package com.dsa.dynamic_programming;

/**
 * @author KowlutlaSwamy
 *
 */
public class FormPalindrome {

    // Method to count the minimum number of insertions required to form a palindrome from the given string
    public static int countMin(String str) {
        // Reverse the given string to find its longest palindromic subsequence
        String rev = new StringBuffer(str).reverse().toString();
        // Find the length of the longest common subsequence between the string and its reverse
        int lcs = longestCommonSubSequence(str, rev);
        // The minimum number of insertions required is equal to the length of the string minus the length of its longest palindromic subsequence
        return str.length() - lcs;
    }

    // Method to find the length of the longest common subsequence between two strings
    private static int longestCommonSubSequence(String s1, String s2) {
        // Create a 2D array to store the lengths of the common subsequences
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];

        // Initialize the first row and column of the DP table with zeros
        for (int index1 = 0; index1 <= s1.length(); index1++) {
            dp[index1][0] = 0;
        }

        for (int index2 = 0; index2 <= s2.length(); index2++) {
            dp[0][index2] = 0;
        }

        // Fill the DP table using a bottom-up approach
        for (int index1 = 1; index1 <= s1.length(); index1++) {
            for (int index2 = 1; index2 <= s2.length(); index2++) {
                if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1)) {
                    // If characters match, increment the length of the common subsequence by 1
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                } else {
                    // If characters don't match, take the maximum length of common subsequence from the previous row or column
                    dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
                }
            }
        }

        // Return the length of the longest common subsequence
        return dp[s1.length()][s2.length()];
    }
    
    public static void main(String[] args) {
        // Example input
        String str = "abcde";

        // Call the countMin method to find the minimum number of insertions required to form a palindrome
        int minInsertions = FormPalindrome.countMin(str);

        // Print the minimum number of insertions required
        System.out.println("Minimum number of insertions required to form a palindrome: " + minInsertions);
    }
}

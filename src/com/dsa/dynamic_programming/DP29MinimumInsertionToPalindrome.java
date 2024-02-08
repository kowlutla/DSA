/**
 * 	Given a string s. In one step you can insert any character at any index of the string.
	Return the minimum number of steps to make s palindrome.
	A Palindrome String is one that reads the same backward as well as forward.
	
	Example 1:
	Input: s = "zzazz"
	Output: 0
	Explanation: The string "zzazz" is already palindrome we do not need any insertions.

	Example 2:
	Input: s = "mbadm"
	Output: 2
	Explanation: String can be "mbdadbm" or "mdbabdm".

	Example 3:
	Input: s = "leetcode"
	Output: 5
	Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 */
package com.dsa.dynamic_programming;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP29MinimumInsertionToPalindrome {

    // Method to find the minimum number of insertions required to make 's' a palindrome
    public static int minInsertions(String s) {
        // Number of insertions required is equal to the length of 's' minus the length of the longest palindromic subsequence in 's'
        return s.length() - longestCommonPalindrome(s);
    }

    // Method to find the length of the longest palindromic subsequence
    private static int longestCommonPalindrome(String s) {
        // Find the longest common subsequence between 's' and its reverse
        return lcs(s, new StringBuffer(s).reverse().toString());
    }

    // Helper method to find the length of the longest common subsequence between two strings
    private static int lcs(String s1, String s2) {
        // Create a DP table to store the lengths of the common subsequences
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

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
                    dp[index1][index2] = Math.max(dp[index1][index2 - 1], dp[index1 - 1][index2]);
                }
            }
        }

        // Return the length of the longest common subsequence
        return dp[s1.length()][s2.length()];
    }
    
    public static void main(String[] args) {
        // Example input
        String s = "leetcode";
        // Find the minimum number of insertions required to make 's' a palindrome
        int minInsertions = minInsertions(s);
        // Print the minimum number of insertions required
        System.out.println("Minimum Insertions Required: " + minInsertions);
    }
}

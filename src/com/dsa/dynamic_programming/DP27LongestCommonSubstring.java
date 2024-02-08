/**
 * 	Given two strings. The task is to find the length of the longest common substring.

	Example 1:
	Input: S1 = "ABCDGH", S2 = "ACDGHR", n = 6, m = 6
	Output: 4
	Explanation: The longest common substring
	is "CDGH" which has length 4.
	
	Example 2:
	Input: S1 = "ABC", S2 "ACB", n = 3, m = 3
	Output: 1
	Explanation: The longest common substrings
	are "A", "B", "C" all having length 1.
 */
package com.dsa.dynamic_programming;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP27LongestCommonSubstring {

    // Tabulation approach to find the length of the longest common substring
    public static int longestCommonSubstrTabulation(String s1, String s2, int n, int m) {
        // Create a DP table
        int[][] dp = new int[n + 1][m + 1];

        // Initialize the first row and column of the DP table with zeros
        for (int index1 = 0; index1 <= n; index1++) {
            dp[index1][0] = 0;
        }

        for (int index2 = 0; index2 <= m; index2++) {
            dp[0][index2] = 0;
        }

        // Variable to store the length of the longest common substring
        int ans = 0;

        // Fill the DP table using a bottom-up approach
        for (int index1 = 1; index1 <= n; index1++) {
            for (int index2 = 1; index2 <= m; index2++) {
                if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1)) {
                    // If characters match, increment the length of common substring by 1
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                    // Update the maximum length of common substring found so far
                    ans = Math.max(ans, dp[index1][index2]);
                } else {
                    // If characters don't match, reset the length of common substring to 0
                    dp[index1][index2] = 0;
                }
            }
        }
        return ans; // Return the length of the longest common substring
    }

    // Space-optimized approach to find the length of the longest common substring
    public static int longestCommonSubstrSpaceOptimization(String s1, String s2, int n, int m) {
        // Create an array to store the previous row of the DP table
        int[] prev = new int[m + 1];

        // Initialize the first row of the DP table with zeros
        for (int index2 = 0; index2 <= m; index2++) {
            prev[index2] = 0;
        }

        // Variable to store the length of the longest common substring
        int ans = 0;

        // Fill the DP table using a bottom-up approach with space optimization
        for (int index1 = 1; index1 <= n; index1++) {
            // Create a new array to store the current row of the DP table
            int[] current = new int[m + 1];
            for (int index2 = 1; index2 <= m; index2++) {
                if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1)) {
                    // If characters match, increment the length of common substring by 1
                    current[index2] = 1 + prev[index2 - 1];
                    // Update the maximum length of common substring found so far
                    ans = Math.max(ans, current[index2]);
                } else {
                    // If characters don't match, reset the length of common substring to 0
                    current[index2] = 0;
                }
            }
            // Update the previous row for the next iteration
            prev = current;
        }
        return ans; // Return the length of the longest common substring
    }
    
    public static void main(String[] args) {
        // Example inputs
        String s1 = "ABABC";
        String s2 = "BABCA";

        // Find the length of the longest common substring using tabulation
        int lcsTabulation = longestCommonSubstrTabulation(s1, s2, s1.length(), s2.length());
        
        // Find the length of the longest common substring using space optimization
        int lcsSpaceOptimization = longestCommonSubstrSpaceOptimization(s1, s2, s1.length(), s2.length());

        // Print the lengths of the longest common substring
        System.out.println("Length of Longest Common Substring (Tabulation): " + lcsTabulation);
        System.out.println("Length of Longest Common Substring (Space Optimization): " + lcsSpaceOptimization);
    }
}

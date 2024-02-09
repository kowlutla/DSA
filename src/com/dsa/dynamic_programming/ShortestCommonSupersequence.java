/**
 * 	Given two strings X and Y of lengths m and n respectively, find the length of the smallest string which has both, X and Y as its sub-sequences.
	Note: X and Y can have both uppercase and lowercase letters.
	
	Example 1
	Input:
	X = abcd, Y = xycd
	Output: 6
	Explanation: Shortest Common Supersequence
	would be abxycd which is of length 6 and
	has both the strings as its subsequences.

	Example 2
	Input:
	X = efgh, Y = jghi
	Output: 6
	Explanation: Shortest Common Supersequence
	would be ejfghi which is of length 6 and
	has both the strings as its subsequences.
 */
package com.dsa.dynamic_programming;

/**
 * @author KowlutlaSwamy
 *
 */
public class ShortestCommonSupersequence {
	//Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
       return m+n-longestCommonSubSequence(X, Y);
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
        String X = "AGGTAB";
        String Y = "GXTXAYB";

        // Call the shortestCommonSupersequence method to find the length of the shortest common supersequence
        int shortestSupersequenceLength = shortestCommonSupersequence(X, Y, X.length(), Y.length());

        // Print the length of the shortest common supersequence
        System.out.println("Length of shortest common supersequence: " + shortestSupersequenceLength);
    }
}

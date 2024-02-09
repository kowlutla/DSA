/**
 * 	Minimum Number of Deletions and Insertions/Delete Operation for Two Strings/Minimum number of deletions and insertions
 	
 	You are given 2 non-empty strings 's1' and 's2' consisting of lowercase English alphabets only.
	In one operation you can do either of the following on 's1':
	(1) Remove a character from any position in 's1'.
	(2) Add a character to any position in 's1'.
	
	Find the minimum number of operations required to convert string 's1' into 's2'.
	Example:
	Input: 's1' = "abcd", 's2' = "anc"
	Output: 3
	
	Explanation:
	Here, 's1' = "abcd", 's2' = "anc".
	In one operation remove 's1[3]', after this operation 's1' becomes "abc".    
	In the second operation remove 's1[1]', after this operation 's1' becomes "ac".
	In the third operation add 'n' in 's1[1]', after this operation 's1' becomes "anc".
	Hence, the minimum operations required will be 3. It can be shown that there's no way to convert s1 into s2 in less than 3 moves.
 */
package com.dsa.dynamic_programming;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP30MinimumNumberOfDeletionsAndInsertions {

    // Method to find the minimum number of deletions and insertions required to transform s1 into s2
    public static int canYouMake(String s1, String s2) {
        // Find the length of the longest common subsequence between s1 and s2
        int lcs = longestCommonSubSequence(s1, s2);
        // The minimum number of deletions and insertions required is equal to the total length of s1 and s2 minus twice the length of the longest common subsequence
        return s1.length() - lcs + s2.length() - lcs;
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
        // Example inputs
        String s1 = "heap";
        String s2 = "pea";

        // Call the canYouMake method to find the minimum number of deletions and insertions required
        int minOperations = DP30MinimumNumberOfDeletionsAndInsertions.canYouMake(s1, s2);

        // Print the minimum number of deletions and insertions required
        System.out.println("Minimum Number of Deletions and Insertions Required: " + minOperations);
    }
}

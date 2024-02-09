/**
 * 	Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. 
 	If there are multiple valid strings, return any of them.

	A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) 
	results in the string s.
	
	Example 1:
	Input: str1 = "abac", str2 = "cab"
	Output: "cabac"
	Explanation: 
	str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
	str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
	The answer provided is the shortest such string that satisfies these properties.

	Example 2:
	Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
	Output: "aaaaaaaa"
 */
package com.dsa.dynamic_programming;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP31ShortestCommonSupersequence {

    public static String shortestCommonSupersequence(String str1, String str2) {
        // Create a 2D array to store the lengths of the common subsequences
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        // Initialize the first row and column of the DP table with zeros
        for (int index1 = 0; index1 <= str1.length(); index1++) {
            dp[index1][0] = 0;
        }
        for (int index2 = 0; index2 <= str2.length(); index2++) {
            dp[0][index2] = 0;
        }

        // Fill the DP table using a bottom-up approach
        for (int index1 = 1; index1 <= str1.length(); index1++) {
            for (int index2 = 1; index2 <= str2.length(); index2++) {
                if (str1.charAt(index1 - 1) == str2.charAt(index2 - 1)) {
                    // If characters match, increment the length of the common subsequence by 1
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                } else {
                    // If characters don't match, take the maximum length of common subsequence from the previous row or column
                    dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
                }
            }
        }

        // Traverse the DP table to construct the shortest common supersequence
        int index1 = str1.length();
        int index2 = str2.length();
        StringBuffer result = new StringBuffer();
        while (index1 > 0 && index2 > 0) {
            if (str1.charAt(index1 - 1) == str2.charAt(index2 - 1)) {
                // If characters match, append one of them to the result and move diagonally up-left
                result.append(str1.charAt(index1 - 1));
                index1--;
                index2--;
            } else if (dp[index1 - 1][index2] > dp[index1][index2 - 1]) {
                // If the length of the subsequence from str1 is greater than that from str2, append the character from str1 to the result and move up
                result.append(str1.charAt(index1 - 1));
                index1--;
            } else {
                // If the length of the subsequence from str2 is greater than that from str1, append the character from str2 to the result and move left
                result.append(str2.charAt(index2 - 1));
                index2--;
            }
        }

        // Add the remaining characters of str1 to the result
        while (index1 > 0) {
            result.append(str1.charAt(index1 - 1));
            index1--;
        }

        // Add the remaining characters of str2 to the result
        while (index2 > 0) {
            result.append(str2.charAt(index2 - 1));
            index2--;
        }

        // Reverse the result to get the correct order of characters
        return result.reverse().toString();
    }
    
    public static void main(String[] args) {
        // Example input strings
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";

        // Call the shortestCommonSupersequence method to find the shortest common supersequence
        String shortestSupersequence = shortestCommonSupersequence(str1, str2);

        // Print the shortest common supersequence
        System.out.println("Shortest common supersequence: " + shortestSupersequence);
    }
}

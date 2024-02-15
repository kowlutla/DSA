/**
 * 	You are given an array of words where each word consists of lowercase English letters.
	wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.

	For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
	A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
	Return the length of the longest possible word chain with words chosen from the given list of words.
	
	Example 1:
	Input: words = ["a","b","ba","bca","bda","bdca"]
	Output: 4
	Explanation: One of the longest word chains is ["a","ba","bda","bdca"].

	Example 2:
	Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
	Output: 5
	Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].

	Example 3:
	Input: words = ["abcd","dbqca"]
	Output: 1
	Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
	["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed.
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP45LongestStringChain {

    /**
     * This method finds the length of the longest string chain in an array of words.
     *
     * @param words An array of strings representing the words to consider.
     * @return The length of the longest string chain that can be formed using these words.
     */
    public static int longestStrChain(String[] words) {
        // Get the number of words.
        int N = words.length;

        // Sort the words in ascending order of length for efficient comparison.
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());

        // Create an array to store the length of the longest chain ending at each word.
        int[] dp = new int[N];

        // Initialize all values in the dp array to 1, assuming each word forms a chain of length 1 initially.
        Arrays.fill(dp, 1);
        
        int[] hash = new int[N];
        int lastIndex = 0;

        // Keep track of the maximum chain length found so far.
        int max = 1;

        // Iterate through each word in the sorted array.
        for (int current = 0; current < N; current++) {
        	hash[current] = current;
            // Iterate through all previous words.
            for (int prev = 0; prev < current; prev++) {
                // Check if the current word can be formed by removing one character from the previous word.
                if (isPossible(words[current], words[prev]) && dp[prev] + 1 > dp[current]) {
                    // If possible and it results in a longer chain, update the dp value for the current word.
                    dp[current] = dp[prev] + 1;
                    hash[current] = prev;
                }
            }

            // Update the maximum chain length if the current word has a longer chain ending at it.
            if (dp[current] > max) {
                max = dp[current];
                lastIndex = current;
            }
        }
        
        StringBuffer sb = new StringBuffer();
        sb.append(words[hash[lastIndex]]);
        while(hash[lastIndex]!=lastIndex) {
        	lastIndex = hash[lastIndex];
        	sb.append(" >- ").append(words[lastIndex]);
        }
        
        System.out.println(sb.reverse());

        // Return the maximum chain length found.
        return max;
    }

    /**
     * This method checks if one string can be formed by removing one character from another string.
     *
     * @param s1 The first string.
     * @param s2 The second string.
     * @return True if s1 can be formed by removing one character from s2, False otherwise.
     */
    private static boolean isPossible(String s1, String s2) {
        // Check if the length difference isn't exactly 1, it's impossible then.
        if (s1.length() != s2.length() + 1) {
            return false;
        }

        // Use pointers to compare characters in both strings efficiently.
        int first = 0, second = 0;

        // Iterate through both strings simultaneously.
        while (first < s1.length()) {
            // If characters match, move both pointers.
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                // If they don't match, skip one character in s1 only.
                first++;
            }
        }

        // Return true if all characters in s1 were processed and corresponding characters in s2 were either matched or skipped.
        return first == s1.length() && second == s2.length();
    }

    // Main method to test the code with an example
    public static void main(String[] args) {
        String[] words = {"a","b","ba","bca","bda","bdca"};
        int length = longestStrChain(words);
        System.out.println("Length of longest string chain: " + length);
    }
}

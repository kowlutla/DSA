/**
 *  Given a string s, partition s such that every substring of the partition is a 
	palindrome. Return all possible palindrome partitioning of s.

	Example 1:
	Input: s = "aab"
	Output: [["a","a","b"],["aa","b"]]

	Example 2:
	Input: s = "a"
	Output: [["a"]]
 */
package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> currentList = new ArrayList<>();
        int index = 0;
        partition(s, index, currentList, result);
        return result;
    }

    // Recursive method to partition the string into palindromic substrings
    private void partition(String s, int index, List<String> currentList,
                           List<List<String>> result) {

        // Base case: if index reaches end of string, add the current partitioning to the result
        if (index == s.length()) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        // Check for all possible palindromic substrings starting from the current index
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                currentList.add(s.substring(index, i + 1)); // Add palindromic substring to current partition
                partition(s, i + 1, currentList, result); // Recur for the rest of the string
                currentList.remove(currentList.size() - 1); // Backtrack: remove the last added substring
            }
        }
    }

    // Helper method to check if a substring is a palindrome
    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    // Main method for demonstration
    public static void main(String[] args) {
        PalindromePartitioning partitioning = new PalindromePartitioning();

        // Define the input string
        String inputString = "abcdcba";

        // Obtain and print all possible palindromic partitions of the input string
        List<List<String>> partitions = partitioning.partition(inputString);
        System.out.println("All possible palindromic partitions of " + inputString + ":");
        for (List<String> partition : partitions) {
            System.out.println(partition);
        }
    }
}

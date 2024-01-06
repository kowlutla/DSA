/**
 * 	Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

	Only numbers 1 through 9 are used.
	Each number is used at most once.
	Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
	
	Example 1:
	Input: k = 3, n = 7
	Output: [[1,2,4]]
	Explanation:
	1 + 2 + 4 = 7
	There are no other valid combinations.

	Example 2:
	Input: k = 3, n = 9
	Output: [[1,2,6],[1,3,5],[2,3,4]]
	Explanation:
	1 + 2 + 6 = 9
	1 + 3 + 5 = 9
	2 + 3 + 4 = 9
	There are no other valid combinations.

	Example 3:
	Input: k = 4, n = 1
	Output: []
	Explanation: There are no valid combinations.
	Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 */
package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIIISolution2 {

    // Method to find combinations of k numbers that add up to n
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> currentList = new ArrayList<>();
        int max = 9;
        int current = 1;
        combinationSum3(k, n, max, current, currentList, result); // Call helper method
        return result;
    }

    // Helper method to find combinations recursively
    private void combinationSum3(int k, int n, int max, int current,
                                 ArrayList<Integer> currentList,
                                 List<List<Integer>> result) {

        if (k == 0) { // If k numbers are selected
            if (n == 0) { // If the sum is reached
                result.add(new ArrayList<>(currentList)); // Add the combination to result
            }
            return;
        }

        if (n < 0) { // If n becomes negative
            return;
        }

        for (int i = current; i <= max; i++) {
            currentList.add(i); // Add the number to the current combination
            // Recursively find combinations with reduced k, reduced n, and next index
            combinationSum3(k - 1, n - i, max, i + 1, currentList, result);
            currentList.remove(currentList.size() - 1); // Backtrack by removing the last element
        }
    }

    // Main method to demonstrate finding combinations
    public static void main(String[] args) {
        CombinationSumIIISolution2 solution = new CombinationSumIIISolution2();
        int k = 5; // Number of elements in each combination
        int n = 30; // Target sum

        List<List<Integer>> combinations = solution.combinationSum3(k, n); // Find combinations
        
        // Display the found combinations
        System.out.println("Combinations of " + k + " elements that sum up to " + n + ":");
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}

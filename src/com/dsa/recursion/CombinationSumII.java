/**
 * 	Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
	Each number in candidates may only be used once in the combination.
	Note: The solution set must not contain duplicate combinations.
	
	Example 1:
	
	Input: candidates = [10,1,2,7,6,1,5], target = 8
	Output: 
	[
	[1,1,6],
	[1,2,5],
	[1,7],
	[2,6]
	]
	Example 2:
	
	Input: candidates = [2,5,2,1,2], target = 5
	Output: 
	[
	[1,2,2],
	[5]
	]
 */
package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	
	public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        // Sorting the candidates array to ensure ascending order
        Arrays.sort(candidates);

        // Initializing the result list to store combinations
        List<List<Integer>> result = new ArrayList<>();

        // Initializing variables: index, currentList
        int index = 0;
        ArrayList<Integer> currentList = new ArrayList<>();

        // Initiating the recursive combinationSum2 method
        combinationSum3(candidates, target, index, currentList, result);

        // Returning the resultant combinations
        return result;
    }

    private void combinationSum3(int[] candidates, int target, int index,
                                 List<Integer> currentList, List<List<Integer>> result) {
        // Base cases: If target becomes negative, or target becomes zero
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        // Loop through candidates
        for (int i = index; i < candidates.length; i++) {
            // Avoid duplicates
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
			if (candidates[i] > target)
				break;
            
            // Add current candidate to the combination list
            currentList.add(candidates[i]);
            // Recursive call with reduced target and updated index
            combinationSum3(candidates, target - candidates[i], i + 1, currentList, result);
            // Backtrack: Remove the last added element to try other combinations
            currentList.remove(currentList.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Sorting the candidates array to ensure ascending order
        Arrays.sort(candidates);

        // Initializing the result list to store combinations
        List<List<Integer>> result = new ArrayList<>();

        // Initializing variables: index, currentList, and currentSum
        int index = 0;
        ArrayList<Integer> currentList = new ArrayList<>();
        int currentSum = 0;

        // Initiating the recursive combinationSum2 method
        combinationSum2(candidates, target, currentSum, index, currentList, result);

        // Returning the resultant combinations
        return result;
    }

    // Recursive method to find combinations that sum up to the target
    private void combinationSum2(int[] candidates, int target, int currentSum,
                                  int index, ArrayList<Integer> currentList,
                                  List<List<Integer>> result) {

        // Base case: If current sum exceeds the target sum, return
        if (currentSum > target) {
            return;
        }

        // Base case: If current sum equals the target sum, add currentList to the result
        if (currentSum == target) {
            if (!result.contains(currentList)) {
                result.add(new ArrayList<>(currentList));
            }
            return;
        }

        // Base case: If all elements are traversed or sum exceeds target, return
        if (index == candidates.length) {
            if (currentSum == target) {
                if (!result.contains(currentList)) {
                    result.add(new ArrayList<>(currentList));
                }
            }
            return;
        }

        // Include the current element in the sum and recursion
        currentSum += candidates[index];
        currentList.add(candidates[index]);
        combinationSum2(candidates, target, currentSum, index + 1, currentList, result);

        // Backtrack: Remove the current element and continue recursion without it
        currentSum -= candidates[index];
        currentList.remove(currentList.size() - 1);
        combinationSum2(candidates, target, currentSum, index + 1, currentList, result);
    }
    
    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();

        // Example candidates array and target sum
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int targetSum = 8;

        // Finding combinations that sum up to the targetSum
        List<List<Integer>> result = combinationSumII.combinationSum2(candidates, targetSum);

        // Displaying the resultant combinations
        System.out.println("Combinations that sum up to " + targetSum + ": ");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}

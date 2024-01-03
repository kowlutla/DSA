/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. 
 * You may return the combinations in any order.

	The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
	frequency of at least one of the chosen numbers is different.
	
	The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
	
	Example 1:
	
	Input: candidates = [2,3,6,7], target = 7
	Output: [[2,2,3],[7]]
	Explanation:
	2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
	7 is a candidate, and 7 = 7.
	These are the only two combinations.
	Example 2:
	
	Input: candidates = [2,3,5], target = 8
	Output: [[2,2,2,2],[2,3,3],[3,5]]
	Example 3:
	
	Input: candidates = [2], target = 1
	Output: []
 */
package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KowlutlaSwamy
 *
 */
public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Initializing the result list to store combinations
        List<List<Integer>> result = new ArrayList<>();

        // Initializing variables: index, currentSum, and currentList
        int index = 0, currentSum = 0;
        ArrayList<Integer> currentList = new ArrayList<>();

        // Initiating the recursive combinationSum method
        combinationSum(candidates, currentSum, currentList, index, result, target);

        // Returning the resultant combinations
        return result;
    }

    // Recursive method to find combinations that sum up to the target
    private void combinationSum(int[] candidates, int currentSum, ArrayList<Integer> currentList,
                                int index, List<List<Integer>> result, int target) {
        // Base case: If the current sum exceeds the target sum, return
        if (currentSum > target) {
            return;
        }
        
        //current sum matches the target sum, add currentList to result
        if(currentSum==target) {
        	result.add(new ArrayList<Integer>(currentList));
        	return;
        }

        // Base case: If all elements are traversed and current sum matches the target sum, add currentList to result
        if (index == candidates.length) {
            if (currentSum == target) {
                result.add(new ArrayList<>(currentList));
            }
            return;
        }

        // Including the current element in the sum if it doesn't exceed the target
        if (candidates[index] + currentSum <= target) {
            currentSum += candidates[index];
            currentList.add(candidates[index]);

            // Recursive call including the current element
            combinationSum(candidates, currentSum, currentList, index, result, target);

            // Backtracking by removing the last added element and adjusting the sum
            currentList.remove(currentList.size() - 1);
            currentSum -= candidates[index];
        }

        // Moving to the next element in candidates array
        combinationSum(candidates, currentSum, currentList, index + 1, result, target);
    }

    // Example main method to demonstrate usage
    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 12;
        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);
        System.out.println("Combinations that sum up to " + target + ": " + result);
    }
}

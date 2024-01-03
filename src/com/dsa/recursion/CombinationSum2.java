/**
 * Given an array of integers and a sum B, find all unique combinations in the array where the sum is equal to B. The same number may be chosen from the array any number of times to make B.
	Note:
        1. All numbers will be positive integers.
        2. Elements in a combination (a1, a2, …, ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
        3. The combinations themselves must be sorted in ascending order.

	Example 1:
	
	Input:
	N = 4
	arr[] = {7,2,6,5}
	B = 16
	Output:
	(2 2 2 2 2 2 2 2)
	(2 2 2 2 2 6)
	(2 2 2 5 5)
	(2 2 5 7)
	(2 2 6 6)
	(2 7 7)
	(5 5 6)
	Example 2:
	
	Input:
	N = 11
	arr[] = {6,5,7,1,8,2,9,9,7,7,9}
	B = 6
	Output:
	(1 1 1 1 1 1)
	(1 1 1 1 2)
	(1 1 2 2)
	(1 5)
	(2 2 2)
	(6)

 */
package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CombinationSum2 {

    // Static method to find combinations that sum up to 'sum'
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int sum) {
        // Initializing the result list to store combinations
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // Removing duplicates by using a HashSet and sorting the array list
        HashSet<Integer> set = new HashSet<>(arr);
        arr = new ArrayList<>(set);
        Collections.sort(arr);

        // Initializing variables: currentList to store current combination
        ArrayList<Integer> currentList = new ArrayList<>();

        // Initiating the recursive combinationSum method
        combinationSum(arr, sum, currentList, 0, result);

        // Returning the resultant combinations
        return result;
    }

    // Recursive method to find combinations that sum up to the target
    private static void combinationSum(ArrayList<Integer> arr, int sum,
                                       ArrayList<Integer> currentList, int index,
                                       ArrayList<ArrayList<Integer>> result) {

        // Base case: If sum becomes negative, return
        if (sum < 0) {
            return;
        }

        // Base case: If sum becomes zero, add currentList to the result
        if (sum == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        // Base case: If all elements are traversed or sum becomes zero, return
        if (index == arr.size()) {
            if (sum == 0) {
                result.add(new ArrayList<>(currentList));
            }
            return;
        }

        // Include the current element in the sum if it doesn't exceed the target
        if (arr.get(index) <= sum) {
            currentList.add(arr.get(index));
            combinationSum(arr, sum - arr.get(index), currentList, index, result);
            currentList.remove(currentList.size() - 1);
        }

        // Move to the next element in the array
        combinationSum(arr, sum, currentList, index + 1, result);
    }
    
    public static void main(String[] args) {

        // Example ArrayList and target sum
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        arr.add(6);
        arr.add(7);
        int targetSum = 12;

        // Finding combinations that sum up to the targetSum
        ArrayList<ArrayList<Integer>> result = combinationSum(arr, targetSum);

        // Displaying the resultant combinations
        System.out.println("Combinations that sum up to " + targetSum + ": ");
        for (ArrayList<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}

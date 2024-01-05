/**
 * 	You are given an integer array nums that may contain duplicates. Your task is to return all possible subsets. 
 * Return only unique subsets and they can be in any order.

	Note: The individual subsets should be sorted.
	
	Example:
	
	Input: 
	nums = [1,2,2] 
	Output: 
	[[],[1],[1,2],[1,2,2],[2],[2,2]]
	Explanation: 
	We can have subsets ranging from length 0 to 3. which are listed above.
	 Also the subset [1,2] appears twice but is printed only once as we require only unique subsets.
 */
package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetII {
    
    // Method to generate unique subsets
    public static ArrayList<ArrayList<Integer>> printUniqueSubsets(int[] nums) {
        Arrays.sort(nums); // Sort the input array
        int index = 0;
        ArrayList<ArrayList<Integer>> results = new ArrayList<>(); // Initialize results list
        ArrayList<Integer> currentList = new ArrayList<>(); // Initialize current subset list
        printUniqueSubsets(nums, index, currentList, results); // Call helper method
        return results;
    }
    
    // Helper method to generate unique subsets recursively
    private static void printUniqueSubsets(int[] nums, int index, ArrayList<Integer> currentList, ArrayList<ArrayList<Integer>> results){
        results.add(new ArrayList<>(currentList)); // Add current subset to the results
        
        // Iterate through the array elements starting from the given index
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i - 1]) continue; // Skip duplicates
            
            currentList.add(nums[i]); // Include the current element in the subset
            printUniqueSubsets(nums, i + 1, currentList, results); // Recursively explore subsets
            currentList.remove(currentList.size() - 1); // Backtrack to explore other subsets
        }
    }

    // Main method to demonstrate generating unique subsets
    public static void main(String[] args) {
        int[] nums = {5,6,5,4,3,2,3}; // Example input array
        
        // Generate unique subsets
        ArrayList<ArrayList<Integer>> uniqueSubsets = printUniqueSubsets(nums);
        
        // Display the generated unique subsets
        System.out.println("Unique Subsets:");
        for (ArrayList<Integer> subset : uniqueSubsets) {
            System.out.println(subset);
        }
    }
}


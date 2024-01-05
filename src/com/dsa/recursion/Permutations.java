/**
 * 	Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

	Example 1:
	Input: nums = [1,2,3]
	Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

	Example 2:
	Input: nums = [0,1]
	Output: [[0,1],[1,0]]

	Example 3:
	Input: nums = [1]
	Output: [[1]]
 */
package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    
    // Method to generate permutations of the given array
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // Initialize the result list
        boolean[] map = new boolean[nums.length]; // Keep track of used elements
        ArrayList<Integer> currentList = new ArrayList<>(); // Initialize current permutation list
        permute(nums, map, currentList, result); // Call the helper method
        return result;
    }

    // Helper method to generate permutations recursively
    private void permute(int[] nums, boolean[] map, ArrayList<Integer> currentList, List<List<Integer>> result) {
        if (currentList.size() == nums.length) { // If current permutation is complete
            result.add(new ArrayList<>(currentList)); // Add the permutation to the result
            return;
        }
        
        // Explore permutations by trying different elements
        for (int i = 0; i < nums.length; i++) {
            if (!map[i]) { // Check if the element is unused
                currentList.add(nums[i]); // Include the element in the permutation
                map[i] = true; // Mark the element as used
                permute(nums, map, currentList, result); // Recursively generate permutations
                currentList.remove(currentList.size() - 1); // Backtrack to explore other permutations
                map[i] = false; // Reset the element as unused for the next iteration
            }
        }
    }

    // Main method to demonstrate generating permutations
    public static void main(String[] args) {
        int[] nums = {1, 2, 3}; // Example input array
        
        Permutations permutationGenerator = new Permutations(); // Create an instance of Permutations class
        List<List<Integer>> permutations = permutationGenerator.permute(nums); // Generate permutations
        
        // Display the generated permutations
        System.out.println("Permutations:");
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}

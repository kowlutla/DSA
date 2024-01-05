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

public class Permutations2 {

    // Method to generate permutations of the given array
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // Initialize the result list
        int index = 0; // Start index for permutations
        permute(nums, index, result); // Call the helper method
        return result; // Return the generated permutations
    }

    // Helper method to generate permutations recursively using swaps
    private void permute(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) { // If reached the end of array
            ArrayList<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list); // Add the generated permutation to the result list
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index); // Swap elements to explore different permutations
            permute(nums, index + 1, result); // Recursively generate permutations
            swap(nums, i, index); // Backtrack by restoring the original order
        }
    }

    // Utility method to swap elements in the array
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    // Main method to demonstrate generating permutations
    public static void main(String[] args) {
        Permutations2 permutationGenerator = new Permutations2(); // Create an instance of Permutations2 class
        int[] nums = {1, 2, 3}; // Example input array
        
        List<List<Integer>> permutations = permutationGenerator.permute(nums); // Generate permutations
        
        // Display the generated permutations
        System.out.println("Permutations:");
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}

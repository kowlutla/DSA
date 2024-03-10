/**
 * 	Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
	You may assume that each input would have exactly one solution, and you may not use the same element twice.
	You can return the answer in any order.
	
	Example 1:
	Input: nums = [2,7,11,15], target = 9
	Output: [0,1]
	Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
	
	Example 2:
	Input: nums = [3,2,4], target = 6
	Output: [1,2]
	
	Example 3:
	Input: nums = [3,3], target = 6
	Output: [0,1]
	 
 */
package com.dsa.arrays;

import java.util.HashMap;

public class A13PairSum2 {

    /**
     * Finds the indices of the two numbers in an array that add up to a given target sum (brute force).
     * Time complexity: O(N^2) due to nested loops iterating through all possible pairs.
     * Space complexity: O(1) as it uses constant extra space for variables (i, j).
     *
     * @param nums   The array containing integer elements.
     * @param target The target sum to find a pair for.
     * @return An array of two integers representing the indices of the pair (empty array if not found).
     */
    public static int[] twoSum1(int[] nums, int target) {

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j}; // Found the pair, return their indices
                }
            }
        }

        return new int[]{}; // No pair found with the target sum
    }

    /**
     * Finds the indices of the two numbers in an array that add up to a given target sum using a HashMap.
     * Time complexity: O(N) as it iterates through the array once.
     * Space complexity: O(N) due to the HashMap potentially storing up to N elements with their indices.
     *
     * @param nums   The array containing integer elements.
     * @param target The target sum to find a pair for.
     * @return An array of two integers representing the indices of the pair (empty array if not found).
     */
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Stores elements and their indices
        int n = nums.length;

        for (int index = 0; index < n; index++) {
            if (map.containsKey(target - nums[index])) { // Check if the complement to form the target sum exists in the map
                return new int[]{index, map.get(target - nums[index])}; // Found a complement, return indices
            } else {
                map.put(nums[index], index); // Store the current element and its index
            }
        }

        return new int[]{}; // No pair found with the target sum
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] indices1 = twoSum1(nums, target);
        int[] indices2 = twoSum2(nums, target);

        if (indices1.length > 0) {
            System.out.println("Indices of the pair using twoSum1: [" + indices1[0] + ", " + indices1[1] + "]");
        } else {
            System.out.println("No pair found using twoSum1");
        }

        if (indices2.length > 0) {
            System.out.println("Indices of the pair using twoSum2: [" + indices2[0] + ", " + indices2[1] + "]");
        } else {
            System.out.println("No pair found using twoSum2");
        }
    }
}

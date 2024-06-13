/**
 * 	Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

	Notice that the solution set must not contain duplicate triplets.
	
	Example 1:
	Input: nums = [-1,0,1,2,-1,-4]
	Output: [[-1,-1,2],[-1,0,1]]
	Explanation: 
	nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
	nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
	nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
	The distinct triplets are [-1,0,1] and [-1,-1,2].
	Notice that the order of the output and the order of the triplets does not matter.

	Example 2:
	Input: nums = [0,1,1]
	Output: []
	Explanation: The only possible triplet does not sum up to 0.
	Example 3:
	
	Input: nums = [0,0,0]
	Output: [[0,0,0]]
	Explanation: The only possible triplet sums up to 0.
 */
package com.dsa.arrays;

/**
 * @author KowlutlaSwamy
 *
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A28ThreeSumProblem {

    /**
     * Method 1: Brute-force approach to find all unique triplets in the array that sum up to zero.
     * This method uses three nested loops to check all possible triplets and stores them in a set to avoid duplicates.
     *
     * Time Complexity: O(N^3)
     * Space Complexity: O(N)
     *
     * @param nums the input array
     * @return a list of all unique triplets that sum up to zero
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        // Iterate over all triplets using three nested loops
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Check if the sum of the current triplet equals zero
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                        Collections.sort(triplet);
                        set.add(triplet); // Add sorted triplet to the set to avoid duplicates
                    }
                }
            }
        }

        return new ArrayList<>(set); // Convert set to list and return
    }

    /**
     * Method 2: Optimized approach using a HashSet to find all unique triplets that sum up to zero.
     * This method iterates through each element and uses a HashSet to check for the complement of the current pair.
     *
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     *
     * @param nums the input array
     * @return a list of all unique triplets that sum up to zero
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        // Iterate through each element of the array
        for (int i = 0; i < n; i++) {
            HashSet<Integer> temp = new HashSet<>();
            // For each element, check for the other two elements that form the triplet
            for (int j = i + 1; j < n; j++) {
                // Check if the complement exists in the HashSet
                if (temp.contains(-(nums[i] + nums[j]))) {
                    List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[j], -(nums[i] + nums[j])));
                    Collections.sort(triplet); // Sort the triplet to avoid duplicates
                    set.add(triplet); // Add the triplet to the set
                }
                temp.add(nums[j]); // Add the current element to the HashSet
            }
        }

        return new ArrayList<>(set); // Convert set to list and return
    }

    /**
     * Method 3: Efficient approach using sorting and two-pointer technique to find all unique triplets that sum up to zero.
     * This method sorts the array and then uses the two-pointer technique to find the triplets.
     *
     * Time Complexity: O(N^2)
     * Space Complexity: O(1) excluding the space required for the output list
     *
     * @param nums the input array
     * @return a list of all unique triplets that sum up to zero
     */
    public List<List<Integer>> threeSum3(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // Sort the array to use the two-pointer technique
        List<List<Integer>> result = new ArrayList<>();

        // Iterate through each element and use two-pointer technique to find the triplet
        for (int index = 0; index < n; index++) {
            // Skip duplicate elements
            if (index == 0 || nums[index] != nums[index - 1]) {
                int left = index + 1; // Left pointer starts after the current element
                int right = n - 1; // Right pointer starts at the end of the array

                while (left < right) {
                    int sum = nums[index] + nums[left] + nums[right]; // Calculate the sum of the triplet
                    if (sum == 0) {
                        // Triplet found
                        result.add(Arrays.asList(nums[index], nums[left], nums[right]));
                        left++;
                        right--;

                        // Skip duplicate elements
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum < 0) {
                        left++; // Move left pointer to the right to increase the sum
                    } else {
                        right--; // Move right pointer to the left to decrease the sum
                    }
                }
            }
        }

        return result; // Return the list of unique triplets
    }
}

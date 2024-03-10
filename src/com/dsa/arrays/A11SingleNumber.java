/**
 * 	Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
	You must implement a solution with a linear runtime complexity and use only constant extra space.
	
	Example 1:
	Input: nums = [2,2,1]
	Output: 1
	
	Example 2:
	Input: nums = [4,1,2,1,2]
	Output: 4
	
	Example 3:
	Input: nums = [1]
	Output: 1
	
	Constraints:
	
	1 <= nums.length <= 3 * 104
	-3 * 104 <= nums[i] <= 3 * 104
	Each element in the array appears twice except for one element which appears only once.
 */
package com.dsa.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KowlutlaSwamy
 *
 */
public class A11SingleNumber {

    /**
     * Finds the single number in a non-empty array where all other elements appear twice using a HashMap.
     * Time complexity: O(N) - iterates through the array once and potentially iterates through the HashMap entries.
     * Space complexity: O(N) - uses a HashMap to store the elements and their frequencies.
     *
     * @param nums The input array containing numbers with one number appearing once and others appearing twice.
     * @return The single number that appears only once.
     */
    public int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, 2); // Mark as occurring twice
            } else {
                map.put(num, 1); // Mark as first occurrence
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) { // Find the entry with a count of 1
                return entry.getKey();
            }
        }

        return -1; // If no single number found, return -1
    }

    /**
     * Finds the single number in a non-empty array where all other elements appear twice using XOR.
     * Time complexity: O(N) - iterates through the array once.
     * Space complexity: O(1) - uses constant extra space for the `xor` variable.
     *
     * @param nums The input array containing numbers with one number appearing once and others appearing twice.
     * @return The single number that appears only once.
     */
    public int singleNumber2(int[] nums) {
        int xor = 0; // XOR with 0 doesn't change the value
        for (int num : nums) {
            xor ^= num; // XOR each element with the accumulated XOR
        }
        return xor; // The final XOR result is the single number
    }

    // Main method for testing
    public static void main(String[] args) {
        A11SingleNumber obj = new A11SingleNumber();

        int[] nums = {4, 1, 2, 1, 2};

        int singleNumber1 = obj.singleNumber1(nums);
        int singleNumber2 = obj.singleNumber2(nums);

        System.out.println("Single number using HashMap: " + singleNumber1);
        System.out.println("Single number using XOR: " + singleNumber2);
    }
}

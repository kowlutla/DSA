/**
 *	You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

	You should return the array of nums such that the the array follows the given conditions:
	
	Every consecutive pair of integers have opposite signs.
	For all integers with the same sign, the order in which they were present in nums is preserved.
	The rearranged array begins with a positive integer.
	Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
	
	Example 1:
	Input: nums = [3,1,-2,-5,2,-4]
	Output: [3,-2,1,-5,2,-4]
	Explanation:
	The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
	The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
	Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.  

	Example 2:
	Input: nums = [-1,1]
	Output: [1,-1]
	Explanation:
	1 is the only positive integer and -1 the only negative integer in nums.
	So nums is rearranged to [1,-1].
	  
 */
package com.dsa.arrays;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class A18RearrangeArrayElementsBySign {

    /**
     * Rearranges the elements of the given array in alternating positive and negative signs, starting with a positive number.
     *
     * @param nums The input array
     * @return The rearranged array
     *
     * Time complexity: O(n) - Iterates through the array twice
     * Space complexity: O(n) - Uses extra arrays for positive and negative numbers
     */
    public static int[] rearrangeArray1(int[] nums) {
        int n = nums.length;

        // Create arrays to store positive and negative numbers separately
        int[] pos = new int[n / 2];
        int[] neg = new int[n / 2];

        // Separate positive and negative numbers into their respective arrays
        int negIndex = 0;
        int posIndex = 0;
        for (int num : nums) {
            if (num > 0) {
                pos[posIndex++] = num;
            } else {
                neg[negIndex++] = num;
            }
        }

        // Interleave positive and negative numbers back into the original array
        posIndex = 0;
        negIndex = 0;
        for (int i = 0; i < n; i = i + 2) {
            nums[i] = pos[posIndex++];
            nums[i + 1] = neg[negIndex++];
        }

        return nums;
    }

    /**
     * Rearranges the elements of the given array in alternating positive and negative signs, starting with a positive number.
     *
     * @param nums The input array
     * @return The rearranged array
     *
     * Time complexity: O(n) - Iterates through the array once
     * Space complexity: O(n) - Creates a new array for the rearranged elements
     */
    public static int[] rearrangeArray2(int[] nums) {
        int posIndex = 0;  // Index for positive numbers in the result array
        int negIndex = 1;  // Index for negative numbers in the result array
        int[] result = new int[nums.length];  // Array to store the rearranged elements

        for (int num : nums) {
            if (num > 0) {
                result[posIndex] = num;
                posIndex += 2;
            } else {
                result[negIndex] = num;
                negIndex += 2;
            }
        }

        return result;
    }

    // Main method for demonstration
    public static void main(String[] args) {
        int[] nums = {3, 1, -2, -5, 2, -4};

        // Using rearrangeArray1
        int[] rearranged1 = rearrangeArray1(nums.clone()); // Clone the array to avoid modifying the original
        System.out.println("Rearranged array using method 1: " + Arrays.toString(rearranged1));

        // Using rearrangeArray2
        int[] rearranged2 = rearrangeArray2(nums.clone());
        System.out.println("Rearranged array using method 2: " + Arrays.toString(rearranged2));
    }
}

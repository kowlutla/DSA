/**
 * 	Given a binary array nums, return the maximum number of consecutive 1's in the array.

	Example 1:
	Input: nums = [1,1,0,1,1,1]
	Output: 3
	Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

	Example 2:
	Input: nums = [1,0,1,1,0,1]
	Output: 2
 */
package com.dsa.arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class A10MaxConsecutiveOnes1 {

    /**
     * Finds the maximum number of consecutive ones in a binary array.
     * Time complexity: O(N) - iterates through the input array once.
     * Space complexity: O(1) - uses constant extra space for variables (maxZeros and count).
     *
     * @param nums The input binary array.
     * @return The maximum number of consecutive ones.
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxZeros = 0; // Stores the max consecutive ones found so far
        int count = 0;   // Stores the current consecutive ones count

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++; // Increment count if current element is 1
                maxZeros = Math.max(maxZeros, count); // Update maxZeros if current count is higher
            } else {
                count = 0; // Reset count if current element is 0
            }
        }

        return maxZeros;
    }

    // Main method for testing
    public static void main(String[] args) {
        A10MaxConsecutiveOnes1 obj = new A10MaxConsecutiveOnes1();

        int[] array1 = {1, 1, 0, 0, 1, 1};
        int[] array2 = {1};
        int[] array3 = {0};

        int maxOnes1 = obj.findMaxConsecutiveOnes(array1);
        int maxOnes2 = obj.findMaxConsecutiveOnes(array2);
        int maxOnes3 = obj.findMaxConsecutiveOnes(array3);

        System.out.println("Max consecutive ones in {1, 1, 0, 0, 1, 1}: " + maxOnes1);
        System.out.println("Max consecutive ones in {1}: " + maxOnes2);
        System.out.println("Max consecutive ones in {0}: " + maxOnes3);
    }
}

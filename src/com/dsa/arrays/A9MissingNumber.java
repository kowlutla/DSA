/**
 * 	Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

	Example 1:
	Input: nums = [3,0,1]
	Output: 2
	Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

	Example 2:
	Input: nums = [0,1]
	Output: 2
	Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

	Example 3:
	Input: nums = [9,6,4,2,3,5,7,0,1]
	Output: 8
	Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
	 
 */
package com.dsa.arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class A9MissingNumber {

    /**
     * Finds the missing number in a sequence of 1 to N using XOR (exclusive OR) operator.
     * Time complexity: O(N) - iterates through the expected sequence and the input array once.
     * Space complexity: O(1) - uses constant extra space for the xor variable.
     *
     * @param nums The input array containing the sequence with a missing number.
     * @return The missing number in the sequence.
     */
    public int missingNumber1(int[] nums) {
        int xor = 0;
        for (int i = 1; i <= nums.length; i++) {
            xor ^= i; // XOR expected number (1 to N)
        }

        for (int num : nums) {
            xor ^= num; // XOR actual numbers in the array
        }

        return xor;
    }

    /**
     * Finds the missing number by calculating the expected sum and subtracting the actual sum.
     * Time complexity: O(N) - iterates through the expected sequence and the input array once.
     * Space complexity: O(1) - uses constant extra space for sum variables.
     *
     * @param nums The input array containing the sequence with a missing number.
     * @return The missing number in the sequence.
     */
    public int missingNumber2(int[] nums) {
        int totalSum = 0;
        for (int i = 1; i <= nums.length; i++) {
            totalSum += i; // Calculate expected sum (1 to N)
        }

        int arrSum = 0;
        for (int num : nums) {
            arrSum += num; // Calculate actual sum of the array
        }

        return totalSum - arrSum;
    }

    /**
     * Finds the missing number using a formula for the expected sum and subtracting the actual sum.
     * Time complexity: O(N) - iterates through the input array once.
     * Space complexity: O(1) - uses constant extra space for sum variables.
     *
     * @param nums The input array containing the sequence with a missing number.
     * @return The missing number in the sequence.
     */
    public int missingNumber3(int[] nums) {
        int n = nums.length;
        int totalSum = (n * (n + 1)) / 2; // Calculate expected sum using formula

        int arrSum = 0;
        for (int num : nums) {
            arrSum += num; // Calculate actual sum of the array
        }

        return totalSum - arrSum;
    }

    /**
     * Finds the missing number by creating a counting array and checking for a missing count (0).
     * Time complexity: O(N) - iterates through the input array twice (once for counting and once for checking).
     * Space complexity: O(N) - uses an additional counting array.
     *
     * @param nums The input array containing the sequence with a missing number.
     * @return The missing number in the sequence.
     */
    public int missingNumber4(int[] nums) {
        int n = nums.length;
        int count[] = new int[n + 1]; // Counting array to track occurrences

        for (int num : nums) {
            count[num]++; // Increment count for each number
        }

        for (int i = 1; i <= n; i++) {
            if (count[i] == 0) {
                return i; // Missing number has a count of 0
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        A9MissingNumber obj = new A9MissingNumber(); // Create an object of A9MissingNumber class

        // Example usage of all methods
        int[] array = {0, 1, 2, 4}; // Input array with a missing number (2)

        int missingNumber1 = obj.missingNumber1(array);
        int missingNumber2 = obj.missingNumber2(array);
        int missingNumber3 = obj.missingNumber3(array);
        int missingNumber4 = obj.missingNumber4(array);

        System.out.println("Missing number using XOR (method 1): " + missingNumber1);
        System.out.println("Missing number using sum calculation (method 2): " + missingNumber2);
        System.out.println("Missing number using sum formula (method 3): " + missingNumber3);
        System.out.println("Missing number using counting array (method 4): " + missingNumber4);
    }
}
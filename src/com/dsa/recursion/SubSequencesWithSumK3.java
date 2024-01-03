/**
 * Count all subsequences with sum is equal to K
 */
package com.dsa.recursion;

/**
 * @author KowlutlaSwamy
 *
 */
public class SubSequencesWithSumK3 {

    // Modulo value for calculations
    int mod = 1000000007;

    // Method to initiate the recursive calculation
    public int perfectSum1(int arr[], int n, int sum) {
        return perfectSum(arr, 0, sum, 0); // Initiating the recursive function
    }

    // Recursive method to calculate the count of subsequences
    public int perfectSum(int[] arr, int index, int sum, int currentSum) {
        // Base case: If the current sum exceeds the target sum, return 0
        if (currentSum > sum) {
            return 0;
        }
        // Base case: If all elements are traversed and current sum matches the target sum, return 1, else return 0
        if (index == arr.length) {
            if (currentSum == sum) {
                return 1;
            } else {
                return 0;
            }
        }
        // Recursive calls: One includes the current element and the other excludes it
        int left = perfectSum(arr, index + 1, sum, currentSum + arr[index]) % mod; // Consider current element
        int right = perfectSum(arr, index + 1, sum, currentSum) % mod; // Exclude current element
        // Returning the sum of counts of subsequences that include or exclude the current element
        return (left + right) % mod;
    }
    
    public static void main(String[] args) {
        // Example array and target sum
        int[] arr = {2, 4, 5, 3, 1, 7};
        int targetSum = 10;

        // Creating an instance of SubSequencesWithSumK3 class
        SubSequencesWithSumK3 sequenceCounter = new SubSequencesWithSumK3();

        // Calculating the count of subsequences that sum up to the targetSum
        int count = sequenceCounter.perfectSum1(arr, arr.length, targetSum);

        // Displaying the count of such subsequences
        System.out.println("Count of subsequences with sum " + targetSum + ": " + count);
    }
}

/**
 *
 *	Given an array arr and target sum k, check whether there exists a subsequence such that the sum of all elements in the subsequence equals the given target sum(k).

	Example:
	
	Input:  arr = [10,1,2,7,6,1,5], k = 8.
	Output:  Yes
	Explanation:  Subsequences like [2, 6], [1, 7] sum upto 8
	
	Input:  arr = [2,3,5,7,9], k = 100. 
	Output:  No
	Explanation:  No subsequence can sum upto 100 
 */
package com.dsa.recursion;

/**
 * @author KowlutlaSwamy
 *
 */
public class SubsequenceWithSumK {

    // Method to check if there exists a subsequence with the sum equal to K
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        // Call the helper method 'checkSubsequenceSum' to perform the check
        return checkSubsequenceSum(arr, 0, K);
    }

    // Recursive helper method to explore subsequence combinations
    private static boolean checkSubsequenceSum(int[] arr, int index, int K) {
        // If the index reaches the end of the array or K becomes negative, no subsequence found
        if (index == arr.length) {
        	// If K becomes zero, a subsequence with the sum 'K' is found
            if (K == 0) {
                return true;
            }else {
            	return false;
            }
        }
        // Include the current element in the subsequence and recursively check for the remaining elements and sum
        if (checkSubsequenceSum(arr, index + 1, K - arr[index])) {
            return true;
        }
        // Exclude the current element and move to the next element in the array
        if (checkSubsequenceSum(arr, index + 1, K)) {
            return true;
        }
        // If neither condition matches, return false
        return false;
    }

    // Main method to demonstrate the subsequence check
    public static void main(String[] args) {
        // Example usage to check for a subsequence sum
        int[] arr = {2, 4, 8, 3};
        int K = 13;

        // Check if there exists a subsequence with sum 'K' in the given array
        boolean existsSubsequenceSumK = checkSubsequenceSum(arr.length, arr, K);

        // Display the result along with the value of K
        if (existsSubsequenceSumK) {
            System.out.println("A subsequence with sum " + K + " exists in the array.");
        } else {
            System.out.println("No subsequence with sum " + K + " exists in the array.");
        }
    }
}

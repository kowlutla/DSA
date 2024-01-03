/**
 * Print all subsequences whose sum equal to K
 */
package com.dsa.recursion;

import java.util.ArrayList;

/**
 * @author KowlutlaSwamy
 *
 */
public class SubsequencesWithSumK2 {

    public static void main(String[] args) {
        // Example usage to find subsequences with a given sum
    	int[] arr = {2, 4, 5, 3, 1, 7};
        int K = 10;

        // Find subsequences with sum 'K' and store the results
        ArrayList<ArrayList<Integer>> results = printSubSequencesWithSumK(arr, K);

        // Display results
        if (results.isEmpty()) {
            System.out.println("No Subsequences found with sum " + K);
        } else {
            System.out.println("SubSequences with Sum " + K + " are: ");
            results.forEach(list -> System.out.println(list));
        }
    }

    /**
     * Method to find subsequences with the given sum 'K'
     */
    public static ArrayList<ArrayList<Integer>> printSubSequencesWithSumK(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> currentList = new ArrayList<>();
        int currentSum = 0;
        int index = 0;
        printSubSequencesWithSumK(arr, k, currentList, currentSum, index, result);
        return result;
    }

    /**
     * Recursive helper method to find subsequences with the given sum 'K'
     */
    private static void printSubSequencesWithSumK(int[] arr, int k, ArrayList<Integer> currentList,
                                                  int currentSum, int index, ArrayList<ArrayList<Integer>> result) {
        // If the end of the array is reached, check if currentSum equals 'K'
        if (index == arr.length) {
            if (currentSum == k) {
                result.add(new ArrayList<Integer>(currentList)); // Add the current subsequence to the result
            }
            return;
        }

        // Include the current element in the subsequence and continue recursion
        currentList.add(arr[index]);
        printSubSequencesWithSumK(arr, k, currentList, currentSum + arr[index], index + 1, result);

        // Exclude the current element and continue recursion
        currentList.remove(currentList.size() - 1);
        printSubSequencesWithSumK(arr, k, currentList, currentSum, index + 1, result);
    }
}

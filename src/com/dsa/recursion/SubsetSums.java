/**
 * 	Given a list arr of N integers, return sums of all subsets in it.
	
	Example 1:
	Input:
	N = 2
	arr[] = {2, 3}
	Output:
	0 2 3 5
	Explanation:
	When no elements is taken then Sum = 0.
	When only 2 is taken then Sum = 2.
	When only 3 is taken then Sum = 3.
	When element 2 and 3 are taken then 
	Sum = 2+3 = 5.

	Example 2:
	Input:
	N = 3
	arr = {5, 2, 1}
	Output:
	0 1 2 3 5 6 7 8
 */
package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSums {
    // Method to calculate subset sums of the given array
    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> result = new ArrayList<>();
        int currentSum = 0;
        int currentIndex = 0;
        subsetSums(arr, N, currentIndex, currentSum, result); // Call helper method
        return result;
    }

    // Helper method to calculate subset sums recursively
    private static void subsetSums(ArrayList<Integer> arr, int N,
                                   int currentIndex, int currentSum, ArrayList<Integer> result) {
        // If the end of the array is reached, add the currentSum to the result
        if (currentIndex == N) {
            result.add(currentSum);
            return;
        }

        // Include the current element in the sum and continue recursion
        subsetSums(arr, N, currentIndex + 1, currentSum + arr.get(currentIndex), result);

        // Exclude the current element and continue recursion
        subsetSums(arr, N, currentIndex + 1, currentSum, result);
    }

    // Main method to demonstrate finding subset sums
    public static void main(String[] args) {
        // Example usage to find subset sums
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);

        int N = arr.size();

        // Calculate subset sums
        ArrayList<Integer> subsetSums = subsetSums(arr, N);
        Collections.sort(subsetSums);
        // Display the subset sums
        System.out.println("Subset Sums:");
        for (Integer sum : subsetSums) {
            System.out.println(sum);
        }
    }
}

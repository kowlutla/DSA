/**
 * 	Given an array arr of size n and an integer X. Find if there's a triplet in the array which sums up to the given integer X.

	Example 1:
	Input:
	n = 6, X = 13
	arr[] = [1 4 45 6 10 8]
	Output:
	1
	Explanation:
	The triplet {1, 4, 8} in 
	the array sums up to 13.

	Example 2:
	Input:
	n = 5, X = 10
	arr[] = [1 2 4 3 6]
	Output:
	1
	Explanation:
	The triplet {1, 3, 6} in 
	the array sums up to 10.
 */
package com.dsa.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class A27TripletSumInArray {

    /**
     * Method 1: Brute-force approach to find if there exists a triplet in the array that sums up to X.
     * This method uses three nested loops to check all possible triplets.
     * 
     * Time Complexity: O(N^3)
     * Space Complexity: O(1)
     * 
     * @param A the input array
     * @param n the size of the array
     * @param X the target sum
     * @return true if a triplet with sum X is found, otherwise false
     */
    public static boolean find3Numbers1(int A[], int n, int X) {
        // Iterate over all triplets using three nested loops
        for (int index1 = 0; index1 < n; index1++) {
            for (int index2 = index1 + 1; index2 < n; index2++) {
                for (int index3 = index2 + 1; index3 < n; index3++) {
                    // Check if the sum of the current triplet equals X
                    if (A[index1] + A[index2] + A[index3] == X) {
                        return true;
                    }
                }
            }
        }
        return false; // No triplet found
    }

    /**
     * Method 2: Optimized approach using a HashSet to find a triplet with sum X.
     * This method iterates through each element and uses a HashSet to check for the complement.
     * 
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     * 
     * @param A the input array
     * @param n the size of the array
     * @param X the target sum
     * @return true if a triplet with sum X is found, otherwise false
     */
    public static boolean find3Numbers2(int A[], int n, int X) {
        // Iterate through each element of the array
        for (int index1 = 0; index1 < n; index1++) {
            HashSet<Integer> set = new HashSet<>();
            // For each element, check for the other two elements that form the triplet
            for (int index2 = index1 + 1; index2 < n; index2++) {
                // Check if the complement exists in the HashSet
                if (set.contains(X - (A[index1] + A[index2]))) {
                    return true;
                }
                set.add(A[index2]);
            }
        }
        return false; // No triplet found
    }

    /**
     * Method 3: Efficient approach using sorting and two-pointer technique.
     * This method sorts the array and then uses two pointers to find a triplet with sum X.
     * 
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     * 
     * @param A the input array
     * @param n the size of the array
     * @param X the target sum
     * @return true if a triplet with sum X is found, otherwise false
     */
    public static boolean find3Numbers3(int A[], int n, int X) {
        Arrays.sort(A); // Sort the array
        // Iterate through each element and use two-pointer technique to find the triplet
        for (int index = 0; index < n; index++) {
            int left = index + 1; // Left pointer starts after the current element
            int right = n - 1;   // Right pointer starts at the end of the array

            while (left < right) {
                int sum = A[index] + A[left] + A[right]; // Calculate the sum of the triplet
                if (sum == X) {
                    return true; // Triplet found
                } else if (sum < X) {
                    left++; // Move left pointer to the right to increase the sum
                } else {
                    right--; // Move right pointer to the left to decrease the sum
                }
            }
        }
        return false; // No triplet found
    }
}

/**
 * 
 */
package com.dsa.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP43LengthOfLISUsingBinarySearch {

    /**
     * This method finds the length of the longest increasing subsequence (LIS) in an array using binary search.
     * 
     * @param arr The input array.
     * @return The length of the LIS in the array.
     */
    public static int longestIncreasingSubsequence(int[] arr) {
        // Create an empty list to store the increasing subsequence (LIS)
        List<Integer> list = new ArrayList<>();
        // Add the first element of the array to the list as it is always part of the LIS
        list.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            // Check if the current element is greater than the last element in the list
            if (arr[i] > list.get(list.size() - 1)) {
                // If it is, simply add it to the end of the list
                list.add(arr[i]);
            } else {
                // Otherwise, we need to find the position where the current element should be inserted to maintain the increasing order
                // Use binary search to find the lower bound of the element in the list
                int lowerBoundIndex = lowerBound(list, 0, list.size() - 1, arr[i]);
                // Update the element at the lower bound index with the current element
                list.set(lowerBoundIndex, arr[i]);
            }
        }

        // Return the size of the list, which is the length of the LIS
        return list.size();
    }

    /**
     * This method implements binary search to find the lower bound of an element in a sorted list.
     * 
     * @param list The sorted list.
     * @param low The starting index of the search.
     * @param high The ending index of the search.
     * @param key The element to search for.
     * @return The index of the lower bound of the element in the list.
     */
    private static int lowerBound(List<Integer> list, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If the element is found at the middle, return its index
            if (list.get(mid) == key) {
                return mid;
            } else if (list.get(mid) > key) {
                // If the element is smaller than the middle element, search in the left half
                high = mid - 1;
            } else {
                // If the element is larger than the middle element, search in the right half
                low = mid + 1;
            }
        }

        // If the element is not found, return the index where it should be inserted (low)
        return low;
    }

    // Main method to test the code
    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int length = longestIncreasingSubsequence(arr);
        System.out.println("Length of LIS: " + length);
    }
}

/**
 * 
 */
package com.dsa.sorting;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class MergeSort implements SortingAlgorithm {
	
	// Main method for testing the merge sort in increasing and decreasing order
    public static void main(String[] args) {
        // Creating an instance of MergeSort class
        MergeSort mergeSort = new MergeSort();

        // Generating and sorting array in increasing order
        int[] arr1 = SortingAlgorithm.getIntegerArray(); // Generating an array of random integers
        System.out.println("\nBefore Sorting: \n" + Arrays.toString(arr1)); // Displaying the array before sorting
        mergeSort.sortIncreasingOrder(arr1); // Sorting the array in increasing order
        System.out.println("\nAfter Sorting: \n" + Arrays.toString(arr1)); // Displaying the array after sorting

        System.out.println("\n===============================================\n");

        // Generating and sorting array in decreasing order
        int[] arr2 = SortingAlgorithm.getIntegerArray(); // Generating another array of random integers
        System.out.println("\nBefore Sorting: \n" + Arrays.toString(arr2)); // Displaying the array before sorting
        mergeSort.sortDecresingOrder(arr2); // Sorting the array in decreasing order
        System.out.println("\nAfter Sorting: \n" + Arrays.toString(arr2)); // Displaying the array after sorting
    }

 // Method to sort the array in increasing order
    @Override
    public void sortIncreasingOrder(int[] arr) {
        System.out.println("\nSorting integers in increasing order using " + this.getClass().getSimpleName());
        // Initiates the merge sort in increasing order
        mergeSortInc(arr, 0, arr.length - 1);
    }

    /**
     * Recursive function to sort the array in increasing order
     * @param arr The array to be sorted
     * @param start The starting index of the range
     * @param end The ending index of the range
     */
    private void mergeSortInc(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            // Divides the array into smaller parts
            mergeSortInc(arr, start, mid);
            mergeSortInc(arr, mid + 1, end);
            // Merges the divided parts in increasing order
            mergeInc(arr, start, mid, end);
        }
    }

    /**
     * Merges two sorted halves of the array in increasing order
     * @param arr The array to be merged
     * @param start The starting index of the first half
     * @param mid The middle index
     * @param end The ending index of the second half
     */
    private void mergeInc(int[] arr, int start, int mid, int end) {
        int temp[] = new int[end - start + 1];
        int first = start;
        int second = mid + 1;
        int index = 0;
        while (first <= mid && second <= end) {
            // Compares elements and merges in increasing order
            if (arr[first] <= arr[second]) {
                temp[index++] = arr[first++];
            } else {
                temp[index++] = arr[second++];
            }
        }
        // Adds remaining elements from the first half
        while (first <= mid) {
            temp[index++] = arr[first++];
        }
        // Adds remaining elements from the second half
        while (second <= end) {
            temp[index++] = arr[second++];
        }
        // Copies sorted elements back to the original array
        for (int i = start; i <= end; i++) {
            arr[i] = temp[i - start];
        }
    }

    // Method to sort the array in decreasing order
    @Override
    public void sortDecresingOrder(int[] arr) {
    	System.out.println("\nSorting integers in decreasing order using "+this.getClass().getSimpleName());
        // Initiates the merge sort in decreasing order
        mergeDesc(arr, 0, arr.length - 1);
    }

    /**
     * Recursive function to sort the array in decreasing order
     * @param arr The array to be sorted
     * @param start The starting index of the range
     * @param end The ending index of the range
     */
    private void mergeDesc(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            // Divides the array into smaller parts
            mergeDesc(arr, start, mid);
            mergeDesc(arr, mid + 1, end);
            // Merges the divided parts in decreasing order
            mergeDesc(arr, start, mid, end);
        }
    }

    /**
     * Merges two sorted halves of the array in decreasing order
     * @param arr The array to be merged
     * @param start The starting index of the first half
     * @param mid The middle index
     * @param end The ending index of the second half
     */
    private void mergeDesc(int[] arr, int start, int mid, int end) {
        int temp[] = new int[end - start + 1];
        int first = start;
        int second = mid + 1;
        int index = 0;
        while (first <= mid && second <= end) {
            // Compares elements and merges in decreasing order
            if (arr[first] >= arr[second]) {
                temp[index++] = arr[first++];
            } else {
                temp[index++] = arr[second++];
            }
        }
        // Adds remaining elements from the first half
        while (first <= mid) {
            temp[index++] = arr[first++];
        }
        // Adds remaining elements from the second half
        while (second <= end) {
            temp[index++] = arr[second++];
        }
        // Copies sorted elements back to the original array
        for (int i = start; i <= end; i++) {
            arr[i] = temp[i - start];
        }
    }
}

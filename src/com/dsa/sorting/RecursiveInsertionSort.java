/**
 * 
 */
package com.dsa.sorting;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class RecursiveInsertionSort implements SortingAlgorithm {
	
	// Main method for testing the recursive insertion sort in increasing and decreasing order
    public static void main(String[] args) {
        // Creating an instance of RecursiveInsertionSort class
        RecursiveInsertionSort recursiveInsertionSort = new RecursiveInsertionSort();

        // Generating and sorting array in increasing order
        int[] arr1 = SortingAlgorithm.getIntegerArray(); // Generating an array of random integers
        System.out.println("\nBefore Sorting: \n" + Arrays.toString(arr1)); // Displaying the array before sorting
        recursiveInsertionSort.sortIncreasingOrder(arr1); // Sorting the array in increasing order
        System.out.println("\nAfter Sorting: \n" + Arrays.toString(arr1)); // Displaying the array after sorting

        System.out.println("\n===============================================\n");

        // Generating and sorting array in decreasing order
        int[] arr2 = SortingAlgorithm.getIntegerArray(); // Generating another array of random integers
        System.out.println("\nBefore Sorting: \n" + Arrays.toString(arr2)); // Displaying the array before sorting
        recursiveInsertionSort.sortDecresingOrder(arr2); // Sorting the array in decreasing order
        System.out.println("\nAfter Sorting: \n" + Arrays.toString(arr2)); // Displaying the array after sorting
    }

    @Override
    public void sortIncreasingOrder(int[] arr) {
        // Print a message indicating the sorting order
        System.out.println("\nSorting integers in increasing order using " + this.getClass().getSimpleName());
        // Call the recursive insertion sort method for sorting in increasing order
        recursiveInsertionSortInc(arr, arr.length);
    }

    // Recursive Insertion Sort method for sorting in increasing order
    private void recursiveInsertionSortInc(int[] arr, int length) {
        // Base case: If there's only one element, return (already sorted)
        if (length == 1) {
            return;
        }
        // Recursively sort the first (length - 1) elements
        recursiveInsertionSortInc(arr, length - 1);
        int j = length - 1;
        // Perform insertion sort operation for the last element
        while (j > 0 && arr[j] < arr[j - 1]) {
            // Swap elements if the current element is smaller than the previous one
            int temp = arr[j];
            arr[j] = arr[j - 1];
            arr[j - 1] = temp;
            j--;
        }
    }

    @Override
    public void sortDecresingOrder(int[] arr) {
        // Print a message indicating the sorting order
        System.out.println("\nSorting integers in decreasing order using " + this.getClass().getSimpleName());
        // Call the recursive insertion sort method for sorting in decreasing order
        recursiveInsertionSortDesc(arr, arr.length);
    }

    // Recursive Insertion Sort method for sorting in decreasing order
    private void recursiveInsertionSortDesc(int[] arr, int length) {
        // Base case: If there's only one element, return (already sorted)
        if (length == 1) {
            return;
        }
        // Recursively sort the first (length - 1) elements
        recursiveInsertionSortDesc(arr, length - 1);
        int j = length - 1;
        // Perform insertion sort operation for the last element
        while (j > 0 && arr[j] > arr[j - 1]) {
            // Swap elements if the current element is larger than the previous one
            int temp = arr[j];
            arr[j] = arr[j - 1];
            arr[j - 1] = temp;
            j--;
        }
    }
}

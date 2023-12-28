/**
 * 
 */
package com.dsa.sorting;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class RecursiveBubbleSort implements SortingAlgorithm{

	// Main method for testing the recursive bubble sort in increasing and decreasing order
    public static void main(String[] args) {
        // Creating an instance of RecursiveBubbleSort class
        RecursiveBubbleSort recursiveBubbleSort = new RecursiveBubbleSort();

        // Generating and sorting array in increasing order
        int[] arr1 = SortingAlgorithm.getIntegerArray(); // Generating an array of random integers
        System.out.println("\nBefore Sorting: \n" + Arrays.toString(arr1)); // Displaying the array before sorting
        recursiveBubbleSort.sortIncreasingOrder(arr1); // Sorting the array in increasing order
        System.out.println("\nAfter Sorting: \n" + Arrays.toString(arr1)); // Displaying the array after sorting

        System.out.println("\n===============================================\n");

        // Generating and sorting array in decreasing order
        int[] arr2 = SortingAlgorithm.getIntegerArray(); // Generating another array of random integers
        System.out.println("\nBefore Sorting: \n" + Arrays.toString(arr2)); // Displaying the array before sorting
        recursiveBubbleSort.sortDecresingOrder(arr2); // Sorting the array in decreasing order
        System.out.println("\nAfter Sorting: \n" + Arrays.toString(arr2)); // Displaying the array after sorting
    }
	
    @Override
    public void sortIncreasingOrder(int[] arr) {
        // Print a message indicating the sorting order
        System.out.println("\nSorting integers in increasing order using " + this.getClass().getSimpleName());
        // Call the recursive bubble sort method for sorting in increasing order
        recursiveBubbleSortInc(arr, arr.length);
    }

    // Recursive Bubble Sort method for sorting in increasing order
    private void recursiveBubbleSortInc(int[] arr, int length) {
        // Base case: If there's only one element, return (already sorted)
        if (length == 1) {
            return;
        }
        // Traverse through the array and swap adjacent elements if necessary
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                // Swap elements if the current element is greater than the next one
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        // Recursively call the sort method with a reduced array length
        recursiveBubbleSortInc(arr, length - 1);
    }

    @Override
    public void sortDecresingOrder(int[] arr) {
        // Print a message indicating the sorting order
        System.out.println("\nSorting integers in decreasing order using " + this.getClass().getSimpleName());
        // Call the recursive bubble sort method for sorting in decreasing order
        recursiveBubbleSortDesc(arr, arr.length);
    }

    // Recursive Bubble Sort method for sorting in decreasing order
    private void recursiveBubbleSortDesc(int[] arr, int length) {
        // Base case: If there's only one element, return (already sorted)
        if (length == 1) {
            return;
        }
        // Traverse through the array and swap adjacent elements if necessary
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                // Swap elements if the current element is smaller than the next one
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        // Recursively call the sort method with a reduced array length
        recursiveBubbleSortDesc(arr, length - 1);
    }
}

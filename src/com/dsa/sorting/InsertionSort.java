/**
 * 
 */
package com.dsa.sorting;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class InsertionSort implements SortingAlgorithm {
	
	 // Main method for testing the bubble sort in increasing and decreasing order
    public static void main(String[] args) {
        // Creating an instance of InsertionSort class
        InsertionSort insertionSort = new InsertionSort();

        // Generating and sorting array in increasing order
        int[] arr1 = SortingAlgorithm.getIntegerArray(); // Generating an array of random integers
        System.out.println("\nBefore Sorting: \n" + Arrays.toString(arr1)); // Displaying the array before sorting
        insertionSort.sortIncreasingOrder(arr1); // Sorting the array in increasing order
        System.out.println("\nAfter Sorting: \n" + Arrays.toString(arr1)); // Displaying the array after sorting

        System.out.println("\n===============================================\n");

        // Generating and sorting array in decreasing order
        int[] arr2 = SortingAlgorithm.getIntegerArray(); // Generating another array of random integers
        System.out.println("\nBefore Sorting: \n" + Arrays.toString(arr2)); // Displaying the array before sorting
        insertionSort.sortDecresingOrder(arr2); // Sorting the array in decreasing order
        System.out.println("\nAfter Sorting: \n" + Arrays.toString(arr2)); // Displaying the array after sorting
    }

    @Override
    public void sortIncreasingOrder(int[] arr) {
    	System.out.println("\nSorting integers in increasing order using "+this.getClass().getSimpleName());
        // Sorting integers in increasing order using insertion sort
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {  // Finding correct position for the current element
                int temp = arr[j];  // Swapping the elements
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }

    @Override
    public void sortDecresingOrder(int[] arr) {
    	System.out.println("\nSorting integers in decreasing order using "+this.getClass().getSimpleName());
        // Sorting integers in decreasing order using insertion sort
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] > arr[j - 1]) {  // Finding correct position for the current element
                int temp = arr[j - 1];  // Swapping the elements
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }


}

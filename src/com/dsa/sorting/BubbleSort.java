/**
 * 
 */
package com.dsa.sorting;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class BubbleSort implements SortingAlgorithm {

	 // Main method for testing the selection sort in increasing and decreasing order
    public static void main(String[] args) {
        // Creating an instance of BubbleSort class
        BubbleSort bubbleSort = new BubbleSort();

        // Generating and sorting array in increasing order
        int[] arr1 = SortingAlgorithm.getIntegerArray(); // Generating an array of random integers
        System.out.println("\nBefore Sorting: \n" + Arrays.toString(arr1)); // Displaying the array before sorting
        bubbleSort.sortIncreasingOrder(arr1); // Sorting the array in increasing order
        System.out.println("\nAfter Sorting: \n" + Arrays.toString(arr1)); // Displaying the array after sorting

        System.out.println("\n===============================================\n");

        // Generating and sorting array in decreasing order
        int[] arr2 = SortingAlgorithm.getIntegerArray(); // Generating another array of random integers
        System.out.println("\nBefore Sorting: \n" + Arrays.toString(arr2)); // Displaying the array before sorting
        bubbleSort.sortDecresingOrder(arr2); // Sorting the array in decreasing order
        System.out.println("\nAfter Sorting: \n" + Arrays.toString(arr2)); // Displaying the array after sorting
    }

    @Override
    public void sortIncreasingOrder(int[] arr) {
        // Displaying the sorting process in increasing order
        System.out.println("\nSorting integers in increasing order using " + this.getClass().getSimpleName());

        // Bubble sort algorithm to sort in increasing order
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {  // If current element is greater than the next
                    // Swapping the elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public void sortDecresingOrder(int[] arr) {
        // Displaying the sorting process in decreasing order
        System.out.println("\nSorting integers in decreasing order using " + this.getClass().getSimpleName());

        // Modified bubble sort to sort in decreasing order
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[j + 1]) {  // If current element is less than the next
                    // Swapping the elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}

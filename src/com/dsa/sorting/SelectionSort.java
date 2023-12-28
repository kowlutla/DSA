/**
 * Program that demonstrate the Selection sort
 */
package com.dsa.sorting;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class SelectionSort implements SortingAlgorithm {

    // Main method for testing the selection sort in increasing and decreasing order
    public static void main(String[] args) {
        // Creating an instance of SelectionSort class
        SelectionSort selectionSort = new SelectionSort();

        // Generating and sorting array in increasing order
        int[] arr1 = SortingAlgorithm.getIntegerArray(); // Generating an array of random integers
        System.out.println("\nBefore Sorting: \n" + Arrays.toString(arr1)); // Displaying the array before sorting
        selectionSort.sortIncreasingOrder(arr1); // Sorting the array in increasing order
        System.out.println("\nAfter Sorting: \n" + Arrays.toString(arr1)); // Displaying the array after sorting

        System.out.println("\n===============================================\n");

        // Generating and sorting array in decreasing order
        int[] arr2 = SortingAlgorithm.getIntegerArray(); // Generating another array of random integers
        System.out.println("\nBefore Sorting: \n" + Arrays.toString(arr2)); // Displaying the array before sorting
        selectionSort.sortDecresingOrder(arr2); // Sorting the array in decreasing order
        System.out.println("\nAfter Sorting: \n" + Arrays.toString(arr2)); // Displaying the array after sorting
    }

    // Sorting the array in increasing order using selection sort algorithm
    @Override
    public void sortIncreasingOrder(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            // Finding the minimum element's index in the remaining unsorted portion
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            // Swapping the found minimum element with the first unsorted element
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    // Sorting the array in decreasing order using selection sort algorithm
    @Override
    public void sortDecresingOrder(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int max = i;
            // Finding the maximum element's index in the remaining unsorted portion
            for (int j = i; j < arr.length; j++) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            // Swapping the found maximum element with the first unsorted element
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
        }
    }
}

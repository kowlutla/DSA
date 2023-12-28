/**
 * Program that demonstrate the Selection sort
 */
package com.dsa.sorting;

import java.util.Arrays;
import java.util.Random;

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
        int[] arr1 = getIntegerArray(); // Generating an array of random integers
        System.out.println("\nBefore Sorting: \n" + Arrays.toString(arr1)); // Displaying the array before sorting
        selectionSort.sortIncreasingOrder(arr1); // Sorting the array in increasing order
        System.out.println("\nAfter Sorting: \n" + Arrays.toString(arr1)); // Displaying the array after sorting

        System.out.println("\n===============================================\n");

        // Generating and sorting array in decreasing order
        int[] arr2 = getIntegerArray(); // Generating another array of random integers
        System.out.println("\nBefore Sorting: \n" + Arrays.toString(arr2)); // Displaying the array before sorting
        selectionSort.sortDecresingOrder(arr2); // Sorting the array in decreasing order
        System.out.println("\nAfter Sorting: \n" + Arrays.toString(arr2)); // Displaying the array after sorting
    }

    /**
     * Generate an array of random integers with random size between 10 and 19
     */
    private static int[] getIntegerArray() {
        Random random = new Random(); // Creating an instance of Random class
        int size = random.nextInt(10) + 10; // Generating a random size between 10 and 19
        System.out.println("Size of array is: " + size); // Displaying the size of the array
        int[] arr = new int[size]; // Creating an array with the generated size

        // Filling the array with random integers between 0 and 99
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100); // Assigning a random integer between 0 and 99 to each index
        }
        return arr; // Returning the generated array
    }

    // Sorting the array in increasing order using selection sort algorithm
    @Override
    public void sortIncreasingOrder(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
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
            for (int j = i; j < arr.length; j++) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }

            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
        }
    }
}

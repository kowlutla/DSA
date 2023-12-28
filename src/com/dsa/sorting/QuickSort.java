/**
 * 
 */
package com.dsa.sorting;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class QuickSort implements SortingAlgorithm {
	
	 // Main method for testing the quick sort in increasing and decreasing order
    public static void main(String[] args) {
        // Creating an instance of QuickSort class
        QuickSort quickSort = new QuickSort();

        // Generating and sorting array in increasing order
        int[] arr1 = SortingAlgorithm.getIntegerArray(); // Generating an array of random integers
        System.out.println("\nBefore Sorting: \n" + Arrays.toString(arr1)); // Displaying the array before sorting
        quickSort.sortIncreasingOrder(arr1); // Sorting the array in increasing order
        System.out.println("\nAfter Sorting: \n" + Arrays.toString(arr1)); // Displaying the array after sorting

        System.out.println("\n===============================================\n");

        // Generating and sorting array in decreasing order
        int[] arr2 = SortingAlgorithm.getIntegerArray(); // Generating another array of random integers
        System.out.println("\nBefore Sorting: \n" + Arrays.toString(arr2)); // Displaying the array before sorting
        quickSort.sortDecresingOrder(arr2); // Sorting the array in decreasing order
        System.out.println("\nAfter Sorting: \n" + Arrays.toString(arr2)); // Displaying the array after sorting
    }

    @Override
    public void sortIncreasingOrder(int[] arr) {
        // Print a message indicating the sorting order
        System.out.println("\nSorting integers in increasing order using " + this.getClass().getSimpleName());
        // Call the quicksort method for sorting in increasing order
        quickSortInc(arr, 0, arr.length - 1);
    }

    // Quicksort method for sorting in increasing order
    private void quickSortInc(int[] arr, int start, int end) {
        if (start < end) {
            // Find the partition index
            int partition = partitionInc(arr, start, end);
            // Recursively sort elements before and after partition
            quickSortInc(arr, start, partition - 1);
            quickSortInc(arr, partition + 1, end);
        }
    }

    // Partition method for sorting in increasing order
    private int partitionInc(int[] arr, int start, int end) {
        // Choosing the pivot element (first element in this case)
        int pivot = start;
        int left = start, right = end;
        while (left < right) {
            // Move the left pointer until finding an element greater than the pivot
            while (left < end && arr[left] <= arr[pivot]) {
                left++;
            }
            // Move the right pointer until finding an element smaller than the pivot
            while (right > start && arr[right] > arr[pivot]) {
                right--;
            }
            // Swap elements if the pointers haven't crossed each other
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        // Swap pivot with the element at the right pointer
        int temp = arr[pivot];
        arr[pivot] = arr[right];
        arr[right] = temp;
        return right;
    }

    // Method to sort integers in decreasing order
    @Override
    public void sortDecresingOrder(int[] arr) {
        // Print a message indicating the sorting order
        System.out.println("\nSorting integers in decreasing order using " + this.getClass().getSimpleName());
        // Call the quicksort method for sorting in decreasing order
        quickSortDesc(arr, 0, arr.length - 1);
    }

    // Quicksort method for sorting in decreasing order
    private void quickSortDesc(int[] arr, int start, int end) {
        if (start < end) {
            // Find the partition index
            int partition = partitionDesc(arr, start, end);
            // Recursively sort elements before and after partition
            quickSortDesc(arr, start, partition - 1);
            quickSortDesc(arr, partition + 1, end);
        }
    }

    // Partition method for sorting in decreasing order
    private int partitionDesc(int[] arr, int start, int end) {
        // Choosing the pivot element (last element in this case)
        int pivot = end;
        int left = start, right = end;
        while (left < right) {
            // Move the left pointer until finding an element smaller than the pivot
            while (left < end && arr[left] > arr[pivot]) {
                left++;
            }
            // Move the right pointer until finding an element greater than the pivot
            while (right > start && arr[right] <= arr[pivot]) {
                right--;
            }
            // Swap elements if the pointers haven't crossed each other
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        // Swap pivot with the element at the left pointer
        int temp = arr[pivot];
        arr[pivot] = arr[left];
        arr[left] = temp;
        return left;
    }
}

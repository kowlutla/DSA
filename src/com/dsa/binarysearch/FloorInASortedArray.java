package com.dsa.binarysearch;

/**
 * Given a sorted array arr[] of size N without duplicates, and given a value x.
 * Floor of x is defined as the largest element K in arr[] such that K is
 * smaller than or equal to x. Find the index of K(0-based indexing).
 */
public class FloorInASortedArray {

    // Method to find the index of the largest element K in arr[] such that K is smaller than or equal to x
    static int findFloor(long arr[], int n, long x) {
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == x) { // If the element at mid is equal to x
                return mid; // Return the index of mid
            }
            if (arr[mid] < x) { // If the element at mid is less than x
                start = mid + 1; // Adjust the start index to search in the right half
            } else { // If the element at mid is greater than x
                end = mid - 1; // Adjust the end index to search in the left half
            }
        }
        return end; // Return the index of the element that is the floor of x
    }

    // Main method for demonstration purposes
    public static void main(String[] args) {
        long[] arr = {1, 2, 8, 10, 10, 12, 19};
        long x = 5;
        int n = arr.length;
        System.out.println("The index of the largest element K in arr[] such that K is smaller than or equal to x is: " + findFloor(arr, n, x));
    }
}

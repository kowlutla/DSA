package com.dsa.binarysearch;

/**
 * Given a sorted array arr[] of size N without duplicates, and given a value x.
 * Ceil of x is defined as the smallest element K in arr[] such that K is
 * greater than or equal to x. Find the index of K(0-based indexing).
 */
public class CeilInASortedArray {

    // Method to find the index of the smallest element K in arr[] such that K is larger than or equal to x
    static int findCeil(long arr[], int n, long x) {
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
        return start; // Return the index of the element that is the ceil of x
    }

    // Main method for demonstration purposes
    public static void main(String[] args) {
        long[] arr = {1, 2, 8, 10, 10, 12, 19};
        long x = 5;
        int n = arr.length;
        System.out.println("The index of the smallest element K in arr[] such that K is greater than or equal to x is: " + findCeil(arr, n, x));
    }
}

package com.dsa.arrays;

import java.util.Arrays;

/**
 * Given an array a[ ] of size N. The task is to find the median and mean of the
 * array elements. Mean is the average of the numbers and the median is the
 * element which is smaller than half of the elements and greater than the
 * remaining half. If there are odd elements, the median is simply the middle
 * element in the sorted array. If there are even elements, then the median is
 * the floor of the average of two middle numbers in the sorted array. If the
 * mean is a floating-point number, then we need to print the floor of it.
 */
public class MeanAndMedianOfArray {

    // Function to find the median of the array elements
    public int median(int A[], int N) {
        Arrays.sort(A); // Sort the array

        // Check if the number of elements is odd or even
        if (N % 2 == 1) { // If the number of elements is odd
            return A[(N / 2)]; // Return the middle element
        } else { // If the number of elements is even
            return (A[N / 2] + A[(N / 2) - 1]) / 2; // Return the floor of the average of the two middle numbers
        }
    }

    // Function to find the mean of the array elements
    public int mean(int A[], int N) {
        int sum = 0; // Initialize sum to 0
        for (int num : A) {
            sum += num; // Calculate the sum of the array elements
        }
        return sum / N; // Return the floor of the mean
    }

    // Main method for demonstration purposes
    public static void main(String[] args) {
        MeanAndMedianOfArray obj = new MeanAndMedianOfArray();
        int[] arr = { 1, 2, 6, 90,3, 4, 5 };
        int N = arr.length;
        System.out.println("Median of the array elements is: " + obj.median(arr, N));
        System.out.println("Mean of the array elements is: " + obj.mean(arr, N));
    }
}

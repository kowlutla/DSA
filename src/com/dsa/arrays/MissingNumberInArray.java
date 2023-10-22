package com.dsa.arrays;

import java.util.Arrays;

/**
 * Given an array of size N-1 such that it only contains distinct integers in the range of 1 to N.
 * Find the missing element.
 */
public class MissingNumberInArray {

    // Using bit manipulation technique
    int missingNumber(int array[], int n) {
        // Initialize xor to 0
        int xor = 0;

        // Calculating xor of all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }

        // Calculating xor of all elements in the array
        for (int i = 0; i < n - 1; i++) {
            xor ^= array[i];
        }

        // The remaining value of xor will be the missing number
        return xor;
    }

    // Using mathematical formula
    int missingNumber1(int array[], int n) {
        // Calculate the sum of first n natural numbers
        long sumOfNNumber = (n * (n + 1)) / 2;

        // Subtract each element in the array from the sum of first n natural numbers
        for (int val : array) {
            sumOfNNumber -= val;
        }

        // The remaining value will be the missing number
        return (int) sumOfNNumber;
    }
    
    public static void main(String[] args) {
        MissingNumberInArray obj = new MissingNumberInArray();

        // Test case 1
        int[] A1 = {1, 2, 3, 5};
        int N1 = 5;
        System.out.println("Input: N = " + N1 + ", A[] = " + Arrays.toString(A1));
        System.out.println("Output using method 1: " + obj.missingNumber(A1, N1));
        System.out.println("Output using method 2: " + obj.missingNumber1(A1, N1));

        // Test case 2
        int[] A2 = {6, 1, 2, 8, 3, 4, 7, 10, 5};
        int N2 = 10;
        System.out.println("Input: N = " + N2 + ", A[] = " + Arrays.toString(A2));
        System.out.println("Output using method 1: " + obj.missingNumber(A2, N2));
        System.out.println("Output using method 2: " + obj.missingNumber1(A2, N2));
    }
}

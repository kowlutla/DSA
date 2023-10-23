package com.dsa.arrays;

/**
 * Given an array arr[] and integer k, Your task is to find smallSum of given
 * array small sum can be obtained by adding all elements of the array in
 * following manner An element A[i] is added as it is if A[i]<A[i+1] otherwise
 * A[i]%k. Consider this array as a circular array
 */
public class SmallSum {

    // Function to find the smallSum value of the array
    public static int smallSum(int[] arr, int K) {
        // Define a modulo value for the sum calculation
        int mod = 1000000007;

        // Initialize a variable to hold the small sum
        long smallSum = 0;

        // Iterate through the array, considering it as a circular array
        for (int i = 0; i < arr.length - 1; i++) {
            // Check if the current element is smaller than the next element
            if (arr[i] < arr[i + 1]) {
                // If it is smaller, add the current element as it is to the smallSum
                smallSum = (smallSum + arr[i]) % mod;
            } else {
                // If it is not smaller, add the remainder of the current element divided by K to the smallSum
                smallSum = (smallSum + (arr[i] % K)) % mod;
            }
        }

        // Check the last and first elements for circular array consideration
        if (arr[arr.length - 1] < arr[0]) {
            // If the last element is smaller than the first, add the last element as it is to the smallSum
            smallSum = (smallSum + arr[arr.length - 1]) % mod;
        } else {
            // If the last element is not smaller than the first, add the remainder of the last element divided by K to the smallSum
            smallSum = (smallSum + (arr[arr.length - 1] % K)) % mod;
        }

        // Return the smallSum modulo mod as an integer
        return (int) (smallSum % mod);
    }

    // Main method to test the SmallSum functionality
    public static void main(String[] args) {
        // Example usage
        int[] arr = { 4, 3, 2, 1, 5 };
        int K = 2;
        System.out.println("Small Sum is: " + smallSum(arr, K)); //expected 3
    }
}

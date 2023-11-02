package com.dsa.arrays;

import java.util.Arrays;

/**
 * Given an array arr of n integers, write a function that returns true if there
 * is a triplet (a, b, c) from the array (where a, b, and c are on different
 * indexes) that satisfies a2 + b2 = c2, otherwise return false.
 */
public class PythagoreanTriplet {

	// Method to check for a Pythagorean triplet using sorting
	boolean checkTriplet(int[] arr, int n) {
		// Square each element in the array
		for (int i = 0; i < n; i++) {
			arr[i] = arr[i] * arr[i];
		}

		// Sort the array
		Arrays.sort(arr);

		// Iterate through the array to find the triplet
		for (int i = n - 1; i > 1; i--) {
			int left = 0;
			int right = i - 1;
			// Use two pointers approach to find the triplet
			while (left < right) {
				// Check if the sum of the squares of left and right is equal to the square of
				// current element
				if (arr[left] + arr[right] == arr[i])
					return true;
				// If the sum is less than the square of the current element, move the left
				// pointer
				if (arr[left] + arr[right] < arr[i])
					left++;
				// If the sum is greater, move the right pointer
				else
					right--;
			}
		}
		// Return false if no such triplet is found
		return false;
	}

	boolean checkTriplet1(int[] arr, int n){
        for(int i=0;i<n;i++){
            int a = arr[i]*arr[i];
            for(int j=0;j<n;j++){
                if(i!=j){
                    int b = arr[j]*arr[j];
                    for(int k = 0;k<n;k++){
                        if(k!=j && k!=i){
                            int c = arr[k]*arr[k];
                            if(c==a+b){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

	// Main method to test the Pythagorean triplet functions
	public static void main(String[] args) {
		PythagoreanTriplet tripletChecker = new PythagoreanTriplet();
		int[] arr = { 3, 1, 4, 6, 5 };
		int n = arr.length;
		System.out.println("Triplet exists without sorting: " + tripletChecker.checkTriplet1(arr, n));
		System.out.println("Triplet exists using sorting: " + tripletChecker.checkTriplet(arr, n));
	}
}

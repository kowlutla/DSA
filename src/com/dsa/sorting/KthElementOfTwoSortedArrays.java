/**
 * 	Given two sorted arrays arr1 and arr2 of size N and M respectively and an element K. The task is to find the element that would be at the kth position of the final sorted array.
 
	Example 1:
	
	Input:
	arr1[] = {2, 3, 6, 7, 9}
	arr2[] = {1, 4, 8, 10}
	k = 5
	Output:
	6
	Explanation:
	The final sorted array would be -
	1, 2, 3, 4, 6, 7, 8, 9, 10
	The 5th element of this array is 6.
	Example 2:
	Input:
	arr1[] = {100, 112, 256, 349, 770}
	arr2[] = {72, 86, 113, 119, 265, 445, 892}
	k = 7
	Output:
	256
	Explanation:
	Final sorted array is - 72, 86, 100, 112,
	113, 119, 256, 265, 349, 445, 770, 892
	7th element of this array is 256.
 */
package com.dsa.sorting;

/**
 * @author KowlutlaSwamy
 *
 */
public class KthElementOfTwoSortedArrays {

    // Method to find the kth element of two sorted arrays using merge concept
    public long kthElement(int arr1[], int arr2[], int n, int m, int k) {
        // Initialize indices for arrays and a counter for elements processed
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;

        // Merge the arrays while tracking the kth element
        while (index1 < n && index2 < m) {
            index3++; // Increment the processed elements count
            // Compare elements from both arrays and merge in ascending order
            if (arr1[index1] <= arr2[index2]) {
                if (index3 == k) {
                    return arr1[index1]; // Return the kth element
                }
                index1++; // Move to the next element in arr1
            } else {
                if (index3 == k) {
                    return arr2[index2]; // Return the kth element
                }
                index2++; // Move to the next element in arr2
            }
        }

        // Handle remaining elements in array arr1
        while (index1 < n) {
            index3++; // Increment the processed elements count
            if (index3 == k) {
                return arr1[index1]; // Return the kth element
            }
            index1++; // Move to the next element in arr1
        }

        // Handle remaining elements in array arr2
        while (index2 < m) {
            index3++; // Increment the processed elements count
            if (index3 == k) {
                return arr2[index2]; // Return the kth element
            }
            index2++; // Move to the next element in arr2
        }

        return -1; // If kth element not found, return -1
    }

    // Main method to demonstrate the usage of kthElement method
    public static void main(String[] args) {
        // Example sorted arrays
        int[] arr1 = { 2, 3, 6, 7, 9 };
        int[] arr2 = { 1, 4, 8, 10 };

        // Lengths of arrays
        int n = arr1.length;
        int m = arr2.length;

        // Kth element to be found
        int k = 5;

        // Create an object of the class
        KthElementOfTwoSortedArrays obj = new KthElementOfTwoSortedArrays();

        // Find the kth element from the two arrays
        long kthElement = obj.kthElement(arr1, arr2, n, m, k);

        if (kthElement != -1) {
            System.out.println("The kth element is: " + kthElement);
        } else {
            System.out.println("value is k is out of range");
        }
    }
}

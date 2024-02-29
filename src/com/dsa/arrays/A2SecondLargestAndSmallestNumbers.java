/**
 * 	You have been given an array ‘a’ of ‘n’ unique non-negative integers.
	Find the second largest and second smallest element from the array.
	Return the two elements (second largest and second smallest) as another array of size 2.
	
	Example :
	Input: ‘n’ = 5, ‘a’ = [1, 2, 3, 4, 5]
	Output: [4, 2]
	The second largest element after 5 is 4, and the second smallest element after 1 is 2.
 */
package com.dsa.arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class A2SecondLargestAndSmallestNumbers {

    // Method to find the second largest and second smallest elements in an array
    // Parameters:
    // - n: the number of elements in the array
    // - a: the input integer array
    // Returns: an array containing the second largest and second smallest elements
    // Time Complexity: O(n) - linear time complexity where n is the number of elements in the array
    // Space Complexity: O(1) - constant space complexity as only a few variables are used
    public static int[] getSecondOrderElements(int n, int[] a) {

        int firstLarge = -1;
        int secondLarge = -1;

        int firstSmall = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;

        // Iterate through the array to find the second largest and second smallest elements
        for (int i = 0; i < n; i++) {
            if (a[i] > firstLarge) {
                secondLarge = firstLarge;
                firstLarge = a[i];
            } else if (a[i] > secondLarge) {
                secondLarge = a[i];
            }

            if (a[i] < firstSmall) {
                secondSmall = firstSmall;
                firstSmall = a[i];
            } else if (a[i] < secondSmall) {
                secondSmall = a[i];
            }
        }

        return new int[]{secondLarge, secondSmall}; // Return an array containing the second largest and second smallest elements
    }

    // Main method to test the getSecondOrderElements method
    public static void main(String[] args) {
        int[] arr = {5, 10, 3, 8, 15}; // Sample input array
        int n = arr.length; // Length of the input array

        // Call the getSecondOrderElements method and print the result
        int[] secondOrderElements = getSecondOrderElements(n, arr);
        System.out.println("Second Largest element in the array: " + secondOrderElements[0]);
        System.out.println("Second Smallest element in the array: " + secondOrderElements[1]);
    }
}

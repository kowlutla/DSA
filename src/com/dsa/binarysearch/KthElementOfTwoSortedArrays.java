/**
 * 	Problem statement
	You're given two sorted arrays 'arr1' and 'arr2' of size 'n' and 'm' respectively and an element 'k'.
	Find the element that would be at the 'kth' position of the combined sorted array.
	Position 'k' is given according to 1 - based indexing, but arrays 'arr1' and 'arr2' are using 0 - based indexing.
	
	For example :
	Input: 'arr1' = [2, 3, 45], 'arr2' = [4, 6, 7, 8] and 'k' = 4
	Output: 6
	Explanation: The merged array will be [2, 3, 4, 6, 7, 8, 45]. The element at position '4' of this array is 6. Hence we return 6.
	
	
	Detailed explanation ( Input/output format, Notes, Images )
	Sample Input 1:
	5
	2 3 6 7 9
	4
	1 4 8 10
	4
	Sample Output 1:
	4
	Explanation of sample input 1 :
	The merged array will be: [1, 2, 3, 4, 6, 7, 8, 9, 10]
	
	The element at position '4' is 4 so we return 4.
	Sample Input 2:
	5
	1 2 3 5 6
	5
	4 7 8 9 100  
	6
	Sample Output 2:
	6
	Explanation of sample input 2 :
	The merged array will be: [1, 2, 3, 4, 5, 6, 7, 8, 9, 100]
	
	The element at position '6'  is 6, so we return 6.
	Constraints :
	1 <= 'n' <= 5000
	1 <= 'm' <= 5000
	0 <= 'arr1[i]', 'arr2[i]' <= 10^9
	1 <= 'k' <= 'n' + 'm'
	
	'n' and 'm' denote the size of 'arr1' and 'arr2'.
	
	Time limit: 1 second
	Expected time complexity :
	The expected time complexity is O(log('n') + log('m')). 
 */
package com.dsa.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class KthElementOfTwoSortedArrays {

    // Method to find the kth element of two sorted arrays represented as ArrayLists
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        // Ensure arr1 is the smaller array for simplicity
        if (n > m) {
            return kthElement(arr2, arr1, m, n, k);
        }

        // Initialize low and high indices for binary search
        int low = Math.max(0, k - m);
        int high = Math.min(k, n);

        // Binary search to find the kth element
        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = k - mid1;

            // Find elements on the left and right sides of the partition
            int left1 = mid1 == 0 ? Integer.MIN_VALUE : arr1.get(mid1 - 1);
            int left2 = mid2 == 0 ? Integer.MIN_VALUE : arr2.get(mid2 - 1);
            int right1 = mid1 == n ? Integer.MAX_VALUE : arr1.get(mid1);
            int right2 = mid2 == m ? Integer.MAX_VALUE : arr2.get(mid2);

            // Check if partition is correct
            if (left1 <= right2 && left2 <= right1) {
                return Math.max(left2, left1);
            } else if (left1 > right2) {
                high = mid1 - 1; // Adjust the search range
            } else {
                low = mid1 + 1; // Adjust the search range
            }
        }

        return -1; // If kth element not found, return -1
    }

    // Main method to demonstrate the usage of kthElement method
    public static void main(String[] args) {
        // Example ArrayLists representing sorted arrays
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(2, 3, 6, 7, 9));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 4, 8, 10));

        // Lengths of arrays
        int n = arr1.size();
        int m = arr2.size();

        // Kth element to be found
        int k = 5;

        // Find the kth element from the two arrays
        int kthElement = kthElement(arr1, arr2, n, m, k);

        if (kthElement != -1) {
            System.out.println("The kth element is: " + kthElement);
        } else {
            System.out.println("Invalid k value or element not found.");
        }
    }
}

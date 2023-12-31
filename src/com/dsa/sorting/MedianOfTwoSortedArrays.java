/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
	The overall run time complexity should be O(log (m+n)).

	Example 1:
	
	Input: nums1 = [1,3], nums2 = [2]
	Output: 2.00000
	Explanation: merged array = [1,2,3] and median is 2.
	Example 2:
	
	Input: nums1 = [1,2], nums2 = [3,4]
	Output: 2.50000
	Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
package com.dsa.sorting;

/**
 * @author KowlutlaSwamy
 *
 */
public class MedianOfTwoSortedArrays {

	// Method to find the median of two sorted arrays without using extra space
	static double medianOfArrays(int n, int m, int a[], int b[]) {
		// Calculate the total length of both arrays
		int totalLength = (n + m);
		int index1, index2 = -1;

		// Determine the indices for median elements based on total length
		if (totalLength % 2 == 1) {
			index1 = (totalLength / 2);
			index2 = (totalLength / 2);
		} else {
			index1 = (totalLength / 2);
			index2 = (totalLength / 2) - 1;
		}

		int resultValue1 = -1, resultValue2 = -1;
		int temp1 = 0, temp2 = 0, temp3 = 0;

		// Merge the arrays to find the median values
		while (temp1 < n && temp2 < m) {
			int current;
			// Compare elements from both arrays and merge in ascending order
			if (a[temp1] <= b[temp2]) {
				current = a[temp1];
				temp1++;
			} else {
				current = b[temp2];
				temp2++;
			}

			// Track elements at indices for median
			if (temp3 == index1) {
				resultValue1 = current;
			}
			if (temp3 == index2) {
				resultValue2 = current;
			}
			temp3++;
		}

		// Handle remaining elements in array 'a'
		while (temp1 < n) {
			int current = a[temp1];
			if (temp3 == index1) {
				resultValue1 = current;
			}
			if (temp3 == index2) {
				resultValue2 = current;
			}
			temp1++;
			temp3++;
		}

		// Handle remaining elements in array 'b'
		while (temp2 < m) {
			int current = b[temp2];
			if (temp3 == index1) {
				resultValue1 = current;
			}
			if (temp3 == index2) {
				resultValue2 = current;
			}
			temp2++;
			temp3++;
		}

		// Calculate and return the median
		return (resultValue1 + resultValue2) / 2.0;
	}

	// Main method to demonstrate the usage of medianOfArrays method
	public static void main(String[] args) {
		int[] arr1 = {1, 3, 5, 6};
		int[] arr2 = {2, 4, 6};

		int n = arr1.length;
		int m = arr2.length;

		// Calculate the median of the two arrays
		double median = medianOfArrays(n, m, arr1, arr2);
		System.out.println("Median of the two sorted arrays is: " + median);
	}
}

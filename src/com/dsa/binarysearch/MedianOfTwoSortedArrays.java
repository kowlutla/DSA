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
package com.dsa.binarysearch;

/**
 * @author KowlutlaSwamy
 *
 */
public class MedianOfTwoSortedArrays {

    // Method to find the median of two sorted arrays
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1); // Ensure nums1 is smaller for easier calculation
        }

        int n1 = nums1.length;
        int n2 = nums2.length;
        int low = 0, high = n1;

        // Perform binary search to find the median
        while (low <= high) {
            int mid1 = low + (high - low) / 2; // Calculate midpoint for nums1
            int mid2 = (n1 + n2 + 1) / 2 - mid1; // Calculate corresponding midpoint for nums2

            int left1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1]; // Get left element of partition in nums1
            int left2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1]; // Get left element of partition in nums2
            int right1 = mid1 == n1 ? Integer.MAX_VALUE : nums1[mid1]; // Get right element of partition in nums1
            int right2 = mid2 == n2 ? Integer.MAX_VALUE : nums2[mid2]; // Get right element of partition in nums2

            // Check if the partitions are at the correct place
            if (left1 <= right2 && left2 <= right1) {
                if ((n1 + n2) % 2 == 0) {
                    // If total elements are even, return the average of middle elements
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    // If total elements are odd, return the larger of the two middle elements
                    return (double) Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                high = mid1 - 1; // Move left in nums1 to get correct partitions
            } else {
                low = mid1 + 1; // Move right in nums1 to get correct partitions
            }
        }
        return 0.0; // Default return if no median is found
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianFinder = new MedianOfTwoSortedArrays();

        // Example sorted arrays
		int[] nums1 = {1, 3, 5, 15};
		int[] nums2 = {2, 4, 8, 9};

        // Find the median of the two sorted arrays
        double median = medianFinder.findMedianSortedArrays(nums1, nums2);
        System.out.println("Median of the two sorted arrays is: " + median);
    }
}

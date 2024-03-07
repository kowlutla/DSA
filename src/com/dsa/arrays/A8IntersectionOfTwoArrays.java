/**
 * 	Given two integer arrays nums1 and nums2, return an array of their intersection. 
 	Each element in the result must be unique and you may return the result in any order.
	
	Example 1:
	Input: nums1 = [1,2,2,1], nums2 = [2,2]
	Output: [2]

	Example 2:
	Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
	Output: [9,4]
	Explanation: [4,9] is also accepted.
 */
package com.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author KowlutlaSwamy
 *
 */
public class A8IntersectionOfTwoArrays {

    /**
     * Finds the intersection of two sorted arrays using two pointers.
     * Time complexity: O(M + N) - iterates through both arrays once in the worst case.
     * Space complexity: O(min(M, N)) - uses an ArrayList or the smaller array size for the result.
     *
     * @param nums1 The first sorted input array.
     * @param nums2 The second sorted input array.
     * @return An array containing the intersection elements.
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n = nums1.length;
        int m = nums2.length;

        List<Integer> result = new ArrayList<>(); // Stores intersection elements (can be replaced with int[] if size is known)
        int index1 = 0, index2 = 0;
        while (index1 < n && index2 < m) {
            if (nums1[index1] == nums2[index2]) {
                // Add only if the element is not already the last element in the result
                if (result.isEmpty() || result.get(result.size() - 1) != nums1[index1]) {
                    result.add(nums1[index1]);
                }
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }

        // Convert ArrayList to int array (if needed)
        int[] inter = new int[result.size()];
        int index = 0;
        for (int num : result) {
            inter[index++] = num;
        }

        return inter;
    }

    /**
     * Finds the intersection of two arrays using HashSet.
     * Time complexity: O(M + N) - iterates through both arrays once to add to the HashSet.
     * Space complexity: O(M + N) - uses two HashSets to store the elements of both arrays.
     *
     * @param nums1 The first input array.
     * @param nums2 The second input array.
     * @return An array containing the intersection elements.
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();

        for (int num : nums1) {
            set1.add(num);
        }

        HashSet<Integer> set2 = new HashSet<Integer>();
        for (int num : nums2) {
            set2.add(num);
        }

        Set<Integer> inter = new HashSet<>(); // Stores intersection elements
        for (int num : set1) {
            if (set2.contains(num)) {
                inter.add(num);
            }
        }

        int result[] = new int[inter.size()];

        int index = 0;
        for (int num : inter) {
            result[index++] = num;
        }
        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        A8IntersectionOfTwoArrays obj = new A8IntersectionOfTwoArrays();

        int[] nums1 = {1, 2, 2, 5, 1};
        int[] nums2 = {5 ,2, 2};

        int[] intersection1 = obj.intersection1(nums1, nums2);
        int[] intersection2 = obj.intersection2(nums1, nums2);

        System.out.print("Intersection using two pointers: ");
        for (int num : intersection1) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Intersection using HashSet: ");
        for (int num : intersection2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

/**
 * 	Given two sorted arrays, ‘a’ and ‘b’, of size ‘n’ and ‘m’, respectively, return the union of the arrays.
	The union of two sorted arrays can be defined as an array consisting of the common and the distinct elements of the two arrays. 
	The final array should be sorted in ascending order.
	
	Note: 'a' and 'b' may contain duplicate elements, but the union array must contain unique elements.
	Example:
	Input: ‘n’ = 5 ‘m’ = 3
	‘a’ = [1, 2, 3, 4, 6]
	‘b’ = [2, 3, 5]
	Output: [1, 2, 3, 4, 5, 6]
	Explanation: Common elements in ‘a’ and ‘b’ are: [2, 3]
	Distinct elements in ‘a’ are: [1, 4, 6]
	Distinct elements in ‘b’ are: [5]
	Union of ‘a’ and ‘b’ is: [1, 2, 3, 4, 5, 6]
	Detailed explanation ( Input/output format, Notes, Images )

	Sample Input 1 :
	5 3
	1 2 3 4 6
	2 3 5
	Sample Output 1 :
	1 2 3 4 5 6
	Explanation Of Sample Input 1 :
	Input: ‘n’ = 5 ‘m’ = 3
	‘a’ = [1, 2, 3, 4, 6]
	‘b’ = [2, 3, 5]
	Output: [1, 2, 3, 4, 5, 6]
	Explanation: Common elements in ‘a’ and ‘b’ are: [2, 3]
	Distinct elements in ‘a’ are: [1, 4, 6]
	Distinct elements in ‘b’ are: [5]
	Union of ‘a’ and ‘b’ is: [1, 2, 3, 4, 5, 6]
	
	Sample Input 2:
	4 3
	1 2 3 3
	2 2 4
	Sample Output 2:
	1 2 3 4
	Explanation Of Sample Input 2 :
	Input: ‘n’ = 5 ‘m’ = 3
	‘a’ = [1, 2, 3, 3]
	‘b’ = [2, 2, 4]
	Output: [1, 2, 3, 4]
	Explanation: Common elements in ‘a’ and ‘b’ are: [2]
	Distinct elements in ‘a’ are: [1, 3]
	Distinct elements in ‘b’ are: [4]
	Union of ‘a’ and ‘b’ is: [1, 2, 3, 4]
 */
package com.dsa.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author KowlutlaSwamy
 *
 */
public class A8MergeTwoSortedArrays {

    /**
     * Merges two sorted arrays using a TreeSet for sorting.
     *
     * Time complexity: O(n log n) due to TreeSet operations.
     * Space complexity: O(n) for the TreeSet.
     *
     * @param a The first sorted array.
     * @param b The second sorted array.
     * @return A list containing the merged elements in sorted order.
     */
    public static List<Integer> sortedArray(int[] a, int[] b) {
        Set<Integer> set = new TreeSet<>();  // Use TreeSet for automatic sorting
        for (int num : a) {
            set.add(num);
        }
        for (int num : b) {
            set.add(num);
        }
        return new ArrayList<>(set);  // Convert back to list for desired output
    }

    /**
     * Merges two sorted arrays using a two-pointer approach for efficient merging.
     *
     * Time complexity: O(n + m), where n and m are the lengths of the arrays.
     * Space complexity: O(n + m) for the result list.
     *
     * @param a The first sorted array.
     * @param b The second sorted array.
     * @return A list containing the merged elements in sorted order.
     */
    public static List<Integer> sortedArray1(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();

        int n = a.length;
        int m = b.length;
        int index1 = 0, index2 = 0;

        // Iterate through both arrays simultaneously using two pointers
        while (index1 < n && index2 < m) {
            if (a[index1] == b[index2]) {  // Handle equal elements
                if (result.isEmpty() || result.get(result.size() - 1) != a[index1]) {
                    result.add(a[index1]);  // Add only if not already added
                }
                index1++;
                index2++;
            } else if (a[index1] < b[index2]) {
                if (result.isEmpty() || result.get(result.size() - 1) != a[index1]) {
                    result.add(a[index1]);
                }
                index1++;
            } else {
                if (result.isEmpty() || result.get(result.size() - 1) != b[index2]) {
                    result.add(b[index2]);
                }
                index2++;
            }
        }

        // Add remaining elements from either array
        while (index1 < n) {
            if (result.isEmpty() || result.get(result.size() - 1) != a[index1]) {
                result.add(a[index1]);
            }
            index1++;
        }
        while (index2 < m) {
            if (result.isEmpty() || result.get(result.size() - 1) != b[index2]) {
                result.add(b[index2]);
            }
            index2++;
        }

        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example usage of both methods
        int[] array1 = {1, 3, 5, 7};
        int[] array2 = {2, 4, 6, 8};

        List<Integer> mergedList1 = sortedArray(array1, array2);
        List<Integer> mergedList2 = sortedArray1(array1, array2);

        System.out.println("Merged list using sortedArray: " + mergedList1);
        System.out.println("Merged list using sortedArray1: " + mergedList2);
    }
}

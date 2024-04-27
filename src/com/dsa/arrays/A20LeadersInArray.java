/**
 * 	Given an array A of positive integers. Your task is to find the leaders in the array. 
  	An element of array is a leader if it is greater than or equal to all the elements to its right side. The rightmost element is always a leader. 
	
	Example 1:
	
	Input:
	n = 6
	A[] = {16,17,4,3,5,2}
	Output: 17 5 2
	Explanation: The first leader is 17 
	as it is greater than all the elements
	to its right.  Similarly, the next 
	leader is 5. The right most element 
	is always a leader so it is also 
	included.
	Example 2:
	
	Input:
	n = 5
	A[] = {1,2,3,4,0}
	Output: 4 0
	Explanation: 0 is the rightmost element
	and 4 is the only element which is greater
	than all the elements to its right.
 */
package com.dsa.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author KowlutlaSwamy
 *
 */
public class A20LeadersInArray {

    // Time Complexity: O(N^2) - Nested loop iterates N times (outer) and N-1 times (inner) in the worst case.
    // Space Complexity: O(N) - An ArrayList is used to store leaders.
    public static List<Integer> leaders1(int[] arr, int n) {

        ArrayList<Integer> leaders = new ArrayList<>();  // Initialize an ArrayList to store leaders

        for (int i = 0; i < n - 1; i++) {  // Loop through all elements except the last one
            boolean isLeader = true;       // Assume the current element is a leader initially

            for (int j = i + 1; j < n; j++) {  // Loop through elements after the current element
                if (arr[i] < arr[j]) {       // If any element after 'i' is greater than 'arr[i]'
                    isLeader = false;        // Not a leader, break the inner loop
                    break;
                }
            }

            if (isLeader) {                 // If the loop completes without finding a greater element
                leaders.add(arr[i]);        // Add the current element to the leaders list
            }
        }

        leaders.add(arr[n - 1]);  // The last element is always a leader (no elements after it)
        return leaders;
    }

    // Time Complexity: O(N) - Single loop iterates N times in the worst case.
    // Space Complexity: O(N) - An ArrayList is used to store leaders.
    public static List<Integer> leaders(int[] arr, int n) {

        ArrayList<Integer> leaders = new ArrayList<>();
        leaders.add(arr[n - 1]); // Rightmost element is always a leader, add it first

        int max = arr[n - 1];  // Initialize max to the rightmost element

        for (int i = n - 2; i >= 0; i--) {  // Loop through the array from second last element to first
            if (arr[i] >= max) {         // If the current element is greater than or equal to the max seen so far
                leaders.add(arr[i]);      // Add it to the leaders list
                max = arr[i];            // Update the max element seen so far
            }
        }

        Collections.reverse(leaders); // Reverse the leaders list to get them in the order they appear in the array
        return leaders;
    }

    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        List<Integer> leaders1 = leaders1(arr, arr.length);
        List<Integer> leaders2 = leaders(arr, arr.length);
        System.out.println("Leaders using leaders1 (Nested Loop): " + leaders1);
        System.out.println("Leaders using leaders2 (Single Loop): " + leaders2);
    }
}

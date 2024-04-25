/**
  	Implement the next permutation, which rearranges the list of numbers into Lexicographically next greater permutation of list of numbers. 
   	If such arrangement is not possible, it must be rearranged to the lowest possible order i.e. sorted in an ascending order. 
   	You are given an list of numbers arr[ ] of size N.

	Example 1:
	
	Input: N = 6
	arr = {1, 2, 3, 6, 5, 4}
	Output: {1, 2, 4, 3, 5, 6}
	Explaination: The next permutation of the 
	given array is {1, 2, 4, 3, 5, 6}.
	Example 2:
	
	Input: N = 3
	arr = {3, 2, 1}
	Output: {1, 2, 3}
	Explaination: As arr[] is the last 
	permutation. So, the next permutation 
	is the lowest one.
 */
package com.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KowlutlaSwamy
 *
 */
public class A19NextPermutation {

    // Time Complexity: O(N) - 
    // In the worst case, the loop to find the first decreasing element iterates N-1 times. 
    // The other loops for swapping and reversing have a maximum combined iteration of N-1 as well. 
    // Overall, the time complexity is linear in the input size (N).
    static List<Integer> nextPermutation(int N, int arr[]) {

        // Find the first element from the right side of the array 
        // that is smaller than its next element
        int index = -1;
        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            // No greater permutation possible, reverse the entire array
            reverse(arr, 0, N - 1);
        } else {
            // Find the first element from the right side that is greater than the element at 'index'
            for (int i = N - 1; i > index; i--) {
                if (arr[i] > arr[index]) {
                    swap(arr, i, index);
                    break;
                }
            }

            // Reverse the sub-array from 'index + 1' to the end
            reverse(arr, index + 1, N - 1);
        }

        // Create a List from the modified array
        List<Integer> result = new ArrayList<>();
        for (int num : arr) {
            result.add(num);
        }
        return result;
    }

    private static void swap(int arr[], int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static void reverse(int[] arr, int start, int end) {

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<Integer> nextPerm = nextPermutation(arr.length, arr);
        System.out.println("Next permutation: " + nextPerm); // Output: Next permutation: [1, 3, 2]
    }
}

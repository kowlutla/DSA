/**
 * 	Given an array arr[] of size N and an integer K. Find the maximum for each and every contiguous subarray of size K.
	
	Example 1:
	Input:
	N = 9, K = 3
	arr[] = 1 2 3 1 4 5 2 3 6
	Output: 
	3 3 4 5 5 5 6 
	Explanation: 
	1st contiguous subarray = {1 2 3} Max = 3
	2nd contiguous subarray = {2 3 1} Max = 3
	3rd contiguous subarray = {3 1 4} Max = 4
	4th contiguous subarray = {1 4 5} Max = 5
	5th contiguous subarray = {4 5 2} Max = 5
	6th contiguous subarray = {5 2 3} Max = 5
	7th contiguous subarray = {2 3 6} Max = 6

	Example 2:
	Input:
	N = 10, K = 4
	arr[] = 8 5 10 7 9 4 15 12 90 13
	Output: 
	10 10 10 15 15 90 90
	Explanation: 
	1st contiguous subarray = {8 5 10 7}, Max = 10
	2nd contiguous subarray = {5 10 7 9}, Max = 10
	3rd contiguous subarray = {10 7 9 4}, Max = 10
	4th contiguous subarray = {7 9 4 15}, Max = 15
	5th contiguous subarray = {9 4 15 12}, 
	Max = 15
	6th contiguous subarray = {4 15 12 90},
	Max = 90
	7th contiguous subarray = {15 12 90 13}, 
	Max = 90
 */
package com.dsa.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.PriorityQueue;

public class S17KSizedSubarrayMaximum {

    /**
     * Finds the maximum of each subarray of size k using a brute force approach.
     * 
     * Time Complexity: O(N * K) - Nested loops, where the outer loop runs N-K+1 times
     *                  and the inner loop runs K times.
     * Space Complexity: O(N) - Uses an ArrayList to store the result.
     *
     * @param arr the input array
     * @param n   the size of the array
     * @param k   the size of the subarray
     * @return the list of maximums for each subarray of size k
     */
    public static ArrayList<Integer> maxOfSubarrays1(int[] arr, int n, int k) {
        ArrayList<Integer> result = new ArrayList<>(); // Initialize the result list
        for (int i = 0; i <= n - k; i++) { // Iterate over each subarray starting index
            int max = arr[i]; // Initialize the maximum for the current subarray
            for (int j = i; j < i + k; j++) { // Iterate over the elements of the current subarray
                max = Math.max(arr[j], max); // Update the maximum value
            }
            result.add(max); // Add the maximum value to the result list
        }
        return result; // Return the result list
    }

    /**
     * Finds the maximum of each subarray of size k using a max heap (priority queue).
     * 
     * Time Complexity: O(N log K) - Each insertion and deletion operation in the priority queue
     *                  takes log K time, and there are N such operations.
     * Space Complexity: O(K) - Uses a priority queue to store K elements.
     *
     * @param arr the input array
     * @param n   the size of the array
     * @param k   the size of the subarray
     * @return the list of maximums for each subarray of size k
     */
    public static ArrayList<Integer> maxOfSubarrays2(int[] arr, int n, int k) {
        ArrayList<Integer> result = new ArrayList<>(); // Initialize the result list
        PriorityQueue<Pair> q = new PriorityQueue<>((p1, p2) -> p2.value - p1.value); // Max heap to store pairs of (value, index)
        for (int i = 0; i < k; i++) {
            q.add(new Pair(arr[i], i)); // Add the first k elements to the heap
        }

        result.add(q.peek().value); // Add the maximum of the first subarray to the result list
        for (int i = k; i < n; i++) {
            while (!q.isEmpty() && q.peek().index <= i - k) {
                q.remove(); // Remove elements that are out of the current subarray
            }
            q.add(new Pair(arr[i], i)); // Add the current element to the heap
            result.add(q.peek().value); // Add the maximum of the current subarray to the result list
        }
        return result; // Return the result list
    }

    private static class Pair {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    /**
     * Finds the maximum of each subarray of size k using a deque for efficient processing.
     * 
     * Time Complexity: O(N) - Each element is added and removed from the deque at most once.
     * Space Complexity: O(K) - Uses a deque to store indices of elements.
     *
     * @param arr the input array
     * @param n   the size of the array
     * @param k   the size of the subarray
     * @return the list of maximums for each subarray of size k
     */
    public static ArrayList<Integer> maxOfSubarrays3(int[] arr, int n, int k) {
        ArrayList<Integer> result = new ArrayList<>(); // Initialize the result list
        Deque<Integer> deque = new ArrayDeque<>(); // Initialize the deque to store indices
        for (int i = 0; i < n; i++) { // Iterate over each element in the array

            if (!deque.isEmpty() && deque.peek() == i - k) {
                deque.poll(); // Remove elements that are out of the current subarray
            }

            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast(); // Remove elements that are smaller than the current element
            }
            deque.offer(i); // Add the current element to the deque
            if (i >= k - 1) {
                result.add(arr[deque.peek()]); // Add the maximum of the current subarray to the result list
            }
        }
        return result; // Return the result list
    }
}

/**
 * 	Given an 2D array intervals of size N representing intervals where intervals [ i ] = [starti, endi ), return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
	 
	Example 1:
	Input:
	N = 4
	intervals [ ] = {{1, 2}, {2, 3}, {3, 4}, {1, 3}}
	Output: 1
	Explanation: 
	{1, 3} can be removed and the rest of the intervals are non-overlapping.
	 
	
	Example 2:
	Input:
	N = 3
	intervals [ ] = {{1, 3}, {1, 3}, {1, 3}}
	Output: 2
	Explanation: 
	You need to remove two {1, 3} to make the rest of the intervals non-overlapping.
 */
package com.dsa.greedy;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class GD7NonOverlappingIntervals {

    /**
     * Time Complexity: O(N log N) for sorting the intervals based on end times,
     * plus O(N) for the single iteration to count non-overlapping intervals.
     * Overall: O(N log N).
     *
     * Space Complexity: O(1) for constant space usage.
     */
    public static int minRemoval(int N, int intervals[][]) {

        // Sort intervals based on their end times
        Arrays.sort(intervals, (i1, i2) -> i1[1] - i2[1]);

        // Initialize the first interval's end time
        int end = intervals[0][1];
        int temp = 1; // Counter for non-overlapping intervals

        // Iterate through the remaining intervals
        for (int i = 1; i < N; i++) {

            // Check if the current interval does not overlap with the previous one
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                temp++; // Increment the counter for non-overlapping intervals
            }
        }

        // Return the minimum number of removals to make all intervals non-overlapping
        return N - temp;
    }
}

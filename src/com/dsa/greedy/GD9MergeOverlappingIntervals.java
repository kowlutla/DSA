/**
 * 	Given a collection of Intervals, the task is to merge all of the overlapping Intervals.
	
	Example 1:
	Input:
	Intervals = {{1,3},{2,4},{6,8},{9,10}}
	Output: {{1, 4}, {6, 8}, {9, 10}}
	Explanation: Given intervals: [1,3],[2,4]
	[6,8],[9,10], we have only two overlapping
	intervals here,[1,3] and [2,4]. Therefore
	we will merge these two and return [1,4],
	[6,8], [9,10].

	Example 2:
	Input:
	Intervals = {{6,8},{1,9},{2,4},{4,7}}
	Output: {{1, 9}}
 */
package com.dsa.greedy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class GD9MergeOverlappingIntervals {

    /**
     * Time Complexity: O(N log N) for sorting the intervals, plus O(N) for the single iteration to merge intervals.
     * Overall: O(N log N).
     *
     * Space Complexity: O(N) for storing the result list.
     */
    public int[][] overlappedInterval(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();

        // Sort intervals based on their start times
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        // Initialize the first interval's start and end times
        int start = intervals[0][0];
        int end = intervals[0][1];

        // Iterate through all intervals
        for (int[] inter : intervals) {

            // Check if the current interval overlaps with the previous one
            if (inter[0] <= end) {
                end = Math.max(end, inter[1]); // Merge intervals
            } else {
                result.add(new int[]{start, end}); // Add the previous interval to the result
                start = inter[0]; // Update start and end to the current interval
                end = inter[1];
            }
        }

        // Add the last interval to the result
        result.add(new int[]{start, end});

        // Convert result list to a 2D array and return
        return result.toArray(new int[0][]);
    }
}

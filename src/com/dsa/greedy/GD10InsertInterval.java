/**
 *	Geek has an array of N non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith event and intervals is sorted in ascending order by starti. He wants to add a new interval newEvent = [newStart, newEnd] where newStart and newEnd represent the start and end of this interval.
	Help Geek to insert newEvent into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
	
	Example 1:
	Input:
	N = 3
	intervals = [[1,3], [10,15], [20,30]]
	newEvent  = [5,6]
	Output: [[1,3], [5,6], [10,15], [20,30]]
	Explanation: The newEvent (5, 6) does not overlap with any of the existing ranges, hence it is added 
	to the intervals list maintaining the sorted order of start times.

	Example 2:
	Input:
	N = 5
	intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]]
	newEvent  = [5,10]
	Output: [[1,2], [3,10], [12,16]]
	Explanation: Because the new interval [5,10] overlaps with [3,5],[6,7],[8,10].
 */
package com.dsa.greedy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class GD10InsertInterval {

    /**
     * Merges overlapping intervals in a given list of intervals.
     *
     * Time Complexity: O(N log N) for sorting the intervals, plus O(N) for the single iteration to merge intervals.
     * Overall: O(N log N).
     *
     * Space Complexity: O(N) for storing the result list.
     */
    public int[][] overlappedInterval(int[][] intervals) {
        // Result list to store merged intervals
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

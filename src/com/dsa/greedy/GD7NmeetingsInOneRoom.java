/**
 * 	There is one meeting room in a firm. There are n meetings in the form of (start[i], end[i]) where start[i] is start time of meeting i and end[i] is finish time of meeting i.
	What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time? Return the maximum number of meetings that can be held in the meeting room.
	
	Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.
	
	Examples :
	Input: n = 6, start[] = {1,3,0,5,8,5}, end[] =  {2,4,6,7,9,9}
	Output: 4
	Explanation: Maximum four meetings can be held with given start and end timings. The meetings are - (1, 2),(3, 4), (5,7) and (8,9)

	Input: n = 3, start[] = {10, 12, 20}, end[] = {20, 25, 30}
	Output: 1
	Explanation: Only one meetings can be held with given start and end timings.
 */
package com.dsa.greedy;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class GD7NmeetingsInOneRoom {

    /**
     * Time Complexity: O(n log n) for sorting the meetings based on end times,
     * plus O(n) for the single iteration to count the maximum number of meetings.
     * Overall: O(n log n).
     *
     * Space Complexity: O(n) for the meetings array.
     */
    public static int maxMeetings(int start[], int end[], int n) {
        // Create an array of Meeting objects
        Meeting[] meetings = new Meeting[n];

        // Initialize each Meeting object with start and end times
        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(start[i], end[i]);
        }

        // Sort the meetings based on end times
        Arrays.sort(meetings, (m1, m2) -> m1.end - m2.end);

        // Initialize total meetings counter and the end time of the first meeting
        int totalMeetings = 1;
        int currentEndTime = meetings[0].end;

        // Iterate through the rest of the meetings
        for (int i = 1; i < n; i++) {
            // If the current meeting starts after the last meeting ends, include it
            if (meetings[i].start > currentEndTime) {
                totalMeetings++;
                currentEndTime = meetings[i].end; // Update the end time
            }
        }

        // Return the total number of meetings that can be held
        return totalMeetings;
    }

    // Inner class to represent a meeting with start and end times
    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

/**
 * 	Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required for the railway station so that no train is kept waiting.
	Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other. At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms.
	
	Examples:
	Input: n = 6, arr[] = {0900, 0940, 0950, 1100, 1500, 1800}, 
	            dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
	Output: 3
	Explanation: There are three trains during the time 0940 to 1200. So we need minimum 3 platforms.
	
	Input: n = 3, arr[] = {0900, 1235, 1100}, 
	            dep[] = {1000, 1240, 1200}
	Output: 1
	Explanation: All train times are mutually exlusive. So we need only one platform
	
	Input: n = 3, arr[] = {1000, 0935, 1100}, 
	            dep[] = {1200, 1240, 1130}
	Output: 3
	Explanation: All 3 trains have to be their from 11:00 to 11:30
 */
package com.dsa.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author KowlutlaSwamy
 *
 */
public class GD13MinimumPlatforms {

    static private class Pair {
        int time;
        char activity;

        public Pair(int time, char activity) {
            this.time = time;
            this.activity = activity;
        }
    }

    /**
     * Finds the minimum number of platforms required for the railway station to avoid any delay.
     *
     * Time Complexity: O(2n log(2n)) = O(n log n), where n is the number of trains,
     * because we sort 2n elements (arrival and departure times).
     *
     * Space Complexity: O(2n) = O(n) for storing arrival and departure times in a list.
     *
     * @param arr array of arrival times of trains
     * @param dep array of departure times of trains
     * @param n number of trains
     * @return minimum number of platforms required
     */
    public static int findPlatform(int arr[], int dep[], int n) {

        List<Pair> list = new LinkedList<>();
        for (int at : arr) {
            list.add(new Pair(at, 'A')); // Add arrival times with 'A' activity
        }

        for (int dt : dep) {
            list.add(new Pair(dt, 'D')); // Add departure times with 'D' activity
        }

        // Sort list based on time
        Collections.sort(list, (p1, p2) -> p1.time - p2.time);

        int platformsNeeded = 0; // Current number of platforms needed
        int result = 0; // Maximum platforms needed at any time

        for (Pair p : list) {
            if (p.activity == 'A') {
                platformsNeeded++; // Increase platform count on arrival
            } else {
                platformsNeeded--; // Decrease platform count on departure
            }
            result = Math.max(platformsNeeded, result); // Update result if needed
        }
        return result; // Return the maximum platforms needed
    }

    /**
     * Another method to find the minimum number of platforms required.
     *
     * Time Complexity: O(n log n), where n is the number of trains,
     * because we sort both the arrival and departure arrays.
     *
     * Space Complexity: O(1) because we use a constant amount of extra space.
     *
     * @param arr array of arrival times of trains
     * @param dep array of departure times of trains
     * @param n number of trains
     * @return minimum number of platforms required
     */
    public static int findPlatform1(int arr[], int dep[], int n) {
        Arrays.sort(arr); // Sort arrival times
        Arrays.sort(dep); // Sort departure times

        int platforms = 1; // Initialize result
        int count = 1; // Count of platforms needed at a time
        int index1 = 1; // Index for arrival array
        int index2 = 0; // Index for departure array

        // Traverse arrival and departure arrays
        while (index1 < n && index2 < n) {
            if (arr[index1] <= dep[index2]) { //if current train arrived before previous train departs then we need one more platform
                count++; // Increase platform count on arrival
                index1++;
            } else {  //if current train arrived after previous train departs then we can use the same platform
            	index1++;
                index2++;
            }
            platforms = Math.max(count, platforms); // Update result if needed
        }
        return platforms; // Return the maximum platforms needed
    }
}

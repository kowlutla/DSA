/**
 * 	Geek is a software engineer. He is assigned with the task of calculating average waiting time of all the processes by following shortest job first policy.
	
	The shortest job first (SJF) or shortest job next, is a scheduling policy that selects the waiting process with the smallest execution time to execute next.
	
	Given an array of integers bt of size n. Array bt denotes the burst time of each process. Calculate the average waiting time of all the processes and return the nearest integer which is smaller or equal to the output.
	
	Note: Consider all process are available at time 0.
	
	Example 1:
	Input:
	n = 5
	bt = [4,3,7,1,2]
	Output: 4
	Explanation: After sorting burst times by shortest job policy, calculated average waiting time is 4.

	Example 2:
	Input:
	n = 4
	arr = [1,2,3,4]
	Output: 2
	Explanation: After sorting burst times by shortest job policy, calculated average waiting time is 2.
 */
package com.dsa.greedy;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class GD3ShortestJobFirst {

    /**
     * Calculates the average waiting time for the shortest job first (SJF) scheduling algorithm.
     *
     * Time Complexity: O(N log N)
     * The time complexity is dominated by the sorting step, which is O(N log N), where N is the number of jobs.
     *
     * Space Complexity: O(1)
     * The space complexity is constant because we are only using a fixed amount of extra space.
     *
     * @param bt an array representing the burst times of each job
     * @return the average waiting time for the jobs
     */
    public static int shortestJobFirst(int[] bt) {
        int waitingTime = 0; // Total waiting time
        int timer = 0; // Cumulative time elapsed

        // Sort the burst times in ascending order
        Arrays.sort(bt);

        // Calculate the total waiting time
        for (int i = 0; i < bt.length; i++) {
            waitingTime += timer; // Add the elapsed time to the waiting time
            timer += bt[i]; // Increment the timer by the current job's burst time
            System.out.println(bt[i] + " " + timer + " " + waitingTime); // Print current job's burst time, cumulative time, and total waiting time
        }

        // Return the average waiting time
        return waitingTime / bt.length;
    }
}

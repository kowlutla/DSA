/**
 *	Given a set of N jobs where each jobi has a deadline and profit associated with it.
	
	Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with job if and only if the job is completed by its deadline.
	
	Find the number of jobs done and the maximum profit.
	
	Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job. Deadline of the job is the time before which job needs to be completed to earn the profit.
	
	
	Example 1:
	Input:
	N = 4
	Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
	Output:
	2 60
	Explanation:
	Job1 and Job3 can be done with
	maximum profit of 60 (20+40).

	Example 2:
	Input:
	N = 5
	Jobs = {(1,2,100),(2,1,19),(3,2,27),
	        (4,1,25),(5,1,15)}
	Output:
	2 127
	Explanation:
	2 jobs can be done with
	maximum profit of 127 (100+27).

 */
package com.dsa.greedy;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class GD6JobSequencingProblem {

    class Job {
        int id, profit, deadline;
        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    /**
     * Time Complexity: O(n log n) for sorting + O(n * d) for job assignment, where n is the number of jobs
     * and d is the maximum deadline. Overall: O(n log n + n * d).
     * 
     * Space Complexity: O(d) for the deadlines array, where d is the maximum deadline.
     */
    int[] JobScheduling(Job arr[], int n) {
        // Sort jobs in descending order of profit
        Arrays.sort(arr, (j1, j2) -> j2.profit - j1.profit);

        // Find the maximum deadline
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        }

        // Initialize deadlines array to track job deadlines
        int[] deadlines = new int[maxDeadline + 1];
        Arrays.fill(deadlines, -1);

        // Variables to keep track of total jobs and maximum profit
        int totalJobs = 0;
        int maxProfit = 0;

        // Iterate through each job
        for (int i = 0; i < n; i++) {
            int currentDeadline = arr[i].deadline;

            // Find a free slot for this job before its deadline
            for (int j = currentDeadline; j > 0; j--) {
                if (deadlines[j] == -1) { // If slot is free
                    deadlines[j] = arr[i].id; // Assign job id to this slot
                    totalJobs++; // Increment total jobs count
                    maxProfit += arr[i].profit; // Add profit
                    break; // Break the loop as job is assigned
                }
            }
        }

        // Return the total number of jobs done and the maximum profit
        return new int[]{totalJobs, maxProfit};
    }
}

/**
 * 	Geek is going for n days training program, he can perform any one of these three activities Running, Fighting, and Learning Practice. 
  	Each activity has some point on each day. as Geek wants to improve all his skills, he can't do the same activity on two consecutive days, 
 	help Geek to maximize his merit points as we were given a 2D array of n*3 points corresponding to each day and activity.

	Example:
	Input:
	n = 3
	point= [[1,2,5],[3,1,1],[3,3,3]]
	Output:
	11

	Explanation:
	Geek will learn a new move and earn 5 point then on second
	day he will do running and earn 3 point and on third day
	he will do fighting and earn 3 points so, maximum point is 11.
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class GeekTraining {

    // Recursive solution to find the maximum points
    public static int maximumPointsRecursion(int[][] points, int N) {
        int lastTask = 3;
        return maximumPointsRecursion(points, N - 1, lastTask);
    }

    // Recursive helper method
    private static int maximumPointsRecursion(int[][] points, int day, int lastTask) {
        if (day == 0) {
            int max = 0;
            // Calculate maximum points for the last day
            for (int task = 0; task < 3; task++) {
                if (task != lastTask) {
                    max = Math.max(max, points[day][task]);
                }
            }
            return max;
        }

        int max = 0;
        // Calculate maximum points for each day considering the previous day's points
        for (int task = 0; task < 3; task++) {
            if (task != lastTask) {
                int currentPoints = points[day][task] + maximumPointsRecursion(points, day - 1, task);
                max = Math.max(max, currentPoints);
            }
        }
        return max;
    }

    // Memoization-based solution to find the maximum points
    public static int maximumPointsMemoization(int points[][], int N) {
        int lastTask = 3;
        // Create a 2D array to store computed values and initialize with -1
        int dp[][] = new int[N][4];

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return maximumPointsMemoization(points, N - 1, lastTask, dp);
    }

    // Memoization-based helper method
    private static int maximumPointsMemoization(int[][] points, int day, int lastTask, int[][] dp) {
        if (day == 0) {
            int max = 0;
            // Calculate maximum points for the last day
            for (int task = 0; task < 3; task++) {
                if (task != lastTask) {
                    max = Math.max(points[day][task], max);
                }
            }
            // Store the computed max in the memoization table
            return dp[day][lastTask] = max;
        }

        if (dp[day][lastTask] != -1) {
            return dp[day][lastTask];
        }

        int max = 0;
        // Calculate maximum points for each day considering the previous day's points
        for (int task = 0; task < 3; task++) {
            if (task != lastTask) {
                int currentPoints = points[day][task] + maximumPointsMemoization(points, day - 1, task, dp);
                max = Math.max(max, currentPoints);
            }
        }

        // Store the computed max in the memoization table
        return dp[day][lastTask] = max;
    }

    // Tabulation-based solution to find the maximum points
    public static int maximumPointsTabulation(int points[][], int N) {
        int dp[][] = new int[N][4];
        // Initialize base cases for day 0
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < N; day++) {
            for (int lastTask = 0; lastTask < 4; lastTask++) {
                dp[day][lastTask] = 0;
                // Compute maximum points for the current day based on previous day's points
                for (int task = 0; task < 3; task++) {
                    if (task != lastTask) {
                        int currentPoints = points[day][task] + dp[day - 1][task];
                        dp[day][lastTask] = Math.max(dp[day][lastTask], currentPoints);
                    }
                }
            }
        }

        return dp[N - 1][3];
    }

    // Space-optimized tabulation-based solution to find the maximum points
    public static int maximumPointsSpaceOptimization(int points[][], int N) {
        int[] previous = new int[4];
        // Initialize base cases for day 0
        previous[0] = Math.max(points[0][1], points[0][2]);
        previous[1] = Math.max(points[0][0], points[0][2]);
        previous[2] = Math.max(points[0][0], points[0][1]);
        previous[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < N; day++) {
            int temp[] = new int[4];
            for (int lastTask = 0; lastTask < 4; lastTask++) {
                temp[lastTask] = 0;
                // Compute maximum points for the current day based on previous day's points
                for (int task = 0; task < 3; task++) {
                    if (task != lastTask) {
                        int currentPoints = points[day][task] + previous[task];
                        temp[lastTask] = Math.max(temp[lastTask], currentPoints);
                    }
                }
            }
            previous = temp; // Update the 'previous' array with new values for the next iteration
        }

        return previous[3]; // Return the maximum points for the last day
    }

    // Main method for testing purposes
    public static void main(String[] args) {
        // Add test cases or method calls to validate the functionality
        // For example:
        int[][] points = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int N = 3;

        // Test each method
        System.out.println("Recursive solution: " + maximumPointsRecursion(points, N));
        System.out.println("Memoization solution: " + maximumPointsMemoization(points, N));
        System.out.println("Tabulation solution: " + maximumPointsTabulation(points, N));
        System.out.println("Space-optimized solution: " + maximumPointsSpaceOptimization(points, N));
    }
}

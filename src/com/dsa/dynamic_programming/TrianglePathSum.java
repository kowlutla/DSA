/**
 * 	Given a triangle array, return the minimum path sum to reach from top to bottom.

	For each step, you may move to an adjacent number of the row below. More formally, 
	if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

	Example 1:
	
	Input:
	n = 4
	triangle = [[2],
	           [3,4],
	          [6,5,7],
	         [4,1,8,3]]
	Output:
	11
	Explanation:
	     2
	   3 4
	  6 5 7
	 4 1 8 3
	The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11.
	Example 2:
	
	Input:
	n =  1
	triangle = [[10]]
	Output:
	10
 */
package com.dsa.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class TrianglePathSum {

	public static int minimizeSumMemoization(int n, ArrayList<ArrayList<Integer>> grid) {
		int row = 0, col = 0;
		int dp[][] = new int[n][n];
		for (int[] d : dp) {
			Arrays.fill(d, -1);
		}
		return minimizeSumMemoization(n, grid, row, col, dp);
	}

	private static int minimizeSumMemoization(int n, ArrayList<ArrayList<Integer>> grid,
			int row, int col, int[][] dp) {
		if (row == n - 1) {
			return grid.get(row).get(col);
		}

		if (dp[row][col] != -1) {
			return dp[row][col];
		}
		int down = minimizeSumMemoization(n, grid, row + 1, col, dp);
		int diagonal = minimizeSumMemoization(n, grid, row + 1, col + 1, dp);

		return dp[row][col] = Math.min(down, diagonal) + grid.get(row).get(col);
	}
}

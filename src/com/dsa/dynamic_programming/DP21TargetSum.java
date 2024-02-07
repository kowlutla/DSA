/**
 *	You are given an integer array nums and an integer target.

	You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
	
	For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
	Return the number of different expressions that you can build, which evaluates to target.
	
	 
	
	Example 1:
	
	Input: nums = [1,1,1,1,1], target = 3
	Output: 5
	Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
	-1 + 1 + 1 + 1 + 1 = 3
	+1 - 1 + 1 + 1 + 1 = 3
	+1 + 1 - 1 + 1 + 1 = 3
	+1 + 1 + 1 - 1 + 1 = 3
	+1 + 1 + 1 + 1 - 1 = 3
	Example 2:
	
	Input: nums = [1], target = 1
	Output: 1
  
 */
package com.dsa.dynamic_programming;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP21TargetSum {

	int mod = (int) 1e9;
	public int findTargetSumWays(int[] nums, int target) {
		/**
		 * when you assign the signs to every number they will divide into 
		 * two groups having +sign and -sign. so it will like (sum of +ve numbers) - (sum of negative numbers)
		 * So this is similar to number of partitions with absolute sum between two partitions is target
		 * +a-b-c+d+e which can be written as (+a+d+e) + (-b-c).
		 */
		return countPartitionsTabulation(nums.length, target, nums);
	}

	public int countPartitionsTabulation(int n, int d, int arr[]) {
		int totalSum = 0;
		for (int num : arr) {
			totalSum += num;
		}
		// s1-s2 = d
		// s1+s2 = totalSum
		// s1 = totalSum-s2
		// totalSum-s2-s2 = d,
		// -2s2 = d-totalSum
		// s2 = (totalSum-d)/2
		// so find the count of subsets with summ s2
		if (totalSum < d || (totalSum - d) % 2 == 1) {
			return 0;
		}
		int sum = (totalSum - d) / 2;
		return findWaysTabulation(arr, sum);
	}

	public int findWaysTabulation(int num[], int tar) {
		int[][] dp = new int[num.length][tar + 1];
		if (num[0] == 0) {
			dp[0][0] = 2;
		} else {
			dp[0][0] = 1;
		}
		if (num[0] != 0 && num[0] <= tar) {
			dp[0][num[0]] = 1;
		}
		for (int index = 1; index < num.length; index++) {
			for (int sum = 0; sum <= tar; sum++) {
				int notPick = dp[index - 1][sum];
				int pick = 0;
				if (num[index] <= sum) {
					pick = dp[index - 1][sum - num[index]];
				}
				dp[index][sum] = (pick + notPick) % mod;
			}
		}
		return dp[num.length - 1][tar];
	}
	
	public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 5;

        DP21TargetSum dp = new DP21TargetSum();

        // Test findTargetSumWays
        System.out.println("Testing findTargetSumWays:");
        System.out.println("Result: " + dp.findTargetSumWays(nums, target));
    }

}

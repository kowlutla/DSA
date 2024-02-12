/**
 * 	You are given an array prices where prices[i] is the price of a given stock 
 	on the ith day, and an integer fee representing a transaction fee.
	
	Find the maximum profit you can achieve. You may complete as many transactions 
	as you like, but you need to pay the transaction fee for each transaction.
	
	Note:
	You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
	The transaction fee is only charged once for each stock purchase and sale.
	 
	Example 1:
	Input: prices = [1,3,2,8,4,9], fee = 2
	Output: 8
	Explanation: The maximum profit can be achieved by:
	- Buying at prices[0] = 1
	- Selling at prices[3] = 8
	- Buying at prices[4] = 4
	- Selling at prices[5] = 9
	The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

	Example 2:
	Input: prices = [1,3,7,5,10,3], fee = 3
	Output: 6
	 
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP40BuyStockWithTransactionFee {

    // Method to find maximum profit using recursion
    public static int maxProfitRecursion(int[] prices, int fee) {
        // Call the recursive method with initial parameters
        return maxProfitRecursion(prices, 0, 1, fee);
    }

    // Recursive method to find maximum profit
    private static int maxProfitRecursion(int[] prices, int day, int canBuy, int fee) {
        // Base case: if day exceeds array length, return 0
        if (day == prices.length) {
            return 0;
        }
        
        // Check if we can buy stocks on the current day
        if (canBuy == 1) {
            // Calculate profit for buying or not buying and return the maximum
            int buy = -prices[day] + maxProfitRecursion(prices, day + 1, 0, fee); // Buy
            int notBuy = maxProfitRecursion(prices, day + 1, 1, fee); // Don't buy
            return Math.max(buy, notBuy);
        } else {
            // Calculate profit for selling or not selling and return the maximum
            int sell = prices[day] + maxProfitRecursion(prices, day + 1, 1, fee) - fee; // Sell
            int notSell = maxProfitRecursion(prices, day + 1, 0, fee); // Don't sell
            return Math.max(sell, notSell);
        }
    }
    
    // Method to find maximum profit using memoization
    public int maxProfitMemoization(int[] prices, int fee) {
        // Initialize a memoization array to store computed results
        int[][] dp = new int[prices.length][2];
        for (int[] d : dp) {
            Arrays.fill(d, -1); // Initialize with -1
        }
        // Call the memoization method with initial parameters
        return maxProfitMemoization(prices, 0, 1, fee, dp);
    }

    // Memoization method to find maximum profit
    private int maxProfitMemoization(int[] prices, int day, int canBuy, int fee, int[][] dp) {
        // Base case: if day exceeds array length, return 0
        if (day == prices.length) {
            return 0;
        }

        // If result is already computed, return it
        if (dp[day][canBuy] != -1) {
            return dp[day][canBuy];
        }

        // Check if we can buy stocks on the current day
        if (canBuy == 1) {
            // Calculate profit for buying or not buying and store the result in dp array
            int buy = -prices[day] + maxProfitMemoization(prices, day + 1, 0, fee, dp); // Buy
            int notBuy = maxProfitMemoization(prices, day + 1, 1, fee, dp); // Don't buy
            return dp[day][canBuy] = Math.max(buy, notBuy);
        } else {
            // Calculate profit for selling or not selling and store the result in dp array
            int sell = prices[day] + maxProfitMemoization(prices, day + 1, 1, fee, dp) - fee; // Sell
            int notSell = maxProfitMemoization(prices, day + 1, 0, fee, dp); // Don't sell
            return dp[day][canBuy] = Math.max(sell, notSell);
        }
    }
    
    // Method to find maximum profit using tabulation
    public int maxProfitTabulation(int[] prices, int fee) {
        int n = prices.length;
        // Initialize a 2D array to store computed results
        int[][] dp = new int[n + 1][2];

        // Iterate over days and transactions to fill the dp array
        for (int day = n; day >= 0; day--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                if (day == n) {
                    dp[day][canBuy] = 0; // Base case: no profit can be made on last day
                } else {
                    // Calculate profit for buying or not buying and store it in dp array
                    if (canBuy == 1) {
                        int buy = -prices[day] + dp[day + 1][0]; // Buy
                        int notBuy = dp[day + 1][1]; // Don't buy
                        dp[day][canBuy] = Math.max(buy, notBuy);
                    } else {
                        // Calculate profit for selling or not selling and store it in dp array
                        int sell = prices[day] - fee + dp[day + 1][1]; // Sell
                        int notSell = dp[day + 1][0]; // Don't sell
                        dp[day][canBuy] = Math.max(sell, notSell);
                    }
                }
            }
        }
        // Return the maximum profit when we can buy stocks
        return dp[0][1];
    }
    
    // Method to find maximum profit with space optimization
    public static int maxProfitSpaceOptimization(int[] prices, int fee) {
        int n = prices.length;
        // Initialize arrays to store profit for current and ahead days
        int[] ahead = new int[2];
        int[] current = new int[2];

        // Iterate over days and transactions to update profit arrays
        for (int day = n; day >= 0; day--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                if (day == n) {
                    current[canBuy] = 0; // Base case: no profit can be made on last day
                } else {
                    // Calculate profit for buying or not buying and store it in current array
                    if (canBuy == 1) {
                        int buy = -prices[day] + ahead[0]; // Buy
                        int notBuy = ahead[1]; // Don't buy
                        current[canBuy] = Math.max(buy, notBuy);
                    } else {
                        // Calculate profit for selling or not selling and store it in current array
                        int sell = prices[day] - fee + ahead[1]; // Sell
                        int notSell = ahead[0]; // Don't sell
                        current[canBuy] = Math.max(sell, notSell);
                    }
                }
            }
            // Update ahead array for the next iteration
            ahead = current;
        }
        // Return the maximum profit when we can buy stocks
        return ahead[1];
    }
    
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9}; // Sample prices array
        int fee = 2; // Transaction fee

        // Using recursion
        int maxProfitRecursion = maxProfitRecursion(prices, fee);
        System.out.println("Maximum profit using recursion: " + maxProfitRecursion);

        // Using memoization
        DP40BuyStockWithTransactionFee dpMemoization = new DP40BuyStockWithTransactionFee();
        int maxProfitMemoization = dpMemoization.maxProfitMemoization(prices, fee);
        System.out.println("Maximum profit using memoization: " + maxProfitMemoization);

        // Using tabulation
        int maxProfitTabulation = dpMemoization.maxProfitTabulation(prices, fee);
        System.out.println("Maximum profit using tabulation: " + maxProfitTabulation);

        // Using space optimization
        int maxProfitSpaceOptimization = maxProfitSpaceOptimization(prices, fee);
        System.out.println("Maximum profit using space optimization: " + maxProfitSpaceOptimization);
    }
}

/**
 * 	You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
	Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and 
	sell at most k times.
	Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
	
	Example 1:
	Input: k = 2, prices = [2,4,1]
	Output: 2
	Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

	Example 2:
	Input: k = 2, prices = [3,2,6,5,0,3]
	Output: 7
	Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. 
	Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP38BestTimeToBuyAndSellStockIV1 {

    // Method to find the maximum profit using recursion
    public static int maxProfitRecursion(int k, int[] prices) {
        return maxProfitRecursion(prices, k, 0, 1); // Call the helper method with initial parameters
    }

    // Helper method for recursion
    private static int maxProfitRecursion(int[] prices, int transactions, int day, int canBuy) {

        if (transactions == 0) { // If no more transactions are allowed
            return 0;
        }

        if (day == prices.length) { // If all days are traversed
            return 0;
        }

        if (canBuy == 1) { // If the stock can be bought
            int buy = -prices[day] + maxProfitRecursion(prices, transactions, day + 1, 0); // Buy the stock and proceed to the next day
            int notBuy = maxProfitRecursion(prices, transactions, day + 1, 1); // Don't buy the stock and proceed to the next day
            return Math.max(buy, notBuy); // Choose the maximum profit between buying and not buying
        } else { // If the stock can be sold
            int sell = prices[day] + maxProfitRecursion(prices, transactions - 1, day + 1, 1); // Sell the stock and proceed to the next day with one less transaction
            int notSell = maxProfitRecursion(prices, transactions, day + 1, 0); // Don't sell the stock and proceed to the next day
            return Math.max(sell, notSell); // Choose the maximum profit between selling and not selling
        }
    }
    
    // Method to find the maximum profit using memoization
    public static int maxProfitMemoization(int k, int[] prices) {
        int[][][] dp = new int[prices.length][2][k + 1]; // Initialize the memoization array
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1); // Fill the memoization array with -1
            }
        }
        return maxProfitMemoization(prices, k, 0, 1, dp); // Call the helper method with initial parameters
    }

    // Helper method for memoization
    private static int maxProfitMemoization(int[] prices, int transactions, int day, int canBuy,
            int[][][] dp) {

        if (transactions == 0) { // If no more transactions are allowed
            return 0;
        }

        if (day == prices.length) { // If all days are traversed
            return 0;
        }
        if (dp[day][canBuy][transactions] != -1) { // If the value is already calculated, return it
            return dp[day][canBuy][transactions];
        }
        if (canBuy == 1) { // If the stock can be bought
            int buy = -prices[day] + maxProfitMemoization(prices, transactions, day + 1, 0, dp); // Buy the stock and proceed to the next day
            int notBuy = maxProfitMemoization(prices, transactions, day + 1, 1, dp); // Don't buy the stock and proceed to the next day
            return dp[day][canBuy][transactions] = Math.max(buy, notBuy);
        } else { // If the stock can be sold
            int sell = prices[day] + maxProfitMemoization(prices, transactions - 1, day + 1, 1, dp); // Sell the stock and proceed to the next day with one less transaction
            int notSell = maxProfitMemoization(prices, transactions, day + 1, 0, dp); // Don't sell the stock and proceed to the next day
            return dp[day][canBuy][transactions] = Math.max(sell, notSell);
        }
    }
    
    // Method to find the maximum profit using tabulation
    public static int maxProfitTabulation(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][k + 1]; // Initialize the tabulation array
        for (int day = n; day >= 0; day--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int transactions = 0; transactions <= k; transactions++) {
                    if (day == n || transactions == 0) { // If it's the last day or no more transactions are allowed
                        dp[day][canBuy][transactions] = 0; // Set profit to 0
                    } else {
                        if (canBuy == 1) { // If the stock can be bought
                            int buy = -prices[day] + dp[day + 1][0][transactions]; // Buy the stock and proceed to the next day
                            int notBuy = dp[day + 1][1][transactions]; // Don't buy the stock and proceed to the next day
                            dp[day][canBuy][transactions] = Math.max(buy, notBuy); // Choose the maximum profit between buying and not buying
                        } else { // If the stock can be sold
                            int sell = prices[day] + dp[day + 1][1][transactions - 1]; // Sell the stock and proceed to the next day with one less transaction
                            int notSell = dp[day + 1][0][transactions]; // Don't sell the stock and proceed to the next day
                            dp[day][canBuy][transactions] = Math.max(sell, notSell); // Choose the maximum profit between selling and not selling
                        }
                    }
                }
            }
        }
        return dp[0][1][k]; // Return the maximum profit
    }
    
    // Method to find the maximum profit using space optimization
    public static int maxProfitSpaceOptimization(int k, int[] prices) {
        int n = prices.length;
        int[][] ahead = new int[2][k + 1]; // Initialize arrays for previous and current days
        int[][] current = new int[2][k + 1];
        for (int day = n; day >= 0; day--) { // Traverse through the days
            for (int canBuy = 0; canBuy <= 1; canBuy++) { // Iterate through buy and sell states
                for (int transactions = 0; transactions <= k; transactions++) { // Iterate through transactions
                    if (day == n || transactions == 0) { // If it's the last day or no more transactions are allowed
                        current[canBuy][transactions] = 0; // Set profit to 0
                    } else {
                        if (canBuy == 1) { // If the stock can be bought
                            int buy = -prices[day] + ahead[0][transactions]; // Buy the stock and use the profit from the previous day
                            int notBuy = ahead[1][transactions]; // Don't buy the stock and use the profit from the previous day
                            current[canBuy][transactions] = Math.max(buy, notBuy); // Choose the maximum profit between buying and not buying
                        } else { // If the stock can be sold
                            int sell = prices[day] + ahead[1][transactions - 1]; // Sell the stock and use the profit from the previous day with one less transaction
                            int notSell = ahead[0][transactions]; // Don't sell the stock and use the profit from the previous day
                            current[canBuy][transactions] = Math.max(sell, notSell); // Choose the maximum profit between selling and not selling
                        }
                    }
                }
                ahead = current; // Update the arrays for the next iteration
            }
        }
        return ahead[1][k]; // Return the maximum profit
    }
    
    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3, 1, 2}; // Sample prices array
        int k = 3; // Maximum number of transactions allowed

        // Using recursion
        int maxProfitRecursion = maxProfitRecursion(k, prices);
        System.out.println("Maximum profit using recursion: " + maxProfitRecursion);

        // Using memoization
        int maxProfitMemoization = maxProfitMemoization(k, prices);
        System.out.println("Maximum profit using memoization: " + maxProfitMemoization);

        // Using tabulation
        int maxProfitTabulation = maxProfitTabulation(k, prices);
        System.out.println("Maximum profit using tabulation: " + maxProfitTabulation);

        // Using space optimization
        int maxProfitSpaceOptimization = maxProfitSpaceOptimization(k, prices);
        System.out.println("Maximum profit using space optimization: " + maxProfitSpaceOptimization);
    }

}


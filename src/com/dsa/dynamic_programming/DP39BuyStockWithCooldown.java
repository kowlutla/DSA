/**
 * 	You are given an array prices where prices[i] is the price of a given stock on the ith day.
	
	Find the maximum profit you can achieve. You may complete as many transactions as you like 
	(i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
	
	After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
	Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the
	stock before you buy again).
	
	Example 1:
	Input: prices = [1,2,3,0,2]
	Output: 3
	Explanation: transactions = [buy, sell, cooldown, buy, sell]

	Example 2:
	Input: prices = [1]
	Output: 0
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP39BuyStockWithCooldown {

    // Method to find the maximum profit using recursion
    public static int maxProfitRecursion(int[] prices) {
        return maxProfitRecursion(prices, 0, 1); // Call the recursive method with initial parameters
    }

    // Recursive method to find the maximum profit
    private static int maxProfitRecursion(int[] prices, int day, int canBuy) {
        if (day >= prices.length) { // If all days are traversed
            return 0;
        }

        if (canBuy == 1) { // If allowed to buy stock
            int buy = -prices[day] + maxProfitRecursion(prices, day + 1, 0); // Buy the stock and proceed to the next available day (cooldown)
            int notBuy = maxProfitRecursion(prices, day + 1, 1); // Do not buy the stock and proceed to the next day
            return Math.max(buy, notBuy); // Choose the maximum profit between buying and not buying
        } else { // If not allowed to buy stock
            int sell = prices[day] + maxProfitRecursion(prices, day + 2, 1); // Sell the stock and skip the next day (cooldown)
            int notSell = maxProfitRecursion(prices, day + 1, 0); // Do not sell the stock and proceed to the next day
            return Math.max(sell, notSell); // Choose the maximum profit between selling and not selling
        }
    }
    
    // Method to find the maximum profit using memoization
    public int maxProfitMemoization(int[] prices) {
        int[][] dp = new int[prices.length][2]; // Initialize the memoization array
        for (int d[] : dp) {
            Arrays.fill(d, -1); // Fill the memoization array with -1
        }
        return maxProfitMemoization(prices, 0, 1, dp); // Call the memoization method with initial parameters
    }

    // Memoization method to find the maximum profit
    private int maxProfitMemoization(int[] prices, int day, int canBuy, int[][] dp) {
        if (day >= prices.length) { // If all days are traversed
            return 0;
        }

        if (dp[day][canBuy] != -1) { // If the value is already calculated, return it
            return dp[day][canBuy];
        }

        if (canBuy == 1) { // If allowed to buy stock
            int buy = -prices[day] + maxProfitMemoization(prices, day + 1, 0, dp); // Buy the stock and proceed to the next available day (cooldown)
            int notBuy = maxProfitMemoization(prices, day + 1, 1, dp); // Do not buy the stock and proceed to the next day
            return dp[day][canBuy] = Math.max(buy, notBuy); // Choose the maximum profit between buying and not buying
        } else { // If not allowed to buy stock
            int sell = prices[day] + maxProfitMemoization(prices, day + 2, 1, dp); // Sell the stock and skip the next day (cooldown)
            int notSell = maxProfitMemoization(prices, day + 1, 0, dp); // Do not sell the stock and proceed to the next day
            return dp[day][canBuy] = Math.max(sell, notSell); // Choose the maximum profit between selling and not selling
        }
    }
    
    // Method to find the maximum profit using tabulation
    public static int maxProfitTabulation(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2]; // Initialize the tabulation array
        for (int day = n; day >= 0; day--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                if (day >= n) { // If it's the last day
                    dp[day][canBuy] = 0; // Set the profit to 0
                } else {
                    if (canBuy == 1) { // If allowed to buy stock
                        int buy = -prices[day] + dp[day + 1][0]; // Buy the stock and proceed to the next available day (cooldown)
                        int notBuy = dp[day + 1][1]; // Do not buy the stock and proceed to the next day
                        dp[day][canBuy] = Math.max(buy, notBuy); // Choose the maximum profit between buying and not buying
                    } else { // If not allowed to buy stock
                        int sell = prices[day] + dp[day + 2][1]; // Sell the stock and skip the next day (cooldown)
                        int notSell = dp[day + 1][0]; // Do not sell the stock and proceed to the next day
                        dp[day][canBuy] = Math.max(sell, notSell); // Choose the maximum profit between selling and not selling
                    }
                }
            }
        }
        return dp[0][1]; // Return the maximum profit
    }
    
    // Method to find the maximum profit using space optimization
    public static int maxProfitSpaceOptimization(int[] prices) {
        int n = prices.length;
        int[] ahead2 = new int[2]; // Initialize the ahead array for two days ahead
        int[] ahead1 = new int[2]; // Initialize the ahead array for one day ahead
        int[] current = new int[2]; // Initialize the current array
        for (int day = n; day >= 0; day--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                if (day >= n) { // If it's the last day
                    current[canBuy] = 0; // Set the profit to 0
                } else {
                    if (canBuy == 1) { // If allowed to buy stock
                        int buy = -prices[day] + ahead1[0]; // Buy the stock and use the profit from one day ahead
                        int notBuy = ahead1[1]; // Do not buy the stock and use the profit from one day ahead
                        current[canBuy] = Math.max(buy, notBuy); // Choose the maximum profit between buying and not buying
                    } else { // If not allowed to buy stock
                        int sell = prices[day] + ahead2[1]; // Sell the stock and use the profit from two days ahead
                        int notSell = ahead1[0]; // Do not sell the stock and use the profit from one day ahead
                        current[canBuy] = Math.max(sell, notSell); // Choose the maximum profit between selling and not selling
                    }
                }
            }
            System.arraycopy(ahead1, 0, ahead2, 0, 2); // Update the ahead array for the next iteration
            System.arraycopy(current, 0, ahead1, 0, 2); // Update the ahead array for the next iteration
        }
        return current[1]; // Return the maximum profit
    }
    
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2}; // Sample prices array

        // Using recursion
        int maxProfitRecursion = DP39BuyStockWithCooldown.maxProfitRecursion(prices);
        System.out.println("Maximum profit using recursion: " + maxProfitRecursion);

        // Using memoization
        DP39BuyStockWithCooldown dpMemoization = new DP39BuyStockWithCooldown();
        int maxProfitMemoization = dpMemoization.maxProfitMemoization(prices);
        System.out.println("Maximum profit using memoization: " + maxProfitMemoization);

        // Using tabulation
        int maxProfitTabulation = DP39BuyStockWithCooldown.maxProfitTabulation(prices);
        System.out.println("Maximum profit using tabulation: " + maxProfitTabulation);

        // Using space optimization
        int maxProfitSpaceOptimization = DP39BuyStockWithCooldown.maxProfitSpaceOptimization(prices);
        System.out.println("Maximum profit using space optimization: " + maxProfitSpaceOptimization);
    }
}

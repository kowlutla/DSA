/**
 * 	You are given an array prices where prices[i] is the price of a given stock on the ith day.
	Find the maximum profit you can achieve. You may complete at most two transactions.
	Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
	
	Example 1:
	Input: prices = [3,3,5,0,0,3,1,4]
	Output: 6
	Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
	Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

	Example 2:
	Input: prices = [1,2,3,4,5]
	Output: 4
	Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
	Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.

	Example 3:
	Input: prices = [7,6,4,3,1]
	Output: 0
	Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP37BestTimeToBuyAndSellStocksIII {

    // Method to find the maximum profit using recursion
    public static int maxProfitRecursion(int[] prices) {
        return maxProfitRecursion(prices, 0, 1, 2); // Call the helper method with initial parameters
    }

    // Helper method for recursion
    private static int maxProfitRecursion(int[] prices, int day, int canBuy, int transactions) {

        if (transactions == 0) { // If no more transactions are allowed
            return 0;
        }

        if (day == prices.length) { // If all days are traversed
            return 0;
        }

        int profit = 0;
        if (canBuy == 1) { // If the stock can be bought
            int buy = -prices[day] + maxProfitRecursion(prices, day + 1, 0, transactions); // Buy the stock and proceed to the next day
            int notBuy = maxProfitRecursion(prices, day + 1, 1, transactions); // Don't buy the stock and proceed to the next day
            profit = Math.max(buy, notBuy); // Choose the maximum profit between buying and not buying
        } else { // If the stock can be sold
            int sell = prices[day] + maxProfitRecursion(prices, day + 1, 1, transactions - 1); // Sell the stock and proceed to the next day with one less transaction
            int notSell = maxProfitRecursion(prices, day + 1, 0, transactions); // Don't sell the stock and proceed to the next day
            profit = Math.max(sell, notSell); // Choose the maximum profit between selling and not selling
        }
        return profit; // Return the maximum profit
    }

    // Method to find the maximum profit using memoization
    public static int maxProfitMemoization(int[] prices) {
        int[][][] dp = new int[prices.length][2][3]; // Initialize the memoization array
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1); // Fill the memoization array with -1
            }
        }
        return maxProfitMemoization(prices, 0, 1, 2, dp); // Call the helper method with initial parameters
    }

    // Helper method for memoization
    private static int maxProfitMemoization(int[] prices, int day, int canBuy, int transactions, int[][][] dp) {

        if (transactions == 0) { // If no more transactions are allowed
            return 0;
        }

        if (day == prices.length) { // If all days are traversed
            return 0;
        }

        if (dp[day][canBuy][transactions] != -1) { // If the value is already calculated, return it
            return dp[day][canBuy][transactions];
        }

        int profit = 0;
        if (canBuy == 1) { // If the stock can be bought
            int buy = -prices[day] + maxProfitMemoization(prices, day + 1, 0, transactions, dp); // Buy the stock and proceed to the next day
            int notBuy = maxProfitMemoization(prices, day + 1, 1, transactions, dp); // Don't buy the stock and proceed to the next day
            profit = Math.max(buy, notBuy); // Choose the maximum profit between buying and not buying
        } else { // If the stock can be sold
            int sell = prices[day] + maxProfitMemoization(prices, day + 1, 1, transactions - 1, dp); // Sell the stock and proceed to the next day with one less transaction
            int notSell = maxProfitMemoization(prices, day + 1, 0, transactions, dp); // Don't sell the stock and proceed to the next day
            profit = Math.max(sell, notSell); // Choose the maximum profit between selling and not selling
        }
        return dp[day][canBuy][transactions] = profit; // Update and return the maximum profit
    }

    // Method to find the maximum profit using tabulation
    public static int maxProfitTabulation(int[] price) {
    	int n = price.length;
        int[][][] dp = new int[price.length + 1][2][3]; // Initialize the tabulation array
        for (int day = n; day >= 0; day--) { // Traverse through the days
            for (int canBuy = 0; canBuy <= 1; canBuy++) { // Iterate through buy and sell states
                for (int transactions = 0; transactions <= 2; transactions++) { // Iterate through transactions
                    int profit = 0;
                    if (day == n || transactions == 0) { // If it's the last day or no more transactions are allowed
                        dp[day][canBuy][transactions] = 0; // Set profit to 0
                    } else {
                        if (canBuy == 1) { // If the stock can be bought
                            int buy = -price[day] + dp[day + 1][0][transactions]; // Buy the stock and proceed to the next day
                            int notBuy = dp[day + 1][1][transactions]; // Don't buy the stock and proceed to the next day
                            profit = Math.max(buy, notBuy); // Choose the maximum profit between buying and not buying
                        } else { // If the stock can be sold
                            int sell = price[day] + dp[day + 1][1][transactions - 1]; // Sell the stock and proceed to the next day with one less transaction
                            int notSell = dp[day + 1][0][transactions]; // Don't sell the stock and proceed to the next day
                            profit = Math.max(sell, notSell); // Choose the maximum profit between selling and not selling
                        }
                        dp[day][canBuy][transactions] = profit; // Update the tabulation array
                    }
                }
            }
        }

        return dp[0][1][2]; // Return the maximum profit
    }
    
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4}; // Sample prices array

        // Using recursion
        int maxProfitRecursion = maxProfitRecursion(prices);
        System.out.println("Maximum profit using recursion: " + maxProfitRecursion);

        // Using memoization
        int maxProfitMemoization = maxProfitMemoization(prices);
        System.out.println("Maximum profit using memoization: " + maxProfitMemoization);

        // Using tabulation
        int maxProfitTabulation = maxProfitTabulation(prices);
        System.out.println("Maximum profit using tabulation: " + maxProfitTabulation);
    }
}

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
public class DP38BestTimeToBuyAndSellStockIV2 {

    // Method to find the maximum profit using recursion
    public static int maxProfitRecursion(int K, int N, int A[]) {
        return maxProfitRecursion(A, K * 2, 0); // Call the recursive method with initial parameters
    }

    // Recursive method to find the maximum profit
    private static int maxProfitRecursion(int[] prices, int transactions, int day) {

        if (day == prices.length) { // If all days are traversed
            return 0;
        }

        if (transactions == 0) { // If no more transactions are allowed
            return 0;
        }

        if (transactions % 2 == 0) { // If the number of transactions is even (indicating a buy state)
            int buy = -prices[day] + maxProfitRecursion(prices, transactions - 1, day + 1); // Buy the stock and proceed to the next day
            int notBuy = maxProfitRecursion(prices, transactions, day + 1); // Don't buy the stock and proceed to the next day
            return Math.max(buy, notBuy); // Choose the maximum profit between buying and not buying
        } else { // If the number of transactions is odd (indicating a sell state)
            int sell = prices[day] + maxProfitRecursion(prices, transactions - 1, day + 1); // Sell the stock and proceed to the next day
            int notSell = maxProfitRecursion(prices, transactions, day + 1); // Don't sell the stock and proceed to the next day
            return Math.max(sell, notSell); // Choose the maximum profit between selling and not selling
        }
    }
    
    // Method to find the maximum profit using memoization
    public static int maxProfitMemoization(int K, int N, int A[]) {
        int[][] dp = new int[N][K * 2 + 1]; // Initialize the memoization array
        for (int d[] : dp) {
            Arrays.fill(d, -1); // Fill the memoization array with -1
        }
        return maxProfitMemoization(A, K * 2, 0, dp); // Call the memoization method with initial parameters
    }

    // Memoization method to find the maximum profit
    private static int maxProfitMemoization(int[] prices, int transactions,
            int day, int[][] dp) {

        if (day == prices.length) { // If all days are traversed
            return 0;
        }

        if (transactions == 0) { // If no more transactions are allowed
            return 0;
        }

        if (dp[day][transactions] != -1) { // If the value is already calculated, return it
            return dp[day][transactions];
        }

        if (transactions % 2 == 0) { // If the number of transactions is even (indicating a buy state)
            int buy = -prices[day] + maxProfitMemoization(prices, transactions - 1, day + 1, dp); // Buy the stock and proceed to the next day
            int notBuy = maxProfitMemoization(prices, transactions, day + 1, dp); // Don't buy the stock and proceed to the next day
            return dp[day][transactions] = Math.max(buy, notBuy); // Choose the maximum profit between buying and not buying
        } else { // If the number of transactions is odd (indicating a sell state)
            int sell = prices[day] + maxProfitMemoization(prices, transactions - 1, day + 1, dp); // Sell the stock and proceed to the next day
            int notSell = maxProfitMemoization(prices, transactions, day + 1, dp); // Don't sell the stock and proceed to the next day
            return dp[day][transactions] = Math.max(sell, notSell); // Choose the maximum profit between selling and not selling
        }
    }

    // Method to find the maximum profit using tabulation
    public static int maxProfitTabulation(int K, int N, int prices[]) {
        int[][] dp = new int[N + 1][K * 2 + 1]; // Initialize the tabulation array
        for (int day = N; day >= 0; day--) {
            for (int transactions = 0; transactions <= K * 2; transactions++) {
                if (transactions == 0 || day == N) { // If it's the last day or no more transactions are allowed
                    dp[day][transactions] = 0; // Set the profit to 0
                } else {
                    if (transactions % 2 == 0) { // If the number of transactions is even (indicating a buy state)
                        int buy = -prices[day] + dp[day + 1][transactions - 1]; // Buy the stock and use the profit from the next day
                        int notBuy = dp[day + 1][transactions]; // Don't buy the stock and use the profit from the next day
                        dp[day][transactions] = Math.max(buy, notBuy); // Choose the maximum profit between buying and not buying
                    } else { // If the number of transactions is odd (indicating a sell state)
                        int sell = prices[day] + dp[day + 1][transactions - 1]; // Sell the stock and use the profit from the next day
                        int notSell = dp[day + 1][transactions]; // Don't sell the stock and use the profit from the next day
                        dp[day][transactions] = Math.max(sell, notSell); // Choose the maximum profit between selling and not selling
                    }
                }
            }
        }
        return dp[0][2 * K]; // Return the maximum profit
    }

    // Method to find the maximum profit using space optimization
    public static int maxProfitSpaceOptimization(int K, int N, int prices[]) {
        int ahead[] = new int[K * 2 + 1]; // Initialize the ahead array
        int current[] = new int[K * 2 + 1]; // Initialize the current array
        for (int day = N; day >= 0; day--) {
            for (int transactions = 0; transactions <= K * 2; transactions++) {
                if (transactions == 0 || day == N) { // If it's the last day or no more transactions are allowed
                    current[transactions] = 0; // Set the profit to 0
                } else {
                    if (transactions % 2 == 0) { // If the number of transactions is even (indicating a buy state)
                        int buy = -prices[day] + ahead[transactions - 1]; // Buy the stock and use the profit from the previous day
                        int notBuy = ahead[transactions]; // Don't buy the stock and use the profit from the previous day
                        current[transactions] = Math.max(buy, notBuy); // Choose the maximum profit between buying and not buying
                    } else { // If the number of transactions is odd (indicating a sell state)
                        int sell = prices[day] + ahead[transactions - 1]; // Sell the stock and use the profit from the previous day
                        int notSell = ahead[transactions]; // Don't sell the stock and use the profit from the previous day
                        current[transactions] = Math.max(sell, notSell); // Choose the maximum profit between selling and not selling
                    }
                }
            }
            ahead = current; // Update the ahead array for the next iteration
        }
        return ahead[2 * K]; // Return the maximum profit
    }
    
    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3}; // Sample prices array
        int K = 2; // Maximum number of transactions allowed
        int N = prices.length; // Length of the prices array

        // Using recursion
        int maxProfitRecursion = maxProfitRecursion(K, N, prices);
        System.out.println("Maximum profit using recursion: " + maxProfitRecursion);

        // Using memoization
        int maxProfitMemoization = maxProfitMemoization(K, N, prices);
        System.out.println("Maximum profit using memoization: " + maxProfitMemoization);

        // Using tabulation
        int maxProfitTabulation = maxProfitTabulation(K, N, prices);
        System.out.println("Maximum profit using tabulation: " + maxProfitTabulation);

        // Using space optimization
        int maxProfitSpaceOptimization = maxProfitSpaceOptimization(K, N, prices);
        System.out.println("Maximum profit using space optimization: " + maxProfitSpaceOptimization);
    }
}

/**
 * 	You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
	On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
	Find and return the maximum profit you can achieve.

	Example 1:
	Input: prices = [7,1,5,3,6,4]
	Output: 7
	Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
	Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
	Total profit is 4 + 3 = 7.

	Example 2:
	Input: prices = [1,2,3,4,5]
	Output: 4
	Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
	Total profit is 4.

	Example 3:
	Input: prices = [7,6,4,3,1]
	Output: 0
	Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP36BestTimeToBuyAndSellStocksII {

    // Method to get the maximum profit using recursion
    public static int getMaximumProfitRecursion(int n, int[] values) {
        return getMaximumProfitRecursion(values, 0, 1); // Call the helper method with initial parameters
    }

    // Helper method for recursion
    private static int getMaximumProfitRecursion(int[] values, int day, int canBuy) {

        if (day == values.length) { // If all days are traversed, return 0
            return 0;
        }

        int profit = 0;
        if (canBuy == 1) { // If the stock can be bought
            int buy = -values[day] + getMaximumProfitRecursion(values, day + 1, 0); // Buy the stock and proceed to the next day
            int notBuy = getMaximumProfitRecursion(values, day + 1, 1); // Don't buy the stock and proceed to the next day
            profit = Math.max(buy, notBuy); // Choose the maximum profit between buying and not buying
        } else { // If the stock can be sold
            int sell = values[day] + getMaximumProfitRecursion(values, day + 1, 1); // Sell the stock and proceed to the next day
            int notSell = getMaximumProfitRecursion(values, day + 1, 0); // Don't sell the stock and proceed to the next day
            profit = Math.max(sell, notSell); // Choose the maximum profit between selling and not selling
        }
        return profit; // Return the maximum profit
    }

    // Method to get the maximum profit using memoization
    public static int maxProfitMemoization(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2]; // Initialize the memoization array
        for (int d[] : dp) {
            Arrays.fill(d, -1); // Fill the memoization array with -1
        }
        return maxProfitMemoization(prices, 0, 1, dp); // Call the helper method with initial parameters
    }

    // Helper method for memoization
    private static int maxProfitMemoization(int[] values, int day, int canBuy, int[][] dp) {

        if (day == values.length) { // If all days are traversed, return 0
            return 0;
        }

        if (dp[day][canBuy] != -1) { // If the value is already calculated, return it
            return dp[day][canBuy];
        }
        int profit = 0;
        if (canBuy == 1) { // If the stock can be bought
            int buy = -values[day] + maxProfitMemoization(values, day + 1, 0, dp); // Buy the stock and proceed to the next day
            int notBuy = maxProfitMemoization(values, day + 1, 1, dp); // Don't buy the stock and proceed to the next day
            profit = Math.max(buy, notBuy); // Choose the maximum profit between buying and not buying
        } else { // If the stock can be sold
            int sell = values[day] + maxProfitMemoization(values, day + 1, 1, dp); // Sell the stock and proceed to the next day
            int notSell = maxProfitMemoization(values, day + 1, 0, dp); // Don't sell the stock and proceed to the next day
            profit = Math.max(sell, notSell); // Choose the maximum profit between selling and not selling
        }
        return dp[day][canBuy] = profit; // Update and return the maximum profit
    }

    // Method to get the maximum profit using tabulation
    public static int maxProfitTabulation(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n + 1][2]; // Initialize the tabulation array
        dp[n][0] = 0;
        dp[n][1] = 0;

        for (int day = n - 1; day >= 0; day--) { // Traverse through the days
            for (int canBuy = 1; canBuy >= 0; canBuy--) { // Iterate through buy and sell states
                int profit = 0;
                if (canBuy == 1) { // If the stock can be bought
                    int buy = -prices[day] + dp[day + 1][0]; // Buy the stock and proceed to the next day
                    int notBuy = dp[day + 1][1]; // Don't buy the stock and proceed to the next day
                    profit = Math.max(buy, notBuy); // Choose the maximum profit between buying and not buying
                } else { // If the stock can be sold
                    int sell = prices[day] + dp[day + 1][1]; // Sell the stock and proceed to the next day
                    int notSell = dp[day + 1][0]; // Don't sell the stock and proceed to the next day
                    profit = Math.max(sell, notSell); // Choose the maximum profit between selling and not selling
                }
                dp[day][canBuy] = profit; // Update the tabulation array
            }
        }

        return dp[0][1]; // Return the maximum profit
    }

    // Method to get the maximum profit using space optimization
    public static int maxProfitSpaceOptimization(int n, int[] values) {
        int aheadDay[] = new int[2]; // Initialize an array to store profit for the next day
        aheadDay[0] = 0;
        aheadDay[1] = 0;

        for (int day = n - 1; day >= 0; day--) { // Traverse through the days
            int currentDay[] = new int[2]; // Initialize an array to store profit for the current day
            for (int canBuy = 1; canBuy >= 0; canBuy--) { // Iterate through buy and sell states
                int profit = 0;
                if (canBuy == 1) { // If the stock can be bought
                    int buy = -values[day] + aheadDay[0]; // Buy the stock and proceed to the next day
                    int notBuy = aheadDay[1]; // Don't buy the stock and proceed to the next day
                    profit = Math.max(buy, notBuy); // Choose the maximum profit between buying and not buying
                } else { // If the stock can be sold
                    int sell = values[day] + aheadDay[1]; // Sell the stock and proceed to the next day
                    int notSell = aheadDay[0]; // Don't sell the stock and proceed to the next day
                    profit = Math.max(sell, notSell); // Choose the maximum profit between selling and not selling
                }
                currentDay[canBuy] = profit; // Update the array for the current day
            }
            aheadDay = currentDay; // Update the array for the next day
        }

        return aheadDay[1]; // Return the maximum profit
    }
    
 // Method to get the maximum profit using space optimization
    public static int maxProfitSpaceOptimization2(int n, int[] values) {
        int aheadDayNotBuy = 0;
        int aheadDayBuy = 0;
        int currentDayNotBuy=0, currentDayBuy=0;

        for (int day = n - 1; day >= 0; day--) { // Traverse through the days
        	
        	int buy = -values[day] + aheadDayNotBuy; // Buy the stock and proceed to the next day
            int notBuy = aheadDayBuy; // Don't buy the stock and proceed to the next day
            currentDayBuy = Math.max(buy, notBuy);
            
            int sell = values[day] + aheadDayBuy; // Sell the stock and proceed to the next day
            int notSell = aheadDayNotBuy; // Don't sell the stock and proceed to the next day
            currentDayNotBuy = Math.max(sell, notSell); // Choose the maximum profit between selling and not selling
            
            aheadDayBuy = currentDayBuy;
            aheadDayNotBuy = currentDayNotBuy;
        }

        return aheadDayBuy; // Return the maximum profit
    }
    
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4}; // Sample prices array

        // Using recursion
        int maxProfitRecursion = getMaximumProfitRecursion(prices.length, prices);
        System.out.println("Maximum profit using recursion: " + maxProfitRecursion);

        // Using memoization
        int maxProfitMemoization = maxProfitMemoization(prices);
        System.out.println("Maximum profit using memoization: " + maxProfitMemoization);

        // Using tabulation
        int maxProfitTabulation = maxProfitTabulation(prices);
        System.out.println("Maximum profit using tabulation: " + maxProfitTabulation);

        // Using space optimization
        int maxProfitSpaceOptimization = maxProfitSpaceOptimization(prices.length, prices);
        System.out.println("Maximum profit using space optimization: " + maxProfitSpaceOptimization);
        
     // Using space optimization
        int maxProfitSpaceOptimization2 = maxProfitSpaceOptimization2(prices.length, prices);
        System.out.println("Maximum profit using space optimization2: " + maxProfitSpaceOptimization2);
    }
}

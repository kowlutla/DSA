/**
 * 
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class BP36BestTimeToBuyAndSellStocksII {

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
    public int maxProfitMemoization(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2]; // Initialize the memoization array
        for (int d[] : dp) {
            Arrays.fill(d, -1); // Fill the memoization array with -1
        }
        return maxProfitMemoization(prices, 0, 1, dp); // Call the helper method with initial parameters
    }

    // Helper method for memoization
    private int maxProfitMemoization(int[] values, int day, int canBuy, int[][] dp) {

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
    public int maxProfitTabulation(int[] prices) {
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
        int nextDay[] = new int[2]; // Initialize an array to store profit for the next day
        nextDay[0] = 0;
        nextDay[1] = 0;

        for (int day = n - 1; day >= 0; day--) { // Traverse through the days
            int currentDay[] = new int[2]; // Initialize an array to store profit for the current day
            for (int canBuy = 1; canBuy >= 0; canBuy--) { // Iterate through buy and sell states
                int profit = 0;
                if (canBuy == 1) { // If the stock can be bought
                    int buy = -values[day] + nextDay[0]; // Buy the stock and proceed to the next day
                    int notBuy = nextDay[1]; // Don't buy the stock and proceed to the next day
                    profit = Math.max(buy, notBuy); // Choose the maximum profit between buying and not buying
                } else { // If the stock can be sold
                    int sell = values[day] + nextDay[1]; // Sell the stock and proceed to the next day
                    int notSell = nextDay[0]; // Don't sell the stock and proceed to the next day
                    profit = Math.max(sell, notSell); // Choose the maximum profit between selling and not selling
                }
                currentDay[canBuy] = profit; // Update the array for the current day
            }
            nextDay = currentDay; // Update the array for the next day
        }

        return nextDay[1]; // Return the maximum profit
    }
    
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4}; // Sample prices array

        // Using recursion
        int maxProfitRecursion = BP36BestTimeToBuyAndSellStocksII.getMaximumProfitRecursion(prices.length, prices);
        System.out.println("Maximum profit using recursion: " + maxProfitRecursion);

        // Using memoization
        BP36BestTimeToBuyAndSellStocksII bp = new BP36BestTimeToBuyAndSellStocksII();
        int maxProfitMemoization = bp.maxProfitMemoization(prices);
        System.out.println("Maximum profit using memoization: " + maxProfitMemoization);

        // Using tabulation
        int maxProfitTabulation = bp.maxProfitTabulation(prices);
        System.out.println("Maximum profit using tabulation: " + maxProfitTabulation);

        // Using space optimization
        int maxProfitSpaceOptimization = BP36BestTimeToBuyAndSellStocksII.maxProfitSpaceOptimization(prices.length, prices);
        System.out.println("Maximum profit using space optimization: " + maxProfitSpaceOptimization);
    }
}

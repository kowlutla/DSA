/**
 * 	You are given an array prices where prices[i] is the price of a given stock on the ith day.

	You want to maximize your profit by choosing a single day to buy one stock and choosing a
	different day in the future to sell that stock.
	
	Return the maximum profit you can achieve from this transaction. 
	If you cannot achieve any profit, return 0.
	 
	Example 1:
	Input: prices = [7,1,5,3,6,4]
	Output: 5
	Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
	Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

	Example 2:
	Input: prices = [7,6,4,3,1]
	Output: 0
	Explanation: In this case, no transactions are done and the max profit = 0.
 */
package com.dsa.dynamic_programming;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP35BestTimeToBuyAndSellStock {

    // Method to find the maximum profit from buying and selling stocks
    public static int maxProfit(int[] prices) {

        int profit = 0; // Initialize the maximum profit to 0
        int minSoFar = Integer.MAX_VALUE; // Initialize the minimum price seen so far to the maximum possible integer value

        // Iterate through each price in the prices array
        for (int price : prices) {
            profit = Math.max(profit, price - minSoFar); // Update the maximum profit by comparing the current profit with the difference between the current price and the minimum price seen so far
            minSoFar = Math.min(minSoFar, price); // Update the minimum price seen so far by comparing it with the current price
        }
        return profit; // Return the maximum profit
    }
    
    public static void main(String[] args) {
        // Example usage
        int[] prices = {7, 1, 5, 3, 6, 4}; // Sample prices array
        int maxProfit = DP35BestTimeToBuyAndSellStock.maxProfit(prices); // Calculate the maximum profit
        System.out.println("Maximum profit: " + maxProfit); // Output the maximum profit
    }
}


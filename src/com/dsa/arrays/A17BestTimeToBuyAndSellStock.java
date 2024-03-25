/**
 * 	You are given an array of integers 'prices' of size 'n', where ‘prices[i]’ is the price of a given stock on an ‘i’-th day.
	You want to maximize the profit by choosing a single day to buy one stock and a different day to sell that stock.
	Please note that you can’t sell a stock before you buy one.
	Return the maximum profit you can achieve from this transaction.
	Example :
	Input: ‘prices’ =[7, 1, 5, 4, 3, 6]
	Output: 5
	Explanation: Purchase stock on day two, where the price is one, and sell it on day six, where the price is 6, profit = 6 - 1 = 5.
	Hence we return 5.
	Detailed explanation ( Input/output format, Notes, Images )
	
	Sample Input 1:
	6
	7 1 5 4 3 6
	Sample Output 1 :
	5
	Explanation Of Sample Input 1:
	Purchase stock on day two, where the price is one, and sell it on day six, where the price is 6. Profit = 6 - 1 = 5.
	Sample Input 2:
	5
	5 4 3 2 1
	Sample Output 2 :
	0
	Expected time complexity :
	The expected time complexity is O(n).
 */
package com.dsa.arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class A17BestTimeToBuyAndSellStock {

	private A17BestTimeToBuyAndSellStock() {
	} // Private constructor to prevent instantiation

	/**
	 * Finds the maximum profit that can be earned by buying and selling a stock once.
	 * @param prices An array of stock prices for each day.
	 * @return The maximum profit achievable.
	 *
	 *Time complexity: O(n) - Iterates through the prices list once.
	 *Space complexity: O(1) - Uses constant extra space for variables.
	 */
	public static int bestTimeToBuyAndSellStock(int[] prices) {
		int profit = 0;
		int minPrice = Integer.MAX_VALUE; // Initialize min price to positive infinity

		for (int price : prices) {
			// Update profit based on current price and minimum seen so far
			profit = Math.max(profit, price - minPrice);

			// Update minPrice to find the lowest possible buy price
			minPrice = Math.min(price, minPrice);
		}

		return profit;
	}

	// Example usage in a main method
	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		int maxProfit = bestTimeToBuyAndSellStock(prices);
		System.out.println("Maximum profit: $" + maxProfit);
	}
}

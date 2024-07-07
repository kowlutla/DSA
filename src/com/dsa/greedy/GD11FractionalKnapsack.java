/**
 * 	Given weights and values of n items, we need to put these items in a knapsack of capacity w to get the maximum total value in the knapsack. Return a double value representing the maximum value in knapsack.
	Note: Unlike 0/1 knapsack, you are allowed to break the item here. The details of structure/class is defined in the comments above the given function.
	
	Examples :
	Input: n = 3, w = 50, value[] = [60,100,120], weight[] = [10,20,30]
	Output: 240.000000
	Explanation: Take the item with value 60 and weight 10, value 100 and weight 20 and split the third item with value 120 and weight 30, to fit it into weight 20. so it becomes (120/30)*20=80, so the total value becomes 60+100+80.0=240.0 Thus, total maximum value of item we can have is 240.00 from the given capacity of sack. 

	Input: n = 2, w = 50, value[] = [60,100], weight[] = [10,20]
	Output: 160.000000
	Explanation: Take both the items completely, without breaking. Total maximum value of item we can have is 160.00 from the given capacity of sack.
 */
package com.dsa.greedy;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class GD11FractionalKnapsack {

    private class Item {
        int value, weight;
    }

    /**
     * Solves the Fractional Knapsack problem to maximize the total value.
     *
     * Time Complexity: O(N log N) for sorting the items based on value/weight ratio,
     * plus O(N) for iterating through the items.
     * Overall: O(N log N).
     *
     * Space Complexity: O(1) additional space (in-place sorting).
     *
     * @param w the maximum weight of the knapsack
     * @param arr the array of items
     * @param n the number of items
     * @return the maximum value achievable with the given knapsack capacity
     */
    double fractionalKnapsack(int w, Item arr[], int n) {
        // Sort items by descending value-to-weight ratio
        Arrays.sort(arr, (i1, i2) -> 
            (i1.value * 1.0 / i1.weight) < (i2.value * 1.0 / i2.weight) ? 1 : -1);

        double totalValue = 0; // Total value in the knapsack
        int remainingWeight = w; // Remaining weight capacity of the knapsack

        // Iterate through sorted items
        for (Item item : arr) {
            // If the item can be fully included in the knapsack
            if (remainingWeight >= item.weight) {
                totalValue += item.value; // Add the full value of the item
                remainingWeight -= item.weight; // Decrease the remaining weight
            } else {
                // Include a fraction of the item
                totalValue += (item.value * 1.0 / item.weight) * remainingWeight;
                break; // Knapsack is full
            }
        }

        return totalValue; // Return the total value in the knapsack
    }
}

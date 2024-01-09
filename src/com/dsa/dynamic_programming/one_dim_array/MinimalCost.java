/**
 * 	There is an array of heights corresponding to 'n' stones. You have to reach from stone 1 to stone ‘n’.
	From stone 'i', it is possible to reach stones 'i'+1, ‘i’+2… ‘i’+'k' , and 
	the cost incurred will be | Height[i]-Height[j] |, where 'j' is the landing stone.

	Return the minimum possible total cost incurred in reaching the stone ‘n’.

	Example:
	For 'n' = 3 , 'k' = 1, height = {2, 5, 2}.

	Answer is 6.

	Initially, we are present at stone 1 having height 2. We can only reach stone 2 as ‘k’ is 1. So, cost incurred is |2-5| = 3. Now, we are present at stone 2, we can only reach stone 3 as ‘k’ is 1. So, cost incurred is |5-2| = 3. So, the total cost is 6.
 */
package com.dsa.dynamic_programming.one_dim_array;

/**
 * @author KowlutlaSwamy
 *
 */
import java.util.Arrays;

public class MinimalCost {

    // Using tabulation
    public static int minimizeCostTabulation(int n, int k, int[] height) {
        int[] dp = new int[n];
        dp[0] = 0; // Base case: starting point cost is 0
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (j <= i) { // Check if the jump is within bounds
                    min = Math.min(min, dp[i - j] + Math.abs(height[i] - height[i - j]));
                }
            }
            dp[i] = min; // Store minimum cost for each position
        }
        return dp[n - 1]; // Return minimum cost to reach the end
    }

    // Using memorization
    public static int minimizeCostMemorization(int n, int k, int[] height, int[] dp) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n]; // Return the calculated minimum cost
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (n - i >= 0) { // Check if the jump is within bounds
                min = Math.min(min, minimizeCostMemorization(n - i, k, height, dp)
                        + Math.abs(height[n] - height[n - i]));
            }
        }
        return dp[n] = min; // Store and return minimum cost for each position
    }

    // Using recursion
    public static int minimizeCostRecursion(int n, int k, int[] height) {
        if (n == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (n - i >= 0) { // Check if the jump is within bounds
                min = Math.min(min, minimizeCostRecursion(n - i, k, height)
                        + Math.abs(height[n] - height[n - i]));
            }
        }
        return min; // Return the minimum cost to reach the end
    }

    public static void main(String[] args) {
        int[] height = {0, 20, 18, 20, 12}; // Example array of heights
        int n = height.length;
        int k = 3; // Example value of k

        // Test minimizeCostTabulation method
        System.out.println("Using Tabulation: " + MinimalCost.minimizeCostTabulation(n, k, height));

        // Test minimizeCostMemorization method
        int[] dp = new int[n];
        Arrays.fill(dp, -1); // Initialize dp array with -1
        System.out.println("Using Memorization: " + MinimalCost.minimizeCostMemorization(n - 1, k, height, dp));

        // Test minimizeCostRecursion method
        System.out.println("Using Recursion: " + MinimalCost.minimizeCostRecursion(n - 1, k, height));
    }
}

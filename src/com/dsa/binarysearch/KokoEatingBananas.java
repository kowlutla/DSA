/**
	Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
	Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, 
	she eats all of them instead and will not eat any more bananas during this hour.
	Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
	Return the minimum integer k such that she can eat all the bananas within h hours.
	
	Example 1:
	
	Input: piles = [3,6,7,11], h = 8
	Output: 4
	Example 2:
	
	Input: piles = [30,11,23,4,20], h = 5
	Output: 30
	Example 3:
	
	Input: piles = [30,11,23,4,20], h = 6
	Output: 23
	 
 * 
 */
package com.dsa.binarysearch;

/**
 * @author KowlutlaSwamy
 *
 */
public class KokoEatingBananas {

    // Main method to test the minEatingSpeed function
    public static void main(String[] args) {
        // Example piles of bananas and hours
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        KokoEatingBananas koko = new KokoEatingBananas();
        int result = koko.minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed: " + result); // Expected Output: 4
    }

    // Method to find the minimum eating speed for Koko to eat all bananas within h hours
    public int minEatingSpeed(int[] piles, int h) {
        // Finding the maximum number of bananas in a pile
        int max = Integer.MIN_VALUE;
        for (int p : piles) {
            max = Math.max(p, max);
        }

        // Initialize low, high, and ans for binary search
        int low = 1, high = max, ans = max;

        // Perform binary search to find the minimum eating speed
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if it's possible to complete eating within h hours at speed mid
            int result = compute(piles, mid);
            if (result <= h) {
                ans = mid;
                high = mid - 1; // Move high pointer to find lower speeds
            } else {
                low = mid + 1; // Move low pointer to find higher speeds
            }
        }

        return ans;
    }

    // Method to compute the total hours needed to eat all bananas at a given speed
    private int compute(int[] v, int hourly) {
        int totalH = 0;
        int n = v.length;

        // Calculate total hours needed to eat all bananas at the given hourly speed
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double) (v[i]) / (double) (hourly));
        }

        return totalH;
    }
}

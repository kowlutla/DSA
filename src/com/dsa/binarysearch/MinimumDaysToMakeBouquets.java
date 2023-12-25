/**
 * 
 */
package com.dsa.binarysearch;

/**
 * @author KowlutlaSwamy
 *
 */
public class MinimumDaysToMakeBouquets {

    // Main method to test the functionality
    public static void main(String[] args) {
        // Example bloomDay array and bouquet requirements
        int[] bloomDay = {1, 10, 3, 10, 2}; // An array representing bloom days of flowers
        int m = 3; // Number of bouquets required
        int k = 1; // Flowers per bouquet

        // Creating an instance of the class
        MinimumDaysToMakeBouquets bouquet = new MinimumDaysToMakeBouquets();

        // Testing both methods
        int result1 = bouquet.minDays1(bloomDay, m, k);
        System.out.println("Minimum days using method 1: " + result1);

        int result2 = bouquet.minDays(bloomDay, m, k);
        System.out.println("Minimum days using method 2: " + result2);
    }

    // Method 1 to find the minimum days to make bouquets
    public int minDays1(int[] bloomDay, int m, int k) {
        int n = bloomDay.length; // Total number of flowers

        // Check if total flowers are less than required for bouquets
        if (n < m * k) {
            return -1; // Cannot make required number of bouquets
        }

        // Finding the minimum and maximum bloom days
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            min = Math.min(day, min); // Finding minimum bloom day
            max = Math.max(day, max); // Finding maximum bloom day
        }

        // Using linear search to find the minimum days
        for (int i = min; i <= max; i++) {
            int cons = 0, bcount = 0; // Cons: Flowers count, bcount: Bouquet count
            for (int j = 0; j < n; j++) {
                if (bloomDay[j] <= i) {
                    cons++; // Increment flower count if it blooms within 'i' days
                } else {
                    bcount += Math.floor((double) cons / (double) k); // Calculate bouquets formed
                    cons = 0; // Reset flower count
                }
            }
            bcount += Math.floor((double) cons / (double) k); // Bouquets formed with remaining flowers
            if (bcount >= m) {
                return i; // Return the minimum days if required bouquets are formed
            }
        }

        return -1; // Cannot form required bouquets within given days
    }

    // Method 2 to find the minimum days using binary search
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length; // Total number of flowers
        long val = (long) m * k; // Total flowers required for bouquets

        // Check if total flowers are less than required for bouquets
        if (val > n) {
            return -1; // Cannot make required number of bouquets
        }

        // Finding the minimum and maximum bloom days
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            min = Math.min(day, min); // Finding minimum bloom day
            max = Math.max(day, max); // Finding maximum bloom day
        }

        // Binary search to find the minimum days
        int low = min, high = max;
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate middle days

            // Check if it's possible to make required bouquets within 'mid' days
            if (isPossible(bloomDay, m, k, mid)) {
                high = mid - 1; // Search in the lower range
            } else {
                low = mid + 1; // Search in the higher range
            }
        }

        return low; // Return the minimum days required to make bouquets
    }

    // Helper method to check if it's possible to make bouquets within 'day' days
    public boolean isPossible(int[] bloomDay, int m, int k, int day) {
        int cons = 0, bCount = 0; // Cons: Flowers count, bCount: Bouquet count
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                cons++; // Increment flower count if it blooms within 'day' days
            } else {
                bCount += (Math.floor(cons / k)); // Calculate bouquets formed
                cons = 0; // Reset flower count
            }
        }

        bCount += (Math.floor(cons / k)); // Bouquets formed with remaining flowers
        return bCount >= m; // Return true if required bouquets are formed
    }
}

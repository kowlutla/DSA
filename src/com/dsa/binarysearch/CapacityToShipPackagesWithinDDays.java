/**
	A conveyor belt has packages that must be shipped from one port to another within days days.
	The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
	Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.
	
	Example 1:
	
	Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
	Output: 15
	Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
	1st day: 1, 2, 3, 4, 5
	2nd day: 6, 7
	3rd day: 8
	4th day: 9
	5th day: 10
	
	Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
	Example 2:
	
	Input: weights = [3,2,2,4,1,4], days = 3
	Output: 6
	Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
	1st day: 3, 2
	2nd day: 2, 4
	3rd day: 1, 4
	Example 3:
	
	Input: weights = [1,2,3,1,1], days = 4
	Output: 3
	Explanation:
	1st day: 1
	2nd day: 2
	3rd day: 3
	4th day: 1, 1
	 
 * 
 */
package com.dsa.binarysearch;

/**
 * @author KowlutlaSwamy
 *
 */
public class CapacityToShipPackagesWithinDDays {

    // Method to find the minimum capacity using linear search
    public int shipWithinDays1(int[] weights, int days) {
        int maxCapacity = 0, minimumCapacity = Integer.MIN_VALUE;

        // Calculate the sum of weights and find the minimum capacity
        for (int v : weights) {
            maxCapacity += v;
            minimumCapacity = Math.max(v, minimumCapacity);
        }

        // Check for minimum capacity that satisfies the given days
        for (int currentCapacity = minimumCapacity; currentCapacity <= maxCapacity; currentCapacity++) {
            int currentDays = 0;
            int currentSum = 0;

            // Check if the current capacity is valid for the given days
            for (int j = 0; j < weights.length; j++) {
                if (currentSum + weights[j] <= currentCapacity) {
                    currentSum += weights[j];
                } else {
                    if (weights[j] > currentCapacity) {
                        currentDays = Integer.MAX_VALUE;
                        break;
                    }
                    currentDays++;
                    currentSum = weights[j];
                }
            }

            if (currentDays < days) {
                return currentCapacity; // Return the minimum capacity found
            }
        }

        return -1; // No valid capacity found
    }

    // Method to find the minimum capacity using binary search
    public int shipWithinDays(int[] weights, int days) {
        int maximumCapacity = 0, minimumCapacity = Integer.MIN_VALUE;

        // Calculate the sum of weights and find the minimum capacity
        for (int v : weights) {
            maximumCapacity += v;
            minimumCapacity = Math.max(v, minimumCapacity);
        }

        int low = minimumCapacity, high = maximumCapacity;
        int ans = maximumCapacity;

        // Binary search to find the minimum capacity
        while (low <= high) {
            int midCapacity = low + (high - low) / 2;
            if (isPossible(weights, days, midCapacity)) {
                ans = midCapacity;
                high = midCapacity - 1;
            } else {
                low = midCapacity + 1;
            }
        }

        return low; // Return the minimum capacity found
    }

    // Helper method to check if it's possible to ship within 'days' using 'capacity'
    private boolean isPossible(int[] weights, int days, int capacity) {
        int currentDays = 1;
        int currentSum = 0;

        // Check if it's possible to ship within 'days' using 'capacity'
        for (int j = 0; j < weights.length; j++) {
            if (currentSum + weights[j] <= capacity) {
                currentSum += weights[j];
            } else {
                if (weights[j] > capacity) {
                    return false;
                }
                currentDays++;
                currentSum = weights[j];
            }
        }
        return currentDays <= days; // Return true if it's possible to ship within the given days
    }

    // Main method for testing
    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays shipper = new CapacityToShipPackagesWithinDDays();
        int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // Example weights array
        int days = 5; // Example number of days

        // Test the linear search method
        int result1 = shipper.shipWithinDays1(weights, days);
        System.out.println("Minimum capacity using linear search: " + result1);

        // Test the binary search method
        int result2 = shipper.shipWithinDays(weights, days);
        System.out.println("Minimum capacity using binary search: " + result2);
    }
}

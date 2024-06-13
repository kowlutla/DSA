/**
 * 	You are given a list of integers nums where each number represents a vote to a candidate. Return the ids of the candidates that have greater than n/3 votes, If there's not a majority vote, return -1. 
	
	Example 1:
	Input:
	n = 11
	nums = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
	Output:
	[5,6]
	Explanation:
	5 and 6 occur more n/3 times.
	 
	
	Example 2:
	Input:
	n=5
	nums = [1,2,3,4,5]
	Output:
	[-1]
 */
package com.dsa.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A26MajorityElement2 {

    /**
     * Method 1: Brute force approach to find the majority elements appearing more than n/3 times.
     * This method iterates over the array and counts occurrences of each element to find the majority elements.
     * 
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     * 
     * @param n the size of the array
     * @param nums the input array
     * @return a list of majority elements or -1 if none found
     */
    public static List<Integer> majorityElement1(int n, int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Iterate over each element in the array
        for (int i = 0; i < n; i++) {
            // Check if the element is already in the result list
            if (!result.contains(nums[i])) {
                int count = 1;
                // Count occurrences of the current element
                for (int j = i + 1; j < n; j++) {
                    if (nums[i] == nums[j]) {
                        count++;
                    }
                }

                // If the count exceeds n/3, add to the result list
                if (count > n / 3) {
                    result.add(nums[i]);
                }

                // If we have found 2 majority elements, break the loop
                if (result.size() == 2) {
                    break;
                }
            }
        }

        // If no majority elements are found, return -1
        if (result.isEmpty()) {
            result.add(-1);
        }
        return result;
    }

    /**
     * Method 2: Using a HashMap to count occurrences of each element to find the majority elements.
     * This method utilizes a HashMap to store the frequency of each element.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * 
     * @param n the size of the array
     * @param nums the input array
     * @return a list of majority elements or -1 if none found
     */
    public static List<Integer> majorityElement2(int n, int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();

        Map<Integer, Integer> countMap = new HashMap<>();

        // Count occurrences of each element using a HashMap
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Check the frequency of each element
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > n / 3) {
                result.add(entry.getKey());
            }
            if (result.size() == 2) {
                break;
            }
        }

        // If no majority elements are found, return -1
        if (result.isEmpty()) {
            result.add(-1);
        }
        return result;
    }

    /**
     * Method 3: Using a HashMap to count occurrences of each element while iterating.
     * This method stops early if two majority elements are found.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * 
     * @param n the size of the array
     * @param nums the input array
     * @return a list of majority elements or -1 if none found
     */
    public static List<Integer> majorityElement3(int n, int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();

        Map<Integer, Integer> countMap = new HashMap<>();

        // Count occurrences of each element while iterating
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            // Add element to result if it appears more than n/3 times
            if (countMap.get(num) > n / 3 && !result.contains(num)) {
                result.add(num);
            }
            // Stop if we already have two majority elements
            if (result.size() == 2) {
                break;
            }
        }

        // If no majority elements are found, return -1
        if (result.isEmpty()) {
            result.add(-1);
        }
        return result;
    }

    /**
     * Method 4: Boyer-Moore Voting Algorithm to find the majority elements.
     * This method finds at most two majority elements appearing more than n/3 times.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * @param n the size of the array
     * @param nums the input array
     * @return a list of majority elements or -1 if none found
     */
    public static List<Integer> majorityElement4(int n, int[] nums) {
        int count1 = 0;
        int count2 = 0;
        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;

        // First pass to find potential candidates
        for (int i = 0; i < n; i++) {
            if (nums[i] == element1) {
                count1++;
            } else if (nums[i] == element2) {
                count2++;
            } else if (count1 == 0) {
                element1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                element2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        // Second pass to verify the candidates
        for (int num : nums) {
            if (num == element1) {
                count1++;
            } else if (num == element2) {
                count2++;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        // Add verified candidates to the result list
        if (count1 > n / 3) {
            result.add(element1);
        }

        if (count2 > n / 3) {
            result.add(element2);
        }

        // If no majority elements are found, return -1
        if (result.isEmpty()) {
            result.add(-1);
        }
        return result;
    }
}

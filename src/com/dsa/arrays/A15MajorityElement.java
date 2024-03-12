/**
 * 	Given an array nums of size n, return the majority element.
	The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
	
	Example 1:
	Input: nums = [3,2,3]
	Output: 3

	Example 2:
	Input: nums = [2,2,1,1,1,2,2]
	Output: 2
	
	Constraints:
	
	n == nums.length
	1 <= n <= 5 * 104
	-109 <= nums[i] <= 109
	 
	Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
package com.dsa.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KowlutlaSwamy
 *
 */
public class A15MajorityElement {

	  /**
	   * Finds the majority element in an array using a HashMap (brute force).
	   * Time complexity: O(N) due to a single pass through the array for counting and another pass for iterating through the HashMap.
	   * Space complexity: O(N) due to the HashMap potentially storing up to N elements with their frequencies.
	   *
	   * @param nums The array containing integer elements.
	   * @return The majority element if it exists, otherwise -1.
	   */
	  public static int majorityElement1(int[] nums) {
	    HashMap<Integer, Integer> map = new HashMap<>(); // Stores elements and their frequencies

	    int n = nums.length;
	    for (int i = 0; i < n; i++) {
	      if (map.containsKey(nums[i])) { // Check if the element already exists in the map
	        map.put(nums[i], map.get(nums[i]) + 1); // Increase its frequency
	      } else {
	        map.put(nums[i], 1); // Store the element with frequency 1
	      }
	    }

	    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	      if (entry.getValue() > n / 2) {  // Check if any element's frequency is greater than half of the array size
	        return (int) entry.getKey(); // Return the majority element
	      }
	    }

	    return -1; // No majority element found
	  }

	  /**
	   * Finds the majority element in an array using Moore's Voting Algorithm.
	   * Time complexity: O(N) as it iterates through the array only once.
	   * Space complexity: O(1) as it uses constant extra space for variables (count, majorityElement).
	   *
	   * @param nums The array containing integer elements.
	   * @return The majority element if it exists, otherwise -1.
	   */
	  public static int majorityElement2(int[] nums) {
	    int count = 1;
	    int majorityElement = nums[0]; // Assume the first element is the majority element initially

	    for (int i = 1; i < nums.length; i++) {
	      if (nums[i] == majorityElement) { // If the current element is same as the majority element
	        count++;
	      } else {
	        count--; // If the current element is different, decrease the count
	        if (count == 0) { // If count becomes 0, reset it to 1 and choose a new potential majority element
	          count = 1;
	          majorityElement = nums[i];
	        }
	      }
	    }

	    // Verify if the chosen majority element is indeed the majority
	    count = 0;
	    for (int i = 0; i < nums.length; i++) {
	      if (nums[i] == majorityElement) {
	        count++;
	      }
	    }

	    if (count > nums.length / 2) { // Check if the frequency of the chosen element is greater than half of the array size
	      return majorityElement;
	    }

	    return -1; // No majority element found
	  }

	  // Main method for testing
	  public static void main(String[] args) {
	    int[] nums1 = {3, 2, 3};
	    int[] nums2 = {2, 2, 1, 1, 1, 2, 2};

	    System.out.println("Majority element in nums1 using majorityElement1: " + majorityElement1(nums1));
	    System.out.println("Majority element in nums2 using majorityElement1: " + majorityElement1(nums2));

	    System.out.println("Majority element in nums1 using majorityElement2: " + majorityElement2(nums1));
	    System.out.println("Majority element in nums2 using majorityElement2: " + majorityElement2(nums2));
	  }
	}

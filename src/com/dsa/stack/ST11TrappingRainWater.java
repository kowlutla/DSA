/**
 * 	Given an array arr[] of N non-negative integers representing the height of blocks. If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 
	
	Example 1:
	Input:
	N = 6
	arr[] = {3,0,0,2,0,4}
	Output:
	10

	Example 2:
	Input:
	N = 4
	arr[] = {7,4,0,9}
	Output:
	10
	Explanation:
	Water trapped by above 
	block of height 4 is 3 units and above 
	block of height 0 is 7 units. So, the 
	total unit of water trapped is 10 units.

	Example 3:
	Input:
	N = 3
	arr[] = {6,9,9}
	Output:
	0
	Explanation:
	No water will be trapped.
 */
package com.dsa.stack;

/**
 * @author KowlutlaSwamy
 *
 */
public class ST11TrappingRainWater {

	public static long trappingWater1(int arr[], int n) {

		long result = 0;
		for (int i = 0; i < n; i++) {

			int leftMax = arr[i];
			int rightMax = arr[i];

			for (int j = 0; j < i; j++) {
				leftMax = Math.max(arr[j], leftMax);
			}

			for (int j = i + 1; j < n; j++) {
				rightMax = Math.max(arr[j], rightMax);
			}
			result += (Math.min(rightMax, leftMax) - arr[i]);
		}
		return result;
	}

	public static long trappingWater2(int arr[], int n) {

		long result = 0;
		int[] leftMax = new int[n];
		int[] rightMax = new int[n];

		leftMax[0] = arr[0];
		rightMax[n - 1] = arr[n - 1];
		for (int i = 1; i < n; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
			rightMax[n - i - 1] = Math.max(rightMax[n - i], arr[n - i - 1]);
		}

		for (int i = 0; i < n; i++) {
			result += (Math.min(rightMax[i], leftMax[i]) - arr[i]);
		}
		return result;
	}

	public static long trappingWater3(int arr[], int n) {

		long result = 0;
		int leftMax = 0;
		int[] rightMax = new int[n];

		rightMax[n - 1] = arr[n - 1];
		for (int i = 1; i < n; i++) {
			rightMax[n - i - 1] = Math.max(rightMax[n - i], arr[n - i - 1]);
		}

		for (int i = 0; i < n; i++) {
			leftMax = Math.max(leftMax, arr[i]);
			result += (Math.min(rightMax[i], leftMax) - arr[i]);
		}
		return result;
	}

	public static long trappingWater4(int arr[], int n) {

		long result = 0;
		int left = 0, right = n - 1, leftMax = 0, rightMax = 0;
		while (left < right) {

			if (arr[left] <= arr[right]) {
				if (leftMax > arr[left]) {
					result += (leftMax - arr[left]);
				} else {
					leftMax = arr[left];
				}
				left++;
			} else {
				if (rightMax > arr[right]) {
					result += (rightMax - arr[right]);
				} else {
					rightMax = arr[right];
				}
				right--;
			}
		}
		return result;
	}
}

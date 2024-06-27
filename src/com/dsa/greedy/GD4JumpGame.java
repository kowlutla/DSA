/**
 * 	Given an positive integer N and a list of N integers A[]. Each element in the array denotes the maximum length of jump you can cover. Find out if you can make it to the last index if you start at the first index of the list.
	
	Example 1:
	Input:
	N = 6
	A[] = {1, 2, 0, 3, 0, 0} 
	Output:
	1
	Explanation:
	Jump 1 step from first index to
	second index. Then jump 2 steps to reach 
	4th index, and now jump 2 steps to reach
	the end.

	Example 2:
	Input:
	N = 3
	A[] =  {1, 0, 2}
	Output:
	0
	Explanation:
	You can't reach the end of the array.
 */
package com.dsa.greedy;

/**
 * @author KowlutlaSwamy
 *
 */
public class GD4JumpGame {

    /**
     * Determines if it is possible to reach the last index of the array.
     * 
     * Time Complexity: O(N)
     * The time complexity is O(N), where N is the length of the array. We traverse the array once.
     * 
     * Space Complexity: O(1)
     * The space complexity is constant because we are using a few integer variables.
     *
     * @param A the input array where each element represents the maximum jump length at that position
     * @param N the length of the array
     * @return 1 if it's possible to reach the last index, otherwise 0
     */
    public static int canReach(int[] A, int N) {
        int maxIndex = 0; // Initialize the maximum reachable index to 0

        for (int i = 0; i < N; i++) {
            if (i > maxIndex) {
                // If the current index is beyond the maximum reachable index, return 0
                return 0;
            }

            // Update the maximum reachable index
            if (i + A[i] >= maxIndex) {
                maxIndex = i + A[i];
            }
        }

        // If we reach here, it means we can reach the last index
        return 1;
    }
}

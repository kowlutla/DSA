/**
 * 	Assume you are an awesome parent of N children and want to give your children some cookies out of given M cookies. But, you should give each child atmost one cookie.
	Each child i has a greed factor greed [ i ], which is the minimum size of cookie that the child will be content with; and each cookie j has a size sz [ j ]. If sz [ j ] >= greed [ i ], we can assign the cookie j to the child ith, and the child i will be content.
	Your goal is to maximize the number of your content children and return the maximum number.
	Return number of maximum content children you can obtain with N cookies.
	
	Example 1:
	Input:
	N = 3 
	M = 2
	greed [ ] = {1, 2, 3}
	sz [ ] = {1, 1}
	Output: 1
	Explanation: 
	You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
	And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
	You need to return 1.
	 
	
	Example 2:
	Input:
	N = 2 
	M = 3
	greed [ ] = {1, 2}
	sz [ ] = {1, 2, 3}
	Output: 2
	Explanation: 
	You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
	You have 3 cookies and their sizes are big enough to gratify all of the children.
	You need to output 2.
	
 */
package com.dsa.greedy;

import java.util.Arrays;

public class GD1AssignCookies {

    /**
     * Determines the maximum number of children that can be satisfied with the given cookies.
     *
     * Time Complexity: O(N log N + M log M)
     * The time complexity is dominated by the sorting steps for both the greed array and the sz array.
     *
     * Space Complexity: O(1)
     * The space complexity is constant because we are only using a fixed amount of extra space.
     *
     * @param N the number of children
     * @param M the number of cookies
     * @param greed an array representing the greed factor of each child
     * @param sz an array representing the size of each cookie
     * @return the maximum number of children that can be satisfied
     */
    public static int maxChildren(int N, int M, int greed[], int sz[]) {

        // Sort the greed factors of children in ascending order
        Arrays.sort(greed);

        // Sort the sizes of cookies in ascending order
        Arrays.sort(sz);

        // Initialize a counter to keep track of the number of satisfied children
        int count = 0;

        // Initialize pointers for the greed array (children) and sz array (cookies)
        int index1 = N - 1;
        int index2 = M - 1;

        // Iterate from the end of both arrays
        while (index1 >= 0 && index2 >= 0) {
            // If the current cookie can satisfy the current child's greed factor
            if (greed[index1] <= sz[index2]) {
                // Decrement both pointers and increment the count of satisfied children
                index1--;
                index2--;
                count++;
            } else {
                // If the current cookie cannot satisfy the current child's greed factor
                // Move to the next child (decrement the greed array pointer)
                index1--;
            }
        }

        // Return the total number of satisfied children
        return count;
    }
}

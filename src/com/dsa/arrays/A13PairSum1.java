/**
 * 	Sam want to read exactly ‘TARGET’ number of pages.
	He has an array ‘BOOK’ containing the number of pages for ‘N’ books.
	Return YES/NO, if it is possible for him to read any 2 books and he can meet his ‘TARGET’ number of pages.
	
	Example:
	Input: ‘N’ = 5, ‘TARGET’ = 5
	‘BOOK’ = [4, 1, 2, 3, 1] 
	Output: YES
	Explanation:
	Sam can buy 4 pages book and 1 page book.
	Detailed explanation ( Input/output format, Notes, Images )
	
	Sample Input 1:
	5 5
	4 1 2 3 1
	Sample Output 1 :
	YES
	Explanation Of Sample Input 1:
	Sam can buy 4 pages book and 1-page book.
	
	Sample Input 2:
	2 1
	1 2
	Sample Output 2 :
	NO
	Expected Time Complexity:
	O( N ), Where N is the length of the array.
 */
package com.dsa.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class A13PairSum1 {

    /**
     * Finds a pair with a given sum using nested loops (brute force).
     * Time complexity: O(N^2) due to nested loops iterating through all possible pairs.
     * Space complexity: O(1) as it uses constant extra space for variables (i, j).
     *
     * @param n      The number of elements in the book array.
     * @param book   The array containing integer elements.
     * @param target The target sum to find a pair for.
     * @return "YES" if a pair with the target sum exists, "NO" otherwise.
     */
    public static String canRead1(int n, int[] book, int target) {
        for (int i = 0; i < n; i++) { // Outer loop iterates through all elements
            for (int j = i + 1; j < n; j++) { // Inner loop iterates through remaining elements (excluding already checked pairs)
                if (book[i] + book[j] == target) {
                    return "YES"; // Found a pair with the target sum
                }
            }
        }
        return "NO"; // No pair found with the target sum
    }

    /**
     * Finds a pair with a given sum using a HashMap.
     * Time complexity: O(N) as it iterates through the array once.
     * Space complexity: O(N) due to the HashMap potentially storing up to N elements with their indices.
     *
     * @param n      The number of elements in the book array.
     * @param book   The array containing integer elements.
     * @param target The target sum to find a pair for.
     * @return "YES" if a pair with the target sum exists, "NO" otherwise.
     */
    public static String canRead2(int n, int[] book, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Stores elements and their indices

        for (int index = 0; index < n; index++) {
            if (map.containsKey(target - book[index])) { // Check if the complement to form the target sum exists in the map
                return "YES"; // Found a complement, so a pair exists
            }
            map.put(book[index], index); // Store the current element and its index
        }

        return "NO"; // No pair found with the target sum
    }

    /**
     * Finds a pair with a given sum using a sorting and two-pointer approach.
     * Time complexity: O(N log N) due to sorting the array.
     * Space complexity: O(1) or O(N) depending on the sorting algorithm used (in-place sorting may use constant extra space, while new array creation for sorting may use extra space).
     *
     * @param n      The number of elements in the book array.
     * @param book   The array containing integer elements.
     * @param target The target sum to find a pair for.
     * @return "YES" if a pair with the target sum exists, "NO" otherwise.
     */
    public static String canRead3(int n, int[] book, int target) {
        Arrays.sort(book); // Sort the array in ascending order

        int left = 0, right = n - 1; // Two pointers for left and right ends

        while (left < right) {
            int sum = book[left] + book[right];

            if (sum == target) {
                return "YES"; // Found a pair with the target sum
            } else if (sum < target) {
                left++; // Increase the left pointer to consider a larger sum
            } else {
                right--; // Decrease the right pointer to consider a smaller sum
            }
        }

        return "NO"; // No pair found with the target sum
    }
    
    // Main method for testing
    public static void main(String[] args) {
        int n = 4;
        int[] book = {2, 7, 5, 1};
        int target = 9;

        System.out.println("Can read using canRead1: " + canRead1(n, book, target));
        System.out.println("Can read using canRead2: " + canRead2(n, book, target));
        System.out.println("Can read using canRead3: " + canRead3(n, book, target));
    }
}

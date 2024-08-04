/**
 * 	Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
	
	Example 1:
	Input: num = "1432219", k = 3
	Output: "1219"
	Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

	Example 2:
	Input: num = "10200", k = 1
	Output: "200"
	Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

	Example 3:
	Input: num = "10", k = 2
	Output: "0"
	Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
package com.dsa.stack;

import java.util.Stack;

public class ST15RemoveKDigits {

    /**
     * Removes k digits from the given number to create the smallest possible number.
     * 
     * Time Complexity: O(N) - Each digit is pushed and popped from the stack at most once.
     * Space Complexity: O(N) - Uses a stack to store the digits.
     *
     * @param num the original number as a string
     * @param k   the number of digits to remove
     * @return the smallest possible number as a string after removing k digits
     */
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>(); // Initialize the stack to keep track of digits
        for (char c : num.toCharArray()) { // Iterate over each digit in the number
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                k--; // Remove the digit from the stack if it's greater than the current digit
                stack.pop();
            }
            stack.push(c); // Push the current digit to the stack
        }

        while (!stack.isEmpty() && k > 0) { // Remove any remaining digits if k > 0
            stack.pop();
            k--;
        }

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()); // Append the remaining digits in the stack to the result
        }

		String result = sb.reverse().toString();
		int index = 0;
		//to remove leading zeros
		while (index < result.length() && result.charAt(index) == '0') {
			index++;
		}
        
        // If the result has no non-zero numbers, return "0", otherwise return the result
        return index==result.length()?"0":result.substring(index);
    }
}

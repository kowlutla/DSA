/**
 * 	Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
	
	The following rules define a valid string:
	
	Any left parenthesis '(' must have a corresponding right parenthesis ')'.
	Any right parenthesis ')' must have a corresponding left parenthesis '('.
	Left parenthesis '(' must go before the corresponding right parenthesis ')'.
	'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
	 
	
	Example 1:
	Input: s = "()"
	Output: true

	Example 2:
	Input: s = "(*)"
	Output: true

	Example 3:
	Input: s = "(*))"
	Output: true
	 
 */
package com.dsa.greedy;

/**
 * @author KowlutlaSwamy
 *
 */
public class GD12ValidParenthesisString {

    /**
     * Checks if the given string containing '(', ')', and '*' is a valid parenthesis string.
     *
     * Time Complexity: O(N), where N is the length of the string, because we iterate through the string once.
     *
     * Space Complexity: O(1), because we use only a fixed amount of extra space.
     *
     * @param s the string to check
     * @return true if the string is a valid parenthesis string, false otherwise
     */
    public boolean checkValidString1(String s) {
        int min = 0; // Minimum number of unmatched open parentheses
        int max = 0; // Maximum number of unmatched open parentheses

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // Increment both min and max for an open parenthesis
                min++;
                max++;
            } else if (c == ')') {
                // Decrement both min and max for a close parenthesis
                min--;
                max--;
            } else {
                // '*' can be treated as either '(', ')' or an empty string
                min--; // Decrement min considering '*' as ')'
                max++; // Increment max considering '*' as '('
            }

            // Ensure min does not drop below 0
            if (min < 0) {
                min = 0;
            }

            // If max is negative, it means we have more ')' than '(' and '*' cannot balance them
            if (max < 0) {
                return false;
            }
        }

        // If min is zero, all open parentheses can be matched, otherwise they can't be
        return min == 0;
    }
    
    /**
     * Checks if the given string containing '(', ')', and '*' is a valid parenthesis string.
     *
     * Time Complexity: O(N), where N is the length of the string, because we iterate through the string twice.
     *
     * Space Complexity: O(1), because we use only a fixed amount of extra space.
     *
     * @param s the string to check
     * @return true if the string is a valid parenthesis string, false otherwise
     */
    public boolean checkValidString(String s) {
        
        int starCount = 0; // Count of '*' characters
        int leftCount = 0; // Count of '(' characters

        // Left to right pass to balance '(' and ')'
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '*') {
                starCount++; // Increment star count for '*'
            } else if (c == '(') {
                leftCount++; // Increment left parenthesis count for '('
            } else { // c == ')'
                // If no unmatched '(', use a '*'
                if (leftCount == 0 && starCount == 0) {
                    return false;
                } else if (leftCount == 0) {
                    starCount--; // Use a '*' to balance ')'
                } else {
                    leftCount--; // Use a '(' to balance ')'
                }
            }
        }

        starCount = 0; // Reset star count for right to left pass
        int rightCount = 0; // Count of ')' characters

        // Right to left pass to balance ')' and '('
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '*') {
                starCount++; // Increment star count for '*'
            } else if (c == ')') {
                rightCount++; // Increment right parenthesis count for ')'
            } else { // c == '('
                // If no unmatched ')', use a '*'
                if (rightCount == 0 && starCount == 0) {
                    return false;
                } else if (rightCount == 0) {
                    starCount--; // Use a '*' to balance '('
                } else {
                    rightCount--; // Use a ')' to balance '('
                }
            }
        }

        return true; // If both passes are successful, the string is valid
    }
}

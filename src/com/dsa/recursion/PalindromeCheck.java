/**
 * Recursive method to check string is palindrome or not
 */
package com.dsa.recursion;

/**
 * @author KowlutlaSwamy
 *
 */
public class PalindromeCheck { // Class declaration for PalindromeCheck

    public static void main(String[] args) { // Main method - entry point of the program
        String s = "madam"; // Declaring and initializing a String variable 's' with the value "madam"

        if (isPalindrome(s)) { // Checking if the string 's' is a palindrome by calling the isPalindrome method
            System.out.println(s + " is palindrome"); // Printing if 's' is a palindrome
        } else {
            System.out.println(s + " is not palindrome"); // Printing if 's' is not a palindrome
        }
    }

    // Method to check if a string is a palindrome, starting the check with initial indices
    private static boolean isPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1); // Calling the overloaded isPalindrome method
    }

    // Overloaded method to check if a string is a palindrome using recursion with specified indices
    private static boolean isPalindrome(String s, int left, int right) {
        if (left > right) { // Base case: if the indices cross each other, the string is a palindrome
            return true;
        }
        // Checking if characters at 'left' and 'right' indices are equal
        if (s.charAt(left) != s.charAt(right)) {
            return false; // If characters don't match, it's not a palindrome
        }
        // Recursively checking next characters towards the middle of the string
        return isPalindrome(s, left + 1, right - 1); // Recursive call to check the next pair of characters
    }
}


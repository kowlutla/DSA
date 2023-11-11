package com.dsa.strings;

/**
 * https://www.geeksforgeeks.org/problems/number-following-a-pattern3126/1
 *
 * Given a pattern containing only I's and D's. I for increasing and D for
 * decreasing. Devise an algorithm to print the minimum number following that
 * pattern. Digits from 1-9 and digits can't repeat.
 */
public class NumberFollowingAPattern {

    // Function to print the minimum number following the given pattern
    static String printMinNumberForPattern(String s) {
        int n = s.length(); // Get the length of the pattern
        int count = 1; // Initialize the count of digits
        char[] ans = new char[n + 1]; // Create an array to store the result

        // Traverse the pattern
        for (int i = 0; i <= n; i++) {
            if (i == n || s.charAt(i) == 'I') { // If 'I' is encountered or reaching the end of the pattern

                // Fill the array in increasing order for consecutive 'I's
                for (int j = i - 1; j >= -1; j--) {
                    ans[j + 1] = (char) ('0' + count); // Convert count to char and add it to the array
                    count++; // Increment the count
                    if (j >= 0 && s.charAt(j) == 'I') {
                        break; // Stop filling if consecutive 'I's are encountered
                    }
                }
            }
        }
        return new String(ans); // Return the result as a string
    }

    // Main method for demonstration purposes
    public static void main(String[] args) {
        String pattern = "IDID";
        String result = printMinNumberForPattern(pattern);
        
        // Print the minimum number following the given pattern
        System.out.println("Minimum number following the pattern " + pattern + " is: " + result);
    }
}

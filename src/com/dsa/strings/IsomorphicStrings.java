package com.dsa.strings;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/problems/isomorphic-strings-1587115620/1
 * 
 * Given two strings 'str1' and 'str2', check if these two strings are
 * isomorphic to each other.
 * 
 * If the characters in str1 can be changed to get str2, then two strings, str1
 * and str2, are isomorphic. A character must be completely swapped out for
 * another character while maintaining the order of the characters. A character
 * may map to itself, but no two characters may map to the same character.
 */
public class IsomorphicStrings {

    // Function to check if two strings are isomorphic
    public static boolean areIsomorphic(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false; // If the lengths are different, the strings cannot be isomorphic
        }

        int[] count1 = new int[256]; // Array to store the mapping of characters from str1 to str2
        int[] count2 = new int[256]; // Array to store the mapping of characters from str2 to str1
        Arrays.fill(count1, -1); // Initialize the arrays with -1, indicating no mapping initially
        Arrays.fill(count2, -1);

        // Traverse both strings character by character
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            // If there is no mapping in both directions, create a new mapping
            if (count1[c1] == -1 && count2[c2] == -1) {
                count1[c1] = c2;
                count2[c2] = c1;
            } else if (count1[c1] != c2 || count2[c2] != c1) {
                return false; // If the mapping is inconsistent, the strings are not isomorphic
            }
        }
        return true; // If all characters are successfully mapped, the strings are isomorphic
    }

    // Main method for demonstration purposes
    public static void main(String[] args) {
        String str1 = "egg";
        String str2 = "add";
        boolean result = areIsomorphic(str1, str2);

        // Print whether the strings are isomorphic or not
        System.out.println("Are \"" + str1 + "\" and \"" + str2 + "\" isomorphic? " + result);
    }
}

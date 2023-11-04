package com.dsa.binarysearch;

/**
 * You are given an array of characters letters that is sorted in non-decreasing
 * order, and a character target. There are at least two different characters in
 * letters.
 * 
 * Return the smallest character in letters that is lexicographically greater
 * than target. If such a character does not exist, return the first character
 * in letters.
 */
public class FindSmallestLetterGreaterThanTarget {

    // Method to find the smallest character in letters that is lexicographically greater than target
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters[letters.length - 1] <= target) { // If the last character is less than or equal to target
            return letters[0]; // Return the first character in letters
        }

        // Binary search for finding the smallest character in letters that is lexicographically greater than target
        int start = 0, end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] <= target) { // If the character at mid is less than or equal to target
                start = mid + 1; // Adjust the start index to search in the right half
            } else {
                end = mid - 1; // Adjust the end index to search in the left half
            }
        }
        return letters[start]; // Return the character at the position found by the binary search
    }

    // Main method for demonstration purposes
    public static void main(String[] args) {
        FindSmallestLetterGreaterThanTarget obj = new FindSmallestLetterGreaterThanTarget();
        char[] letters = {'a', 'c', 'f', 'h'};
        char target = 'd';
        System.out.println("The smallest character in letters that is lexicographically greater than target is: " + obj.nextGreatestLetter(letters, target));
    }
}

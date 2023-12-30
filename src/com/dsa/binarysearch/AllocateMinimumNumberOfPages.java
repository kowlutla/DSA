/**
 * 	You have N books, each with A[i] number of pages. M students need to be allocated contiguous books, with each student getting at least one book.
	Out of all the permutations, the goal is to find the permutation where the maximum number of pages allotted to a student should be minimum, out of all possible permutations.
	Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

	Example 1:
	
	Input:
	N = 4
	A[] = {12,34,67,90}
	M = 2
	Output:113
	Explanation:Allocation can be done in 
	following ways:
	{12} and {34, 67, 90} Maximum Pages = 191
	{12, 34} and {67, 90} Maximum Pages = 157
	{12, 34, 67} and {90} Maximum Pages =113.
	Therefore, the minimum of these cases is 113,
	which is selected as the output.
	
	Example 2:
	
	Input:
	N = 3
	A[] = {15,17,20}
	M = 2
	Output:32
	Explanation: Allocation is done as
	{15,17} and {20}
 */
package com.dsa.binarysearch;

/**
 * @author KowlutlaSwamy
 *
 */
public class AllocateMinimumNumberOfPages {

    // Method to find the minimum pages each student must read (less efficient approach)
    public static int findPages1(int[] A, int N, int M) {
        if (N < M) {
            return -1; // If the number of books is less than the number of students, return -1
        }

        int min = Integer.MIN_VALUE;
        int max = 0;

        // Find the maximum and minimum possible pages by a single student
        for (int num : A) {
            min = Math.max(num, min); // Find the book with the maximum number of pages
            max += num; // Calculate the total pages of all books
        }

        // Try allocating different pages to each student
        for (int pages = min; pages <= max; pages++) {
            int maxStudents = allocateBooks(A, pages); // Get the number of students with current pages allocation
            if (maxStudents <= M) {
                return pages; // If the number of students is less than or equal to M, return current pages
            }
        }
        return -1; // If no valid allocation found, return -1
    }

    // Method to find the minimum pages each student must read (more efficient approach using binary search)
    public static int findPages(int[] A, int N, int M) {
        if (N < M) {
            return -1; // If the number of books is less than the number of students, return -1
        }

        int min = Integer.MIN_VALUE;
        int max = 0;

        // Find the maximum and minimum possible pages by a single student
        for (int num : A) {
            min = Math.max(num, min); // Find the book with the maximum number of pages
            max += num; // Calculate the total pages of all books
        }

        int low = min, high = max;

        // Binary search for the minimum pages that satisfy the condition
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int numOfStudents = allocateBooks(A, mid); // Get the number of students with current pages allocation
            if (numOfStudents <= M) {
                high = mid - 1; // Reduce the pages for the next iteration
            } else {
                low = mid + 1; // Increase the pages for the next iteration
            }
        }
        return low; // Return the minimum pages that satisfy the condition
    }

    // Helper method to allocate books to students based on given maximum pages
    private static int allocateBooks(int A[], int maxPages) {
        int students = 1;
        int currentPages = 0;

        // Allocate books to students based on the given maximum pages
        for (int i = 0; i < A.length; i++) {
            if (currentPages + A[i] <= maxPages) {
                currentPages += A[i];
            } else {
                students++;
                currentPages = A[i];
            }
        }
        return students; // Return the number of students needed for the allocation
    }
    
    // Example usage in a main method
    public static void main(String[] args) {
        int[] pagesArray = {12, 34, 67, 90}; // Sample array representing pages of books
        int totalBooks = pagesArray.length;
        int students = 2; // Number of students

        // Using the less efficient approach
        int result1 = findPages1(pagesArray, totalBooks, students);
        System.out.println("Using findPages1 method: " + result1);

        // Using the more efficient approach (binary search)
        int result2 = findPages(pagesArray, totalBooks, students);
        System.out.println("Using findPages method: " + result2);
    }
}

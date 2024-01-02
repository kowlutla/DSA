/**
 * Given a set of positive integers, find all its subsets.

	Example 1 :
	
	Input : 
	array = {1, 2, 3}
	Output :
	// this space denotes null element. 
	1
	1 2
	1 2 3
	1 3
	2
	2 3
	3
	Explanation: 
	The following are the subsets 
	of the array {1, 2, 3}.
	Example 2 :
	
	Input :
	array = {1, 2}
	Output :
	
	1 
	1 2
	2
	Explanation :
	The following are the 
	subsets of {1, 2}.
 */
package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author KowlutlaSwamy
 *
 */
public class Subsets {

    // Method to generate subsets of an ArrayList
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        // Initialize the result container for subsets
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        // Generate subsets recursively and store them in 'result'
        subsets(A, new ArrayList<>(), 0, result);
        
        // Sort the subsets lexicographically
        Collections.sort(result, (a, b) -> {
            // Custom comparator to sort subsets
            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                int cmp = Integer.compare(a.get(i), b.get(i));
                if (cmp != 0) {
                    return cmp;
                }
            }
            return Integer.compare(a.size(), b.size());
        });
        
        // Return the sorted subsets
        return result;
    }

    // Helper method to generate subsets recursively
    private static void subsets(ArrayList<Integer> A, ArrayList<Integer> aux, int index, ArrayList<ArrayList<Integer>> result) {
        // When index reaches the end of 'A', add the subset to 'result'
        if (index == A.size()) {
            ArrayList<Integer> r = new ArrayList<>(aux);
            result.add(r);
            return;
        }
        
        // Recursively generate subsets excluding the current element
        subsets(A, aux, index + 1, result);
        
        // Recursively generate subsets including the current element
        aux.add(A.get(index));
        subsets(A, aux, index + 1, result);
        aux.remove(aux.size() - 1); // Backtrack: Remove the current element to backtrack
    }

    // Main method to test subset generation
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);

        // Generate subsets for the given input
        ArrayList<ArrayList<Integer>> subsets = subsets(input);

        // Display the generated subsets
        for (ArrayList<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}

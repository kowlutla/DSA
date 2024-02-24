/**
 * 	Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. 
 	Find the order of characters in the alien language.
 	
	Note: Many orders may be possible for a particular test case, thus you may return any valid order and output 
	will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.
	 
	Example 1:
	Input: 
	N = 5, K = 4
	dict = {"baa","abcd","abca","cab","cad"}
	Output:
	1
	Explanation:
	Here order of characters is 
	'b', 'd', 'a', 'c' Note that words are sorted 
	and in the given language "baa" comes before 
	"abcd", therefore 'b' is before 'a' in output.
	Similarly we can find other orders.

	Example 2:
	Input: 
	N = 3, K = 3
	dict = {"caa","aaa","aab"}
	Output:
	1
	Explanation:
	Here order of characters is
	'c', 'a', 'b' Note that words are sorted
	and in the given language "caa" comes before
	"aaa", therefore 'c' is before 'a' in output.
	Similarly we can find other orders.
 */
package com.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KowlutlaSwamy
 *
 */
public class G26AlienDictionary {

    /**
     * Finds the lexicographical order of characters in an alien language based on a given dictionary.
     *
     * @param dictionary: An array of words in the alien language.
     * @param n: Number of words in the dictionary.
     * @param k: Number of unique characters in the alien language.
     * @return A string representing the lexicographical order of characters, or an empty string if a valid order cannot be determined.
     *
     * Time Complexity: O(N * K), where N is the number of words and K is the maximum word length.
     * Space Complexity: O(K^2) due to the adjacency list.
     */
    public String findOrder(String[] dictionary, int n, int k) {
        // Create an adjacency list to represent the graph of character dependencies.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }

        // Construct the graph based on the dictionary words.
        for (int i = 0; i < n - 1; i++) {
            String word1 = dictionary[i];
            String word2 = dictionary[i + 1];
            int minLength = Math.min(word1.length(), word2.length());
            for (int j = 0; j < minLength; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    // Add an edge from the first character to the second character.
                    adj.get(word1.charAt(j) - 'a').add(word2.charAt(j) - 'a');
                    break; // Only consider the first differing characters.
                }
            }
        }

        // Perform a topological sort to determine the character order.
        int[] inDegree = new int[k]; // Store the in-degree of each character.
        for (ArrayList<Integer> edges : adj) {
            for (int neighbor : edges) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        StringBuffer order = new StringBuffer();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.append((char) (node + 'a')); // Append the character to the order string.
            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // If the order string doesn't contain all characters, there's a cyclic dependency.
        return order.length() == k ? order.toString() : "";
    }

    // **Main method (for demonstration purposes)**
    public static void main(String[] args) {
        String[] dictionary = {"baa", "abcd", "abca", "cab", "cad"};
        int n = dictionary.length;
        int k = 4;

        String order = new G26AlienDictionary().findOrder(dictionary, n, k);

        System.out.println("Alien language order: " + order);
    }
}

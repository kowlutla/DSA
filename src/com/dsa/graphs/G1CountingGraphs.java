/**
 * 	Given an integer n representing number of vertices. Find out how many undirected graphs (not necessarily connected) can be constructed out of a given n number of vertices.
	
	Example 1:
	Input: 2
	Output: 2

	Example 2:
	Input: 5
	Output: 1024
 */
package com.dsa.graphs;

/**
 * @author KowlutlaSwamy
 *
 */
public class G1CountingGraphs {

    /**
     * This method counts the number of undirected graphs that can be formed with n nodes.
     *
     * @param n The number of nodes in the graph.
     * @return The number of possible undirected graphs with n nodes.
     */
    public static long count(int n) {
        int edges = n * (n - 1) / 2; // Calculate the maximum number of possible edges in a complete graph with n nodes.
        return (long) Math.pow(2, edges); // Each edge can be either present or absent, leading to 2^edges possible combinations.
    }

    // Main method to test the code with an example
    public static void main(String[] args) {
        int n = 4; // Example with 4 nodes
        long graphCount = count(n);
        System.out.println("Number of possible graphs with " + n + " nodes: " + graphCount); // Output: 64
    }
}


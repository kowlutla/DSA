/**
 * 	Given an undirected graph with V nodes and E edges, create and return an adjacency list of the graph. 0-based indexing is followed everywhere.
	
	Example 1:
	Input:
	V = 5, E = 7
	edges = {(0,1),(0,4),(4,1),(4,3),(1,3),(1,2),(3,2)}
	
	Output: 
	{{1,4}, 
	 {0,2,3,4}, 
	 {1,3},
	 {1,2,4},
	 {0,1,3}}
	Explanation:
	Node 0 is connected to 1 and 4.
	Node 1 is connected to 0,2,3 and 4.
	Node 2 is connected to 1 and 3.
	Node 3 is connected to 1,2 and 4.
	Node 4 is connected to 0,1 and 3.

	Example 2:
	Input:
	V = 4, E = 3
	edges = {(0,3),(0,2),(2,1)}
	
	Output: 
	{{2,3} 
	 {2}, 
	 {0,1} 
	 {0}}
	Explanation:
	Node 0 is connected to 2 and 3.
	Node 1 is only connected to 2.
	Node 2 is connected to 0 and 1.
	Node 3 is only connected to 0.
 */
package com.dsa.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KowlutlaSwamy
 *
 */
public class G2And3PrintAdjacencyList {

    /**
     * This method creates and returns the adjacency list representation of an undirected graph.
     *
     * @param V The number of vertices in the graph.
     * @param edges A 2D array where each row represents an edge (u, v).
     * @return A list of lists representing the adjacency list of the graph.
     */
    public static List<List<Integer>> printGraph(int V, int edges[][]) {
        // Create an empty adjacency list with V empty lists (one for each vertex).
        List<List<Integer>> result = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            result.add(new ArrayList<>());
        }

        // Add edges to the adjacency list, considering undirected nature.
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            result.get(u).add(v); // Add v as a neighbor of u
            result.get(v).add(u); // Add u as a neighbor of v (for undirected graph)
        }

        return result;
    }

    // Main method to test the code with an example
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int edges[][] = {{0, 1}, {0, 4}, {1, 2}, {1, 3}, {2, 3}, {3, 4}}; // Example edges

        List<List<Integer>> adjList = printGraph(V, edges);

        // Print the adjacency list
        for (int i = 0; i < V; i++) {
            System.out.print("Adjacency list for vertex " + i + ": ");
            for (int j : adjList.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}

/**
 * 	You are given a connected undirected graph. Perform a Depth First Traversal of the graph.
	Note: Use the recursive approach to find the DFS traversal of the graph starting from the 
	0th vertex from left to right according to the graph.
	
	Example 1:
	Input: V = 5 , adj = [[2,3,1] , [0], [0,4], [0], [2]]
	Output: 0 2 4 3 1
	Explanation: 
	0 is connected to 2, 3, 1.
	1 is connected to 0.
	2 is connected to 0 and 4.
	3 is connected to 0.
	4 is connected to 2.
	so starting from 0, it will go to 2 then 4,
	and then 3 and 1.
	Thus dfs will be 0 2 4 3 1.

	Example 2:
	Input: V = 4, adj = [[1,3], [2,0], [1], [0]]
	Output: 0 1 2 3
	Explanation:
	0 is connected to 1 , 3.
	1 is connected to 0, 2. 
	2 is connected to 1.
	3 is connected to 0. 
	so starting from 0, it will go to 1 then 2
	then back to 0 then 0 to 3
	thus dfs will be 0 1 2 3. 
 */
package com.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class G6DepthFirstSearch {

    /**
     * Performs a Depth-First Search (DFS) on a graph and returns the traversal order as a list.
     *
     * Time complexity: O(V + E), where V is the number of vertices and E is the number of edges.
     * Space complexity: O(V), due to the visited array and recursive stack for DFS exploration.
     *
     * @param V Number of vertices in the graph.
     * @param adj Adjacency list representation of the graph, where adj[i] stores the neighbors of vertex i.
     * @return A list containing the DFS traversal order of the graph.
     */
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Array to track visited vertices.
        boolean[] visited = new boolean[V];

        // List to store the DFS traversal order.
        ArrayList<Integer> traversal = new ArrayList<>();

        // Start DFS exploration from an arbitrary node (usually 0).
        dfsOfGraph(adj, visited, traversal, 0);

        return traversal;
    }

    // Recursive helper function for DFS exploration.
    private void dfsOfGraph(ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> traversal, int node) {
        // Mark the current node as visited.
        visited[node] = true;

        // Add the current node to the traversal list.
        traversal.add(node);

        // Explore all unvisited neighbors of the current node.
        for (int nextNode : adj.get(node)) {
            if (!visited[nextNode]) {
                dfsOfGraph(adj, visited, traversal, nextNode);
            }
        }
    }

    // Main method to test the code with an example
    public static void main(String[] args) {
        // Example adjacency list representing a simple graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2, 3)));
        adj.add(new ArrayList<>(Arrays.asList(0, 1, 4)));
        adj.add(new ArrayList<>(Arrays.asList(2)));
        adj.add(new ArrayList<>(Arrays.asList(2)));

        int V = 5; // Number of vertices

        G6DepthFirstSearch dfs = new G6DepthFirstSearch();
        ArrayList<Integer> traversal = dfs.dfsOfGraph(V, adj);

        System.out.println("DFS traversal order: " + traversal); // Output: [0, 1, 2, 3, 4]
    }
}

/**
 *	Given an undirected graph with V vertices. We say two vertices u and v belong to a single province 
 	if there is a path from u to v or v to u. Your task is to find the number of provinces.
	Note: A province is a group of directly or indirectly connected cities and no other cities outside of the group.

	Example 1:
	Input:
	[
	 [1, 0, 1],
	 [0, 1, 0],
	 [1, 0, 1]
	]
	Output:
	2
	Explanation:
	The graph clearly has 2 Provinces [1,3] and [2]. As city 1 and city 3 has a path between them they belong to a 
	single province. City 2 has no path to city 1 or city 3 hence it belongs to another province.

	Example 2:
	Input:
	[
	 [1, 1],
	 [1, 1]
	]
	Output :
	1 
 */
package com.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KowlutlaSwamy
 *
 */
public class G4NumberOfProvincesBFS {

    /**
     * Calculates the number of connected components (provinces) in an undirected graph.
     *
     * Time complexity: O(V + E), where V is the number of vertices and E is the number of edges.
     * Space complexity: O(V), due to the visited array and queue used for exploration.
     *
     * @param adj Adjacency list representation of the graph, where adj[i] stores the neighbors of vertex i.
     * @param V Number of vertices in the graph.
     * @return The number of connected components (provinces) in the graph.
     */
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // Use a queue for Breadth-First Search (BFS) exploration.
        Queue<Integer> q = new LinkedList<>();

        // Create a visited array to track explored vertices.
        boolean[] visited = new boolean[V];

        // Initialize the number of provinces (connected components) to 0.
        int provinces = 0;

        // Iterate through all vertices, starting from unvisited ones.
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                // Mark the current vertex as visited and increment the province count.
                visited[i] = true;
                provinces++;

                // Add the current vertex to the queue to start BFS exploration.
                q.add(i);

                // Perform BFS to explore all connected vertices from the current one.
                while (!q.isEmpty()) {
                    int node = q.poll();

                    // Iterate through neighbors of the dequeued vertex.
                    for (int nextLevelNode = 0; nextLevelNode < V; nextLevelNode++) {
                        // If a neighbor is connected and unvisited, mark it as visited and add it to the queue.
                        if (adj.get(node).get(nextLevelNode) == 1 && !visited[nextLevelNode]) {
                            visited[nextLevelNode] = true;
                            q.add(nextLevelNode);
                        }
                    }
                }
            }
        }

        return provinces;
    }

    public static void main(String[] args) {
    	ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    	adjList.add(new ArrayList<>(Arrays.asList(1, 1, 1, 0))); 
    	adjList.add(new ArrayList<>(Arrays.asList(1, 1, 1, 0))); 
    	adjList.add(new ArrayList<>(Arrays.asList(1, 1, 1, 0))); 
    	adjList.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1))); 


        int V = 4; // Number of vertices

        int provinceCount = numProvinces(adjList, V);

        System.out.println("Number of provinces: " + provinceCount); // Output: 2
    }
}

/**
 * 	There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. 
 	You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. 
 	More formally, for each v in graph[u], there is an undirected edge between node u and node v. 
 	The graph has the following properties:
	
	There are no self-edges (graph[u] does not contain u).
	There are no parallel edges (graph[u] does not contain duplicate values).
	If v is in graph[u], then u is in graph[v] (the graph is undirected).
	The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
	A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in 
	the graph connects a node in set A and a node in set B.
	
	Return true if and only if it is bipartite.
	
	Example 1:
	Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
	Output: false
	Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.

	Example 2:
	Input: graph = [[1,3],[0,2],[1,3],[0,2]]
	Output: true
	Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
	 
 */
package com.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class G18BipartiteGraphDFS {

	/**
	 * Checks if the given graph represented by an adjacency list is bipartite using Depth First Search (DFS).
	 * 
	 * Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph.
	 * Space Complexity: O(V) for the color array used in DFS.
	 * 
	 * @param V   The number of vertices in the graph.
	 * @param adj The adjacency list representing the graph.
	 * @return    True if the graph is bipartite, otherwise false.
	 */
	public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
		int[] color = new int[V]; // Array to store colors of vertices
		Arrays.fill(color, -1); // Initialize all vertices with color -1 (unvisited)

		// Iterate through each vertex
		for (int i = 0; i < V; i++) {
			if (color[i] == -1) { // If the vertex is unvisited
				if (!dfs(adj, color, i, 0)) { // Perform DFS traversal
					return false; // If the graph is not bipartite, return false
				}
			}
		}
		return true; // If no conflicts are found, return true (graph is bipartite)
	}

	/**
	 * Depth First Search (DFS) traversal to assign colors to vertices and check for conflicts.
	 * 
	 * @param adj   The adjacency list representing the graph.
	 * @param color Array to store colors of vertices.
	 * @param node  The current vertex being visited.
	 * @param c     The color to be assigned to the current vertex.
	 * @return      True if the graph is bipartite from the given source vertex, otherwise false.
	 */
	private static boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] color, int node, int c) {
		color[node] = c; // Assign color c to the current vertex
		for (int adjNode : adj.get(node)) { // Iterate through adjacent vertices of the current vertex
			if (color[adjNode] == -1) { // If the adjacent vertex is unvisited
				color[adjNode] = 1 - color[node]; // Assign alternate color to the adjacent vertex
				if (!dfs(adj, color, adjNode, 1 - color[node])) { // Recursive DFS traversal
					return false; // If the graph is not bipartite, return false
				}
			} else if (color[node] == color[adjNode]) { // If adjacent vertices have the same color
				return false; // Graph is not bipartite (conflict found)
			}
		}
		return true; // Graph is bipartite
	}
	
	 public static void main(String[] args) {
	        // Example graph represented by an adjacency list
	        int V = 4; // Number of vertices
	        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	        for (int i = 0; i < V; i++) {
	            adj.add(new ArrayList<>());
	        }
	        adj.get(0).add(1);
	        adj.get(1).add(0);
	        adj.get(1).add(2);
	        adj.get(2).add(1);
	        adj.get(2).add(3);
	        adj.get(3).add(2);
	        
	        // Check if the graph is bipartite
	        boolean isBipartite = isBipartite(V, adj);
	        
	        // Print the result
	        if (isBipartite) {
	            System.out.println("The graph is bipartite.");
	        } else {
	            System.out.println("The graph is not bipartite.");
	        }
	    }
}


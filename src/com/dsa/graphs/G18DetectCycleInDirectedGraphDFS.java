/**
 * 	Given a directed graph, check whether the graph contains a cycle or not. 
 	Your function should return true if the given graph contains at least one 
 	cycle, else return false.
	
	Detailed explanation ( Input/output format, Notes, Images )
	Constraints:
	1 <= T <= 10
	1 <= V <= 10^3
	0 <= E <= 10^3
	0 <= A, B < V
	
	Time Limit: 1 sec
	Sample Input 1:.
	2
	4 4
	0 1
	1 2
	2 3
	3 0
	3 3
	1 0
	1 2
	0 2
	Sample Output 1:
	true
	false
	Explanation for Sample Input 1:
	In the first case,
	From node 0 we can reach 0 again by following this sequence of nodes in the path: 0,1,2,3,0.
 */
package com.dsa.graphs;

import java.util.ArrayList;

/**
 * @author KowlutlaSwamy
 *
 */
public class G18DetectCycleInDirectedGraphDFS {

	/**
	 * Determines whether a directed graph represented by an adjacency list contains a cycle using Depth First Search (DFS).
	 * 
	 * Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph.
	 * Space Complexity: O(V) for the visited and pathVisited arrays used in DFS.
	 * 
	 * @param edges An array containing directed edges represented as pairs of vertices.
	 * @param V     The number of vertices in the graph.
	 * @param e     The number of edges in the graph.
	 * @return      True if the graph contains a cycle, otherwise false.
	 */
	public static Boolean isCyclic(int[][] edges, int V, int e) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < e; i++) {
			int from = edges[i][0];
			int to = edges[i][1];
			adj.get(from).add(to);
		}

		boolean[] visited = new boolean[V]; // Array to mark visited vertices
		boolean[] pathVisited = new boolean[V]; // Array to mark vertices visited in the current DFS path

		// Iterate through each vertex
		for (int i = 0; i < V; i++) {
			if (!visited[i]) { // If the vertex is not visited
				if (hasCycle(adj, visited, pathVisited, i)) { // Check for cycle
					return true; // If a cycle is found, return true
				}
			}
		}
		return false; // If no cycle is found, return false
	}

	/**
	 * Recursive Depth First Search (DFS) to detect a cycle in the graph.
	 * 
	 * @param adj         The adjacency list representing the graph.
	 * @param visited     Array to mark visited vertices.
	 * @param pathVisited Array to mark vertices visited in the current DFS path.
	 * @param node        The current vertex being visited.
	 * @return            True if the graph contains a cycle from the given source vertex, otherwise false.
	 */
	private static boolean hasCycle(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited, int node) {
		visited[node] = true; // Mark the current vertex as visited
		pathVisited[node] = true; // Mark the current vertex as visited in the current DFS path

		for (int adjNode : adj.get(node)) { // Iterate through adjacent vertices
			if (!visited[adjNode]) { // If the adjacent vertex is not visited
				visited[adjNode] = true; // Mark the adjacent vertex as visited
				pathVisited[adjNode] = true; // Mark the adjacent vertex as visited in the current DFS path
				if (hasCycle(adj, visited, pathVisited, adjNode)) { // Recursive DFS traversal
					return true; // If a cycle is found in the subtree rooted at the adjacent vertex, return true
				}
			} else if (pathVisited[adjNode]) { // If the adjacent vertex is visited in the current DFS path
				return true; // A cycle is found
			}
		}

		pathVisited[node] = false; // Reset pathVisited status for the current vertex
		return false; // No cycle found
	}
	
	public static void main(String[] args) {
        // Example directed graph represented by edges
        int[][] edges = {
            {0, 1}, {1, 2}, {2, 3}, {3, 0} // Example cyclic graph
        };
        int V = 4; // Number of vertices
        int e = edges.length; // Number of edges

        // Check if the graph contains a cycle
        boolean isCyclic = isCyclic(edges, V, e);

        // Print the result
        if (isCyclic) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }
}

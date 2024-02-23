/**
 * 	Given a DAG(direct acyclic graph), print Topological Sorting of a given graph
	
	Detailed explanation ( Input/output format, Notes, Images )
	Constraints:
	1 <= T <= 10
	1 <= V <= 1000
	0 <= E <= 3000
	0 <= U, V <= V-1
	
	Time Limit: 1sec
	Sample Input 1:
	1
	5 4
	0 2
	1 2
	3 1
	0 4
	Sample Output 1:
	Correct
	Sample Output 1 Explanation:
	One correct sort order is : 3 1 0 4 2.
 */
package com.dsa.graphs;

/**
 * @author KowlutlaSwamy
 *
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class G21TopologicalSort {

	/**
	 * Performs topological sorting of a directed acyclic graph (DAG) represented by edges.
	 * 
	 * @param edges An array containing directed edges represented as pairs of vertices.
	 * @param e     The number of edges in the graph.
	 * @param v     The number of vertices in the graph.
	 * @return      A list representing the topological ordering of vertices.
	 */
	public static List<Integer> topologicalSort(int[][] edges, int e, int v) {

		// Create adjacency list representation of the graph
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<>());
		}

		// Populate adjacency list from edges
		for (int i = 0; i < e; i++) {
			int from = edges[i][0];
			int to = edges[i][1];
			adj.get(from).add(to);
		}

		boolean visited[] = new boolean[v]; // Array to track visited vertices during DFS
		Stack<Integer> stack = new Stack<>(); // Stack to store vertices in topological order

		// Perform DFS traversal on each vertex
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				dfs(adj, visited, stack, i); // DFS traversal
			}
		}

		List<Integer> result = new ArrayList<>();

		// Pop elements from stack to get topological order
		while (!stack.isEmpty()) {
			result.add(stack.pop());
		}
		return result;
	}

	/**
	 * Recursive Depth First Search (DFS) traversal for topological sorting.
	 * 
	 * @param adj      The adjacency list representing the graph.
	 * @param visited  Array to mark visited vertices.
	 * @param stack    Stack to store vertices in topological order.
	 * @param node     The current vertex being visited.
	 */
	private static void dfs(ArrayList<ArrayList<Integer>> adj,
			boolean[] visited, Stack<Integer> stack, int node) {
		visited[node] = true; // Mark the current vertex as visited

		// Traverse adjacent vertices
		for (int adjNode : adj.get(node)) {
			if (!visited[adjNode]) { // If adjacent vertex is not visited
				dfs(adj, visited, stack, adjNode); // Recursive DFS traversal
			}
		}
		stack.push(node); // Push the current vertex onto the stack after visiting all its adjacent vertices
	}
	
	public static void main(String[] args) {
		// Example directed graph represented by edges
		int[][] edges = {{5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}};
		int V = 6; // Number of vertices
		int E = edges.length; // Number of edges

		// Perform topological sorting
		List<Integer> result = topologicalSort(edges, E, V);

		// Print the topological ordering
		System.out.println("Topological ordering:");
		for (int vertex : result) {
			System.out.print(vertex + " ");
		}
	}
}

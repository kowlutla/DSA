/**
 * 	There is a directed graph of n nodes with each node labeled from 0 to n - 1.
  	The graph is represented by a 0-indexed 2D integer array graph where graph[i] 
  	is an integer array of nodes adjacent to node i, meaning there is an edge from 
  	node i to each node in graph[i].
  	
	A node is a terminal node if there are no outgoing edges.
	A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).
	Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
	
	Example 1:
	Illustration of graph
	Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
	Output: [2,4,5,6]
	Explanation: The given graph is shown above.
	Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
	Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.

	Example 2:
	Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
	Output: [4]
	Explanation:
	Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
 */
package com.dsa.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author KowlutlaSwamy
 *
 */
public class G20EventualSafeStatesBFS {

    /**
     * Finds all eventual safe nodes in a directed graph using Breadth-First Search (BFS).
     * An eventual safe node is a node that can be reached from a terminal node (a node with no outgoing edges).
     *
     * @param graph: A 2D array representing directed edges, where graph[i] is a list of nodes reachable from node i.
     * @return A sorted list of indices of eventual safe nodes.
     *
     * Time Complexity: O(V + E), where V is the number of nodes and E is the number of edges.
     * Space Complexity: O(V + E) due to the usage of adjacency list, queue, and visited arrays.
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length; // Number of nodes in the graph

        // Create a reversed adjacency list for efficient BFS traversal.
        // Instead of iterating through outgoing edges, we iterate through incoming edges.
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            revAdj.add(new ArrayList<>());
        }

        // Calculate the in-degree of each node (number of incoming edges).
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j : graph[i]) {
                revAdj.get(j).add(i); // Add edges from destination to source (reversed)
                inDegree[i]++;
            }
        }

        // Queue to store nodes to be explored during BFS.
        Queue<Integer> q = new LinkedList<>();

        // List to store eventual safe nodes.
        List<Integer> safeNodes = new LinkedList<>();

        // Start BFS from nodes with 0 in-degree (terminal nodes).
        // These nodes are guaranteed to be eventually safe as they have no outgoing edges.
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        // Perform BFS traversal to explore reachable nodes and identify safe nodes.
        while (!q.isEmpty()) {
            int node = q.poll(); // Dequeue the next node to explore.

            // Add the current node to the list of safe nodes.
            // Since it has been reached from a previously identified safe node,
            // it is also eventually safe.
            safeNodes.add(node);

            // Decrement the in-degree of all its neighbors (nodes it points to).
            // If a neighbor's in-degree becomes 0 after this decrement, it means
            // all its incoming edges have been explored, making it reachable from
            // a safe node and therefore eventually safe. Add it to the queue for further exploration.
            for (int adjNode : revAdj.get(node)) {
                inDegree[adjNode]--;
                if (inDegree[adjNode] == 0) {
                    q.add(adjNode);
                }
            }
        }

        // Sort the list of safe nodes for consistent output (optional).
        Collections.sort(safeNodes);

        return safeNodes;
    }

    // **Main method (for demonstration purposes)**
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};

        List<Integer> safeNodes = new G20EventualSafeStatesBFS().eventualSafeNodes(graph);

        System.out.println("Eventual safe nodes: " + safeNodes);
    }
}

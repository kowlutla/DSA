/**
 * 	Ninja has been given a matrix/list 'EDGES' denoting 'E' edges of a directed graph having ‘N’ nodes. 
 	Ninja starts walking from some node (say ‘START’) in the graph along a directed edge of the graph. 
 	If Ninja reaches an end node (say ‘END’) (a node that has no outgoing directed edges), 
 	Ninja stops walking.
	
	Now a starting node ‘START’ is a safe node only if Ninja must eventually walk to an end node 
	‘END’. More specifically, there must be a natural number ‘K’, so that Ninja must have stopped 
	at an end node in less than ‘K’ steps for any choice of where to walk.
	
	For Example: For the graph, as shown in the picture below, [2, 4] are the only safe nodes.
	
	
	Ninja wants to know all the safe nodes in the graph in sorted order. Can you help Ninja 
	to find out all the safe nodes?
	
	Detailed explanation ( Input/output format, Notes, Images )
	Constraints :
	1 <= T <= 100
	1 <= N <= 10 ^ 4
	1 <= E <= 10 ^ 4
	0 <= EDGE[i][0] and EDGE[i][1] < N
	
	Where ‘EDGE[i][0]’ and ‘EDGE[i][1]’ represents the directed edge.
	
	Time Limit: 1 sec
	Sample Input 1 :
	2
	3 2
	1 2
	2 0
	2 0
	Sample Output 1:
	0 1 2
	0 1
	Explanation for Sample Output 1:
	For the first test case:
	[0, 1, 2] are the safe nodes. See the picture below for your reference:
	
	For the second case:
	[0, 1] are the safe nodes. Because there is no edge between nodes so each node is a starting and an ending node.
	Sample Input 2 :
	2
	5 3
	0 1
	1 0
	0 2
	2 2
	0 1
	1 0
	Sample Output 2 :
	2 3 4
	Explanation for Sample Output 1:
	For the first test case:
	[2, 3, 4] are the safe nodes. See the picture below for your reference:

 */
package com.dsa.graphs;

import java.util.ArrayList;

/**
 * @author KowlutlaSwamy
 *
 */
public class G20EventualSafeStatesDFS {

    /**
     * Finds all safe nodes in a directed graph using Depth-First Search (DFS).
     * A safe node is one that can be eventually reached without encountering cycles.
     *
     * @param edges: A 2D array representing directed edges, where edges[i][0] is the source and edges[i][1] is the destination.
     * @param n: Total number of nodes.
     * @param e: Number of edges.
     * @return An ArrayList containing the indices of all safe nodes.
     *
     * Time Complexity: O(V + E) in the worst case, where V is the number of nodes and E is the number of edges.
     * Space Complexity: O(V) due to the usage of recursion stack and visited arrays.
     */
    public static ArrayList<Integer> safeNodes(int[][] edges, int n, int e) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            adj.get(from).add(to); // Add edges from source to destination
        }

        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        boolean[] safeNodes = new boolean[n];

        ArrayList<Integer> result = new ArrayList<>();

        // Perform DFS traversal from each unvisited node.
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                hasCycle(adj, visited, pathVisited, safeNodes, i);
            }
        }

        // Collect safe nodes based on the safeNodes array.
        for (int i = 0; i < n; i++) {
            if (safeNodes[i]) {
                result.add(i);
            }
        }

        return result;
    }

    /**
     * Helper function to check for cycles and mark safe nodes during DFS traversal.
     *
     * @param adj: Adjacency list representing the graph.
     * @param visited: Array to track visited nodes.
     * @param pathVisited: Array to track nodes in the current DFS path.
     * @param safeNodes: Array to mark safe nodes.
     * @param node: Current node being explored in DFS.
     * @return true if a cycle is found, false otherwise.
     */
    private static boolean hasCycle(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited, boolean[] safeNodes, int node) {
        visited[node] = true;
        pathVisited[node] = true;
        safeNodes[node] = false; // Initially assume node in cycle until proven otherwise

        for (int adjNode : adj.get(node)) {
            if (!visited[adjNode]) {
                if (hasCycle(adj, visited, pathVisited, safeNodes, adjNode)) {
                    return true;
                }
            } else if (pathVisited[adjNode]) {
                return true; // Cycle detected
            }
        }

        pathVisited[node] = false;
        safeNodes[node] = true; // Mark node as safe if no cycle found in its subtree
        return false;
    }

    // **Main method (for demonstration purposes)**
    public static void main(String[] args) {
        int[][] edges = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int n = 4; // Number of nodes
        int e = 4; // Number of edges

        ArrayList<Integer> safeNodes = safeNodes(edges, n, e);

        if (safeNodes.isEmpty()) {
            System.out.println("No safe nodes exist due to cycles in the graph.");
        } else {
            System.out.println("Safe nodes: ");
            for (int node : safeNodes) {
                System.out.print(node + " ");
            }
        }
    }
}

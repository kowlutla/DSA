/**
 * 	Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
	Note: One can move from node u to node v only if there's an edge from u to v. Find the BFS traversal 
	of the graph starting from the 0th vertex, from left to right according to the input graph. Also, 
	you should only take nodes directly or indirectly connected from Node 0 in consideration.
	
	Example 1:
	Input:
	V = 5, E = 4
	adj = {{1,2,3},{},{4},{},{}}
	Output: 
	0 1 2 3 4
	Explanation: 
	0 is connected to 1 , 2 , 3.
	2 is connected to 4.
	so starting from 0, it will go to 1 then 2
	then 3. After this 2 to 4, thus bfs will be
	0 1 2 3 4.

	Example 2:
	Input:
	V = 3, E = 2
	adj = {{1,2},{},{}}
	Output: 
	0 1 2
	Explanation:
	0 is connected to 1 , 2.
	so starting from 0, it will go to 1 then 2,
	thus bfs will be 0 1 2. 
 */
package com.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KowlutlaSwamy
 *
 */
public class G5BredthFirstSearch {

    /**
     * Performs Breadth-First Search (BFS) on an undirected graph and returns the traversal order.
     *
     * Time complexity: O(V + E), where V is the number of vertices and E is the number of edges.
     * Space complexity: O(V), due to the visited array and queue used for exploration.
     *
     * @param V Number of vertices in the graph.
     * @param adj Adjacency list representation of the graph, where adj[i] stores the neighbors of vertex i.
     * @return A list containing the BFS traversal order of the graph.
     */
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Create an empty list to store the BFS traversal order.
        ArrayList<Integer> bfs = new ArrayList<>();

        // Create a visited array to track explored vertices.
        boolean visited[] = new boolean[V];

        // Use a queue to implement the BFS exploration.
        Queue<Integer> q = new LinkedList<>();

        // Start BFS from vertex 0 and mark it as visited.
        q.add(0);
        visited[0] = true;

        // Iterate until the queue becomes empty (all reachable vertices explored).
        while (!q.isEmpty()) {
            // Dequeue the next vertex from the queue.
            int node = q.poll();

            // Add the dequeued vertex to the BFS traversal order.
            bfs.add(node);

            // Iterate through neighbors of the dequeued vertex.
            for (int nextLevelNode : adj.get(node)) {
                // If neighbor hasn't been visited yet, mark it as visited and add it to the queue.
                if (!visited[nextLevelNode]) {
                    visited[nextLevelNode] = true;
                    q.add(nextLevelNode);
                }
            }
        }

        return bfs;
    }

    // Main method to test the BFS implementation
    public static void main(String[] args) {
        // Adjacency list representation of a 7-node graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph (modify connections as needed)
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);
        adj.get(2).add(4);
        adj.get(3).add(5);
        adj.get(4).add(6);

        G5BredthFirstSearch bfs = new G5BredthFirstSearch();
        ArrayList<Integer> traversal = bfs.bfsOfGraph(7, adj);

        System.out.println("BFS traversal order: " + traversal);
    }
}

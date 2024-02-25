/**
 * 	Given a Directed Acyclic Graph of N vertices from 0 to N-1 and a 2D Integer array(or vector) edges[ ][ ] of length M, 
 	where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.
	Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, 
	then return -1 for that vertex.
	
	Example1:
	Input:
	N = 4, M = 2
	edge = [[0,1,2],[0,2,1]]
	Output:
	0 2 1 -1
	Explanation:
	Shortest path from 0 to 1 is 0->1 with edge weight 2. 
	Shortest path from 0 to 2 is 0->2 with edge weight 1.
	There is no way we can reach 3, so it's -1 for 3.

	Example2:
	Input:
	N = 6, M = 7
	edge = [[0,1,2],[0,4,1],[4,5,4],[4,2,2],[1,2,3],[2,3,6],[5,3,1]]
	Output:
	0 2 3 6 1 5
	Explanation:
	Shortest path from 0 to 1 is 0->1 with edge weight 2. 
	Shortest path from 0 to 2 is 0->4->2 with edge weight 1+2=3.
	Shortest path from 0 to 3 is 0->4->5->3 with edge weight 1+4+1=6.
	Shortest path from 0 to 4 is 0->4 with edge weight 1.
	Shortest path from 0 to 5 is 0->4->5 with edge weight 1+4=5.
 */
package com.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author KowlutlaSwamy
 *
 */
public class G28ShortestPathInDirectedAcyclicGraphTopoSort {

    /**
     * Represents a pair of node and its weight in an edge.
     */
    private static class Pair {
        int to;
        int wt;

        public Pair(int to, int wt) {
            this.to = to;
            this.wt = wt;
        }

        @Override
        public String toString() {
            return "[" + to + ", " + wt + "]";
        }
    }

    /**
     * Finds the shortest paths from a source node to all other nodes in a directed acyclic graph (DAG) using topological sorting.
     *
     * @param n: Number of nodes in the graph.
     * @param m: Number of edges in the graph.
     * @param edges: A 2D array representing edges, where edges[i] = [from, to, weight] denotes an edge from node 'from' to node 'to' with weight 'weight'.
     * @return An array where distance[i] represents the shortest path length from the source node (assumed to be node 0) to node i, or -1 if there is no path.
     *
     * Time Complexity: O(V + E), where V is the number of nodes and E is the number of edges.
     * Space Complexity: O(V) due to the adjacency list, visited array, stack, and distance array.
     */
    public static int[] shortestPath(int n, int m, int[][] edges) {
        // Create an adjacency list representation of the graph.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the adjacency list.
        for (int i = 0; i < m; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            int wt = edges[i][2];
            adj.get(from).add(new Pair(to, wt));
        }

        // Perform topological sort using Depth-First Search (DFS).
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj, visited, i, stack);
            }
        }

        // Initialize distances to infinity and set distance to source node as 0.
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        // Relax edges in topological order to find shortest paths.
        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (Pair adjNode : adj.get(node)) {
                int to = adjNode.to;
                int wt = adjNode.wt;
                if (distance[to] > distance[node] + wt) {
                    distance[to] = distance[node] + wt;
                }
            }
        }

        // Replace infinity values with -1 to indicate unreachable nodes.
        for (int i = 0; i < n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }

        return distance;
    }

    private static void dfs(ArrayList<ArrayList<Pair>> adj, boolean[] visited, int node, Stack<Integer> stack) {
        visited[node] = true;
        for (Pair adjNode : adj.get(node)) {
            if (!visited[adjNode.to]) {
                dfs(adj, visited, adjNode.to, stack);
            }
        }
        stack.push(node); // Push node to the stack after visiting all its neighbors.
    }

    // **Main method (for demonstration purposes)**
    public static void main(String[] args) {
        int n = 6; // Number of nodes
        int m = 7; // Number of edges
        int[][] edges = {{0, 1, 2}, {0, 2, 4}, {1, 2, 3}, {1, 3, 6}, {2, 4, 2}, {4, 5, 4}, {3, 5, 1}};

        int[] distances = shortestPath(n,m, edges);
        System.out.println("Shortest distances from source node 0:");
        for (int i = 0; i < n; i++) {
            System.out.println("Distance to node " + i + ": " + distances[i]);
        }
    }
 }

/**
 * 	There are n cities. Some of them are connected, while some are not. 
 	If city a is connected directly with city b, and city b is connected directly with city c,
 	then city a is connected indirectly with city c.
	
	A province is a group of directly or indirectly connected cities and no other cities outside of the group.
	
	You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, 
	and isConnected[i][j] = 0 otherwise.
	
	Return the total number of provinces.
	
	Example 1:
	Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
	Output: 2

	Example 2:
	Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
	Output: 3
 */
package com.dsa.graphs;

/**
 * @author KowlutlaSwamy
 *
 */
public class G7NumberOfProvincesDFS {

    /**
     * Calculates the number of connected components (provinces) in an undirected graph represented by an adjacency matrix.
     *
     * Time complexity: O(V + E), where V is the number of vertices and E is the number of edges.
     * Space complexity: O(V), due to the visited array used for exploration.
     *
     * @param isConnected Adjacency matrix representation of the graph, where isConnected[i][j] is 1 if there's a connection between city i and city j, and 0 otherwise.
     * @return The number of connected components (provinces) in the graph.
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length; // Number of cities (vertices)
        boolean[] visited = new boolean[n]; // Array to track visited cities
        int components = 0; // Initialize province count

        // Iterate through all cities (starting from unvisited ones)
        for (int cityNo = 0; cityNo < n; cityNo++) {
            if (!visited[cityNo]) {
                // Perform DFS exploration from the current unvisited city
                dfs(isConnected, visited, cityNo);
                components++; // Increment province count for a new connected component
            }
        }

        return components;
    }

    // Recursive helper function for DFS exploration
    private void dfs(int[][] edges, boolean[] visited, int city) {
        visited[city] = true; // Mark the current city as visited

        // Explore all unvisited connected cities
        for (int nextCity = 0; nextCity < edges[city].length; nextCity++) {
            if (city != nextCity && edges[city][nextCity] == 1 && !visited[nextCity]) {
                dfs(edges, visited, nextCity); // Recursively explore connected cities
            }
        }
    }

    // Main method to test the code with an example
    public static void main(String[] args) {
        // Example adjacency matrix representing a simple graph
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        G7NumberOfProvincesDFS provinces = new G7NumberOfProvincesDFS();
        int provinceCount = provinces.findCircleNum(isConnected);

        System.out.println("Number of provinces: " + provinceCount); // Output: 2
    }
}


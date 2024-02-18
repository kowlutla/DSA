/**
  	You are given ‘n’ cities, some of which are connected by bidirectional roads. 
  	You are also given an ‘n x n’ matrix i.e. ‘roads’, where if city ‘i’ and ‘j’ 
 	are connected by a road then ‘roads[i][j]'= 1, otherwise ‘roads[i][j]' = 0.
	
	A province is a group of cities that are either directly or indirectly connected 
	to each other through roads.
	
	The goal is to count and return the total number of such provinces in the 
	given matrix.
	
	Example:
	n = 4, roads = [ [1, 1, 1, 0],
	                 [1, 1, 1, 0],
	                 [1, 1, 1, 0],
	                 [0, 0, 0, 1] ]
	
	So, there are ‘2’ provinces.
	Note:
	1. A city is connected to itself. So, for every city ‘i’, ‘roads[i][i] = 1’.
	Detailed explanation ( Input/output format, Notes, Images )
	Sample input 1:
	3
	1 0 0 
	0 1 0 
	0 0 1 
	Sample output 1:
	3
	
	Sample input 2:
	4
	1 1 0 0 
	1 1 0 0 
	0 0 1 1 
	0 0 1 1 
	Sample output 2:
	2
 */
package com.dsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KowlutlaSwamy
 *
 */
public class G4NumberOfProvincesCitiesBFS {

    /**
     * Calculates the number of connected components (provinces) in a graph representing cities and roads.
     *
     * Time complexity: O(V + E), where V is the number of cities and E is the number of roads.
     * Space complexity: O(V), due to the visited array and queue used for exploration.
     *
     * @param roads Adjacency matrix representation of the graph, where roads[i][j] is 1 if there's a road between city i and city j, and 0 otherwise.
     * @param n Number of cities in the graph.
     * @return The number of connected components (provinces) in the graph.
     */
    public static int findNumOfProvinces(int[][] roads, int n) {
        // Queue for Breadth-First Search (BFS) exploration
        Queue<Integer> q = new LinkedList<>();

        // Array to track visited cities
        boolean[] visitedCities = new boolean[n];

        // Initialize province count
        int provinces = 0;

        // Iterate through all cities (starting from unvisited ones)
        for (int cityNo = 0; cityNo < n; cityNo++) {
            if (!visitedCities[cityNo]) {
                // Mark current city as visited and increment province count
                visitedCities[cityNo] = true;
                provinces++;
                q.add(cityNo);

                // Perform BFS to explore connected cities
                while (!q.isEmpty()) {
                    int currentCity = q.poll();

                    // Check all cities connected to the current one
                    for (int nextCity = 0; nextCity < n; nextCity++) {
                        if (roads[currentCity][nextCity] == 1 && !visitedCities[nextCity]) {
                            // If a road exists to an unvisited city, mark it visited and add to queue
                            visitedCities[nextCity] = true;
                            q.add(nextCity);
                        }
                    }
                }
            }
        }

        return provinces;
    }

    // Main method to test the code with an example
    public static void main(String[] args) {
        // Example adjacency matrix representing a simple graph
        int[][] roads = {
                {1, 1, 1, 0}, 
                {1, 1, 1, 0}, 
                {1, 1, 1, 0}, 
                {0, 0, 0, 1}};

        int n = 4; // Number of cities

        int provinceCount = findNumOfProvinces(roads, n);

        System.out.println("Number of provinces: " + provinceCount); // Output: 2
    }
}

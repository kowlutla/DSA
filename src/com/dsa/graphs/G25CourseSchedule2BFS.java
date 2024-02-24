/**
 * 	There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
 	You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you 
 	must take course bi first if you want to take course ai.
	
	For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
	Return the ordering of courses you should take to finish all courses. If there are many valid answers, 
	return any of them. If it is impossible to finish all courses, return an empty array.
	
	Example 1:
	Input: numCourses = 2, prerequisites = [[1,0]]
	Output: [0,1]
	Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. 
	So the correct course order is [0,1].

	Example 2:
	Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
	Output: [0,2,1,3]
	Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. 
	Both courses 1 and 2 should be taken after you finished course 0.
	So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

	Example 3:
	Input: numCourses = 1, prerequisites = []
	Output: [0]
 */
package com.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KowlutlaSwamy
 *
 */
public class G25CourseSchedule2BFS {

    /**
     * Time Complexity: O(V + E)
     * Space Complexity: O(V)
     *
     * Finds a topological ordering of courses using Breadth-First Search (BFS) if possible,
     * indicating the order in which courses can be taken without violating prerequisites.
     *
     * @param numCourses: Total number of courses.
     * @param prerequisites: Array of prerequisite pairs, where [a, b] indicates that course b is a prerequisite for course a.
     * @return An array representing the topological ordering of courses, or an empty array if no order exists due to cycles.
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Create an adjacency list to represent the course dependencies.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            adj.get(prereq[1]).add(prereq[0]); // Add edges from prerequisites to courses
        }

        // Create an array to store the in-degree (incoming dependencies) of each course.
        int[] inDegree = new int[numCourses];
        for (int node = 0; node < numCourses; node++) {
            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]++;
            }
        }

        // Create a queue to perform BFS.
        Queue<Integer> q = new LinkedList<>();

        // Enqueue courses with no prerequisites (in-degree 0).
        for (int node = 0; node < numCourses; node++) {
            if (inDegree[node] == 0) {
                q.add(node);
            }
        }

        // Count the number of courses processed and create an array to store the topological order.
        int count = 0;
        int[] topo = new int[numCourses];

        // Perform BFS traversal.
        while (!q.isEmpty()) {
            int currentCourse = q.poll();
            topo[count++] = currentCourse; // Add current course to the topological order.

            // Decrement in-degree of dependent courses.
            for (int neighbor : adj.get(currentCourse)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor); // Enqueue courses with no remaining dependencies.
                }
            }
        }

        // If all courses cannot be processed due to a cycle, return an empty array.
        if (count < numCourses) {
            return new int[]{};
        }

        return topo; // Return the topological order of courses.
    }

    // **Main method (for demonstration purposes)**
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        G25CourseSchedule2BFS obj = new G25CourseSchedule2BFS();
        int[] order = obj.findOrder(numCourses, prerequisites);

        if (order.length > 0) {
            System.out.println("Topological order: ");
            for (int course : order) {
                System.out.print(course + " ");
            }
        } else {
            System.out.println("No valid topological order exists due to cycles.");
        }
    }
}

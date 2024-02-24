/**
 * 	There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
	
	For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
	Return true if you can finish all courses. Otherwise, return false.
	
	 
	
	Example 1:
	
	Input: numCourses = 2, prerequisites = [[1,0]]
	Output: true
	Explanation: There are a total of 2 courses to take. 
	To take course 1 you should have finished course 0. So it is possible.
	Example 2:
	
	Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
	Output: false
	Explanation: There are a total of 2 courses to take. 
	To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
	 
 */
package com.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KowlutlaSwamy
 *
 */
public class G24CourseSchedule1BFS {

    /**
     * Time Complexity: O(V + E)
     * Space Complexity: O(V)
     *
     * Determines if it's possible to finish all courses given their prerequisites using Breadth-First Search (BFS).
     *
     * @param numCourses: Total number of courses.
     * @param prerequisites: Array of prerequisite pairs, where [a, b] indicates that course b is a prerequisite for course a.
     * @return true if all courses can be finished, false if there's a cycle in the prerequisites.
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

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

        // Count the number of courses that can be completed.
        int count = 0;

        // Perform BFS traversal.
        while (!q.isEmpty()) {
            int currentCourse = q.poll();
            count++;

            // Decrement in-degree of dependent courses.
            for (int neighbor : adj.get(currentCourse)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor); // Enqueue courses with no remaining dependencies.
                }
            }
        }

        // If all courses have been processed, there's no cycle and all courses can be finished.
        return count == numCourses;
    }

    // **Main method (for demonstration purposes)**
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        G24CourseSchedule1BFS obj = new G24CourseSchedule1BFS();
        if (obj.canFinish(numCourses, prerequisites)) {
            System.out.println("All courses can be finished.");
        } else {
            System.out.println("Courses cannot be finished due to a cycle.");
        }
    }
}

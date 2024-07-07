/**
 * 	In operating systems that use paging for memory management, page replacement algorithm is needed to decide which page needs to be replaced when the new page comes in. Whenever a new page is referred and is not present in memory, the page fault occurs and Operating System replaces one of the existing pages with a newly needed page.
	Given a sequence of pages in an array pages[] of length N and memory capacity C, find the number of page faults using Least Recently Used (LRU) Algorithm. 
	
	Note:- Before solving this example revising the OS LRU cache mechanism is recommended.
	
	Example 1:
	Input: N = 9, C = 4
	pages = {5, 0, 1, 3, 2, 4, 1, 0, 5}
	Output: 8
	Explaination: memory allocated with 4 pages 5, 0, 1, 
	3: page fault = 4
	page number 2 is required, replaces LRU 5: 
	page fault = 4+1 = 5
	page number 4 is required, replaces LRU 0: 
	page fault = 5 + 1 = 6
	page number 1 is required which is already present: 
	page fault = 6 + 0 = 6
	page number 0 is required which replaces LRU 3: 
	page fault = 6 + 1 = 7
	page number 5 is required which replaces LRU 2: 
	page fault = 7 + 1  = 8.
 */
package com.dsa.greedy;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author KowlutlaSwamy
 *
 */
public class GD14PageFaultsInLRU {

    /**
     * Calculates the number of page faults using the Least Recently Used (LRU) algorithm.
     *
     * Time Complexity: O(N * C), where N is the number of pages and C is the capacity of the cache.
     * Space Complexity: O(C), because we use a LinkedList and a HashSet to store the pages in the cache.
     *
     * @param N number of pages
     * @param C capacity of the cache
     * @param pages array of page requests
     * @return the number of page faults
     */
    public static int pageFaults(int N, int C, int pages[]) {

        LinkedList<Integer> list = new LinkedList<>(); // To maintain the order of pages for LRU
        HashSet<Integer> hash = new HashSet<>(); // To quickly check if a page is in the cache

        int pageFaults = 0; // Count of page faults
        for (int i = 0; i < N; i++) {
            // If the page is already in the cache
            if (hash.contains(pages[i])) {
                // Remove and re-add the page to update its position to the most recently used
                list.remove((Integer) pages[i]);
                list.add(pages[i]);
            } else {
                // Page fault occurs
                pageFaults++;
                // If the cache is full, remove the least recently used page
                if (list.size() == C) {
                    int item = list.removeFirst(); // Remove the oldest page
                    hash.remove(item); // Remove it from the hash set
                }
                // Add the new page to the cache
                list.add(pages[i]);
                hash.add(pages[i]);
            }
        }
        return pageFaults; // Return the total number of page faults
    }
}
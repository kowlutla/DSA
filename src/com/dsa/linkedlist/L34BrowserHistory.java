/**
 * 	You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history number of steps or move forward in the history number of steps.
	
	Implement the BrowserHistory class:
	BrowserHistory (string homepage) Initializes the object with the homepage of the browser.
	void visit (string url) Visits url from the current page. It clears up all the forward history.
	string back (int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
	string forward (int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.
	Example 1:
	
	Input:
	homepage = "gfg.org"
	visit("google.com");
	visit("facebook.com");
	visit("youtube.com");
	back(1);
	back(1);
	forward(1);
	visit("linkedin.com");
	forward(2);
	back(2);
	back(7);
	
	Output:
	facebook.com
	google.com
	facebook.com
	linkedin.com
	google.com
	gfg.org
	
	Explanation: 
	query1: you are now at "google.com"
	query2: you are now at "facebook.com"
	query3: you are now at "youtube.com"
	query4: move one step back, you will be at
	        "facebook.com" again.
	query5: move one more step back, you will be
	        at "google.com"
	query6: move one step forward, you will be 
	        at "facebook.com"
	query7: jump to "linkedin.com"
	query8: No forward steps available, be at 
	        "linkedin.com"
	query9: move two steps back, you will go to 
	        "facebook.com" and then "google.com"
	query10: required 7 steps backward but only 
	         1 step available, so move 1 step  
	         back, you will be at "gfg.org"
	Example 2:
	
	Input:
	homepage = "google.com"
	visit("youtube.com");
	back(2);
	
	Output:
	google.com
	
	Explanation:
	Required 2 steps backward, but only 1 step
	available. So move 1 step back and you will
	be at "google.com"
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L34BrowserHistory {

    // Node class representing each page in the browser history
    private class Node {
        String url; // URL of the page
        Node next; // Pointer to the next page in the history
        Node prev; // Pointer to the previous page in the history

        // Constructor to initialize the node with a URL
        public Node(String url) {
            this.url = url;
        }
    }

    // Pointer to the current page in the history
    Node currentPage;

    /**
     * Constructor to initialize the BrowserHistory object with the homepage.
     *
     * @param homepage the initial homepage URL
     */
    public L34BrowserHistory(String homepage) {
        currentPage = new Node(homepage); // Initialize the current page as the homepage
    }

    /**
     * Visit a new URL. This clears forward history.
     *
     * @param url the URL of the page to visit
     */
    public void visit(String url) {
        Node newPage = new Node(url); // Create a new node for the new page
        currentPage.next = newPage; // Link the new page as the next page of the current page
        newPage.prev = currentPage; // Link the current page as the previous page of the new page
        currentPage = newPage; // Move the current page pointer to the new page
    }

    /**
     * Move 'steps' backward in the history and return the current page URL.
     *
     * @param steps the number of steps to move backward
     * @return the URL of the current page after moving backward
     */
    public String back(int steps) {
        // Move backward until either steps run out or there are no more previous pages
        while (steps-- > 0 && currentPage.prev != null) {
            currentPage = currentPage.prev;
        }
        return currentPage.url; // Return the URL of the current page
    }

    /**
     * Move 'steps' forward in the history and return the current page URL.
     *
     * @param steps the number of steps to move forward
     * @return the URL of the current page after moving forward
     */
    public String forward(int steps) {
        // Move forward until either steps run out or there are no more next pages
        while (steps-- > 0 && currentPage.next != null) {
            currentPage = currentPage.next;
        }
        return currentPage.url; // Return the URL of the current page
    }
}

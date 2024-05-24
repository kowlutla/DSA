/**
 * 	Given a link list of size N, modify the list such that all the even numbers appear before all the odd numbers in the modified list. The order of appearance of numbers within each segregation should be same as that in the original list.

	Example 1:
	Input: 
	N = 7
	Link List:
	17 -> 15 -> 8 -> 9 -> 2 -> 4 -> 6 -> NULL
	Output: 8 2 4 6 17 15 9
	
	Explaination: 8,2,4,6 are the even numbers 
	so they appear first and 17,15,9 are odd 
	numbers that appear later.
	
	Example 2:
	Input:
	N = 4
	Link List:
	1 -> 3 -> 5 -> 7
	Output: 1 3 5 7
	Explaination: There is no even number. 
	So no need for modification.
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L17SegregateEvenOddNodes {

	public static Node divide(int N, Node head) {
		Node even = new Node(0);
		Node odd = new Node(0);

		Node current1 = even;
		Node current2 = odd;
		Node current = head;
		while (current != null) {
			if (current.data % 2 == 0) {
				Node newNode = new Node(current.data);
				current1.next = newNode;
				current1 = current1.next;
			} else {
				Node newNode = new Node(current.data);
				current2.next = newNode;
				current2 = current2.next;
			}
			current = current.next;
		}

		current1.next = odd.next;
		return even.next;
	}
}

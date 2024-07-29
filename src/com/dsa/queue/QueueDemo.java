/**
 * 
 */
package com.dsa.queue;

/**
 * @author KowlutlaSwamy
 *
 */
public class QueueDemo {
	
	public static void main(String[] args) {
		
		Queue<Integer> q = new Q1ArrayQueue<Integer>();
		q.add(10);
		System.out.println(q);
		q.add(11);
		q.add(12);
//	q.add(13);
		q.add(14);
//		System.out.println(q.peek());
//		System.out.println("Removed: "+q.remove());
//		System.out.println(q.peek());
//		q.add(12);
//		q.add(13);
//		q.add(14);
//		System.out.println(q);
//		q.remove();
//		q.remove();
//		q.remove();
//		q.remove();
//		System.out.println(q.size());
//		q.remove();
//		System.out.println(q);
//		System.out.println(q.peek());
		
		System.out.println("Size Of Queue: " + q.size());
		System.out.println("Queue Elements: ");
		
		while (!q.isEmpty()) {
			System.out.println(q.remove());
		}
		
	}
}

//[null, null, null, null, null] capacity = 5;
//add(10) => [10, null, null, null, null] front = 0, rear = 0, size = 1;
//add(11) => [10, 11, null, null, null] front = 0, rear = 1, size = 2;
//add(12) => [10, 11, 12, null, null] front = 0, rear = 2, size = 3;
//add(13) => [10, 11, 12, 13, null] front = 0, rear = 3, size = 4;
//add(14) => [10, 11, 12, 13, 14] front = 0, rear = 4, size = 5; => rear = 5
//remove() => 
//add(15) => [15, 11, 12, 13, 14] front = 1, rear = 5, size = 5;
//remove() = > [15, null, 12, 13, 14] front = 2, rear = 6, size = 4
//remove() => [15, null, null, 13, 14] front = 3, rear = 6, size = 3
//remove() =>  [15, null, null, null, 14] front = 4, rear = 6, size = 2
//remove() =>  [15, null, null, null, null] front = 5, rear = 6, size = 1
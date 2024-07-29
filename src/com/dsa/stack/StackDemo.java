/**
 * 
 */
package com.dsa.stack;

/**
 * @author KowlutlaSwamy
 *
 */
public class StackDemo {
	
	public static void main(String[] args) {
		
		Stack<Integer> stack = new ST2LinkedStack<Integer>();
		stack.push(10);
		System.out.println(stack);
		stack.push(11);
		System.out.println(stack);
		stack.push(12);
		System.out.println(stack);
		stack.push(13);
		System.out.println(stack);
		stack.push(14);
		System.out.println(stack);
		
		System.out.println("Stack Elements: ");
		
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		System.out.println(stack.isEmpty());
		System.out.println(stack);
		
	}
}

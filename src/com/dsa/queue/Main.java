/**
 * 
 */
package com.dsa.queue;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author KowlutlaSwamy
 *
 */
public class Main {
	
	static class MyThread implements Callable<String> {
		
		@Override
		public String call() throws Exception {
			
			return Stream.iterate(1, i -> i <= 20, i -> i + 2).map(i -> "" + i).collect(Collectors.joining(" "));
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Integer integer = map.put(10, 1);
		System.out.println(integer);
		System.out.println(map);
		Integer integer1 = map.put(10, 2);
		System.out.println(integer1);
		System.out.println(map);
		Integer integer2 = map.put(10, 3);
		System.out.println(integer2);
		System.out.println(map);
		
		MyThread t = new MyThread();
		String call = t.call();
		// Declare String without using new operator
		String name = "GeeksforGeeks";
		
		// Prints the String.
		System.out.println("String name = " + name);
		
		// Declare String using new operator
		String newString = new String("GeeksforGeeks");
		
		// Prints the String.
		System.out.println("String newString = " + newString);
		newString = newString.intern();
		System.out.println(name == newString);
		
	}
}

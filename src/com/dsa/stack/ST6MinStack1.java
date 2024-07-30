/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
  
  Implement the MinStack class:
  
  MinStack() initializes the stack object.
  void push(int val) pushes the element val onto the stack.
  void pop() removes the element on the top of the stack.
  int top() gets the top element of the stack.
  int getMin() retrieves the minimum element in the stack.
  You must implement a solution with O(1) time complexity for each function.
  
   
  
  Example 1:
  
  Input
  ["MinStack","push","push","push","getMin","pop","top","getMin"]
  [[],[-2],[0],[-3],[],[],[],[]]
  
  Output
  [null,null,null,null,-3,null,0,-2]
  
  Explanation
  MinStack minStack = new MinStack();
  minStack.push(-2);
  minStack.push(0);
  minStack.push(-3);
  minStack.getMin(); // return -3
  minStack.pop();
  minStack.top();    // return 0
  minStack.getMin(); // return -2
 */
package com.dsa.stack;

import java.util.Stack;

/**
 * @author KowlutlaSwamy
 *
 */
public class ST6MinStack1 {

  // Inner class to store a value and the minimum value at the time of this value being added
  private class Pair {
      private int value;
      private int min;

      // Constructor to initialize the value and the min value
      public Pair(int value, int min) {
          this.value = value;
          this.min = min;
      }
  }

  // Stack to store pairs of (value, min)
  Stack<Pair> stack;

  // Constructor to initialize the stack
  public ST6MinStack1() {
      stack = new Stack<>();
  }

  // Method to push a new value onto the stack
  public void push(int val) {
      // If the stack is empty, the new value is also the min value
      if (stack.isEmpty()) {
          stack.push(new Pair(val, val));
      } else {
          // Otherwise, push the new value and the min of the new value and the current min
          stack.push(new Pair(val, Math.min(val, stack.peek().min)));
      }
  }

  // Method to remove the top value from the stack
  public void pop() {
      stack.pop();
  }

  // Method to get the top value from the stack without removing it
  public int top() {
      return stack.peek().value;
  }

  // Method to get the current minimum value in the stack
  public int getMin() {
      return stack.peek().min;
  }
}

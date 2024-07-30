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
public class ST7MinStack2 {

  // Stack to store the elements
  private Stack<Integer> stack;
  // Variable to keep track of the current minimum
  private int minimum;

  // Constructor to initialize the stack and set minimum to the maximum integer value
  public ST7MinStack2() {
      stack = new Stack<>();
      minimum = Integer.MAX_VALUE;
  }

  // Method to push a new value onto the stack
  public void push(int val) {
      // If the stack is empty, push the value and set it as the minimum
      if (stack.isEmpty()) {
          stack.push(val);
          minimum = val;
      } else {
          // If the new value is greater than or equal to the current minimum, push it directly
          if (val >= minimum) {
              stack.push(val);
          } else {
              // If the new value is less than the current minimum, push a calculated value and update the minimum
              stack.push(2 * val - minimum);
              minimum = val;
          }
      }
  }

  // Method to remove the top value from the stack
  public void pop() {
      int top = stack.pop();
      // If the popped value is less than the current minimum, update the minimum using the formula
      if (top < minimum) {
          minimum = 2 * minimum - top;
      }
  }

  // Method to get the top value from the stack without removing it
  public int top() {
      // If the top value is less than the current minimum, return the previous minimum value
      if (stack.peek() < minimum) {
          return 2 * minimum - stack.peek();
      }
      return stack.peek();
  }

  // Method to get the current minimum value in the stack
  public int getMin() {
      return minimum;
  }
}

/**
 * Given an array arr[ ] of n elements, the task is to find the next greater element for each element of the array in order of their appearance in the array. Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
  If there does not exist next greater of current element, then next greater element for current element is -1. For example, next greater of the last element is always -1.
  
  Examples
  
  Input: arr[] = [1 3 2 4], n = 4
  Output: 3 4 4 -1
  Explanation: The next larger element to 1 is 3, 3 is 4, 2 is 4 and for 4, since it doesn't exist, it is -1.
  Input: arr[] [6 8 0 1 3], n = 5
  Output: 8 -1 1 3 -1
  Explanation: The next larger element to 6 is 8, for 8 there is no larger elements hence it is -1, for 0 it is 1 , for 1 it is 3 and then for 3 there is no larger element on right and hence -1.
  Input: arr[] [10, 20, 30, 50], n = 4
  Output: 20 30 50 -1
  Explanation: For a sorted array, the next element is next greater element also exxept for the last element.
  Input: arr[] [50, 40, 30, 10], n = 4
  Output: -1 -1 -1 -1
  Explanation: For a reverse sorted array, the next greater element is always 1.
 */
package com.dsa.stack;

import java.util.Stack;

/**
 * @author KowlutlaSwamy
 *
 */
public class ST8NextGreaterElement {

  // Brute-force method to find the next larger element for each element in the array
  public static long[] nextLargerElement1(long[] arr, int n) {
      long result[] = new long[n];  // Array to store the results

      // Iterate through each element in the array
      for (int i = 0; i < n; i++) {
          long max = -1;  // Initialize max to -1 (default if no greater element is found)

          // Check elements to the right of the current element
          for (int j = i + 1; j < n; j++) {
              if (arr[j] > arr[i]) {
                  max = arr[j];  // Update max if a greater element is found
                  break;  // Break the inner loop once the next greater element is found
              }
          }
          result[i] = max;  // Store the result for the current element
      }
      return result;
  }

  // Efficient method to find the next larger element for each element in the array using a stack
  public static long[] nextLargerElement2(long[] arr, int n) {
      long[] result = new long[n];  // Array to store the results
      Stack<Long> stack = new Stack<>();  // Stack to keep track of next greater elements

      // Iterate through the array from right to left
      for (int i = n - 1; i >= 0; i--) {
          // Pop elements from the stack until we find a greater element or the stack becomes empty
          while (!stack.isEmpty() && stack.peek() <= arr[i]) {
              stack.pop();
          }

          // If the stack is empty, it means there is no greater element to the right
          if (stack.isEmpty()) {
              result[i] = -1;
          } else {
              result[i] = stack.peek();  // The top of the stack is the next greater element
          }

          // Push the current element onto the stack
          stack.push(arr[i]);
      }
      return result;
  }
}

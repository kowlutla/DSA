package com.dsa.stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

  An input string is valid if:
  
  Open brackets must be closed by the same type of brackets.
  Open brackets must be closed in the correct order.
  Every close bracket has a corresponding open bracket of the same type.
   
  
  Example 1:
  
  Input: s = "()"
  Output: true
  Example 2:
  
  Input: s = "()[]{}"
  Output: true
  Example 3:
  
  Input: s = "(]"
  Output: false
 */

import java.util.Stack;

/**
 * @author KowlutlaSwamy
 *
 */
public class ST5ValidParentheses {
	
	public boolean isValid(String s) {
		
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				
				if (stack.isEmpty()) {
					return false;
				}
				char top = stack.pop();
				
				if (c == ')' && top != '(') {
					return false;
				}
				
				if (c == '}' && top != '{') {
					return false;
				}
				
				if (c == ']' && top != '[') {
					return false;
				}
			}
		}
		return stack.isEmpty();
		
	}
}

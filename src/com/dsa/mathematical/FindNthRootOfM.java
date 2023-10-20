package com.dsa.mathematical;

/**
 * You are given 2 numbers (n , m); the task is to find n√m (nth root of m).
 */
public class FindNthRootOfM {
	
    /**
     * Method to find the nth root of m.
     * 
     * @param n the power value
     * @param m the number
     * @return the nth root of m
     */
	public int NthRoot(int n, int m)
    {
        // Implementing binary search for finding the nth root of m
        int left = 1;
        int right = m;
        while(left<=right){
            int mid = (left+right)/2;
            
            if(Math.pow(mid,n)==m){ // If mid to the power n is equal to m, return mid
                return mid;
            }
            
            if(Math.pow(mid,n)<m){ // If mid to the power n is less than m, adjust the left
                left = mid+1;
            }else{ // If mid to the power n is greater than m, adjust the right
                right = mid-1;
            }
        }
        
        return -1; // Return -1 if no nth root is found
    }

    // Main method with test cases
    public static void main(String[] args) {
        FindNthRootOfM obj = new FindNthRootOfM();
        
        // Test cases
        int n1 = 3, m1 = 27; // Expected output: 3
        int n2 = 4, m2 = 81; // Expected output: 3

        // Testing NthRoot method
        System.out.println("The " + n1 + "th root of " + m1 + " is: " + obj.NthRoot(n1, m1)); // Expected output: 3
        System.out.println("The " + n2 + "th root of " + m2 + " is: " + obj.NthRoot(n2, m2)); // Expected output: 3
    }
}

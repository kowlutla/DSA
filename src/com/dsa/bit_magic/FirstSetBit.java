package com.dsa.bit_magic;
public class FirstSetBit {

    // Function to find the position of the first set bit in a number
    public static int getFirstSetBit1(int n) {
        // Initialize a variable to keep track of the position of the first set bit
        int count = 0;

        // Loop until the number is greater than 0
        while (n > 0) {
            // Increment the count to keep track of the current position
            count++;

            // Check if the remainder when n is divided by 2 is 1 (i.e., if the last bit is set)
            if (n % 2 == 1) {
                // Break the loop if the last bit is set
                break;
            }

            // Divide the number by 2 for the next iteration
            n = n / 2;
        }

        // Return the position of the first set bit
        return count;
    }
    

    // Function to find the position of the first set bit in a number
    public static int getFirstSetBit2(int n) {
        // Initialize a variable to keep track of the position of the first set bit
        int count = 0;

        // Loop until the number is greater than 0
        while (n > 0) {
            // Increment the count to keep track of the current position
            count++;

            // Check if the bitwise AND of n and 1 is not 0 (i.e., if the last bit is set)
            if ((n & 1) != 0) {
                // Break the loop if the last bit is set
                break;
            }

            // Right shift the number by 1 for the next iteration
            n = n >> 1;
        }

        // Return the position of the first set bit
        return count;
    }
    
    static int INT_SIZE = 32;
    
    static int getFirstSetBit3(int num)
    {
        int pos = 1;
        // counting the position of first set bit
        for (int i = 0; i < INT_SIZE; i++) {
            if ((num & (1 << i)) == 0)
                pos++;
 
            else
                break;
        }
        return pos;
    }

    // Main method to test the getFirstSetBit functionality
    public static void main(String[] args) {
        // Example usage
        int n = 18;
        System.out.println("Position of the first set bit in " + n + " is: " + getFirstSetBit2(n));
    }
}

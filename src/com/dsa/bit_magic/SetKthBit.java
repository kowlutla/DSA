package com.dsa.bit_magic;

/**
 * Given a number N and a value K. From the right, set the Kth bit in the binary
 * representation of N. The position of the Least Significant Bit (or last bit) is 0,
 * the second last bit is 1, and so on.
 */
public class SetKthBit {

    // Function to set the Kth bit in the binary representation of N
    static int setKthBit(int N, int K) {
        N = N | (1 << (K)); // Setting the Kth bit of N
        return N; // Return the modified N
    }

    // Main method to test the setKthBit function
    public static void main(String[] args) {
        int N = 10; // Sample number
        int K = 2; // Sample value of K
        System.out.println("Original Number: " + N);
        N = setKthBit(N, K);
        System.out.println("Number after setting the " + K + "th bit: " + N);
    }
}

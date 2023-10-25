package com.dsa.bit_magic;

import java.util.ArrayList;

/**
 * Given an integer N and an integer D, rotate the binary representation of the
 * integer N by D digits to the left as well as right and return the results in
 * their decimal representation after each of the rotation. Note: Integer N is
 * stored using 16 bits. i.e. 12 will be stored as 0000000000001100.
 */
public class RotateBits {

    // Function to rotate the binary representation of N by D bits to the left and right
    ArrayList<Integer> rotate(int N, int D) {
        // Number of bits used to store N
        int BITS = 16;
        // Compute the effective rotation considering the bits used for N
        D = D % BITS;
        // Create an ArrayList to store the results of rotation
        ArrayList<Integer> result = new ArrayList<>();
        // Compute the left rotation and store the result
        int A = (N << D | N >> (BITS - D)) & 0xFFFF;
        // Compute the right rotation and store the result
        int B = (N >> D | N << (BITS - D)) & 0xFFFF;
        result.add(A);
        result.add(B);
        // Return the results of left and right rotations
        return result;
    }

    // Main method to test the rotate functionality
    public static void main(String[] args) {
        // Example usage
        RotateBits rotateBits = new RotateBits();
        int N = 12; // 0000000000001100 in binary
        int D = 2; // Number of bits to rotate
        ArrayList<Integer> result = rotateBits.rotate(N, D);
        System.out.println("Left rotation result: " + result.get(0));
        System.out.println("Right rotation result: " + result.get(1));
    }
}

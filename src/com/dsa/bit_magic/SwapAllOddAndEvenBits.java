package com.dsa.bit_magic;

/**
 * Given an unsigned integer N. The task is to swap all odd bits with even bits.
 * For example, if the given number is 23 (00010111), it should be converted to
 * 43(00101011). Here, every even position bit is swapped with an adjacent bit
 * on the right side(even position bits are highlighted in the binary
 * representation of 23), and every odd position bit is swapped with an adjacent
 * on the left side.
 */
public class SwapAllOddAndEvenBits {
    // Function to swap odd and even bits.
    public static int swapBits(int n) {
        // 0xAAAAAAAA means 10101010101010101010101010101010 in binary
        // we get all even bits of n.
        int ev = n & 0xAAAAAAAA;
        // 0x55555555 means 01010101010101010101010101010101 in binary.
        // we get all odd bits of n.
        int od = n & 0x55555555;

        // Right shifting the even bits obtained previously.
        ev >>= 1;
        // Left shifting the even bits obtained previously.
        od <<= 1;

        // Performing bitwise OR of even and odd bits obtained and
        // returning the final result.
        return (ev | od);
    }

    // Main method to test the swapBits functionality
    public static void main(String[] args) {
        // Example usage
        int n = 23;
        System.out.println("Result after swapping odd and even bits: " + swapBits(n));
    }
}

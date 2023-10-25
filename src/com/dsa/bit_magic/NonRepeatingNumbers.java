package com.dsa.bit_magic;

/**
 * Given an array A containing 2*N+2 positive numbers, out of which 2*N numbers
 * exist in pairs whereas the other two numbers occur exactly once and are
 * distinct. Find the other two numbers. Return in increasing order.
 */
public class NonRepeatingNumbers {

    // Function to find the two non-repeating numbers
    public int[] singleNumber(int[] nums) {
        // Initialize xor to 0
        int xor = 0;
        // Perform XOR of all elements in the array
        for (int num : nums) {
            xor ^= num;
        }

        // Extract the rightmost set bit of xor
        xor = (xor & ~(xor - 1));
        
       //construct number with first set bit of xor
        // int pos = 0;
        // while(true){
        //     pos++;
        //     if((xor&1)==1){
        //         break;
        //     }
        //     xor=xor>>1;
        // }
        // xor = 1<<pos-1;
        
        // Initialize first and second numbers to 0
        int first = 0, second = 0;
        // Iterate over the array again to find the non-repeating numbers
        for (int i = 0; i < nums.length; i++) {
            // XOR the numbers based on their set bits in the rightmost set bit of xor
            if ((nums[i] & xor) == 0) {
                first ^= nums[i];
            } else {
                second ^= nums[i];
            }
        }
        // Return the non-repeating numbers in increasing order
        return new int[] { Math.min(first, second), Math.max(first, second) };
    }

    // Main method to test the singleNumber functionality
    public static void main(String[] args) {
        // Example usage
        NonRepeatingNumbers nonRepeatingNumbers = new NonRepeatingNumbers();
        int[] nums = { 1, 2, 3, 2, 1, 4 };
        int[] result = nonRepeatingNumbers.singleNumber(nums);
        System.out.println("Non-repeating numbers in increasing order: " + result[0] + " " + result[1]);
    }
}

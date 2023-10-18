package com.dsa.mathematical;

public class MultiplyTwoStrings {

    /**
     * This method multiplies two input strings as if they are numbers.
     * @param s1 The first string.
     * @param s2 The second string.
     * @return The product of the two input strings as a string.
     */
    public String multiplyStrings(String s1, String s2) {
        // Check if either input string is zero
        if (isZero(s1) || isZero(s2)) {
            return "0";
        }

        // Check for negative sign and remove it temporarily for calculation
        boolean isNeg = false;
        if (s1.charAt(0) == '-') {
            isNeg = !isNeg;
            s1 = s1.substring(1);
        }

        if (s2.charAt(0) == '-') {
            isNeg = !isNeg;
            s2 = s2.substring(1);
        }

        // Initialize an array to store the result of multiplication
        int[] multiples = new int[s1.length() + s2.length()];

        // Perform multiplication digit by digit
        for (int i = s2.length() - 1; i >= 0; i--) { // iterate over each digit of s2
            for (int j = s1.length() - 1; j >= 0; j--) { // iterate over each digit of s1
                // multiply the digits at the current positions
                int mul = (s1.charAt(j) - '0') * (s2.charAt(i) - '0');
                // add the product to the previous products at appropriate positions
                int sum = mul + multiples[i + j + 1];
                // update the result and handle any carry to the previous digit
                multiples[i + j] += sum / 10; // add the carry to the previous digit's result
                multiples[i + j + 1] = sum % 10; // store the remainder as the current digit
            }
        }

        // Construct the result string from the array of multiplication results
        StringBuilder result = new StringBuilder();
        for (int val : multiples) {
            if (result.length() != 0 || val != 0) { // skip leading zeros
                result.append(val);
            }
        }

        // Add back the negative sign if necessary
        if (isNeg) {
            result.insert(0, '-');
        }

        return result.toString();
    }

    // Helper method to check if a string represents zero
    private static boolean isZero(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    /**
     * The main method for testing the multiplyStrings method.
     */
    public static void main(String[] args) {
        MultiplyTwoStrings multiplyTwoStrings = new MultiplyTwoStrings();

        // Test the multiplyStrings method with different inputs
        String s1 = "123";
        String s2 = "456";
        String s3 = "0";
        String s4 = "-123";
        String s5 = "789";

        // Testing multiplyStrings method
        System.out.println("The product of " + s1 + " and " + s2 + " is: " + multiplyTwoStrings.multiplyStrings(s1, s2));
        System.out.println("The product of " + s1 + " and " + s3 + " is: " + multiplyTwoStrings.multiplyStrings(s1, s3));
        System.out.println("The product of " + s4 + " and " + s5 + " is: " + multiplyTwoStrings.multiplyStrings(s4, s5));

        // Expected output for the provided test cases:
        // The product of 123 and 456 is: 56088
        // The product of 123 and 0 is: 0
        // The product of -123 and 789 is: -97047
    }
}

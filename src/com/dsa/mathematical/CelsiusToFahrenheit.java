package com.dsa.mathematical;

/**
 * Given a temperature in celsius C. You need to convert the given temperature
 * to Fahrenheit.
 */
public class CelsiusToFahrenheit {

	/**
	 * This method converts a temperature in Celsius to Fahrenheit.
	 * 
	 * @param C The temperature in Celsius to be converted.
	 * @return The temperature in Fahrenheit.
	 */
	public static double cToF(int C) {
		// Your code here
		return C * (9.0 / 5.0) + 32; // Convert Celsius to Fahrenheit using the formula
	}

	/**
	 * The main method for testing the cToF method.
	 */
	public static void main(String[] args) {
		// Test the cToF method with different inputs
		int temperature1 = 0;
		int temperature2 = 100;
		int temperature3 = -40;

		// Testing cToF method
		System.out.println("Fahrenheit temperature for " + temperature1 + " degree Celsius: " + cToF(temperature1));
		System.out.println("Fahrenheit temperature for " + temperature2 + " degree Celsius: " + cToF(temperature2));
		System.out.println("Fahrenheit temperature for " + temperature3 + " degree Celsius: " + cToF(temperature3));

		// Expected output for the provided test cases:
		// Fahrenheit temperature for 0 degree Celsius: 32.0
		// Fahrenheit temperature for 100 degree Celsius: 212.0
		// Fahrenheit temperature for -40 degree Celsius: -40.0
	}
}

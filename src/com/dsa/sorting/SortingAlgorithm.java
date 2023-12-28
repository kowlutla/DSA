/**
 * 
 */
package com.dsa.sorting;

import java.util.Random;

/**
 * @author KowlutlaSwamy
 *
 */
public interface SortingAlgorithm {

	void sortIncreasingOrder(int[] arr);

	void sortDecresingOrder(int[] arr);
	
	static int[] getIntegerArray() {
        Random random = new Random(); // Creating an instance of Random class
        int size = 20; // Generating a random size of 20
        System.out.println("Size of array is: " + size); // Displaying the size of the array
        int[] arr = new int[size]; // Creating an array with the generated size

        // Filling the array with random integers between 0 and 99
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100); // Assigning a random integer between 0 and 99 to each index
        }
        return arr; // Returning the generated array
    }
}

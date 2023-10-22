package com.dsa.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array A of N elements. Find the majority element in the array. A
 * majority element in an array A of size N is an element that appears strictly
 * more than N/2 times in the array.
 * 
 * 
 * Example 1:
 * 
 * Input: N = 3 A[] = {1,2,3} Output: -1 Explanation: Since, each element in
 * {1,2,3} appears only once so there is no majority element. Example 2:
 * 
 * Input: N = 5 A[] = {3,1,3,3,2} Output: 3 Explanation: Since, 3 is present
 * more than N/2 times, so it is the majority element.
 * 
 */
public class MajorityElement {

    // O(n) time and O(n) space
    static int majorityElement1(int a[], int size) {
        // Creating a HashMap to store the counts of each element
        HashMap<Integer, Integer> countMap = new HashMap<>();
        // Iterating through the array and updating the counts in countMap
        for (int num : a) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        // Checking for the element that appears more than size / 2 times
        for (Map.Entry<Integer, Integer> e : countMap.entrySet()) {
            if (e.getValue() > size / 2) {
                return e.getKey();
            }
        }

        // If no majority element is found, return -1
        return -1;
    }
    
    //Efficient O(n) time and O(1) space
    static int majorityElement2(int a[], int size){
        // Initialize the element to the first element of the array
        int element = a[0];
        // Initialize the count of the element to 1
        int count = 1;

        // Traverse the array to find the majority element
        for(int i=1;i<size;i++){
            // Increment the count if the current element is the same as the majority element
            if(a[i]==element){
                count++;
            } else {
                // Decrement the count if the current element is different from the majority element
                count--;
            }

            // If the count becomes 0, update the element to the current element and reset the count to 1
            if(count==0){
                element = a[i];
                count = 1;
            }
        }

        // Reset the count to 0 and count the occurrences of the found potential majority element
        count = 0;
        for(int i=0;i<size;i++){
            if(a[i]==element){
                count++;
            }
        }

        // Check if the count of the potential majority element is greater than size/2
        if(count>size/2){
            return element; // Return the majority element
        }

        return -1; // Return -1 if there is no majority element
    }
    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {3, 1, 3, 3, 2};
        int size1 = arr1.length;
        int result1 = MajorityElement.majorityElement2(arr1, size1);
        System.out.println("Majority element for the array " + Arrays.toString(arr1) + " is: " + result1);
        // Expected output: Majority element for the array [3, 1, 3, 3, 2] is: 3

        // Test case 2
        int[] arr2 = {1, 2, 3};
        int size2 = arr2.length;
        int result2 = MajorityElement.majorityElement2(arr2, size2);
        System.out.println("Majority element for the array " + Arrays.toString(arr2) + " is: " + result2);
        // Expected output: Majority element for the array [1, 2, 3] is: -1
    }

}

package com.dsa.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TopKFrequentElementsInArray {
    // Define a Pair class to store key-value pairs
    static class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Method to find the top K frequent elements in an array
    public static int[] topK(int[] nums, int k) {
        // Create a HashMap to store the frequencies of elements
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Sort the HashMap based on values in descending order and store it in a LinkedHashMap
        LinkedHashMap<Integer, Integer> linkedHashMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        int result[] = new int[k];
        int i = 1;
        // Extract the top K elements from the LinkedHashMap and store them in the result array
        for (Map.Entry<Integer, Integer> e : linkedHashMap.entrySet()) {
            if (i > k) {
                break;
            }
            result[i - 1] = e.getKey();
            i++;
        }

        return result;
    }

    // Another method to find the top K frequent elements in an array using PriorityQueue
    public static int[] topK1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // Calculate the frequencies of elements using a HashMap
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Create a PriorityQueue and define a custom Comparator for sorting elements based on frequency and key in descending order
        PriorityQueue<Pair> p = new PriorityQueue<Pair>(
                Comparator.comparing((Pair pair) -> pair.value).thenComparing((pair) -> pair.key).reversed());

        // Add elements to the PriorityQueue
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            p.add(new Pair(e.getKey(), e.getValue()));
        }

        int result[] = new int[k];
        // Retrieve top K elements from the PriorityQueue and store them in the result array
        for (int i = 0; i < k; i++) {
            result[i] = p.remove().key;
        }
        return result;
    }

    // Main method for demonstration purposes
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println("Using topK method: " + Arrays.toString(topK(nums, k)));
        System.out.println("Using topK1 method: " + Arrays.toString(topK1(nums, k)));
    }
}

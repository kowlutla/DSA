package com.dsa.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given an array a of size N which contains elements from 0 to N-1, you need to
 * find all the elements occurring more than once in the given array. Return the
 * answer in ascending order. If no such element is found, return list
 * containing [-1].
 * 
 * Note: The extra space is only for the array to be returned. Try and perform
 * all operations within the provided array.
 */
public class FindDuplicatesInAnArrayFrom0toN {
	public static ArrayList<Integer> duplicates1(int arr[], int n) {
		// code here
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {

				if (i != j && arr[i] == arr[j]) {
					if (!result.contains(arr[i])) {
						result.add(arr[i]);
					}
					break;
				}
			}
		}

		if (result.size() == 0) {
			result.add(-1);
		}
		return result;
	}

	public static ArrayList<Integer> duplicates2(int arr[], int n) {
		HashSet<Integer> dup = new HashSet<>();
		Set<Integer> result = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (!dup.add(arr[i])) {
				result.add(arr[i]);
			}
		}
		if (result.size() == 0) {
			result.add(-1);
		}
		ArrayList<Integer> re = new ArrayList<>(result);
		Collections.sort(re);
		return re;
	}

	public static ArrayList<Integer> duplicates3(int arr[], int n) {
		int count[] = new int[n];
		for (int i = 0; i < n; i++) {
			count[arr[i]]++;
		}

		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (count[i] > 1) {
				result.add(i);
			}
		}

		if (result.size() == 0) {
			result.add(-1);
		}
		return result;
	}

	// May not work for all cases but we can take this approch
	public static ArrayList<Integer> duplicates4(int arr[], int n) {
		TreeSet<Integer> set = new TreeSet<>();

		int zeros = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				zeros++;
			}
		}

		if (zeros > 1) {
			set.add(0);
		}

		for (int i = 0; i < n; i++) {
			if (arr[Math.abs(arr[i])] < 0) {
				set.add(Math.abs(arr[i]));
			} else {
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			}
		}

		if (set.size() == 0) {
			set.add(-1);
		}

		return new ArrayList<Integer>(set);
	}

	public static ArrayList<Integer> duplicates5(int arr[], int n) {
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int index = arr[i] % n;
			arr[index] += n;
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] / n > 1) {
				result.add(i);
			}
		}

		if (result.size() == 0) {
			result.add(-1);
		}

		return result;
	}

	// Main method to test each method
	public static void main(String[] args) {
		int[] arr1 = { 0, 3, 1, 2 }; //expected: [-1]
		int[] arr2 = { 2, 3, 1, 2, 3 }; // expected: [2, 3]
		int N1 = 4;
		int N2 = 5;
		System.out.println("Using method 5: " + duplicates5(arr1, N1));
		System.out.println("Using method 5: " + duplicates5(arr2, N2));
	}

}

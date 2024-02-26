/**
 * 	Given two distinct words startWord and targetWord, and a list denoting wordList of unique words of equal lengths. 
 	Find all shortest transformation sequence(s) from startWord to targetWord. You can return them in any order possible.
	Keep the following conditions in mind:
	
	A word can only consist of lowercase characters.
	Only one letter can be changed in each transformation.
	Each transformed word must exist in the wordList including the targetWord.
	startWord may or may not be part of the wordList.
	Return an empty list if there is no such transformation sequence.
	The first part of this problem can be found here.
	
	
	Example 1:
	Input:
	startWord = "der", targetWord = "dfs",
	wordList = {"des","der","dfr","dgt","dfs"}
	Output:
	der dfr dfs
	der des dfs
	Explanation:
	The length of the smallest transformation is 3.
	And the following are the only two ways to get
	to targetWord:-
	"der" -> "des" -> "dfs".
	"der" -> "dfr" -> "dfs".

	Example 2:
	Input:
	startWord = "gedk", targetWord = "geek", 
	wordList = {"geek", "gefk"}
	Output:
	"gedk" -> "geek"
 */
package com.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KowlutlaSwamy
 *
 */
public class G30WordLadder2 {

    /**
     * Finds all possible word transformation sequences from a start word to an end word using a dictionary.
     *
     * @param startWord: The starting word.
     * @param targetWord: The target end word.
     * @param wordList: A list of valid words in the dictionary.
     * @return A list of lists, where each inner list represents a valid word transformation sequence.
     *
     * Time Complexity: O(V * E * L), where:
     *   V - Number of words in the dictionary (wordList.length)
     *   E - Average number of words reachable from a single word by changing one character
     *   L - Length of the words
     *
     * Space Complexity: O(V * L), due to the queues, sets, and lists used in the algorithm.
     */
    public static ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        // Convert the word list to a set for efficient membership checks.
        HashSet<String> words = new HashSet<>(Arrays.asList(wordList));

        // Create a queue to store sequences of words encountered during the search.
        Queue<ArrayList<String>> q = new LinkedList<>();

        // Create the initial sequence containing the starting word.
        ArrayList<String> initialSequence = new ArrayList<>();
        initialSequence.add(startWord);

        // Keep track of used words to avoid revisiting them in the same sequence.
        ArrayList<String> usedWords = new ArrayList<>();
        usedWords.add(startWord);

        // Track the current level of exploration in the search tree.
        int level = 0;

        // Enqueue the initial sequence.
        q.add(initialSequence);

        while (!q.isEmpty()) {
            // Dequeue the first sequence from the queue.
            ArrayList<String> currentSequence = q.poll();

            // Check if the current sequence length has increased, indicating a new level in the search tree.
            if (currentSequence.size() > level) {
                level++;

                // Remove used words from the dictionary when moving to a new level to avoid revisiting them
                // in the same sequence within the current level.
                for (String usedWord : usedWords) {
                    words.remove(usedWord);
                }
            }

            // Get the last word from the current sequence.
            String word = currentSequence.get(currentSequence.size() - 1);

            // If the last word is the target word, add the sequence to the results.
            if (word.equals(targetWord)) {
                result.add(new ArrayList<>(currentSequence)); // Create a copy to avoid modification of the original sequence
            }

            // Iterate through all characters in the last word.
            for (int i = 0; i < word.length(); i++) {
                char[] arr = word.toCharArray();

                // Try replacing each character with all possible letters (a-z).
                for (char c = 'a'; c <= 'z'; c++) {
                    arr[i] = c;
                    String newWord = new String(arr);

                    // Check if the new word is in the dictionary and hasn't been used in the current sequence yet.
                    if (words.contains(newWord)) {
                        // Create a copy of the current sequence and add the new word to it.
                        ArrayList<String> nextSequence = new ArrayList<>(currentSequence);
                        nextSequence.add(newWord);

                        // Enqueue the new sequence for further exploration.
                        q.add(nextSequence);

                        // Mark the new word as used in the current sequence.
                        usedWords.add(newWord);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String startWord = "hit";
        String targetWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

        ArrayList<ArrayList<String>> sequences = findSequences(startWord, targetWord, wordList);

        if (sequences.isEmpty()) {
            System.out.println("No word ladder exists between the given words.");
        } else {
            System.out.println("All possible word ladder sequences:");
            for (ArrayList<String> sequence : sequences) {
                System.out.println(sequence); // Print each sequence on a new line
            }
        }
    }
}
/**
 *	A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
	
	Every adjacent pair of words differs by a single letter.
	Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
	sk == endWord
	Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
	
	Example 1:
	Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
	Output: 5
	Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

	Example 2:
	Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
	Output: 0
	Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence. 
 */
package com.dsa.graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author KowlutlaSwamy
 *
 */
public class G29WordLadder1 {

    /**
     * Represents a word and its corresponding sequence number in the transformation sequence.
     */
    private static class Pair {
        String word;
        int sequence;

        public Pair(String word, int sequence) {
            this.word = word;
            this.sequence = sequence;
        }
    }

    /**
     * Finds the length of the shortest word transformation sequence from a start word to an end word using a dictionary.
     *
     * @param beginWord: The starting word.
     * @param endWord: The target end word.
     * @param wordList: A list of valid words in the dictionary.
     * @return The length of the shortest transformation sequence, or 0 if no such sequence exists.
     *
     * Time Complexity: O(V * E * L), where:
     *   V - Number of words in the dictionary (wordList.size())
     *   E - Average number of words reachable from a single word by changing one character
     *   L - Length of the words
     *
     * Space Complexity: O(V), due to the queue and set used in the algorithm.
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Convert the word list to a set for efficient membership checks.
        Set<String> words = new HashSet<>(wordList);

        // Create a queue to store words and their corresponding sequence numbers.
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1)); // Add the starting word with sequence 1

        // Remove the starting word from the dictionary to avoid revisiting it.
        words.remove(beginWord);

        while (!q.isEmpty()) {
            // Dequeue the first element from the queue.
            Pair current = q.poll();
            String currentWord = current.word;
            int currentSequence = current.sequence;

            // If the current word is the target word, return the sequence length.
            if (currentWord.equals(endWord)) {
                return currentSequence;
            }

            // Iterate through each character in the current word.
            for (int i = 0; i < currentWord.length(); i++) {
                // Try replacing each character with all possible letters (a-z).
                for (char j = 'a'; j <= 'z'; j++) {
                    char[] arr = currentWord.toCharArray();
                    arr[i] = j;
                    String newWord = new String(arr);

                    // Check if the new word is in the dictionary and hasn't been visited yet.
                    if (words.contains(newWord)) {
                        // Add the new word to the queue with its sequence incremented by 1.
                        words.remove(newWord);
                        q.add(new Pair(newWord, currentSequence + 1));
                    }
                }
            }
        }

        // If no sequence is found, return 0.
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        int ladderLength = ladderLength(beginWord, endWord, wordList);

        if (ladderLength > 0) {
            System.out.println("The shortest word ladder length is: " + ladderLength);
        } else {
            System.out.println("No word ladder exists between the given words.");
        }
    }
}

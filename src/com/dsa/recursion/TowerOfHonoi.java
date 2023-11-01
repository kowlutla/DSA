package com.dsa.recursion;

/**
 * The tower of Hanoi is a famous puzzle where we have three rods and N disks.
 * The objective of the puzzle is to move the entire stack to another rod. You
 * are given the number of discs N. Initially, these discs are in the rod 1. You
 * need to print all the steps of discs movement so that all the discs reach the
 * 3rd rod. Also, you need to find the total moves. Note: The discs are arranged
 * such that the top disc is numbered 1 and the bottom-most disc is numbered N.
 * Also, all the discs have different sizes and a bigger disc cannot be put on
 * the top of a smaller disc. Refer the provided link to get a better clarity
 * about the puzzle.
 */
public class TowerOfHonoi {

    // Global variable to keep track of the total moves
    long count = 0;

    // Recursive function to solve the Tower of Hanoi puzzle
    public long toh(int N, int from, int to, int aux) {
        // If there is only one disk, move it from 'from' rod to 'to' rod
        if (N == 1) {
            System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
            count++;
            return count;
        }
        // Move N-1 disks from 'from' rod to 'aux' rod using 'to' rod as auxiliary
        toh(N - 1, from, aux, to);
        // Move the remaining one disk from 'from' rod to 'to' rod
        System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
        // Move the N-1 disks from 'aux' rod to 'to' rod using 'from' rod as auxiliary
        toh(N - 1, aux, to, from);
        // Increment the total move count
        ++count;
        return count;
    }
    
    // Main method to test the TowerOfHonoi functionality
    public static void main(String[] args) {
        // Example number of disks
        int N = 3;
        // Create an instance of the TowerOfHonoi class
        TowerOfHonoi tower = new TowerOfHonoi();
        // Call the toh method to solve the Tower of Hanoi problem
        long totalMoves = tower.toh(N, 1, 3, 2);
        // Print the total number of moves required to solve the Tower of Hanoi problem
        System.out.println("Total moves required: " + totalMoves);
    }
}

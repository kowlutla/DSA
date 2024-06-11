/**
 *  Geek wants to know the traversals required to construct a unique binary tree. 
 *  Given a pair of traversals, return true if it is possible to construct a unique binary tree from the given traversals, otherwise return false.
 *
 *  Each traversal is represented with an integer: 
 *  preorder - 1, inorder - 2, postorder - 3.
 *  
 *  Example 1:
 *  Input:
 *  a = 1, b = 2
 *  Output: 1
 *  Explanation: We can construct binary tree using inorder traversal and preorder traversal.
 * 
 *  Example 2:
 *  Input: a = 1, b = 3
 *  Output: 0
 *  Explanation: We cannot construct binary tree using preorder traversal and postorder traversal.
 */
package com.dsa.binary_tree;

public class BT36UniqueBinaryTreeRequirements {

    /**
     * Determines if it is possible to construct a unique binary tree from the given pair of traversals.
     *
     * @param a The first traversal type (1 for preorder, 2 for inorder, 3 for postorder).
     * @param b The second traversal type (1 for preorder, 2 for inorder, 3 for postorder).
     * @return true if it is possible to construct a unique binary tree, false otherwise.
     * 
     * Time Complexity: O(1) - The method performs a constant amount of work.
     * Space Complexity: O(1) - The method uses a constant amount of space.
     */
    public static boolean isPossible(int a, int b) {
        // If both traversals are inorder, it is not possible to construct a unique tree.
        if (a == 2 && b == 2) {
            return false;
        }
        // If at least one traversal is inorder, it is possible to construct a unique tree.
        if (a == 2 || b == 2) {
            return true;
        }
        // For any other pair of traversals, it is not possible to construct a unique tree.
        return false;
    }
}

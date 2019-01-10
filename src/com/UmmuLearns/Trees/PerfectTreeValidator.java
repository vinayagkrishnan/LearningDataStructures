package com.UmmuLearns.Trees;

import com.UmmuLearns.BSTNode;

/**
 * A binary tree is considered to be perfect if
 *      1. All nodes have exactly 2 children except leaf nodes
 *      2. All leaf nodes are at the same depth
 */
public class PerfectTreeValidator {

    private int depthOfTree = -1;
    /**
     * Recursively checks if the tree is perfect.
     * The given tree is perfect if both left and right subtrees are perfect.
     *
     * If the given node is null, the tree is considered perfect
     * If the given node is a leaf, function validates whether it is at the same depthOfTree as the other leaf nodes
     * If given node is an internal node, above steps are checked for the left and right subtree
     *
     * @param root
     * @return true/false
     */
    private boolean checkConditions(final BSTNode root, int depth){
        if(root == null){
            return true;
        }
        if(root.getLeft() == null && root.getRight() == null){
            if(depthOfTree == -1){
                depthOfTree = depth;
                return true;
            } else {
              return (depth == depthOfTree);
            }
        }
        if(root.getLeft() == null || root.getRight() == null){
            return false;
        }

        return (checkConditions(root.getLeft(), depth + 1) &&
                checkConditions(root.getRight(), depth + 1));
    }

    /**
     * Checks if the given tree is perfect ie., all nodes except leaf have 2 children and all
     * leaf nodes are at the same depth
     *
     * @param rootNode
     * @return true/false
     */
    public boolean isPerfect(BSTNode rootNode){
        return checkConditions(rootNode, 0);
    }

}

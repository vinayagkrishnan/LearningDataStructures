package com.UmmuLearns.trees;

import com.UmmuLearns.BSTNode;

/**
 * Two trees are considered identical if both trees have the same structure as well as
 * the same values in each node
 * Given the root nodes, two trees are identical if:
 *          1. Both nodes have same value
 *          2. The left sub tree and right sub tree are identical
 */
public class IdenticalTreeTester {

    /**
     * Given the root nodes of two trees, this function recursively checks if both trees are identical
     * If both root nodes are null, the trees are considered identical
     * If one node is null while the other node isn't, then the trees are not identical
     * If nodes are not null and have same values, the trees are identical if the recursive call to
     *      the function with the left subtree node and right sub tree node returns true
     * @param root1
     * @param root2
     * @return
     */
    public boolean checkIfTreesAreIdentical(BSTNode root1, BSTNode root2){
        if(root1 == root2){
            return true;
        }

        if(root1 == null || root2 == null){
            return false;
        }

        return root1.getData() == root2.getData() &&
                checkIfTreesAreIdentical(root1.getLeft(), root2.getLeft()) &&
                  checkIfTreesAreIdentical(root1.getRight(), root2.getRight());

    }
}

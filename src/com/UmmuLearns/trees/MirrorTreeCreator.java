package com.UmmuLearns.trees;

import com.UmmuLearns.BSTNode;

/**
 * Computes the mirror image of a given binary tree
 * The mirror image of a tree is obtained by swapping the left and right subtrees recursively to the leaf
 *
 *              1                          1
 *             / \                        / \
 *            2   5                      5   2
 *           /     \                    /     \
 *          3       6       and        6       3    are mirror images of each other
 *           \     /                    \     /
 *           4    7                      7   4
 */
public class MirrorTreeCreator {

    /**
     * Given the root node to a binary tree, this function returns the mirror image of the tree
     * Child subtrees are mirrored and swapped in place recursively to create the mirrored tree
     *
     * If root is null, then it is considered a mirror image of itself and null is returned
     * @param root of the tree to be mirrored
     * @return root of the mirrored tree
     */
    public BSTNode createMirroredTree(final BSTNode root){
        if(root == null) {
            return null;
        } else {
           // swap(root.getLeft(), root.getRight());

            BSTNode newLeft = createMirroredTree(root.getRight());
            BSTNode newRight = createMirroredTree(root.getLeft());

            root.setLeft(newLeft);
            root.setRight(newRight);
        }
        return root;
    }

    //TODO
    /*public BSTNode createMirroredTreeNew(final BSTNode root){
        BSTNode mirroredNode;
        if(root == null) {
            return null;
        } else {
            mirroredNode = new BSTNode(root.getData());

            BSTNode newLeft = createMirroredTree(root.getRight());
            BSTNode newRight = createMirroredTree(root.getLeft());

            mirroredNode.setLeft(newLeft);
            mirroredNode.setRight(newRight);
        }
        return mirroredNode;
    }*/

    /**
     * Accepts two subtrees and recursively swaps the left and right subtrees in place
     *
     * If both children are null, does nothing.
     * Else, swaps left and right subtree for both children
     * And finally swaps the child nodes themselves
     *
     * @param left - root of left subtree
     * @param right - root of right subtree
     */
   /* private void swap(BSTNode left, BSTNode right) {
        if(left == null && right == null){
            return;
        }

        if(left != null){
            swap(left.getLeft(), left.getRight());
        }
        if(right != null){
            swap(right.getLeft(), right.getRight());
        }

        BSTNode temp = left;
        left = right;
        right = temp;
        return;
    }*/
}

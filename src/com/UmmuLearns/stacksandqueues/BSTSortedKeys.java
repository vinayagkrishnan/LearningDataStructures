package com.UmmuLearns.stacksandqueues;

import com.UmmuLearns.BSTNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a node N in a BST, compute all keys of the subtree starting at N, in sorted order
 *              43
 *             /  \
 *            23   47
 *             \    \
 *             37   53
 *            /  \
 *          29    41
 *          \
 *          31
 * Given the node N = 43, return [23,29, 31, 37, 41, 43, 47, 53]
 */
public class BSTSortedKeys {


    /**
     * Given a node in the BST, function keeps going left and pushing all nodes encountered on the way to the stack
     * When there is no more left children in the current path, the topmost node from the stack is popped and it moves on to the right child
     * This process is then again repeated for the right child.
     *
     * If a null tree is given as input, function returns an empty key list as output
     *
     * @param root of the BST
     * @return List of all keys in sorted order (ascending)
     */
    public List<Integer> sortBSTKeys(final BSTNode root){
        BSTNode current = root;
        Stack<BSTNode> keyStack = new Stack<>();
        List<Integer> sortedKeys = new ArrayList<>();

        while (!keyStack.isEmpty() || current != null){             //keep going left/right till the stack is empty. If stack is empty, continue till there are no other children

              if(current != null){
                  keyStack.push(current);
                  current = current.getLeft();
              } else {
                current = keyStack.pop();
                sortedKeys.add(current.getData());
                current = current.getRight();
              }
          }
          return sortedKeys;
    }

}

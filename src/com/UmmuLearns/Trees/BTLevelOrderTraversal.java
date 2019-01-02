package com.UmmuLearns.Trees;

import com.UmmuLearns.BSTNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Traverse the BT level first > left to right
 */
public class BTLevelOrderTraversal {

    /**
     * Accepts the root node of the binary tree to traverse
     * Moves through the tree and creates a list of tree elements in each level left to right and returns the list(Breadth first order)
     *
     * A queue keeps track of the traversal order. Each node is dequeued and added to the result while its children are added
     * back to the queue to maintain the order.
     * Returns empty list of root is null
     *
     * @param root of the binary tree
     * @return list of elements in Level first order
     */
    List<Integer> traverseLevelFirst(final BSTNode root){
        List<Integer> result = new LinkedList<>();
        Deque<BSTNode> nodeValueQueue;
        if(root == null){
            return result;
        }

        nodeValueQueue = new LinkedList<>();
        nodeValueQueue.add(root);

        while(!nodeValueQueue.isEmpty()){
            BSTNode currentNode = nodeValueQueue.getFirst();
            result.add(currentNode.getData());
            nodeValueQueue.add(currentNode.getLeft());
            nodeValueQueue.add(currentNode.getRight());
        }
        return result;
    }
}

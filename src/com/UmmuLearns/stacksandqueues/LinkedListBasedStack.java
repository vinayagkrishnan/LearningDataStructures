package com.UmmuLearns.stacksandqueues;

import com.UmmuLearns.Node;

/**
 * Stack implementation using a linked list to store values
 * Operations that can be performed : push, pop, peek, check if empty
 */
public class LinkedListBasedStack<T> implements MyStack<T>{

    private Node top;   //head of the linked list has the newest/topmost element in stack

    /**
     * Reads and returns the value from the node at the top of the stack
     * If the stack is empty, returns null
     * @return
     */
    @Override
    public T peek() {
        if (top == null) {
            System.out.println("Error: Stack is empty!");
            return null;
        } else {
          return (T) top.getData();     //doubt : y (T)
        }
    }

    /**
     * Creates a new node with the given value and inserts it at the top
     * The new node becomes the head of the implementing list
     */
    @Override
    public void push(T data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        //max = top = null ? data : Math.Max(max,data)
    }

    /**
     * Removes the node at the top of the stack (head of the implementing list) and
     * returns the value to the calling function
     * If you try to pop from an empty stack, this method will return null
     * @return
     */
    @Override
    public T pop() {
        if(top == null){
            System.out.println("Error: cannot pop from empty stack");
            return null;
        } else {
            // NOTE Use finals everywhere relevant
            final T poppedValue = (T) top.getData();
            top = top.next;
            return poppedValue;
        }
    }

    /**
     * Checks whether or not the stack has any elements
     * Returns true if there are no nodes in the implementing list
     * @return
     */
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Gets the max value from the topmost node by peeking
     * Returns null for empty maps
     * @return
     * DOUBT type
     */
    @Override
    public T max() {
        if(top == null){
            System.out.println("Error: Cannot find max from empty map!");
            return null;
        } else {
            return (T) top.getMax();
        }
    }

    /**
     * Structure for each value in the stack
     * done : Read about "DRY", refactor the original Node and make it use generics
     */
    /*private class Node {
        //Doubt : why can I use this variable above?
        private T data;
        private Node next;
        private T max;            //DOUBT how to control type?
        public Node(T data){
            this.data = data;
        }
    }*/
}

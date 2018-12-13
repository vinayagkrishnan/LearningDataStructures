package com.UmmuLearns.stacksandqueues;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListBasedStackTest {

    //MyStack<Integer> testStack;       // DOUBT  throws error in assert
    MyStack<Integer> testStack;

    @BeforeEach
    void setupStack(){
        testStack = new LinkedListBasedStack<>();
        System.out.println("Starting test");
    }

    @Test
    void peek() {
        System.out.println("peek test");
        Assertions.assertNull(testStack.peek());    // peeking from empty stack >> null

        testStack.push(34);
        testStack.push(45);
        testStack.push(1);
        Assertions.assertEquals(testStack.peek(), (Integer) 1);

        testStack.pop();
        Assertions.assertEquals(testStack.peek(), (Integer) 45);

        testStack.pop();
        Assertions.assertEquals(testStack.peek(), (Integer) 34);

        testStack.pop();
        Assertions.assertNull(testStack.peek());

    }

    @Test
    void push() {
        System.out.println("push test");

        testStack.push(null);
        testStack.push(2);
        Assertions.assertEquals(testStack.peek(), (Integer) 2);

        // testStack.push('a');        // DOUBT how to check type mismatch?
        // Assertions.assertEquals(testStack.pop(), 'a');
    }

    @Test
    void pop() {
        System.out.println("pop test");

        Assertions.assertNull(testStack.pop()); //popping from empty stack

        testStack.push(1);
        testStack.push(2);
        Assertions.assertEquals(testStack.pop(), (Integer) 2);
        Assertions.assertEquals(testStack.peek(), (Integer) 1);
        Assertions.assertEquals(testStack.pop(), (Integer) 1);
        Assertions.assertNull(testStack.pop());
    }

    @Test
    void isEmpty() {
        System.out.println("isempty test");

        Assertions.assertTrue(testStack.isEmpty());
    }
}
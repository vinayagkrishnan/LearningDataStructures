package com.UmmuLearns.stacksandqueues;

/**
 * Generic stack with push, pop and peek operations
 * TODO Update all APIs with info on how they handle edge cases, for eg: push(null)
 * @param <T>
 */
public interface MyStack<T> {

    /**
     * Peeks at the top of the stack and returns the topmost value without actually popping it
     * @return
     */
    T peek();

    /**
     * Inserts a value to the top of the stack
     * FIXME final arguments
     */
    void push(T data);

    /**
     * Removes the topmost value from the stack and returns it
     * @return
     */
    T pop();

    /**
     * Tells whether or not the stack has any values
     * @return true/false
     */
    boolean isEmpty();

    /**
     * Returns the maximum value in the stack at the time
     * TODO Learn about @{@link Comparable} and implement this the right way
     * @return
     */
    T max();

    // TODO Add size(), clear()

}

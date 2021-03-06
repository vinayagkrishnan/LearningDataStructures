package com.UmmuLearns.trees;

import com.UmmuLearns.BSTNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PerfectTreeValidatorTest {

    BSTNode testNode;

    @BeforeEach
    void setUp() {

        //TODO - add tests for imperfect tree and balanced but imperfect tree(level diff at most 1)
        testNode = new BSTNode(4);
        testNode.setLeft(new BSTNode(5));
        testNode.setRight(new BSTNode(6));
        System.out.println("Starting test for perfect tree");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test completed");
    }

    @Test
    void isPerfect() {
        PerfectTreeValidator validator = new PerfectTreeValidator();
        boolean result = validator.isPerfect(testNode);
        Assertions.assertTrue(result);
    }
}
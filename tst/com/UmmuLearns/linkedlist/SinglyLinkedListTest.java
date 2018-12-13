package com.UmmuLearns.linkedlist;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

public class SinglyLinkedListTest {

    @Test
    public void testJunit() {
        // do test logic here
        Assert.assertTrue(true);
    }

    @Test
    @Ignore
    public void dontTest() {
        Assertions.assertTrue(false);
    }

    @Test
    public void testAppendApi() {
        LinkedList testList = new SinglyLinkedList();
        assertEquals(testList.size(), 0);

        testList.append(1);
        testList.append(2);
        testList.append(3);

        assertEquals(testList.size(), 3);
    }

}
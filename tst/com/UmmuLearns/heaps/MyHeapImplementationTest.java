package com.UmmuLearns.heaps;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MyHeapImplementationTest {

    private MyHeap myHeap = new MyHeapImplementation();

    @BeforeEach
    void setUp() {
        System.out.println("Starting test for :");
    }

    @AfterEach
    void tearDown() {
        myHeap = null;
    }

    @Test
    void testMergeSortedSequences() {
        System.out.println("merge sorted sequences");

        List<Integer> seq1 = new ArrayList<>();
        seq1.add(0);
        seq1.add(6);
        seq1.add(20);
        List<Integer> seq2 = new ArrayList<>();
        seq2.add(0);
        seq2.add(6);
        List<Integer> seq3 = new ArrayList<>();
        seq3.add(3);
        seq3.add(5);
        seq3.add(7);

        List<List<Integer>> sequences = new ArrayList<>();
        sequences.add(seq1);
        sequences.add(seq2);
        sequences.add(seq3);

        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(0);
        expectedList.add(0);
        expectedList.add(3);
        expectedList.add(5);
        expectedList.add(6);
        expectedList.add(6);
        expectedList.add(7);
        expectedList.add(20);

        Assertions.assertEquals(myHeap.mergeSortedSequences(sequences), expectedList);
        System.out.println("Ending test");
    }

    @Test
    void testSortIncreasingDecreasingList(){
        System.out.println("sort increasing decreasing list");

        List<Integer> testList = new ArrayList<>();
        testList.add(0);
        testList.add(4);
        testList.add(9);
        testList.add(8);
        testList.add(3);
        testList.add(6);
        testList.add(70);
        testList.add(20);
        testList.add(16);
        testList.add(12);

        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(0);
        expectedList.add(3);
        expectedList.add(4);
        expectedList.add(6);
        expectedList.add(8);
        expectedList.add(9);
        expectedList.add(12);
        expectedList.add(16);
        expectedList.add(20);
        expectedList.add(70);

        Assertions.assertEquals(myHeap.sortIncreasingDecreasingList(testList), expectedList);
        System.out.println("Ending test");


    }
}
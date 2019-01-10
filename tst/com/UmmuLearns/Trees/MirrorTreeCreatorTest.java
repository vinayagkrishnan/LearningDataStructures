package com.UmmuLearns.Trees;

import com.UmmuLearns.BSTNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MirrorTreeCreatorTest {

    BSTNode testNode1;
    BSTNode testNode2;

    @BeforeEach
    void setUp() {
        // Tree to be mirrored
        testNode1 = new BSTNode(1);
        BSTNode leftL1 = new BSTNode(2);
        BSTNode rightR1 = new BSTNode(5);
        BSTNode leftL1L2 = new BSTNode(3);
        BSTNode rightL1R2 = null;
        BSTNode leftR1L2 = null;
        BSTNode rightR1R2 = new BSTNode(6);
        BSTNode leftL2L3 = null;
        BSTNode rightL2R3 = new BSTNode(4);
        BSTNode leftR2L3 = new BSTNode(7);
        BSTNode rightR2R3 = null;

        testNode1.setLeft(leftL1);
        testNode1.setRight(rightR1);
        leftL1.setLeft(leftL1L2);
        leftL1.setRight(rightL1R2);
        rightR1.setLeft(leftR1L2);
        rightR1.setRight(rightR1R2);

        leftL1L2.setLeft(leftL2L3);
        leftL1L2.setRight(rightL2R3);
        rightR1R2.setLeft(leftR2L3);
        rightR1R2.setRight(rightR2R3);

        //Mirror image of testNode1
        testNode2 = new BSTNode(1);
        BSTNode L1 = new BSTNode(5);
        BSTNode R1 = new BSTNode(2);
        BSTNode L1L2 = new BSTNode(6);
        BSTNode L1R2 = null;
        BSTNode R1L2 = null;
        BSTNode R1R2 = new BSTNode(3);
        BSTNode L2L3 = null;
        BSTNode L2R3 = new BSTNode(7);
        BSTNode R2L3 = new BSTNode(4);
        BSTNode R2R3 = null;

        testNode2.setLeft(L1);
        testNode2.setRight(R1);
        L1.setLeft(L1L2);
        L1.setRight(L1R2);
        R1.setLeft(R1L2);
        R1.setRight(R1R2);

        L1L2.setLeft(L2L3);
        L1L2.setRight(L2R3);
        R1R2.setLeft(R2L3);
        R1R2.setRight(R2R3);

        System.out.println("Starting test for Mirrored tree");
    }

    @AfterEach
    void tearDown(){
        System.out.println("Mirrored tree test completed");
    }

    @Test
    void createMirroredTree() {
        MirrorTreeCreator treeManipulator = new MirrorTreeCreator();
        IdenticalTreeTester validator = new IdenticalTreeTester();

        /*System.out.println(testNode1);
        BSTNode mirroredRootNew = treeManipulator.createMirroredTreeNew(testNode1);
        final boolean result2 = validator.checkIfTreesAreIdentical(mirroredRootNew, testNode2);

        System.out.println(testNode1);*/

        BSTNode mirroredRoot = treeManipulator.createMirroredTree(testNode1);
        //Checking if the mirrored version of testNode1 and the testNode2 are identical
        final boolean result = validator.checkIfTreesAreIdentical(mirroredRoot, testNode2);

        Assertions.assertTrue(result);
        //Assertions.assertTrue(result2);
    }
}
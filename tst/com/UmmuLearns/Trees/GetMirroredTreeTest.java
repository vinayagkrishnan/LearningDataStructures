package com.UmmuLearns.Trees;

import com.UmmuLearns.BSTNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetMirroredTreeTest {

    BSTNode rootNode;

    @BeforeEach
    void setUp() {
        rootNode = new BSTNode(1);
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

        rootNode.setLeft(leftL1);
        rootNode.setRight(rightR1);
        leftL1.setLeft(leftL1L2);
        leftL1.setRight(rightL1R2);
        rightR1.setLeft(leftR1L2);
        rightR1.setRight(rightR1R2);

        leftL1L2.setLeft(leftL2L3);
        leftL1L2.setRight(rightL2R3);
        rightL1R2.setLeft(leftR2L3);
        rightL1R2.setRight(rightR2R3);


    }

    @Test
    void createMirroredTree() {

    }
}
package com.UmmuLearns;

public class BSTNode {

    private BSTNode left, right;
    private int data;

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public BSTNode(int data){
        this.data = data;
    }
}

package com.UmmuLearns;

public class Node<T> {

    private T data;
    public Node next;
    private T max;


    public T getMax() {
        return max;
    }

    public void setMax(T max) {
        this.max = max;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node(){
    }

    public Node(T data){
        this.data = data;
    }
}

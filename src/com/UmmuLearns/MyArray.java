package com.UmmuLearns;

import java.util.LinkedList;

public class MyArray {

    int[] demoArray = new int[50];
    int initArraySize = 10;

    public void getRandomArray(){
        for(int i = 0; i<initArraySize; i++) {
            demoArray[i] = (int) (Math.random() * 11) + 10;
            System.out.print(demoArray[i]);
        }
    }

    public void printArray(){
        for(int i = 0; i<initArraySize; i++){
            System.out.println("| " + i + " | ");
            System.out.println("| " + demoArray[i] + " | ");
        }
    }

    public static void main(String[] args) {

        LinkedList n = new LinkedList();

    }
}


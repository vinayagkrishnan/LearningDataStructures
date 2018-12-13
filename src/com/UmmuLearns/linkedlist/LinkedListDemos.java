package com.UmmuLearns.linkedlist;

public class LinkedListDemos {

    public static void main(String[] args) {
        LinkedList myList = new SinglyLinkedList();

        //Creating the list
        myList.append(2);
        myList.append(5);
        myList.append(12);
        myList.append(2);

        myList.displayList();

        System.out.println(myList.size());

        myList.deleteValue(2);
        myList.displayList();
        System.out.println(myList.size());
    }

}

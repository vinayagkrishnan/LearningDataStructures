package com.UmmuLearns.linkedlist;

import com.UmmuLearns.Node;

public class SinglyLinkedList implements LinkedList {
    private Node head;
    private int size;

    /* display elements of a list */
    public void displayList(){
        if(head == null){
            System.out.println("Empty list");
        }else{
            Node current = head;
            while(current != null){
                System.out.println(current.data);
                current = current.next;
            }
        }
    }

    /* append to end of list */
    public void append(final int value){
        Node newValueNode = new Node(value);

        // inserting to an empty list
        if(head == null){
            head = newValueNode;
        }else{

            //inserting at the end of list
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newValueNode;
        }
        size++;
    }

    /**
     * Get no of nodes in list
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /* delete all occurrences of given value from list */
    public void deleteValue(int value){
        if(head == null)
            return;                        // No list to delete from
        /*if(head.data == value){
            head = head.next;              // First value gets deleted and the next node is the new head
        }*/

        Node current = head;
        Node previous = new Node();
        while(current != null){
            if(current.data == value){
                previous.next = current.next;
                current.next = null;
                if(current == head)
                    head = previous.next;
                current = previous.next;
                size--;
            }else{
                previous = current;
                current = current.next;
            }
        }
        /*
        Node prev = new Node();
        Node current = head;

        while(current != null && current.data != value) {
            prev = current;
            current = current.next;
        }
            prev.next = current.next;
            size--;
*/
    }

}



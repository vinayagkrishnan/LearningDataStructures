package com.UmmuLearns.hashmaps;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

// FIXME Make this a concurrent hashmap

/**
 * Uses a linked list to implement a map data structure
 * Supported functions are get and put key - value pairs in map, check if key exists in map,
 * get the size of map, get a list of keys in map and delete entries from map
 */
public class LinkedListBackedHashMap extends AbstractHashMapBase implements MyMap {

    private int size = 0;

    private Set<Object> keySet = new HashSet<>();

    private  ValueMap head;
    /**
     * Template for individual key - value mapping node
     */
    private class ValueMap{

        private Object key;
        private Object value;
        ValueMap next;
        public ValueMap(Object key, Object value){
            this.key = key;
            this.value = value;
        }
        public Object getValue() {
            return value;
        }
        public Object getKey() {
            return key;
        }
    }
    /**
     * Get number of mappings in the map at a given time
     * This returns the number of nodes in the backing linked list
     * @return size of map (no.of linked list nodes)
     */
    @Override
    public int getMapSize() {
        return size;
    }

    /**
     * Function inserts a key - value mapping to the map
     * A new node is created with the given parameter values and added to the linked list
     * A null key entry is not allowed. If a key is already present in the map, its value will be overwritten with the new value
     * New entries are attached to the beginning of the linked list to have O(n) time
     *
     * @param key
     * @param value
     * @throws IllegalArgumentException when given key is null
     */
    @Override
    public void put(final Object key, final Object value) {

        // Cannot allow null keys
        if(key == null)
            throw new IllegalArgumentException("key cannot be null");

        // If a duplicate key is found, to simulate an overwrite, the entry with the given key(already in map) is deleted from the linked list
        // and a new node with the given key and value is attached to the list
        if(doesKeyExist(key)){
            deleteEntry(key);
        }

        final ValueMap newKVPair = new ValueMap(key, value);
        newKVPair.next = head;
        head = newKVPair;
        keySet.add(key);
        size++;

        /*if (head == null)
            head = newKVPair;
        else {
            ValueMap current = head;
            // fixed :  This is O(n), why?
            while (current.next != null) {
                current = current.next;
            }
            current.next = newKVPair;
        }*/

        // fixed : Handle duplicate inserts

    }

    /**
     * Checks the linked list backed map for the given key and when the node is found, returns the value field
     * Will generate an error in case key is not in map
     * Returns null if map got corrupted and value was not found
     *
     * @param key
     * @throws  NoSuchElementException if key not found
     * @return value corresponding to the given key
     */
    @Override
    public Object get(final Object key) {
        if (head == null){
            throw new NullPointerException("Error : empty map");
        }

        // error if key mapping is not present in map
        if(key == null || !keySet.contains(key))
            // fixed : Is this the contract ?
            throw new NoSuchElementException("Error : Key not found");

        ValueMap current = head;
        while(current != null && !current.getKey().equals(key)){
            current = current.next;
        }

        // fixed : Validate that at this point, current.getKey == key
        if(current == null){
            return null;        //Map is corrupted
        } else {
            return current.getValue();
        }
    }

    /**
     * Return a list of all keys in the map
     * @return list of keys
     */
    @Override
    public ArrayList<Object> getAllKeys() {
        return new ArrayList<>(keySet);
    }

    /**
     * Check if the map contains given key
     * @param key
     * @return true/false
     */
    @Override
    public boolean doesKeyExist(final Object key) {
        return keySet.contains(key);
    }

    /**
     * Delete a key - value mapping from the map
     * If the given key is null / it does not exist in map, an exception is generated
     * Otherwise, the node with the given key is found and deleted from the backing linked list
     * After this operation, the size is decremented and the key is removed from the keyset
     * @param key
     * @throws NoSuchElementException if key not found
     * @throws NullPointerException if deleting from empty map
     * @throws IllegalStateException if map is corrupt
     */
    @Override
    public void deleteEntry(final Object key) {

        synchronized (this) {

            if (head == null){
                throw new NullPointerException("Error : empty map!");
            }
            if (key == null || !doesKeyExist(key))
                // fixed Is this the contract?
                throw new NoSuchElementException("Error : Key not found");

            // fixed : possible NPE
            if (head.getKey().equals(key))
                head = head.next;
            else {
                ValueMap prev = head;
                ValueMap current = head.next;
                while(current != null && !current.getKey().equals(key)){
                    prev = current;
                    current = current.next;
                }

                if(current == null){
                    throw new IllegalStateException("Error : Map corrupt");
                }

                prev.next = current.next;
                current.next = null;

                /*ValueMap current = head;
                while (current.next != null && !current.next.getKey().equals(key)) {
                    current = current.next;
                }
                // FIXed Possible NPE!!
                current.next = current.next.next;*/
            }
            size--;
            keySet.remove(key);
        }
    }

}



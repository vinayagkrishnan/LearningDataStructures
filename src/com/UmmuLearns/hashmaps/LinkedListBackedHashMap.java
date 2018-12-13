package com.UmmuLearns.hashmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// TODO Add unit tests
// FIXME Make this a concurrent hashmap
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
     * Get number of mappings in the map
     * @return
     */
    @Override
    public int getMapSize() {
        return size;
    }

    /**
     * insert a key - value mapping to the map
     * FIXME Update the doc
     * @param key
     * @param value
     */
    @Override
    public void put(final Object key, final Object value) {

        // Cannot allow null keys
        if(key == null)
            throw new RuntimeException("key cannot be null");
        // cannot allow duplicate keys
        // TODO Are duplicates allowed?
//        if(doesKeyExist(key))
//            throw new RuntimeException("key already exists in map");

        final ValueMap newKVPair = new ValueMap(key, value);
        if (head == null)
            head = newKVPair;
        else {
            ValueMap current = head;
            // FIXME This is O(n), why?
            while (current.next != null) {
                current = current.next;
            }
            current.next = newKVPair;
        }
        keySet.add(key);

        // FIXME Handle duplicate inserts
        size++;

    }

    /**
     * Return the value corresponding to the given key
     * @param key
     * @return
     */
    @Override
    public Object get(final Object key) {

        // error if key mapping is not present in map
        if(key == null || !keySet.contains(key))
            // FIXME Is this the contract ?
            throw new RuntimeException("Key not found");

        ValueMap current = head;
        while(current != null && !current.getKey().equals(key)){
            current = current.next;
        }

        // FIXME Validate that at this point, current.getKey == key

        return current.getValue();
    }

    /**
     * Return a list of all keys in the map
     * @return
     */
    @Override
    public ArrayList<Object> getAllKeys() {
        // TODO Set the expectation in the api that this is a snapshot
        return new ArrayList<>(keySet);
    }

    /**
     * Check if the map contains given key
     * @param key
     * @return
     */
    @Override
    public boolean doesKeyExist(final Object key) {
        return keySet.contains(key);
    }

    /**
     * Delete a key - value mapping from the map
     * @param key
     * @return
     */
    @Override
    public void deleteEntry(final Object key) {

        synchronized (this) {

            if (key == null || !doesKeyExist(key))
                // FIXME Is this the contract?
                throw new RuntimeException("Key not found");

            if (head.getKey().equals(key))
                head = head.next;
            else {
                ValueMap current = head;
                while (current.next != null && !current.next.getKey().equals(key)) {
                    current = current.next;
                }
                // FIXME Possible NPE!!
                current.next = current.next.next;
            }
            size--;
            keySet.remove(key);
        }
    }
}



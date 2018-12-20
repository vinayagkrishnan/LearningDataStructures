package com.UmmuLearns.hashmaps;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public interface MyMap {

    /**
     * Insert a key - value pair in the map
     * @param key
     * @param value
     * @throws IllegalArgumentException when given key is null
     */
    void put(final Object key, final Object value);

    /**
     * Fetch a value corresponding to the given key from map
     * @param key
     * @throws NoSuchElementException if key not found
     * @return value corresponding to the given key
     */
    Object get(final Object key);

    /**
     * Return a list of all keys in the map at the time of calling the function
     * @return list of keys
     */
    ArrayList<Object> getAllKeys();

    /**
     * Check if the map contains given key
     * @param key
     * @return true/false
     */
    boolean doesKeyExist(final Object key);

    /**
     * Delete a key - value mapping from the map
     * @param key
     * @throws NoSuchElementException if key not found
     * @throws NullPointerException if deleting from empty map
     * @throws IllegalStateException if map is corrupt
     */
    void deleteEntry(final Object key);

    /**
     * Get number of mappings in the map
     * @return
     */
    int getMapSize();

    default String getDetails() {
        return "MyMap";
    }

}

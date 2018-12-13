package com.UmmuLearns.hashmaps;

import java.util.ArrayList;

public interface MyMap {

    /**
     * Insert a key - value pair in the map
     * @param key
     * @param value
     */
    void put(final Object key, final Object value);

    /**
     * Fetch a value corresponding to the given key from map
     * FIXME Handle exceptions in all APIs
     * @param key
     * @return
     */
    Object get(final Object key);

    /**
     * Return a list of all keys in the map
     * @return
     */
    ArrayList<Object> getAllKeys();

    /**
     * Check if the map contains given key
     * @param key
     * @return
     */
    boolean doesKeyExist(final Object key);

    /**
     * Delete a key - value mapping from the map
     * @param key
     * @return
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

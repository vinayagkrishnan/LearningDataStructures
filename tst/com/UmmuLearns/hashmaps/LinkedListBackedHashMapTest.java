package com.UmmuLearns.hashmaps;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class LinkedListBackedHashMapTest {

    MyMap testMap;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Unit tests started");
    }

    @Before
    public void setup() {
        testMap = new LinkedListBackedHashMap();
        System.out.println("Test started");
    }

    @After
    public void after() {
        testMap = null;
        System.out.println("Test completed");
    }

    @Test
    public void testEmptyMaps() {
        System.out.println("Testing empty map");
        assertEquals(testMap.getMapSize(), 0);
        assertEquals(testMap.getAllKeys().size(), 0);
    }

    @Test
    public void testHappyCase() {
        System.out.println("testing happy case");

        testMap.put("ummu", 27);
        testMap.put("poocha", 28);
        ArrayList keyList = new ArrayList<>(Arrays.asList("ummu", "poocha"));
        assertEquals(testMap.getMapSize(), 2);
        assertTrue(keyList.containsAll(testMap.getAllKeys()));
        assertFalse(testMap.doesKeyExist("diya"));
        assertTrue(testMap.doesKeyExist("ummu"));
        assertEquals((int)testMap.get("ummu"), 27);
        assertEquals((int)testMap.get("poocha"), 28);

    }

    @Test
    public void testEmptyKeys() {
        System.out.println("testing with empty keys");


    }

    @Test
    public void testInvalidDeletions() {

    }


    @Test
    public void testMultiThreadedInsertAndDelete() {

    }

}

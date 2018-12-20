package com.UmmuLearns.hashmaps;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

class LinkedListBackedHashMapTest {

    private MyMap testMap;

    @BeforeAll
    static void beforeClass() {
        System.out.println("Unit tests started");
    }

    @BeforeEach
    void setup() {
        testMap = new LinkedListBackedHashMap();
        System.out.println("Test started");
    }

    @AfterEach
    void after() {
        testMap = null;
        System.out.println("Test completed");
    }

    @Test
    void testEmptyMaps() {
        System.out.println("Testing empty map");
        Assertions.assertEquals(testMap.getMapSize(), 0);
        Assertions.assertEquals(testMap.getAllKeys().size(), 0);
        Assertions.assertThrows(NullPointerException.class, () -> testMap.get("Ummu"));     //get from empty map
        Assertions.assertThrows(NullPointerException.class, () -> testMap.deleteEntry("Ummu"));     //delete from empty map
        Assertions.assertFalse(testMap.doesKeyExist("Ummu"));
    }

    @Test
    void testHappyCase() {
        System.out.println("testing happy case");

        testMap.put("ummu", 27);
        testMap.put("poocha", 28);
        ArrayList keyList = new ArrayList<>(Arrays.asList("ummu", "poocha"));
        Assertions.assertEquals(testMap.getMapSize(), 2);
        Assertions.assertTrue(keyList.containsAll(testMap.getAllKeys()));
        Assertions.assertFalse(testMap.doesKeyExist("diya"));
        Assertions.assertTrue(testMap.doesKeyExist("ummu"));
        Assertions.assertEquals((int)testMap.get("ummu"), 27);
        Assertions.assertEquals((int)testMap.get("poocha"), 28);
        testMap.deleteEntry("ummu");
        Assertions.assertFalse(testMap.doesKeyExist("ummu"));
        Assertions.assertEquals(testMap.getMapSize(), 1);
        keyList.remove("ummu");
        Assertions.assertTrue(keyList.containsAll(testMap.getAllKeys()));

    }

    @Test
    void testEdgeCases() {
        System.out.println("testing edge cases");

        Assertions.assertThrows(IllegalArgumentException.class, () -> testMap.put(null,23));
        testMap.put("ummu", 27);
        testMap.put("poocha", 28);
        testMap.put("ummu", 30);
        ArrayList keyList = new ArrayList<>(Arrays.asList("ummu", "poocha"));
        Assertions.assertEquals(testMap.getMapSize(), 2);
        Assertions.assertTrue(keyList.containsAll(testMap.getAllKeys()));
        Assertions.assertEquals(testMap.get("ummu"), 30);
        Assertions.assertThrows(NoSuchElementException.class, () -> testMap.get(null));
        Assertions.assertThrows(NoSuchElementException.class, () -> testMap.get("amma"));
        Assertions.assertThrows(NoSuchElementException.class, () -> testMap.deleteEntry("amma"));
        Assertions.assertThrows(NoSuchElementException.class, () -> testMap.deleteEntry(null));

    }

    @Test
    void testMapCorruption() {
        System.out.println("testing corrupt map cases");

        testMap.put("ummu", 27);
        testMap.put("poocha", 28);
        //TODO test corruption

    }


    @Test
    void testMultiThreadedInsertAndDelete() {

    }

}

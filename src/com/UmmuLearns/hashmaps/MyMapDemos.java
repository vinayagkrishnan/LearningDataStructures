package com.UmmuLearns.hashmaps;

public class MyMapDemos {

    public static void main(String[] args) {

        MyMap ummusMap = new LinkedListBackedHashMap();

        MyMapDemos app = new MyMapDemos();
        app.printSizeAndKeys(ummusMap);

        ummusMap.put("ummu", 27);
        ummusMap.put("poocha", 28);

        System.out.println("keys in map" + ummusMap.getAllKeys());
        System.out.println("size of map" + ummusMap.getMapSize());
        System.out.println("'diya' exists in map " + ummusMap.doesKeyExist("diya"));
        System.out.println("'ummu' exists in map " + ummusMap.doesKeyExist("ummu"));

        System.out.println("poochs age " + ummusMap.get("poocha"));

        ummusMap.deleteEntry("ummu");

        System.out.println("deleted ummu!");
        app.printSizeAndKeys(ummusMap);

    }

    private void printSizeAndKeys(MyMap ummusMap) {
        System.out.println("keys in map" + ummusMap.getAllKeys());
        System.out.println("size of map" + ummusMap.getMapSize());
    }
}

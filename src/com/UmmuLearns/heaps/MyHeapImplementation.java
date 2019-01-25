package com.UmmuLearns.heaps;

import java.util.*;

public class MyHeapImplementation implements MyHeap {

    /**
     * Structure for the min heap node used in mergeSortedSequences()
     */
    private static class ListEntry{
        int value;
        int listId;

        ListEntry(int val, int id){
            this.value = val;
            this.listId = id;
        }
    }

    private enum ListType {
        INCREASING,
        DECREASING;
    }
    /**
     * Function merges the given sorted sequence into a final sorted sequence
     * To sort and merge the sequences, we consider just the first element from
     * the remaining elements of each sequence as we proceed
     * A min heap is used to keep track of the smallest of the considered elements
     * Doubt >> O(klogk) ??
     * @param sequences - list of sorted integer lists
     * @return
     */
    @Override
    public List<Integer> mergeSortedSequences(final List<List<Integer>> sequences) {

        List<Integer> result = new ArrayList<>();               // Contains final sorted and merged sequence
        List<Integer> nextIndexWithinList = new ArrayList<>(sequences.size());  //Stores the index of next element
                                                                                //to be considered in each sequence
        final int INITIAL_CAPACITY = 20;        //Doubt

        //Min heap for holding the first of remaining elements from each sequence
        PriorityQueue<ListEntry> minHeap = new PriorityQueue<>(INITIAL_CAPACITY, new Comparator<ListEntry>() {
            @Override
            public int compare(ListEntry entry1, ListEntry entry2) {
                return Integer.compare(entry1.value, entry2.value);
            }
        });

        for(int i = 0; i < sequences.size(); i++){
            if(sequences.get(i).size() > 0){            //handle empty sequences
                minHeap.add(new ListEntry(sequences.get(i).get(0), i));
                nextIndexWithinList.add(1);
            } else {
                nextIndexWithinList.add(0);
            }
        }

        while(!minHeap.isEmpty()){
            ListEntry head = minHeap.poll();            //gets the smallest of the considered sequence elements
            result.add(head.value);

            int parentListId = head.listId;             //gets the index of the parent sequence in the sequences list
            List<Integer> parentList = sequences.get(parentListId);
            int nextElementIndex = nextIndexWithinList.get(parentListId);   //index of first of remaining elements in the parent sequence

            //Add the next element from the remaining elements(if any) in the parent list to the min heap
            if(nextElementIndex < parentList.size()){
                Integer nextValue = parentList.get(nextIndexWithinList.get(parentListId));
                nextIndexWithinList.set(parentListId, nextIndexWithinList.get(parentListId) + 1);
                minHeap.add(new ListEntry(nextValue, parentListId));
            }
        }

        return result;
    }

    /**
     * Function sorts the given Increasing-Decreasing array into a fully sorted array
     * This is done by converting the different increasing and decreasing parts into
     * sublists, reversing the sort order of the decreasing sublists and merging these sublists
     * using the mergeSortedSequences() function above
     *
     * @param IncDecList - a list in which elements increase up to a certain index and then decrease repeatedly
     * @return Sorted list
     */
    @Override
    public List<Integer> sortIncreasingDecreasingList(List<Integer> IncDecList) {

        int startIndex = 0;
        ListType subListType = ListType.INCREASING;
        List<List<Integer>> subLists = new ArrayList<>();

        for(int i = 1; i <= IncDecList.size(); i++){

            if(i == IncDecList.size()
                    || IncDecList.get(i) < IncDecList.get(i-1) && subListType == ListType.INCREASING
                    || IncDecList.get(i) > IncDecList.get(i-1) && subListType == ListType.DECREASING){

                List<Integer> subList = IncDecList.subList(startIndex, i);

                if(subListType == ListType.DECREASING){
                    Collections.reverse(subList);
                }
                subLists.add(subList);
                startIndex = i;
                subListType = (subListType == ListType.INCREASING) ? ListType.DECREASING : ListType.INCREASING;

            }
        }

        return mergeSortedSequences(subLists);
    }

    /**
     * Function accepts a k-sorted list and sorts it fully by
     * keeping track of k+1 elements at a time and sorting them (since an element can only be at most
     * k away from its actual sorted position)
     * A heap is used to hold these k elements at any7 given time
     *
     * @param kSortedList - a k-sorted list
     * @return fully sorted list
     */
    @Override
    public List<Integer> sortKSortedList(final List<Integer> kSortedList, final int k) {

        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> kHeap = new PriorityQueue<>();
        int maxPosDeviation = k;
        int listIndex = 0;

        while(maxPosDeviation-- >= 0){
            kHeap.add(kSortedList.get(listIndex));
            listIndex++;
        }

        for( ;listIndex < kSortedList.size(); listIndex++){
            result.add(kHeap.poll());
            kHeap.add(kSortedList.get(listIndex));
        }

        while(!kHeap.isEmpty()){
            result.add(kHeap.poll());
        }
        return result;
    }


}

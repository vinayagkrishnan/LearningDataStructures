package com.UmmuLearns.heaps;

import java.util.List;

public interface MyHeap {

    /**
     * Q11.1
     * Merge the given integer sequences which are sorted, into a new sorted list
     *
     * @param sequences - list of sorted integer lists
     * @return List of merged and sorted sequences
     */
    List<Integer> mergeSortedSequences(final List<List<Integer>> sequences);

    /**
     * Q11.2
     * Sort a k-Increasing-Decreasing array
     *
     * @param IncDecList - a list in which elements increase up to a certain index and then decrease repeatedly
     * @return Sorted list
     */
    List<Integer> sortIncreasingDecreasingList(final List<Integer> IncDecList);

    /**
     * Q11.3
     * Sort an almost sorted list where each element is at most k position away from its actual sorted position
     *
     * @param kSortedList - a k-sorted list
     * @param k - max deviation of any element from its actual sorted position
     * @return fully sorted list
     */
    List<Integer> sortKSortedList(final List<Integer> kSortedList, final int k);



}

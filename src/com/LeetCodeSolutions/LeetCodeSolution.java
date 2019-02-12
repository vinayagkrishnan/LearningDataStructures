package com.LeetCodeSolutions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCodeSolution {

    /**
     *  Structure for the object that is inserted into the heap for each candidate pair
     *
     **/
    class Pair{
        int[] pair;
        int sum;
        int indexI;
        int indexJ;

        /**
         *  Constructor to initialize the fields
         *  @param pair - is the int array of pair of candidate values from nums1 and nums2
         *  @param sum - is the sum of values in the pair
         *  @param indexI and indexJ - index of the candidate value pair[0] in nums1 and
         *            index of candidate value pair[1] in nums2 respectively
         **/
        Pair(int[] pair, int sum, int indexI, int indexJ){
            this.pair = pair;
            this.sum = sum;
            this.indexI = indexI;
            this.indexJ = indexJ;
        }

        public int compare(final Pair p2) {
            return Integer.compare(this.sum,p2.sum);
        }
    }

    /**
     *  Function returns k pairs with the smallest sum from given arrays nums1 and nums2
     *  If any of the given arrays are empty or k is 0, an empty list is returned
     *  In other cases, a minHeap keeps track of k candidate pairs from given arrays and
     *               continuously extracts the pair with min sum into a result list and adds the next best candidate pair into the heap
     **/
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();

        if(nums1.length == 0 || nums2.length == 0 || k <= 0){
            return result;
        }

        // Initializing a min heap for storing Pair objects - ordered based on the sum field
//        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(new Comparator<Pair>() {
//
//            @Override
//            public int compare(Pair p1, Pair p2)
//
//            {
//                int compare = Integer.compare(p1.sum,p2.sum);
//                if (compare == 0) {
//                    // do more to decide order
//                    compare = Integer.compare(p1.indexI, p2.indexI);
//                }
//                return compare;
//            }
//        });

        //using lambda for functional interface
        PriorityQueue<Pair> minHeap = new PriorityQueue<>( (p1,p2) -> {
            int compare = Integer.compare(p1.sum,p2.sum);
            if (compare == 0) {
                // do more to decide order
                compare = Integer.compare(p1.indexI, p2.indexI);
            }
            return compare;
        } );

        // Initial k candidate pairs with elements upto k from nums1 and the smallest element from nums2
        // if k > nums1.length,
        for(int i=0, j=0; i < Math.min(nums1.length, k); i++){
            minHeap.offer(new Pair(new int[]{nums1[i], nums2[j]}, nums1[i] + nums2[j], i, j));
        }

        while(!minHeap.isEmpty() && k-- > 0){
            Pair minPair = minHeap.poll();
            result.add(minPair.pair);
            int i = minPair.indexI, j = minPair.indexJ;

            if(j < nums2.length - 1){
                minHeap.add(new Pair(new int[]{nums1[i], nums2[j+1]}, nums1[i] + nums2[j+1], i, j+1));
            }
        }

        return result;
    }

}

package com.LeetCodeSolutions;

import java.util.Deque;
import java.util.LinkedList;

public class UnsortedSubArray {

    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int len = nums.length;
        //Track index of elements to get the change points
        Deque<Integer> indexQueue = new LinkedList<>();

        int subIndex_Start = len - 1;
        int subIndex_End = 0;
        for(int i = 0; i < len; i++){

            //if current number is less than the previous number rocessed,,
            //It is not in the correct position(assuming ascending sorted order)
            while(!indexQueue.isEmpty() && nums[indexQueue.peekLast()] > nums[i]){
                //keep polling till a[i] is in the correct position
                subIndex_Start = Math.min(subIndex_Start, indexQueue.pollLast());
            }
            indexQueue.offer(i);
        }
        //If all elements are in correct position
        if(subIndex_Start == len -1){
            return 0;
        }

        indexQueue.clear();
        for(int i = len - 1; i >= subIndex_Start; i--){
            //keep polling till a[i] is in the correct position
            while(!indexQueue.isEmpty() && nums[indexQueue.peekLast()] < nums[i]){
                subIndex_End = Math.max(subIndex_End, indexQueue.pollLast());
            }
            indexQueue.offer(i);
        }
        // Getting length of unsorted sub array from the change point indices
        return subIndex_End - subIndex_Start + 1;
    }


}

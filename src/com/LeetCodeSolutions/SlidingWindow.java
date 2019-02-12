package com.LeetCodeSolutions;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Invalid cases
        int len = nums == null ? 0 : nums.length;
        if(len == 0){
            return nums;
        }
        int[] result = new int[len - k + 1];
        int resIndx = 0;
        //DE Queue holds index of elements in nums
        Deque<Integer> q = new LinkedList<>();

        for(int i = 0, windowStart = 0; i < len; i++){

            // In current window, keep index of max element at the head
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                q.pollLast();
            }
            q.offer(i);

            // At the end of each window, take the max element(from
            // index at head) and remove the head index if it is out of range
            if(i >= k-1){
                result[resIndx++] = nums[q.peek()];
                if(q.peek() == windowStart){
                    q.poll();
                }
                windowStart++;
            }
        }
        return result;
    }
}

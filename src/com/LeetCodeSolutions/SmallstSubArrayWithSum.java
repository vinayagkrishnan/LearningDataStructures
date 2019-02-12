package com.LeetCodeSolutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Q209
 * TODO - implement with O(1) space ( same with 2 pointers instead of Q )
 * TODO - implement in O(nlogn) with binary search (search range end point in cumulative sum)
 * TODO - implement for case with negative integrs (testCase :
 */
public class SmallstSubArrayWithSum {
    /**
     * Given an array of n positive integers and a positive integer s,
     * finds the minimal length of a contiguous subarray of which the sum ≥ s.
     * If there isn't one, returns 0 instead.

     * Example:

     * Input: s = 7, nums = [2,3,1,2,4,3]
     * Output: 2
     * Explanation: the subarray [4,3] has the minimal length under the problem constraint.

     * @param requiredSum
     * @param nums - given array of POSITIVE integers
     * @return min length of contiguous subarray with sum >= requiredSum if exists
     * @return  0 if such an array does not exist
     * @return  -1 if provided with invalid inputs
     */
        public int minSubArrayLen(int requiredSum, int[] nums) {
            if(nums == null || nums.length == 0 || requiredSum < 0){
                return -1;  //invalid input
            }
            int currentSum = 0, minLen_SubAray = Integer.MAX_VALUE;;
            Queue<Integer> subArrayQ = new LinkedList<>();

            for(int i = 0; i < nums.length; i++){
                if(nums[i] >= requiredSum){
                    return 1;
                }
                int currentNum = nums[i];
                subArrayQ.offer(currentNum);
                currentSum += currentNum;
                while(currentSum >= requiredSum){
                    minLen_SubAray = Math.min(minLen_SubAray, subArrayQ.size());
                    currentSum -= subArrayQ.poll();
                }
            }

            return minLen_SubAray == Integer.MAX_VALUE ? 0 : minLen_SubAray;

        }
}

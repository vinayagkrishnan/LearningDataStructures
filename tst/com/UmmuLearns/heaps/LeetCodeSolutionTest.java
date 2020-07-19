package com.UmmuLearns.heaps;

import org.junit.jupiter.api.Test;

import java.util.List;

class LeetCodeSolutionTest {

    @Test
    void kSmallestPairs() {

        int[] nums1 = new int[]{1,1,2};
        int[] nums2 = new int[]{1,2,3};

        LeetCodeSolution runner = new LeetCodeSolution();
        List<int[]> result = runner.kSmallestPairs(nums1, nums2, 12);
    }
}
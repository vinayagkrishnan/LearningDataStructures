package com.LeetCodeSolutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SumOfRegionInMatrixTest {

    private SumOfRegionInMatrix obj;
    @BeforeEach
    void setUp() {
        int[][] matrix = new int[][]{{3,0,1,4,2}, {5,6,3,2,1}, {1,2,0,1,5}, {4,1,0,1,7}, {1,0,3,0,5}};
        //int[][] matrix = new int[][]{{-1}};
        obj = new SumOfRegionInMatrix(matrix);
    }

    @Test
    void sumRegion() {
        Assertions.assertEquals(8,obj.sumRegion(2,1,4,3));
        Assertions.assertEquals(11,obj.sumRegion(1,1,2,2));
        Assertions.assertEquals(12,obj.sumRegion(1,2,2,4));
       // Assertions.assertEquals(-1,obj.sumRegion(1,2,2,4));
    }
}
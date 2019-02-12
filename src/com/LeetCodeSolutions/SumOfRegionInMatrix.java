package com.LeetCodeSolutions;

/**
 * 304. Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined
 * by its upper left corner (row1, col1) and lower right corner (row2, col2).
 *
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class SumOfRegionInMatrix {

    private int[][] calculatedSumMatrix;

    /**
     * Constructor to initialize the matrix
     * Since it is given that the matrix will not change and the sumRegion function
     * will be called multiple times, it is optimal to calculate a sum matrix from the given matrix initially
     * and quickly access the sums each time the sumRegion method is called
     *
     * @param matrix - given matrix
     */
    public SumOfRegionInMatrix(int[][] matrix) {
        this.calculatedSumMatrix = matrix;
        initMatrix();
    }

    /**
     * This function transforms the calculatedSumMatrix such that the
     * value at any index (i,j) = sum of all elements from origin (0,0) to (i,j) so that :
     *      +-----+-+-------+     +--------+-----+     +-----+---------+     +-----+--------+
            |     | |       |     |        |     |     |     |         |     |     |        |
            +-----+-+       |     +--------+     |     |     |         |     +-----+        |
            |     | |       |  =  |              |  +  |     |         |  -  |              |
            +-----+-+       |     |              |     +-----+         |     |              |
            |               |     |              |     |               |     |              |
            +---------------+     +--------------+     +---------------+     +--------------+
     *          sum[i][j]      =    sum[i-1][j]     +     sum[i][j-1]     -     sum[i-1][j-1]   + matrix[i][j]
     */
    private void initMatrix(){

        if(calculatedSumMatrix == null || calculatedSumMatrix.length == 0 || calculatedSumMatrix[0].length == 0){
            return;
        }

        int totalRows = calculatedSumMatrix.length;
        int totalColumns = calculatedSumMatrix[0].length;
        for(int i = 0; i < totalRows; i++){
            for(int j = 0; j < totalColumns; j++){
                calculatedSumMatrix[i][j] += ((i > 0) ? calculatedSumMatrix[i-1][j] : 0) +
                        ((j > 0) ? calculatedSumMatrix[i][j-1] : 0) -
                        ((i > 0 && j > 0) ? calculatedSumMatrix[i-1][j-1] : 0);
            }
        }
    }

    /**
     * Returns sum of elements in matrix from index [row1,col1] to [row2,col2]
     * Internally uses the calculatedSumMatrix and gets the required sum by the area principle :
     *
     * +---------------+   +--------------+   +---------------+   +--------------+   +--------------+
       |               |   |         |    |   |   |           |   |         |    |   |   |          |
       |   (r1,c1)     |   |         |    |   |   |           |   |         |    |   |   |          |
       |   +------+    |   |         |    |   |   |           |   +---------+    |   +---+          |
       |   |      |    | = |         |    | - |   |           | - |      (r1,c2) | + |   (r1,c1)    |
       |   |      |    |   |         |    |   |   |           |   |              |   |              |
       |   +------+    |   +---------+    |   +---+           |   |              |   |              |
       |        (r2,c2)|   |       (r2,c2)|   |   (r2,c1)     |   |              |   |              |
       +---------------+   +--------------+   +---------------+   +--------------+   +--------------+
     *
     * @param row1 - upper left corner row
     * @param col1 - upper left corner column
     * @param row2 - lower right corner row
     * @param col2 - lower right corner column
     * @return int sum of rectangle described by the two diagonal corners (row1,col1) and (row2,col2)
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {

        if(row1 < 0 || row1 > calculatedSumMatrix.length -1 || row2 < 0 || row2 > calculatedSumMatrix.length - 1
                || col1 < 0 || col1 > calculatedSumMatrix[0].length -1 || col2 < 0 || col2 > calculatedSumMatrix[0].length -1){
            return -1;
        }

        return ((calculatedSumMatrix[row2][col2]) -
                ((row1 > 0) ? calculatedSumMatrix[row1-1][col2] : 0) -
                ((col1 > 0) ? calculatedSumMatrix[row2][col1-1] : 0) +
                ((row1 > 0 && col1 > 0) ? calculatedSumMatrix[row1-1][col1-1] : 0));

    }

/**
 * Your SumOfRegionInMatrix object will be instantiated and called as such:
 * SumOfRegionInMatrix obj = new SumOfRegionInMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
}

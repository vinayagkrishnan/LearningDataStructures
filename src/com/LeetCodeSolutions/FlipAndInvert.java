package com.LeetCodeSolutions;

/**
 * Q832. To flip an image horizontally means that each row of the image is reversed.
 *      For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
 *      For example, inverting [0, 1, 1] results in [1, 0, 0].
 */
public class FlipAndInvert {
    /**
     * Given a binary matrix A, this function flips the image horizontally,
     * then inverts it, and returns the resulting image.
     * @param A - given 2D matrix
     * @return - Flipped and inverted 2D matrix
     */
    public int[][] flipAndInvertImage(int[][] A) {

        if(A == null || A.length == 0){
            return A;
        }
        int len = A.length;
        for(int[] row : A){
            for(int j = 0; j*2 < len; j++){
                if(row[j] == row[len-1-j]){
                    row[j] ^= 1;
                    row[len-j-1] = row[j];
                }
            }
        }
        return A;
    }
}

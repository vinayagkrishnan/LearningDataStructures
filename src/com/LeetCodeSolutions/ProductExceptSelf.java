package com.LeetCodeSolutions;

public class ProductExceptSelf {

    /**
     * 238. Function finds the product of array elements such that output[i] = product of all the elements of nums except nums[i]
     *
     * For any element at index i, the result is
     *    product of all elements to the left of the ith element *
     *    product of all elements to the right of the ith element
     * Here we use 2 arrays to keep track of the 'product so far' when traversing the given array from left to right
     *    as well as from right to left.
     * The expected result is just the product of these two arrays
     * This function gives an O(n) time and O(n) space solution
     *
     **/
    public int[] productExceptSelf(final int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        int[] productArray_LeftToRight = new int[size];
        int[] productArray_RightToLeft = new int[size];

        // For the first element, the product so far is just 1
        // For subsequent elements, it becomes previous element * product so far
        for(int i=0; i<size; i++){
            productArray_LeftToRight[i] = (i == 0) ? 1 : productArray_LeftToRight[i-1] * nums[i-1];
        }

        // For the rightmost element, the product so far is just 1
        // For subsequent elements, it becomes previous element * product so far
        for(int i=size-1; i>=0; i--){
            productArray_RightToLeft[i] = (i == size-1) ? 1 : productArray_RightToLeft[i+1] * nums[i+1];
        }

        //result at index i = product of all elements to the left * product of all elements in the right
        for(int i=0; i<size; i++){
            result[i] = productArray_LeftToRight[i] * productArray_RightToLeft[i];
        }
        return result;
        //return productExceptSelfInO1(nums);
    }

    /**
     * Above function with O(n) time and O(1) extra space complexity
     **/
    private int[] productExceptSelfInO1(final int[] nums){
        int size = nums.length;
        int[] result = new int[size];

        for(int i=0; i<size; i++){
            result[i] = (i == 0) ? 1 : result[i-1] * nums[i-1];
        }

        //Eliminating the extra space taken up by the product arrays in the above function and directly
        //  computing result array to achieve O(1) extra space (On top of the result array)
        int productSoFar_Right = 1;
        for(int i=size-1; i>=0; i--){
            result[i] *=  productSoFar_Right;
            productSoFar_Right *= nums[i];
        }
        return result;

    }


}

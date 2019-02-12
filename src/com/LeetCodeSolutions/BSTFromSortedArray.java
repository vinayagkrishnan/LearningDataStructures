package com.LeetCodeSolutions;

/**
 * Given an array where elements are sorted in ascending order, c
 * onvert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BSTFromSortedArray {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {

            if(nums == null || nums.length == 0){
                return null;
            }

            return getBST(nums, 0, nums.length - 1);
        }

        private TreeNode getBST(int[] base, int range_Lower, int range_Upper){

            if(range_Lower > range_Upper){
                return null;    //null node when called from a node without child
            }

            int range_Mid = range_Lower + (range_Upper - range_Lower)/2;
            TreeNode root = new TreeNode(base[range_Mid]);
            root.left = getBST(base, range_Lower, range_Mid-1);
            root.right = getBST(base, range_Mid+1, range_Upper);

            return root;
        }
    }
}

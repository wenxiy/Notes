package com.company;

/**
 * Given two integer arrays nums1 and nums2,
 * return an array of their intersection.
 * Each element in the result must be unique and you may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 */
class Solution {
    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] res = new int[Math.max(nums1.length,nums2.length)];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0;j < nums2.length; j++) {

                int d1 = nums1[i];
                int d2 = nums2[j];
                int out = d1 ^ d2;
                if (d2 != 0) {
                    int flag = 0;
                    for (int k = 0; k < res.length; k++) {
                        if (res[k] != nums1[i]) {
                            res[i] = nums1[i];
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
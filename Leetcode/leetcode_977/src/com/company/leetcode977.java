package com.company;

/**
 *
 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 输入: [0,1,3]
 输出: 2
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    /**
     * 方法一：对数组下标进行遍历，如果nums[i]!=i那么就是i这个数少了 排除0的情况
     * 方法二：二分查找：如果nums【mid】不等于mid，证明这个数在左半边，反之右半边，所以由一下程序
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums){
        int i = 0,j=nums.length-1;
        while (i<=j){
            int mid = (i+j)/2;
            if (nums[mid] == mid) i=mid+1;
            else j=mid-1;
        }
        return i;
    }
}

package com.company;

/**
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 * 其实这个题不是我想出来的，一个hard难度我感觉对于我来说还是有些难度，但是还是可以来说一下思路
 * 思路：就是是一个指针问题，先找最大值较小的一端，从该端向中间移动，
 * 遇到的每个height[i]都会被另一端（因为较大）接住。因此只需要考虑较小端能达到多少高度，
 * 就可以得到接的水的量。
 */

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
    public int trap(int[] height) {
        if(height.length < 3) return 0;

        int left = 0, right = height.length - 1;
        int leftmax = height[left], rightmax = height[right];
        int res = 0;

        while(left < right){
            if(leftmax < rightmax){
                res += leftmax - height[left++];
                leftmax = Math.max(height[left], leftmax);
            }else{
                res += rightmax - height[right--];
                rightmax = Math.max(height[right], rightmax);
            }
        }

        return res;
    }
}

package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * 输入：[3,2]
 * 输出：-1
 * 思路：这个题其实可以有两个思路，一个是开辟空间的思路，一个是不用开辟空间的思路。
 * 开辟空间来说，我们可以直接利用hashmap来进行放入，最后get来统计
 * 不开辟空间来说，我们可以利用摩尔投票发来进行（当然我也是现学，只会用hashmap这种来进行.....
 */
public class Main {

    public static void main(String[] args) {
        // write your code here

    }

    public int majorityElement(int[] nums) {
        // 投票算法
        int temp = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == temp) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                temp = nums[i];
                count = 1;
            }
        }

        // 验证是否满足要求
        int t = nums.length / 2 + 1;
        count = 0;
        for (int num : nums) {
            if (num == temp) count++;
            if (count == t) return temp;
        }
        return -1;
    }
}

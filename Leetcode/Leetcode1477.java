package com.company;

import java.util.Arrays;

/**
 * 给你一个整数数组 arr 和一个整数值 target 。
 *
 * 请你在 arr 中找 两个互不重叠的子数组 且它们的和都等于 target 。可
 * 能会有多种方案，请你返回满足要求的两个子数组长度和的 最小值 。
 *
 * 请返回满足要求的最小长度和，如果无法找到这样的两个子数组，请返回 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode1477 {
    class Solution {
        public int minSumOfLengths(int[] arr, int target) {
            int n = arr.length;
            int[] dp = new int[n];
            // 注意不能设置为最大值，因为相加会溢出
            Arrays.fill(dp, Integer.MAX_VALUE / 2);

            int ans = Integer.MAX_VALUE;
            for(int i = 0, j = 0, sum = 0; j < n; j++){
                sum += arr[j];
                while(i <= j && sum > target){
                    sum -= arr[i++];
                }
                // 找到满足条件的一个区间
                if(sum == target){
                    dp[j] = j - i + 1;
                    if(i != 0){
                        ans = Math.min(ans, dp[i-1] + j - i + 1);
                    }
                }
                if(j != 0)
                    dp[j] = Math.min(dp[j], dp[j-1]);
            }

            return ans > arr.length ? -1 : ans;
        }
    }
}

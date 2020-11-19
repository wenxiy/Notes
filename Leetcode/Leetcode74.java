package com.company;

/**
 * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode74 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            if (m == 0) return false;
            int n = matrix[0].length;

            // 二分查找
            int left = 0, right = m * n - 1;
            int pivotIdx, pivotElement;
            while (left <= right) {
                pivotIdx = (left + right) / 2;
                pivotElement = matrix[pivotIdx / n][pivotIdx % n];
                if (target == pivotElement) return true;
                else {
                    if (target < pivotElement) right = pivotIdx - 1;
                    else left = pivotIdx + 1;
                }
            }
            return false;
        }
    }
}

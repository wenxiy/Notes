package com.company;

/**
 * 请你实现一个类 SubrectangleQueries ，它的构造函数的参数是一个 rows x cols 
 * 的矩形（这里用整数矩阵表示），并支持以下两种操作：
 *
 * 1. updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
 *
 * 用 newValue 更新以 (row1,col1) 为左上角且以 (row2,col2) 为
 * 右下角的子矩形。
 * 2. getValue(int row, int col)
 *
 * 返回矩形中坐标 (row,col) 的当前值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subrectangle-queries
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode1476 {
    class SubrectangleQueries {

        private int[][] rec = null;
        public SubrectangleQueries(int[][] rectangle) {
            this.rec = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            if(rec != null){
                for(int i = row1; i <= row2; ++ i){
                    for(int j = col1; j <= col2; ++ j){
                        rec[i][j] = newValue;
                    }
                }
            }
        }

        public int getValue(int row, int col) {
            if(rec != null){
                return rec[row][col];
            }
            return -1;
        }
    }

}

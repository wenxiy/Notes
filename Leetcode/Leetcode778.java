package com.company;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度
 * 。
 *
 * 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。
 * 你可以从一个平台游向四周相邻的任意一个平台，
 * 但是前提是此时水位必须同时淹没这两个平台。假定你可以瞬间移动无限距离，
 * 也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
 *
 * 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swim-in-rising-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode778 {
    class Solution {
        public int swimInWater(int[][] grid) {
            int N = grid.length;
            Set<Integer> seen = new HashSet();
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>((k1, k2) ->
                    grid[k1 / N][k1 % N] - grid[k2 / N][k2 % N]);
            pq.offer(0);
            int ans = 0;

            int[] dr = new int[]{1, -1, 0, 0};
            int[] dc = new int[]{0, 0, 1, -1};

            while (!pq.isEmpty()) {
                int k = pq.poll();
                int r = k / N, c = k % N;
                ans = Math.max(ans, grid[r][c]);
                if (r == N-1 && c == N-1) return ans;

                for (int i = 0; i < 4; ++i) {
                    int cr = r + dr[i], cc = c + dc[i];
                    int ck = cr * N + cc;
                    if (0 <= cr && cr < N && 0 <= cc && cc < N && !seen.contains(ck)) {
                        pq.offer(ck);
                        seen.add(ck);
                    }
                }
            }

            throw null;
        }
    }
}

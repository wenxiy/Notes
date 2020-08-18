package com.company;
class Solution {
	private int a;
	public double findMedianSortedArrays(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		int len = m + n;
		int left = -1, right = -1;
		int aStart = 0, bStart = 0;
		for (int i = 0; i <= len / 2; i++) {
			left = right;
			if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
				right = A[aStart++];
			} else {
				right = B[bStart++];
			}
		}
		if ((len & 1) == 0)
			return (left + right) / 2.0;
		else
			return right;
	}
	public Solution(int a){
		this.a=a;

	}
}
public class Main {
	public static void main(String[] args) {
    	int A[]=new int[]{1,2};
    	int B[]=new int[]{3,4};
    	Solution a=new Solution(1);
    	System.out.println(a.findMedianSortedArrays(A,B));
        // write your code here
    }
}


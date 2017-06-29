package com.chentianran;

/**
 * Created by Tianran on 6/28/2017.
 */
public class LC566ReshapTheMatrix {
	public int[][] matrixReshap(int[][] nums, int r, int c) {
		int rows = nums.length;
		int cols = nums[0].length;

		if(rows * cols != r * c) {
			return nums;
		}
		int curR = 0;
		int curC = 0;
		int[][] res = new int[r][c];
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				res[i][j] = nums[curR][curC];
				if(curC == cols) {
					curC = 0;
					curR++;
				}
			}
		}
		return res;
	}
}

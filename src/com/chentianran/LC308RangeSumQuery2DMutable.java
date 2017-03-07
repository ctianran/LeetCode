package com.chentianran;

/**
 * Created by Tianran on 3/5/2017.
 */
public class LC308RangeSumQuery2DMutable {
	private int[][] matrix;
	private int[][] pre;
	public LC308RangeSumQuery2DMutable(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		this.matrix = matrix;
		int rows = matrix.length;
		int cols = matrix[0].length;
		pre = new int[rows + 1][cols];
		for(int i = 1; i <= rows; i++) {
			for(int j = 0; j < cols; j++) {
				pre[i][j] = pre[i-1][j] + matrix[i-1][j];
			}
		}
	}

	public void update(int row, int col, int val) {
		matrix[row][col] = val;
		for(int i = row; i < matrix.length; i++) {
			pre[i + 1][col] = pre[i][col] + matrix[i][col];
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int sum = 0;
		for(int j = col1; j <= col2; j++) {
			sum += pre[row2 + 1][j] - pre[row1][j];
		}
		return sum;
	}
}

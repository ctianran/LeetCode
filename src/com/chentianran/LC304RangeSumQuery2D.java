package com.chentianran;

/**
 * Created by Tianran on 2/19/2017.
 */
public class LC304RangeSumQuery2D {
	public int sumRegion(int[][] matrix, int row1, int col1, int row2, int col2) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] subSum = new int[rows + 1][cols + 1];
		for(int i = 1; i <= rows; i++) {
			for(int j = 1; j <= cols; j++) {
				subSum[i][j] = subSum[i-1][j] + subSum[i][j-1] - subSum[i-1][j-1] + matrix[i-1][j-1];
			}
		}
		return subSum[row2 + 1][col2 + 1] - subSum[row1][col2 + 1] - subSum[row2 + 1][col1] + subSum[row1][col1];
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] {{3, 0, 1, 4, 2},
					                      	{5, 6, 3, 2, 1},
						                      {1, 2, 0, 1, 5},
					                      	{4, 1, 0, 1, 7},
						                      {1, 0, 3, 0, 5}};

		LC304RangeSumQuery2D sol = new LC304RangeSumQuery2D();
		int res = sol.sumRegion(matrix, 1, 2, 2, 4);
		System.out.println(res);
	}
}

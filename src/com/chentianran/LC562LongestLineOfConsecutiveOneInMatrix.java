package com.chentianran;

/**
 * Created by Tianran on 7/15/2017.
 */
public class LC562LongestLineOfConsecutiveOneInMatrix {
	public int longestLine(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][][] dp = new int[rows][cols][4];
		int res = 0;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if (matrix[i][j] == 1) {
					for(int k = 0; k < 4; k++) {
						dp[i][j][k] = 1;
					}
					if(j > 0) {
						dp[i][j][0] += dp[i][j-1][0];
					}
					if(j > 0 && i > 0) {
						dp[i][j][1] += dp[i-1][j-1][1];
					}
					if(i > 0) {
						dp[i][j][2] += dp[i-1][j][2];
					}
					if(i > 0 && j < cols) {
						dp[i][j][3] += dp[i-1][j+1][3];
					}
				}
				res = Math.max(res, Math.max(dp[i][j][0], dp[i][j][1]));
				res = Math.max(res, Math.max(dp[i][j][2], dp[i][j][3]));
			}
		}
		return res;
	}
}

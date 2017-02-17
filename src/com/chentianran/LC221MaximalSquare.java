package com.chentianran;

/**
 * Created by Tianran on 2/16/2017.
 */
public class LC221MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if(matrix == null || matrix.length == 0) {
			return 0;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] dp = new int[rows + 1][cols + 1];
		int longest = 0;
		for(int i = 1; i <= rows; i++) {
			for(int j = 1; j <= cols; j++) {
				if(matrix[i-1][j-1] == '0') {
					dp[i][j] = 0;
				} else {
					dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
				}
				longest = Math.max(longest, dp[i][j]);
			}
		}
		return longest * longest;
	}

	public static void main(String[] args) {
		char[][] input = new char[][] {{'1', '0','1','0','0'},
						                       {'1', '0','1','1','1'},
						                       {'1', '0','1','1','1'},
						                       {'1', '0','0','1','0'}};
		LC221MaximalSquare sol = new LC221MaximalSquare();
		int res = sol.maximalSquare(input);
		System.out.println(res);
	}
}

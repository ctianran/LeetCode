package com.chentianran;

/**
 * Created by Tianran on 6/14/2017.
 */
public class LC329LongestIncreasingPathInAMatrix {
	public static int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	public int longestIncreasingPath(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;

		int[][] cache = new int[rows][cols];
		int res = 0;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				int len = dfs(i, j, matrix, cache);
				res = Math.max(res, len);
			}
		}
		return res;
	}

	private int dfs(int x, int y, int[][] matrix, int[][] cache) {
		if(cache[x][y] != 0) {
			return cache[x][y];
		}
		int max = 1;
		for(int[] dir : DIRS) {
				int newX = x + dir[0];
				int newY = y + dir[1];

				if(newX < 0 || newX >= matrix.length || newY < 0 || newY >= matrix[0].length || matrix[newX][newY] <= matrix[x][y]) {
					continue;
				}
				int len = 1 + dfs(newX, newY, matrix, cache);
				max = Math.max(max, len);
		}
		cache[x][y] = max;
		return max;
	}
}

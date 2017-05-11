package com.chentianran;

/**
 * Created by Tianran on 5/9/2017.
 */
public class LC200NumberOfIslands {
	private final static int[][] DIR = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			 return 0;
		}
		int rows = grid.length;
		int cols = grid[0].length;

		boolean[][] visited = new boolean[rows][cols];
		int result = 0;

		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(!visited[i][j] && grid[i][j] == '1') {
					result++;
					helper(i, j, grid, visited);
				}
			}
		}
		return result;
	}

	private void helper(int x, int y, char[][] grid, boolean[][] visited) {
		visited[x][y] = true;

		for(int i = 0; i < 4; i++) {
			int newX = x + DIR[i][0];
			int newY = y + DIR[i][1];
			if(newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length ||
							visited[newX][newY]) {
				continue;
			}
			if(grid[newX][newY] == '1') {
				helper(newX, newY, grid, visited);
			}
		}
	}

}

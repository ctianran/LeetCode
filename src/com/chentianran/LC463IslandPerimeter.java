package com.chentianran;

/**
 * Created by Tianran on 5/9/2017.
 */
public class LC463IslandPerimeter {
	public int islandPerimeter(int[][] grid) {
			if(grid == null || grid.length == 0 || grid[0].length == 0) {
				return 0;
			}
			int island = 0;
			int neighbor = 0;
			int rows = grid.length;
			int cols = grid[0].length;

			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					if(grid[i][j] == 1) {
						island++;
						if(i < rows - 1 && grid[i+1][j] == 1) {
							neighbor++;
						}
						if(j < cols - 1 && grid[i][j+1] == 1) {
							neighbor++;
						}
					}
				}
			}
			return island * 4 - neighbor * 2;
	}
}

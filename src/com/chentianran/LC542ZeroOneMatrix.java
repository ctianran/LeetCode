package com.chentianran;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Tianran on 6/14/2017.
 */
public class LC542ZeroOneMatrix {
	class Cell {
		int x;
		int y;
		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int[][] updateMatrix(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return matrix;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		Queue<Cell> queue = new LinkedList<>();
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(matrix[i][j] == 0) {
					queue.offer(new Cell(i, j));
				} else {
					matrix[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		while(!queue.isEmpty()) {
			Cell cur = queue.poll();
			for(int[] dir : dirs) {
				int newX = cur.x + dir[0];
				int newY = cur.y + dir[1];
				if(newX < 0 || newX >= rows || newY < 0 || newY >= cols || matrix[newX][newY] <= matrix[cur.x][cur.y] + 1) {
					continue;
				}
				queue.offer(new Cell(newX, newY));
				matrix[newX][newY] = matrix[cur.x][cur.y] + 1;
			}
		}
		return matrix;
	}
}

package com.chentianran;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Tianran on 7/16/2017.
 */
public class LC85MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		//pre-process the input matrix, to get the longest consecutive one's from top to bottom view
		int[][] helper = new int[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(matrix[i][j] == '1') {
					helper[i][j] = 1;
					if(i > 0) {
						helper[i][j] += helper[i-1][j];
					}
				}
			}
		}
		//for each row call getLargestRec and get the global max
		int res = 0;
		for(int i = 0; i < rows; i++) {
			res = Math.max(res, getLargestRec(helper[i]));
		}
		return res;
	}

	private int getLargestRec(int[] array) {
		if(array == null || array.length == 0) {
			return 0;
		}
		Deque<Integer> stack = new LinkedList<>();
		int res = 0;
		for(int i = 0; i <= array.length; i++) {
			int cur = i == array.length ? 0 : array[i];
			while(!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
					int height = array[stack.pollFirst()];
					int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
					res = Math.max(res, height * (i - left));
			}
			//maintain the stack elements in increasing order
			stack.offerFirst(i);
		}
		return res;
	}
}

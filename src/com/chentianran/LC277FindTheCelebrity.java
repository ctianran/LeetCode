package com.chentianran;

/**
 * Created by Tianran on 2/24/2017.
 */
public class LC277FindTheCelebrity {
	public int findCelebrity(int[][] matrix) {
		if(matrix == null || matrix.length == 0) {
			return -1;
		}
		int i = 0;
		int j = 1;
		while(j < matrix.length) {
			if(matrix[i][j] == 1) {
				i = j;
				j++;
			} else {
				j++;
			}
		}
		for(int k = 0; k < matrix.length; k++) {
			if(i != k) {
				if(matrix[i][k] == 1 || matrix[k][i] == 0) {
					return -1;
				}
			}
		}
		return i;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1, 0, 1},
						                      {0, 1, 1},
						                      {0, 0, 1}};
		LC277FindTheCelebrity sol = new LC277FindTheCelebrity();
		int res = sol.findCelebrity(matrix);
		System.out.println(res);
	}
}

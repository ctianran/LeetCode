package com.chentianran;

/**
 * Created by Tianran on 4/27/2017.
 */
public class LC419BattleshipsInABoard {
	public int countBattleships(char[][] board) {
		if(board.length == 0 || board[0].length == 0) {
			return 0;
		}
		int rows = board.length;
		int cols = board[0].length;
		int count = 0;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(board[i][j] == '.') {
					continue;
				}
				if(i > 0 && board[i-1][j] == 'X') {
					continue;
				}
				if(j > 0 && board[i][j-1] == 'X') {
					continue;
				}
				count++;
			}
		}
		return count;
	}
}

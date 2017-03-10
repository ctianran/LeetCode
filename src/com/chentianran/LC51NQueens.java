package com.chentianran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 3/8/2017.
 */
public class LC51NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> cur = new ArrayList<>();
		helper(n, cur, result);
		return result;
	}

	private void helper(int n, List<String> cur, List<List<String>> result) {
		if (n == cur.size()) {
			result.add(new ArrayList<>(cur));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (valid(i, cur)) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < n; j++) {
					if (j == i) {
						sb.append('Q');
					} else {
						sb.append('.');
					}
				}
				cur.add(sb.toString());
				helper(n, cur, result);
				cur.remove(cur.size() - 1);
			}
		}
	}

	private boolean valid(int col, List<String> cur) {
		int row = cur.size();
		for (int i = 0; i < row; i++) {
			if (cur.get(i).charAt(col) == 'Q' || cur.get(i).charAt(i - col) == 'Q' );
		}
		return false;
	}
}



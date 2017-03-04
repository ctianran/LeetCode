package com.chentianran;

/**
 * Created by Tianran on 3/3/2017.
 */
public class LC248StrobogrammaticNumberIII {
	private static final char[][] PAIRS = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
	public int strobogrammaticInRange(String low, String high) {
		int[] result = new int[1];
		for(int i = low.length(); i <= high.length(); i++) {
			char[] c = new char[i];
			dfs(low, high, c, 0, i - 1, result);
		}
		return result[0];
	}

	private void dfs(String low, String high, char[] c, int left, int right, int[] result) {
		if(left > right) {
			String s = new String(c);
			if((s.length() == low.length() && s.compareTo(low) < 0) ||
							(s.length() == high.length() && s.compareTo(high) > 0)) {
				return;
			}
			result[0]++;
			return;
		}

		for(char[] temp : PAIRS) {
			c[left] = temp[0];
			c[right] = temp[1];
			if(c.length != 1 && c[0] == '0') {
				continue;
			}
			if(left == right && temp[0] != temp[1]) {
				continue;
			}
			dfs(low, high, c, left + 1, right - 1, result);
		}
	}

}

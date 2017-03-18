package com.chentianran;

/**
 * Created by Tianran on 2/15/2017.
 */
public class LC5LongestPalindromicSubString {
	public String longestPalindrome(String s) {
		if(s == null || s.length() == 0) {
			return null;
		}
		if(s.length() == 1) {
			return s;
		}
		int[] start = new int[1];
		int[] length = new int[1];
		for(int i = 0; i < s.length(); i++) {
			helper(s, i, i, start, length);
			helper(s, i, i + 1, start, length);
		}
		return s.substring(start[0], start[0] + length[0]);
	}

	private void helper(String s, int left, int right, int[] start, int[] length) {
		while(left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		if(right - left - 1 > length[0]) {
			length[0] = right - left - 1;
			start[0] = left + 1;
		}
	}

	public String longestPalindromeII(String s) {
		if(s == null || s.isEmpty()) {
			return null;
		}
		if(s.length() == 1) {
			return s;
		}
		boolean[][] dp = new boolean[s.length()][s.length()];
		int resStart = 0;
		int resEnd = 0;
		int longest = 1;
		for(int i = 0; i < s.length(); i++) {
			for(int start = 0; start < s.length() - i; start++) {
				int end = start + i;
				if(s.charAt(start) == s.charAt(end) && (end - start <= 1 || dp[start+ 1][end - 1])) {
					dp[start][end] = true;
					if(longest < end - start + 1) {
						longest = end - start + 1;
						resStart = start;
						resEnd = end;
					}
				}
			}
		}
		return s.substring(resStart, resEnd + 1);
	}

	public static void main(String[] args) {
		String s = "babc";
		LC5LongestPalindromicSubString sol = new LC5LongestPalindromicSubString();
		String res = sol.longestPalindrome(s);
		String res2 = sol.longestPalindromeII(s);
		System.out.println(res);
		System.out.println(res2);
	}
}

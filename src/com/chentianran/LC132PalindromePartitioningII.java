package com.chentianran;

/**
 * Created by Tianran on 3/17/2017.
 */
public class LC132PalindromePartitioningII {
	public int minCuts(String s) {
		if(s == null || s.length() == 0) {
			return -1;
		}
		if(s.length() == 1) {
			return 0;
		}
		int[] dp = new int[s.length() + 1];
		boolean[][] isPal = new boolean[s.length() + 1][s.length() + 1];
		for(int end = 1; end <= s.length(); end++) {
			dp[end] = end;
			for(int start = end; start >= 1; start--) {
				if(s.charAt(start - 1) == s.charAt(end - 1)) {
					if(end - start <= 1) {
						isPal[start][end] = true;
					} else {
						isPal[start][end] = isPal[start + 1][end -1];
					}
					if(isPal[start][end]) {
						dp[end] = Math.min(dp[end], dp[start - 1] + 1);
					}
				}
			}
		}
		return dp[s.length()] - 1;
	}
}

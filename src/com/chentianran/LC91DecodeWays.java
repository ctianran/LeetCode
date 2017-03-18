package com.chentianran;

/**
 * Created by Tianran on 2/26/2017.
 */
public class LC91DecodeWays {
	public int numDecodings(String s) {
		if(s == null || s.length() == 0 || s.charAt(0) == '0') {
			return 0;
		}
		if(s.length() == 1) {
			return 1;
		}
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i <= s.length(); i++) {
			int temp = s.charAt(i - 1) - '0';
			if(temp != 0) {
				dp[i] = dp[i-1];
			}
			if(s.charAt(i - 2) != '0') {
				temp = Integer.parseInt(s.substring(i-2, i));
				if(temp >= 10 && temp <= 26) {
					dp[i] += dp[i-2];
				}
			}
		}
		return dp[s.length()];
	}
}

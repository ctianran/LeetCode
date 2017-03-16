package com.chentianran;

/**
 * Created by Tianran on 3/16/2017.
 */
public class LC70ClimbingStairs {
	public int climbStaris(int n) {
		if(n <= 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 2;
		}
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		return dp[n];
	}

	public int climbStairs(int n) {
		if(n <= 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		int one = 1;
		int two = 2;
		while(n > 2) {
			int temp = one + two;
			one = two;
			two = temp;
			n--;
		}
		return two;
	}
}

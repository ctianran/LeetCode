package com.chentianran;

/**
 * Created by Tianran on 5/9/2017.
 */
public class LC300LongestIncreasingSubsequence {
	public int lengthofLIS(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int res = 1;
		int[] dp = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}
}

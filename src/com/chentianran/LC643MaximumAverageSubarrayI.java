package com.chentianran;

/**
 * Created by Tianran on 8/21/2017.
 */
public class LC643MaximumAverageSubarrayI {
	public double findMaxAverage(int[] nums, int k) {
		int cur = 0;
		for(int i = 0; i < k; i++) {
			cur += nums[i];
		}
		int res = cur;
		for(int i = k; i < nums.length; i++) {
			cur += nums[i];
			cur -= nums[i-k];
			res = Math.max(res, cur);
		}
		return (res - 0.0)/k;
	}
}

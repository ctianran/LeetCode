package com.chentianran;

/**
 * Created by Tianran on 7/4/2017.
 */
public class LC53MaximumSubarray {
	public int maxSubArray(int[] nums) {
		//sanity check
		int res = nums[0];
		int cur = nums[0];
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] + cur > nums[i]) {
				cur += nums[i];
			} else {
				cur = nums[i];
			}
			res = Math.max(res, cur);
		}
		return res;
	}
}



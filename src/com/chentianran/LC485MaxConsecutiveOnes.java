package com.chentianran;

/**
 * Created by Tianran on 6/16/2017.
 */
public class LC485MaxConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int res = 0;
		int cur = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 1) {
				if(i == 0 || nums[i - 1] == 0) {
					cur = 1;
				} else {
					cur++;
				}
			}
			res = Math.max(res, cur);
		}
		return res;
	}
}

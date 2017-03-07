package com.chentianran;

/**
 * Created by Tianran on 3/5/2017.
 */
public class LC238ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		if(nums == null || nums.length == 0) {
			return new int[0];
		}
		int[] result = new int[nums.length];
		result[nums.length - 1] = 1;
		for(int i = nums.length - 2; i >= 0; i--) {
			result[i] = result[i + 1] * nums[i + 1];
		}
		int left = 1;
		for(int i = 0; i < nums.length; i++) {
			result[i] *= left;
			left *= nums[i];
		}
		return result;
	}
}

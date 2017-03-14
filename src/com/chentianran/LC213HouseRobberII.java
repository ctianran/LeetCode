package com.chentianran;

/**
 * Created by Tianran on 3/13/2017.
 */
public class LC213HouseRobberII {
	public int rob(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int num1 = helper(nums, 0, nums.length - 2);
		int num2 = helper(nums, 1, nums.length - 1);
		return Math.max(num1, num2);
	}

	private int helper(int[] nums, int left, int right) {
		int num1 = nums[left];
		int num2 = Math.max(nums[left], nums[left + 1]);
		for(int i = left + 2; i < nums.length; i++) {
			int temp = Math.max(num1 + nums[i], num2);
			num1 = num2;
			num2 = temp;
		}
		return num2;
	}
}

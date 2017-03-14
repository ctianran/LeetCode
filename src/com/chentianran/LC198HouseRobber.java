package com.chentianran;

/**
 * Created by Tianran on 3/13/2017.
 */
public class LC198HouseRobber {
	public int rob(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		if(nums.length == 1) {
			return nums[0];
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for(int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
		}
		return dp[nums.length - 1];
	}

	public int robII(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		if(nums.length == 1) {
			return nums[0];
		}
		int num1 = nums[0];
		int num2 = Math.max(nums[0], nums[1]);

		for(int i = 2; i < nums.length; i++) {
			int temp = Math.max(num1 + nums[i], num2);
			num1 = num2;
			num2 = temp;
		}
		return num2;
	}
}

package com.chentianran;

/**
 * Created by Tianran on 2/11/2017.
 */
public class LC494TargetSum {
	public int findTargetSumWays(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int[] result = new int[1];
		helper(nums, target, 0, 0, result);
		return result[0];
	}

	private void helper(int[] nums, int target, int index, int sum, int[] result) {
		if(index == nums.length) {
			if(sum == target) {
				result[0]++;
			}
			return;
		}
		helper(nums, target, index + 1, sum + nums[index], result);
		helper(nums, target, index + 1, sum - nums[index], result);
	}
}

package com.chentianran;

/**
 * Created by Tianran on 2/23/2017.
 */
public class LC152MaximumProductSubArray {
	//Time: O(n);
	//Space: O(n);
	public int maxProductI(int[] nums) {
		int[] max = new int[nums.length];
		int[] min = new int[nums.length];
		max[0] = nums[0];
		min[0] = nums[0];
		int result = nums[0];
		for(int i = 1; i < nums.length; i++) {
			max[i] = Math.max(nums[i], Math.max(nums[i] * max[i-1], nums[i] * min[i - 1]));
			min[i] = Math.min(nums[i], Math.min(nums[i] * max[i-1], nums[i] * min[i - 1]));
			result = Math.max(result, max[i]);
		}
		return result;
	}

	//Time: O(n)
	//Space: O(1)
	public int maxProductII(int[] nums) {
		int max = nums[0];
		int min = nums[0];
		int result = nums[0];
		for(int i = 1; i < nums.length; i++) {
			int tempMax = max;
			max = Math.max(nums[i], Math.max(nums[i] * tempMax, nums[i] * min));
			min = Math.min(nums[i], Math.min(nums[i] * tempMax, nums[i] * min));
			result = Math.max(result, max);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {2, 3, -2, 4};
		LC152MaximumProductSubArray sol = new LC152MaximumProductSubArray();
		int res = sol.maxProductII(nums);
		System.out.println(res);
	}
}

package com.chentianran;

/**
 * Created by Tianran on 2/19/2017.
 */
public class LC303RangeSumQuery {
	public int sumRange(int[] nums, int i, int j) {
		if(nums == null || nums.length == 0) {
			throw new IllegalArgumentException("invalid input");
		}
		int[] subSum = new int[nums.length];
		subSum[0] = nums[0];
		for(int k = 1; k < nums.length; k++) {
			subSum[k] = subSum[k - 1] + nums[k];
		}
		return subSum[j] - subSum[i] + nums[i];
	}

	public static void main(String[] args) {
		int[] nums = new int[] {-2, 0, 3, -5, 2, -1};
		LC303RangeSumQuery sol = new LC303RangeSumQuery();
		int res = sol.sumRange(nums, 2, 5);
		System.out.println(res);
	}
}

package com.chentianran;

/**
 * Created by Tianran on 6/28/2017.
 */
public class LC581ShortestUnsortedContinuousSubarray {
	public int findUnsortedSubarray(int[] nums) {
		int len = nums.length;

		int end = -2;
		int beg = -1;
		int max = nums[0];
		int min = nums[nums.length - 1];
		for(int i = 1; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[len - 1 - i]);
			if (nums[i] < max) {
				end = i;
			}
			if (nums[len - 1 - i] > min) {
				beg = len - 1 - i;
			}
		}
		return end - beg + 1;
	}
}

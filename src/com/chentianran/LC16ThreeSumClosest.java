package com.chentianran;

import java.util.Arrays;

/**
 * Created by Tianran on 7/5/2017.
 */
public class LC16ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		if(nums == null || nums.length <= 2) {
			throw new IllegalArgumentException("Invalid input");
		}
		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		int res = nums[0] + nums[1] + nums[2];
		for(int i = 0; i < nums.length; i++) {
				int left = i + 1;
				int right = nums.length - 1;
				while(left < right) {
					int sum = nums[i] + nums[left] + nums[right];
					if(sum == target) {
						return sum;
					}
					if(Math.abs(sum - target) < min) {
						min = Math.abs(sum - target);
						res = sum;
					}
					if(sum < target) {
						left++;
					} else {
						right--;
					}
				}
		}
		return res;
	}
}

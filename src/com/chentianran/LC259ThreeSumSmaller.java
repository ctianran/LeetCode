package com.chentianran;

import java.util.Arrays;

/**
 * Created by Tianran on 3/3/2017.
 */
public class LC259ThreeSumSmaller {
	public int threeSumSmaller(int[] nums, int target) {
			if(nums == null || nums.length <= 2) {
				return 0;
			}
			Arrays.sort(nums);
			int result = 0;
			for(int i = 0; i < nums.length - 2; i++) {
				int left= i + 1;
				int right = nums.length - 1;
				while(left < right) {
					int sum = nums[i] + nums[left] + nums[right];
					if(sum < target) {
						result += right - left;
						left++;
					} else {
						right--;
					}
				}
			}
			return result;
	}
}

package com.chentianran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tianran on 7/4/2017.
 */
public class LC15ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length <= 2) {
			return res;
		}
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 2; i++) {
			if(i > 0 && nums[i] == nums[i -1]) {
				continue;
			}
			int left = i + 1;
			int right = nums.length - 1;
			int target = -nums[i];
			while(left < right) {
				if(nums[left] + nums[right] == target) {
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
					while(left < right && nums[left] == nums[left - 1]) {
						left++;
					}
					while(left < right && nums[right] == nums[right + 1]) {
						right--;
					}
				} else if (nums[left] + nums[right] < target) {
					left++;
				} else {
					right--;
				}
			}
		}
		return res;
	}
}

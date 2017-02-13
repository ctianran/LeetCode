package com.chentianran;

/**
 * Created by Tianran on 2/11/2017.
 */
public class LC169MajorityElement {
	public int majorityElement(int[] nums) {
		if(nums == null || nums.length == 0) {
			return -1;
		}
		int candidate = nums[0];
		int count = 1;
		for(int i = 1; i < nums.length; i++) {
			if(count == 0) {
				candidate = nums[i];
				count++;
			} else if (candidate == nums[i]) {
				count++;
			} else {
				count--;
			}
		}
		return candidate;
	}
}

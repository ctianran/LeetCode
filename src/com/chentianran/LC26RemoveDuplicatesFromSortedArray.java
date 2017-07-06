package com.chentianran;

/**
 * Created by Tianran on 7/5/2017.
 */
public class LC26RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int slow = 0;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] == nums[slow]) {
				nums[++slow] = nums[i];
			}
		}
		return slow + 1;
	}
}

package com.chentianran;

/**
 * Created by Tianran on 7/5/2017.
 */
public class LC27RemoveElement {
	public int removeElement(int[] nums, int val) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int slow = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != val) {
				nums[slow++] = nums[i];
			}
		}
		return slow;
	}
}

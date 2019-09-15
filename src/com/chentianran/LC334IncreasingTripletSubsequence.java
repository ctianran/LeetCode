package com.chentianran;

/**
 * Created by Tianran on 9/7/2017.
 */
public class LC334IncreasingTripletSubsequence {
	public boolean increasingTriplet(int[] nums) {
		if(nums == null || nums.length == 0) {
			return false;
		}
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;

		for(int i = 0; i < nums.length; i++) {
			if(nums[i] <= first) {
				first = nums[i];
			} else if(nums[i] <= second) {
				second = nums[i];
			} else {
				return true;
			}
		}
		return false;
	}

}

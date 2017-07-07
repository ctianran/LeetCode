package com.chentianran;

/**
 * Created by Tianran on 7/7/2017.
 */
public class LC35SearchInsertPosition {
	//search for the largest smaller than the target
	public int searchInsert(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if(nums[mid] >= target) {
					right = mid - 1;
			} else {
					left = mid;
			}
		}
		if(target <= nums[left]) {
			return left;
		}
		return target <= nums[right] ? right : right + 1;
	}


}

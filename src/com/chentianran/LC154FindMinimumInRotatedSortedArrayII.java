package com.chentianran;

/**
 * Created by Tianran on 2/24/2017.
 */
public class LC154FindMinimumInRotatedSortedArrayII {
	public int findMin(int[] nums) {
		if(nums == null || nums.length == 0) {
			return -1;
		}
		int left = 0;
		int right= nums.length - 1;
		while(left < right - 1) {
			int mid = left + (right - left) / 2;
			if(nums[mid] == nums[right]) {
				right--;
			} else if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return nums[left] <= nums[right] ? nums[left] : nums[right];
	}
}

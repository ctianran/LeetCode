package com.chentianran;

/**
 * Created by Tianran on 2/24/2017.
 * e.g. {4, 5, 6, 7, 0, 1, 2} -> 0
 */
public class LC153FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		if(nums == null || nums.length == 0) {
			return -1;
		}
		int left = 0;
		int right = nums.length - 1;
		while(left < right - 1) {
			int mid = left + (right - left) / 2;
			if(nums[mid] > nums[right]) {
				left = mid + 1;
			} else if(nums[mid] < nums[right]) {
				right = mid;
			}
		}
		return nums[left] < nums[right] ? nums[left] : nums[right];
	}

	public static void main(String[] args) {
		int[] nums = new int[] {4, 5, 6, 7, 0, 1, 2};
		LC153FindMinimumInRotatedSortedArray sol = new LC153FindMinimumInRotatedSortedArray();
		int res = sol.findMin(nums);
		System.out.println(res);
	}
}

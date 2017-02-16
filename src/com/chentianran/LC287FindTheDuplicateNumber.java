package com.chentianran;

/**
 * Created by Tianran on 2/15/2017.
 */
public class LC287FindTheDuplicateNumber {
	public int findDuplicate(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int left = 1;
		int right = nums.length - 1;
		while(left < right) {
			int mid = left + (right - left) / 2;
			if(countSmallerOrEqual(nums, nums[mid]) <= mid) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

	private int countSmallerOrEqual(int[] nums, int num) {
		int count = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] <= num) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] input = new int[] {1, 2, 2};
		LC287FindTheDuplicateNumber sol = new LC287FindTheDuplicateNumber();
		int res = sol.findDuplicate(input);
		System.out.println(res);
	}
}

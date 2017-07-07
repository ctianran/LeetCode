package com.chentianran;

/**
 * Created by Tianran on 7/7/2017.
 */
public class LC34SearchForARange {
	public int[] searchRange(int[] nums, int target) {
		int[] res = new int[] {-1, -1};
		if(nums == null || nums.length == 0) {
			return res;
		}
		res[0] = firstOccur(nums, target, 0, nums.length -1);
		if(res[0] == -1) {
			return res;
		}
		res[1] = lastOccur(nums, target, res[0], nums.length - 1);
		return res;

	}

	private int firstOccur(int[] nums, int target, int left, int right) {
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if(nums[mid] == target) {
				right = mid;
			} else if(nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		if(nums[left] == target) {
			return left;
		}
		if(nums[right] == target) {
			return right;
		}
		return -1;
	}

	private int lastOccur(int[] nums, int target, int left, int right) {
		while(left < right - 1) {
			int mid = left + (right - left) / 2;
			if(nums[mid] == target) {
				left = mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		if(nums[right] == target) {
			return right;
		}
		if(nums[left] == target) {
			return left;
		}
		return -1;
	}
}

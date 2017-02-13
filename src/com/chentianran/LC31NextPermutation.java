package com.chentianran;

/**
 * Created by Tianran on 2/13/2017.
 */
public class LC31NextPermutation {
	public void nextPermutation(int[] nums) {
		if(nums == null || nums.length <= 1) {
			return;
		}
		int index = nums.length - 2;
		while(index >= 0) {
			if(nums[index] < nums[index + 1]) {
				break;
			}
			index--;
		}
		if(index == -1) {
			reverse(nums, 0, nums.length - 1);
		} else {
			int rightIndex = getSmallestLarger(nums, index + 1, nums.length - 1, nums[index]);
			swap(nums, index, rightIndex);
			reverse(nums, index + 1, nums.length - 1);
		}
		return;
	}

	private int getSmallestLarger(int[] nums, int left, int right, int target) {
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] <= target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}

	private void reverse(int[] nums, int left, int right) {
		while(left < right) {
			swap(nums, left++, right--);
		}
	}

	private void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

	public static void main(String[] args) {
		int[] input = new int[] {1, 2, 3, 2, 1};
		LC31NextPermutation sol = new LC31NextPermutation();
		sol.nextPermutation(input);
		for(int num : input) {
			System.out.print(num + " ");
		}
	}
}

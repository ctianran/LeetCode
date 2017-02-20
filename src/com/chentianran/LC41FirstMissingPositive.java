package com.chentianran;

/**
 * Created by Tianran on 2/19/2017.
 */
public class LC41FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 1;
		}
		for(int i = 0; i < nums.length; i++) {
			while(nums[i] != i + 1 && nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
				swap(nums, i, nums[i] - 1);
			}
		}
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != i + 1) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}

	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {-1, 2, 0};
		LC41FirstMissingPositive sol = new LC41FirstMissingPositive();
		int res = sol.firstMissingPositive(nums);
		System.out.println(res);
	}
}

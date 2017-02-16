package com.chentianran;

/**
 * Created by Tianran on 2/16/2017.
 */
public class LC137SingleNumberII {
	public int singleNumberI(int[] nums) {
		int one = 0;
		int two = 0;
		for(int i = 0; i < nums.length; i++) {
			one = (one ^ nums[i]) & ~two;
			two = (two ^ nums[i]) & ~one;
		}
		return one;
	}

	public int singleNumberII(int[] nums) {
		int result = 0;
		for(int i = 0; i < 32; i++) {
			int sum = 0;
			for(int j = 0; j < nums.length; j++) {
					sum += (nums[j] >> i) & 1;
			}
			result |= (sum % 3) << i;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] input = new int[] {1, 1, 1, 2, 2, 2, 3};
		LC137SingleNumberII sol = new LC137SingleNumberII();
		int res = sol.singleNumberII(input);
		System.out.println(res);
	}
}

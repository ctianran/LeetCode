package com.chentianran;

/**
 * Created by Tianran on 2/16/2017.
 */
public class LC136SingleNumber {
	public int singleNumber(int[] nums) {
		int result = 0;
		for(int num : nums) {
			result ^= num;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] input = new int[] {1, 1, 3, 4, 4, 6, 6};
		LC136SingleNumber sol = new LC136SingleNumber();
		int res = sol.singleNumber(input);
		System.out.println(res);
	}
}



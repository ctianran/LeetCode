package com.chentianran;

/**
 * Created by Tianran on 2/23/2017.
 */
public class LC260SingleNumberIII {
	public int[] singleNumber(int[] nums) {
		if(nums == null || nums.length == 0) {
			return new int[0];
		}
		int[] result = new int[2];
		int temp = 0;
		for(int num : nums) {
			temp ^= num;
		}
		int lastBit = temp - (temp & (temp - 1));
		for(int num : nums) {
			if((num & lastBit) == 0) {
				result[0] ^= num;
			} else {
				result[1] ^= num;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] input = new int[] {1, 1, 2, 3, 4, 4, 5, 5};
		LC260SingleNumberIII sol = new LC260SingleNumberIII();
		int[] res = sol.singleNumber(input);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}
}

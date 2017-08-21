package com.chentianran;

import java.util.Arrays;

/**
 * Created by Tianran on 8/11/2017.
 */
public class LC561ArrayPartitionI {
	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int res = 0;
		for(int i = 0; i < nums.length; i+=2) {
			res += nums[i];
		}
		return res;
	}
}

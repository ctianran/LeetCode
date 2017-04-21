package com.chentianran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tianran on 3/20/2017.
 */
public class LC368LargestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
			List<Integer> result = new ArrayList<>();
			if(nums == null || nums.length == 0) {
				return result;
			}
			Arrays.sort(nums);
			return result;
	}
}

package com.chentianran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 2/25/2017.
 */
public class LC163MissingRanges {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> result = new ArrayList<>();
		long low = (long) lower;
		long high = (long) upper;
		for(int num : nums) {
			long cur = (long) num - 1;
			if(cur == low) {
				result.add(low + "");
			} else if(low < cur) {
				result.add(low + "->" + cur);
			}
			low = (long)num + 1;
		}
		if(low == high) {
			result.add(high + "");
		} else if(low < high) {
			result.add(low + "->" + high);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {0, 1, 3, 50, 75};
		LC163MissingRanges sol = new LC163MissingRanges();
		List<String> res = sol.findMissingRanges(nums, 0, 99);
		System.out.println(res);
	}
}

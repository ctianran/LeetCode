package com.chentianran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 3/3/2017.
 */
public class LC288SummayRanges {
	public List<String> summary(int[] nums) {
		List<String> result = new ArrayList<>();
		for(int i = 0; i < nums.length; i++) {
			int cur = nums[i];
			while(i + 1 < nums.length && (nums[i + 1] - nums[i]) == 1) {
				i++;
			}
			if(cur == nums[i]) {
				result.add(cur + "");
			} else {
				result.add(cur + "->" + nums[i]);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {0, 1, 2, 4, 5, 7};
		LC288SummayRanges sol = new LC288SummayRanges();
		List<String> res = sol.summary(nums);
		System.out.println(res);
	}
}

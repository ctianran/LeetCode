package com.chentianran;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tianran on 3/8/2017.
 */
public class LC217ContainsDuplicate {
	public boolean containsDuplicateI(int[] nums) {
		if(nums == null || nums.length <= 1) {
			return false;
		}
		for(int i = 0; i < nums.length - 1; i++) {
			if(nums[i] == nums[i + 1]) {
				return true;
			}
		}
		return false;
	}

	public boolean containsDuplicateII(int[] nums) {
		if(nums == null || nums.length <= 1) {
			return false;
		}
		Set<Integer> set = new HashSet<>();
		for(int num : nums) {
			if(!set.add(num)) {
				return true;
			}
		}
		return false;
	}
}

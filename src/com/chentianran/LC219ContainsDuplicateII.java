package com.chentianran;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tianran on 8/25/2017.
 */
public class LC219ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < nums.length; i++) {
			if(i > k) {
				set.remove(nums[i - k - 1]);
			}
			if(!set.add(nums[i])) {
				return true;
			}
		}
		return false;
	}
}

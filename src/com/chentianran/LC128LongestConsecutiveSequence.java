package com.chentianran;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tianran on 7/15/2017.
 */
public class LC128LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}

		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		int res = 1;
		for(int i = 0; i < nums.length; i++) {
				int left = nums[i] - 1;
				int right = nums[i] + 1;
				int count = 1;
				while(set.contains(left)) {
					count++;
					set.remove(left);
					left--;
				}
				while(set.contains(right)) {
					count++;
					set.remove(right);
					right++;
				}
				res = Math.max(res, count);
		}
		return res;
	}
}

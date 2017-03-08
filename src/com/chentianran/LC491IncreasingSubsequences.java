package com.chentianran;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tianran on 3/8/2017.
 */
public class LC491IncreasingSubsequences {
	public List<List<Integer>> findSubsequences(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length <= 1) {
			return result;
		}
		List<Integer> cur = new ArrayList<>();
		helper(nums, 0, cur, result);
		return result;
	}

	private void helper(int[] nums, int index, List<Integer> cur, List<List<Integer>> result) {
		if(cur.size() >= 2) {
			result.add(new ArrayList<>(cur));
		}
		Set<Integer> set = new HashSet<>();
		for(int i = index; i < nums.length; i++) {
			if(set.add(nums[i]) && (cur.size() == 0 || cur.get(cur.size() - 1) <= nums[i])) {
				cur.add(nums[i]);
				helper(nums, i + 1, cur, result);
				cur.remove(cur.size() - 1);
			}
		}
	}
}

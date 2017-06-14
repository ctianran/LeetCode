package com.chentianran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tianran on 6/11/2017.
 */
public class LC90SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0) {
			return res;
		}
		Arrays.sort(nums);
		List<Integer> cur = new ArrayList<>();
		helper(nums, 0, cur, res);
		return res;
	}

	private void helper(int[] nums, int index, List<Integer> cur, List<List<Integer>> res) {
		if(index == nums.length) {
			res.add(new ArrayList<Integer>(cur));
			return;
		}

		cur.add(nums[index]);
		helper(nums, index + 1, cur, res);
		cur.remove(cur.size() - 1);

		while(index + 1 < nums.length && nums[index] == nums[index + 1]) {
			index++;
		}

		helper(nums, index + 1, cur, res);
	}
}

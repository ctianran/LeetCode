package com.chentianran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 6/11/2017.
 */
public class LC78Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0) {
			return res;
		}
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

		helper(nums, index + 1, cur, res);
	}

	public static void main(String[] args) {
		int[] nums = new int[] {1, 2, 3};
		LC78Subsets sol = new LC78Subsets();
		List<List<Integer>> res = sol.subsets(nums);

		System.out.println(res);
	}
}

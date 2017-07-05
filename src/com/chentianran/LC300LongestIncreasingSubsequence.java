package com.chentianran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 5/9/2017.
 */
public class LC300LongestIncreasingSubsequence {
	public int lengthofLIS(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int res = 1;
		int[] dp = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}

	public int lengthofLISdfs(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		List<Integer> path = new ArrayList<>();
		int[] res = new int[1];
		path.add(nums[nums.length - 1]);
		dfsHelper(nums, nums.length - 1, path, res);
		path.remove(path.size() - 1);
		return res[0];
	}

	private void dfsHelper(int[] nums, int index, List<Integer> path, int[] res) {
		res[0] = Math.max(res[0], path.size());
		for(int i = index - 1; i >= 0; i--) {
			if(nums[i] < nums[index]) {
				path.add(nums[i]);
				dfsHelper(nums, i, path, res);
				path.remove(path.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] {10, 9, 2, 5, 3, 7, 101, 18};
		LC300LongestIncreasingSubsequence sol = new LC300LongestIncreasingSubsequence();
		int res = sol.lengthofLIS(nums);
		int res1 = sol.lengthofLISdfs(nums);
		System.out.println(res);
		System.out.println(res1);
	}
}

package com.chentianran;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 2/13/2017.
 */
public class LC1TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[] {-1, -1};
		if(nums == null || nums.length <= 1) {
			return result;
		}
		Map<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if(map.containsKey(target - num)) {
				result[0] = map.get(target - num);
				result[1] = i;
				return result;
			} else {
				map.put(nums[i], i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] input = new int[] {2, 7, 11, 15};
		LC1TwoSum sol = new LC1TwoSum();
		int[] res = sol.twoSum(input, 22);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}
}

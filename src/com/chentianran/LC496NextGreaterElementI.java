package com.chentianran;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Tianran on 2/17/2017.
 */
public class LC496NextGreaterElementI {
	public int[] nextGreaterElement(int[] findNums, int[] nums) {
		if(nums == null || nums.length == 0) {
			return nums;
		}
		Deque<Integer> stack = new LinkedList<>();
		Map<Integer, Integer> map = new HashMap<>();
		int i = 0;
		while(i < nums.length) {
			if(stack.isEmpty() || nums[i] <= stack.peekFirst()) {
				stack.offerFirst(nums[i++]);
			} else {
				map.put(stack.pollFirst(), nums[i]);
			}
		}

		int[] result = new int[findNums.length];
		for(int j = 0; j < findNums.length; j++) {
			if(map.containsKey(findNums[j])) {
				result[j] = map.get(findNums[j]);
			} else {
				result[j] = -1;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {1, 3, 4, 2};
		int[] findNums = new int[] {4, 1, 2};

		LC496NextGreaterElementI sol = new LC496NextGreaterElementI();
		int[] res = sol.nextGreaterElement(findNums, nums);
		for(int n : res) {
			System.out.print(n + " ");
		}
	}
}

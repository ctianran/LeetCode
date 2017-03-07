package com.chentianran;

import java.util.*;

/**
 * Created by Tianran on 2/17/2017.
 */
public class LC496NextGreaterElementI {
	public int[] nextGreaterElementI(int[] findNums, int[] nums) {
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

	public int[] nextGreaterElementII(int[] nums) {
		if(nums == null || nums.length == 0) {
				return nums;
		}
		int[] result = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			result[i] = -1;
			for(int j = i; j < nums.length; j++) {
				if(nums[j] > nums[i]) {
					result[i] = nums[j];
					break;
				}
			}
		}
		return result;
	}

	public int[] nextGreaterElementIII(int[] nums) {
		if(nums == null || nums.length == 0) {
			return nums;
		}
		int[] result = new int[nums.length];
		Arrays.fill(result, -1);
		Deque<Integer> stack = new LinkedList<>();
		for(int i = 0; i < nums.length; i++) {
			while(!stack.isEmpty() && nums[i] > nums[stack.peekFirst()]) {
				result[stack.pollFirst()] = nums[i];
			}
			stack.offerFirst(i);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {1, 3, 4, 2};
		int[] findNums = new int[] {4, 1, 2};

		LC496NextGreaterElementI sol = new LC496NextGreaterElementI();
		int[] res = sol.nextGreaterElementI(findNums, nums);
		int[] res2 = sol.nextGreaterElementII(nums);
		int[] res3 = sol.nextGreaterElementIII(nums);
		for(int n : res) {
			System.out.print(n + " ");
		}
		System.out.println();
		for(int n : res2) {
			System.out.print(n + " ");
		}
		System.out.println();
		for(int n : res3) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
}

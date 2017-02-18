package com.chentianran;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Tianran on 2/17/2017.
 */
public class LC503NextGreaterElementII {
	public int[] nextGreaterElements(int[] nums) {
		if(nums == null || nums.length == 0) {
			return nums;
		}
		Deque<Integer> stack = new LinkedList<>();
		int[] result = new int[nums.length];
		Arrays.fill(result, -1);
		for(int i = 0; i < nums.length * 2; i++) {
			int num = nums[i % nums.length];
			while(!stack.isEmpty() && nums[stack.peekFirst()] < num) {
					result[stack.pollFirst()] = num;
			}
			if(i < nums.length) {
				stack.offerFirst(i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] input = new int[] {1, 2, 1};
		LC503NextGreaterElementII sol = new LC503NextGreaterElementII();
		int[] res = sol.nextGreaterElements(input);

		for(int n : res) {
			System.out.print(n + " ");
		}
	}
}

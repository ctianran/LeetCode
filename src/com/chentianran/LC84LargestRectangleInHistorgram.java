package com.chentianran;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Tianran on 7/15/2017.
 */
public class LC84LargestRectangleInHistorgram {
	//Time: O(n^2)
	public int largestRectangleArea(int[] heights) {
		if(heights == null || heights.length == 0) {
			return 0;
		}
		int res = 0;
		for(int i = 0; i < heights.length; i++) {
			int height = heights[i];
			int left = i - 1;
			int right = i + 1;
			while(left >= 0 && heights[left] >= height) {
				left--;
			}
			while(right < heights.length && heights[right] >= height) {
				right++;
			}
			res = Math.max(res, height * (right - left - 1));
		}
		return res;
	}
	// use stack
	// Time: O(n)
	public int largestRectangleAresII(int[] nums) {
		if(nums == null || nums.length == 0) {
				return 0;
		}
		Deque<Integer> stack = new LinkedList<>();
		int res = 0;
		for(int i = 0; i <= nums.length; i++) {
			int cur = i == nums.length ? 0 : nums[i];
			while(!stack.isEmpty() && nums[stack.peekFirst()] >= cur) {
					int height = nums[stack.pollFirst()];
					int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
					res = Math.max(res, height * (i - left));
			}
			stack.offerFirst(i);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {1, 1, 0, 1, 1, 1};
		LC84LargestRectangleInHistorgram sol = new LC84LargestRectangleInHistorgram();
		int res = sol.largestRectangleAresII(nums);
		System.out.println(res);
	}
}

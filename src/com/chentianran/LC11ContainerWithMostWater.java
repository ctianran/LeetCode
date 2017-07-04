package com.chentianran;

/**
 * Created by Tianran on 7/4/2017.
 */
public class LC11ContainerWithMostWater {
	public int maxArea(int[] height) {
		if(height == null || height.length <= 1) {
			return 0;
		}
		int res = 0;
		int left = 0;
		int right = height.length - 1;
		while(left < right) {
			res = Math.max(res, (right - left) * Math.min(height[left], height[right]));
			if(height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return res;
	}
}

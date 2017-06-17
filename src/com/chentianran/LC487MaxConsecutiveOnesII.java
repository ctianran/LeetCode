package com.chentianran;

/**
 * Created by Tianran on 6/16/2017.
 */
public class LC487MaxConsecutiveOnesII {
	public int findMaxConsecutiveOnes(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int slow = 0;
		int fast = 0;
		int res = 0;
		int countZero = 0;
		while(fast < nums.length) {
			if(nums[fast] == 0) {
				countZero++;
				while(countZero > 1) {
					if(nums[slow] == 0) {
						countZero--;
					}
					slow++;
				}
			}
			res = Math.max(res, fast - slow + 1);
		}
		return res;
	}
}

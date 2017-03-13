package com.chentianran;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 3/12/2017.
 */
public class LC209MinimumSizeSubArraySum {
	public int minSubArrayLenI(int s, int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		map.put(-1, 0);
		int sum = 0;
		int slow = -1;
		int result = Integer.MAX_VALUE;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			map.put(i, sum);
			while(slow < i && map.get(i) - map.get(slow) >= s) {
				result = Math.min(result, i - slow);
				slow++;
			}
		}
		return result == Integer.MAX_VALUE ? 0 : result;
	}

	public int minSubArrayLenII(int s, int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int sum = 0;
		int slow = 0;
		int result = Integer.MAX_VALUE;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while(slow <= i && sum >= s) {
				result = Math.min(result, i - slow + 1);
				sum -= nums[slow++];
			}
		}
		return result == Integer.MAX_VALUE ? 0 : result;
	}
}


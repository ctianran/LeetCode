package com.chentianran;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 9/3/2017.
 */
public class LC325MaximumSizeSubarraySumEqualsK {
	public int maxSubArrayLen(int[] nums, int k) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int res = 0;
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if(map.containsKey(sum - k)) {
				res = Math.max(res, i - map.get(sum - k));
			}
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return res;
	}

}

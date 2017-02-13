package com.chentianran;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianran on 2/11/2017.
 * find all the elements that appear more than n / 3 times
 */
public class LC229MajorityElementII {
	public List<Integer> majorityElementI(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if(nums == null || nums.length == 0) {
			return result;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for(int num : nums) {
			Integer count = map.get(num);
			if(count == null) {
				map.put(num, 1);
			} else {
				map.put(num, count + 1);
			}
		}

		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() > nums.length / 3) {
				result.add(entry.getKey());
			}
		}
		return result;
	}

	public List<Integer> majorityElementII(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		Integer num1 = null;
		Integer num2 = null;
		int count1 = 0;
		int count2 = 0;
		for(int num : nums) {
			if(num1 != null && num == num1.intValue()) {
				count1++;
			} else if (num2 != null && num == num2.intValue()) {
				count2++;
			} else if (count1 == 0) {
				count1 = 1;
				num1 = num;
			} else if (count2 == 0) {
				count2 = 1;
				num2 = num;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = count2 = 0;
		for(int num : nums) {
			if(num == num1.intValue()) {
				count1++;
			} else if (num == num2.intValue()) {
				count2++;
			}
		}

		if(count1 > nums.length / 3) {
			result.add(num1);
		}
		if(count1 > nums.length / 3) {
			result.add(num2);
		}
		return result;
	}
}

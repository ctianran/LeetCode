package com.chentianran;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 2/16/2017.
 */
public class LC136SingleNumber {
	public int singleNumber(int[] nums) {
		int result = 0;
		for(int num : nums) {
			result ^= num;
		}
		return result;
	}

	public String singleElement(String[] elements) {
		if(elements.length == 1) {
			return elements[0];
		}
		Map<String, Integer> map = new HashMap<>();
		for(String s : elements) {
			Integer count = map.get(s);
			if(count == null) {
				map.put(s, 1);
			} else {
				map.put(s, count + 1);
			}
		}
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[] input = new int[] {1, 1, 3, 4, 4, 6, 6};
		String[] elements = new String[] {"abc", "abc", "bcd", "efg", "efg"};
		LC136SingleNumber sol = new LC136SingleNumber();
		int res = sol.singleNumber(input);
		String res2 = sol.singleElement(elements);
		System.out.println(res);
		System.out.println(res2);
	}
}



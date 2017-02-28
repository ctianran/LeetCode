package com.chentianran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 2/25/2017.
 */
public class LC163MissingRanges {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> result = new ArrayList<>();
		long curLow = (long) lower;
		long high = (long) upper;
		for(int num : nums) {
			if(curLow >= num) {
				if(curLow == num) {
					curLow = num + 1;
				}
				continue;
			}
			long curHigh = (long) num - 1;
			if(curHigh > high) {
				break;
			}
			if(curLow == curHigh) {
				result.add(curLow + "");
			} else if(curLow < curHigh) {
				result.add(curLow + "->" + curHigh);
			}
			curLow = (long)num + 1;
		}
		if(curLow == high) {
			result.add(high + "");
		} else if(curLow < high) {
			result.add(curLow + "->" + high);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {0, 1, 3, 24, 50, 75, 99, 130, 140};
		LC163MissingRanges sol = new LC163MissingRanges();
		List<String> res = sol.findMissingRanges(nums, 20, 100);
		System.out.println(res);
	}
}

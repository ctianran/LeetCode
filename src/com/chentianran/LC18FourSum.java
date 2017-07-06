package com.chentianran;

import java.util.*;

/**
 * Created by Tianran on 7/5/2017.
 */
public class LC18FourSum {
	//Time: O(n^3)
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length < 4) {
			return res;
		}
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 3; i++) {
			if(i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for(int j = i + 1; j < nums.length - 2; j++) {
				if(j > 0 && nums[j] == nums[j - 1]) {
					continue;
				}
				int k = j + 1;
				int l = nums.length - 1;
				while(k < l) {
					int sum = nums[i] + nums[j] + nums[k] + nums[l];
					if(sum < target) {
						k++;
					} else if(sum > target) {
						l--;
					} else {
						res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
						k++;
						l--;
						while(k < l && nums[k] == nums[k - 1]){
							k++;
						}
						while(k < l && nums[l] == nums[l + 1]) {
							l--;
						}
					}
				}
			}
		}
		return res;
	}
	//Time: O(n^2)
	public boolean existForurSum(int[] nums, int target) {
		if(nums == null || nums.length < 4) {
			return false;
		}
		Map<Integer, Cell> map = new HashMap<>();
		for(int j = 1; j < nums.length; j++) {
			for(int i = 0; i < j; i++) {
				int sum = nums[i] + nums[j];
				if(map.containsKey(target - sum) && map.get(target - sum).right < i) {
					return true;
				}
				if(!map.containsKey(sum)) {
					map.put(sum, new Cell(i, j));
				}
			}
		}
		return false;
	}

	class Cell {
		int left;
		int right;
		public Cell(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}
}

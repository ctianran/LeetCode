package com.chentianran;

import com.chentianran.utility.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianran on 5/26/2017.
 */
public class LC508MostFrequentSubtreeSum {
	public int[] findFrequentTreeSum(TreeNode root) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] max = new int[] {Integer.MIN_VALUE};
		postHelper(root, map, max);
		List<Integer> list = new ArrayList<>();
		for(int key : map.keySet()) {
			if(map.get(key) == max[0]) {
				list.add(key);
			}
		}
		int[] res = new int[list.size()];
		for(int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	private int postHelper(TreeNode root, Map<Integer, Integer> map, int[] max) {
		if(root == null) {
			return 0;
		}

		int left = postHelper(root.left, map, max);
		int right = postHelper(root.right, map, max);

		int sum = left + right + root.val;
		Integer count = map.get(sum);
		if(count == null) {
			map.put(sum, 0);
		} else {
			map.put(sum, count + 1);
		}
		max[0] = Math.max(max[0], map.get(sum));
		return sum;
	}
}

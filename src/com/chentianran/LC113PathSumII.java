package com.chentianran;

import com.chentianran.utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 3/5/2017.
 */
public class LC113PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) {
			return result;
		}
		List<Integer> cur = new ArrayList<>();
		helper(root, sum, cur, result);
		return result;
	}

	private void helper(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> result) {
		if(root == null) {
			return;
		}
		cur.add(root.val);
		sum -= root.val;
		if(root.left == null && root.right == null && sum == 0) {
			result.add(new ArrayList<Integer>(cur));
		}
		helper(root.left, sum, cur, result);
		helper(root.right, sum, cur, result);
		cur.remove(cur.size() - 1);
	}
}

package com.chentianran;

import com.chentianran.utility.TreeNode;

/**
 * Created by Tianran on 3/5/2017.
 */
public class LC129SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int[] result = new int[1];
		helper(root, 0, result);
		return result[0];
	}

	private void helper(TreeNode root, int cur, int[] result) {
		if(root == null) {
			return;
		}
		cur = cur * 10 + root.val;
		if(root.left == null && root.right == null) {
			result[0] += cur;
		}
		helper(root.left, cur, result);
		helper(root.right, cur, result);
	}
}

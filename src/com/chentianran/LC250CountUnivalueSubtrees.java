package com.chentianran;

import com.chentianran.utility.TreeNode;

/**
 * Created by Tianran on 3/6/2017.
 */
public class LC250CountUnivalueSubtrees {
	public int countUnivalSubtrees(TreeNode root) {
		int[] result = new int[1];
		helper(root, result);
		return result[0];
	}

	private boolean helper(TreeNode root, int[] result) {
		if(root == null) {
			return true;
		}
		boolean left = helper(root.left, result);
		boolean right = helper(root.right, result);

		if(left && right && (root.left == null || root.left.val == root.val) && (root.right == null || root.right.val == root.val)) {
			result[0]++;
			return true;
		}
		return false;
	}
}

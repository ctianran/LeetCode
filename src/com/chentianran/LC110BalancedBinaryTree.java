package com.chentianran;

import com.chentianran.utility.TreeNode;

/**
 * Created by Tianran on 3/5/2017.
 */
public class LC110BalancedBinaryTree {
	public boolean isBalaned(TreeNode root) {
		if(root == null) {
			return true;
		}
		return getHeight(root) != -1;
	}

	private int getHeight(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		if(left == -1 || right == -1 || Math.abs(left - right) > 1) {
			return -1;
		}
		return 1 + Math.max(left, right);
	}
}

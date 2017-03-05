package com.chentianran;

import com.chentianran.utility.TreeNode;

/**
 * Created by Tianran on 3/4/2017.
 */
public class LC98ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		if(root == null) {
			return true;
		}
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean helper(TreeNode root, int min, int max) {
		if(root == null) {
			return true;
		}
		if(root.val <= min || root.val >= max) {
			return false;
		}
		return helper(root.left, min, root.val) && helper(root.right, root.val, max);
	}
}

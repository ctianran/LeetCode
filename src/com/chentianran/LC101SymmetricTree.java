package com.chentianran;

import com.chentianran.utility.TreeNode;

/**
 * Created by Tianran on 3/4/2017.
 */
public class LC101SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if(root == null) {
			return true;
		}
		return helper(root.left, root.right);
	}

	private boolean helper(TreeNode one, TreeNode two) {
		if(one == null && two == null) {
			return true;
		} else if (one == null || two == null) {
			return false;
		} else if(one.val != two.val) {
			return false;
		}
		return helper(one.left, two.right) && helper(one.right, two.left);
	}
}

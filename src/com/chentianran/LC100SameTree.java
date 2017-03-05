package com.chentianran;

import com.chentianran.utility.TreeNode;

/**
 * Created by Tianran on 3/4/2017.
 */
public class LC100SameTree {
	public boolean isSameTree(TreeNode one, TreeNode two) {
		if(one == null && two == null) {
			return true;
		} else if (one == null || two == null) {
			return false;
		} else if(one.val != two.val) {
			return false;
		}
		return isSameTree(one.left, two.left) && isSameTree(one.right, two.right);
	}
}

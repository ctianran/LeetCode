package com.chentianran;

import com.chentianran.utility.TreeNode;

/**
 * Created by Tianran on 3/5/2017.
 */
public class LC112PathSum {
	public boolean hasPathSum(TreeNode root, int num) {
		if(root == null) {
			return false;
		}
		if(root.left == null && root.right == null && root.val == num) {
			return true;
		}
		return hasPathSum(root.left, num - root.val) || hasPathSum(root.right, num - root.val);
	}

}

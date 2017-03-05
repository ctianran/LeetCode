package com.chentianran;

import com.chentianran.utility.TreeNode;

/**
 * Created by Tianran on 3/4/2017.
 */
public class LC104MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		return 1 + Math.max(left, right);
	}
}

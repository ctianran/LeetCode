package com.chentianran;

import com.chentianran.utility.TreeNode;

/**
 * Created by Tianran on 3/5/2017.
 */
public class LC111MinimumDepthOfBinaryTree {
	public int minDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		if(root.left == null) {
			return right + 1;
		}
		if(root.right == null) {
			return left + 1;
		}
		return 1 + Math.min(left, right);
	}
}

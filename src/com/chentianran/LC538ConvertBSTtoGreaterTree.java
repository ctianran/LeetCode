package com.chentianran;

import com.chentianran.utility.TreeNode;

/**
 * Created by Tianran on 5/20/2017.
 */
public class LC538ConvertBSTtoGreaterTree {
	public TreeNode convertBST(TreeNode root) {
		int[] curSum = new int[1];
		helper(root, curSum);
		return root;
	}

	private void helper(TreeNode root, int[] curSum) {
		if(root == null) {
			return;
		}
		helper(root.right, curSum);
		root.val += curSum[0];
		curSum[0] = root.val;
		helper(root.left, curSum);
	}
}

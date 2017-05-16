package com.chentianran;

import com.chentianran.utility.TreeNode;

/**
 * Created by Tianran on 5/16/2017.
 */
public class LC563BinaryTreeTilt {
	public int findTilt(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int[] res = new int[1];
		helper(root, res);
		return res[0];
	}

	private int helper(TreeNode root, int[] res) {
		if(root == null) {
			return 0;
		}

		int left = helper(root.left, res);
		int right = helper(root.right, res);

		res[0] += Math.abs(left - right);
		return left + right + root.val;
	}
}


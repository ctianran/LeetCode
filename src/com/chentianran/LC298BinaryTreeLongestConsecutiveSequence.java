package com.chentianran;

import com.chentianran.utility.TreeNode;

/**
 * Created by Tianran on 5/16/2017.
 */
public class LC298BinaryTreeLongestConsecutiveSequence {
	public int longestConsecutive(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int[] res = new int[1];
		helper(root, 0, root.val, res);
		return res[0];
	}

	private void helper(TreeNode root, int cur, int target, int[] res) {
		if(root == null) {
			return;
		}
		if(root.val == target) {
			cur++;
		} else {
			cur = 1;
		}
		res[0] = Math.max(res[0], cur);
		helper(root.left, cur, root.val + 1, res);
		helper(root.right, cur, root.val + 1, res);
	}
}

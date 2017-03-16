package com.chentianran;

import com.chentianran.utility.TreeNode;

/**
 * Created by Tianran on 3/13/2017.
 */
public class LC337HouseRobberIII {
	public int rob(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int val = 0;
		if(root.left != null) {
			val += rob(root.left.left) + rob(root.left.right);
		}
		if(root.right != null) {
			val += rob(root.right.left) + rob(root.right.right);
		}
		return Math.max(root.val + val, rob(root.left) + rob(root.right));
	}

	public int robII(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int[] res = helper(root);
		return Math.max(res[0], res[1]);
	}

	private int[] helper(TreeNode root) {
		if(root == null) {
			return new int[] {0, 0};
		}
		int[] res = new int[2];
		int[] left = helper(root.left);
		int[] right = helper(root.right);

		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		res[1] = root.val + left[0] + right[0];
		return res;
	}

}

package com.chentianran;

import com.chentianran.utility.TreeNode;

/**
 * Created by Tianran on 5/16/2017.
 */
public class LC549BinaryTreeLongestConsecutiveSequenceII {
	public int longestConsecutive(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int[] res = new int[1];
		helper(root, res);
		return res[0];
	}

	private int[] helper(TreeNode root, int[] res) {
		if(root == null) {
			return new int[] {0, 0};
		}
		int inc = 1;
		int dec = 1;
		//check left child
		if(root.left != null) {
			int[] left = helper(root.left, res);
			if(root.val + 1 == root.left.val) { // increasing
				inc = left[0] + 1;
			} else if(root.val - 1 == root.val) { //decreaseing
				dec = left[1] + 1;
			}
		}
		//check right child
		if(root.right != null) {
			int[] right = helper(root.right, res);
			if(root.val + 1 == root.right.val) {
				inc = Math.max(right[0] + 1, inc);
			} else if(root.val - 1 == root.right.val) {
				dec = Math.max(right[1] + 1, dec);
			}
		}
		//update solution
		res[0] = Math.max(res[0], inc + dec - 1);
		//report current status
		return new int[] {inc, dec};
	}
}

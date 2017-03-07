package com.chentianran;

import com.chentianran.utility.TreeNode;

/**
 * Created by Tianran on 3/6/2017.
 */
public class LC222CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = getLeftHeight(root);
		int right = getRightHeight(root);

		if(left == right) {
			return (2 << (left - 1))  - 1;
		} else {
			return countNodes(root.left) + countNodes(root.right)  + 1;
		}
	}

	private int getLeftHeight(TreeNode root) {
		int count = 0;
		if(root != null) {
			count++;
			root = root.left;
		}
		return count;
	}

	private int getRightHeight(TreeNode root) {
		int count = 0;
		if(root != null) {
			count++;
			root = root.right;
		}
		return count;
	}
}

package com.chentianran;

import com.chentianran.utility.TreeNode;

/**
 * Created by Tianran on 2/9/2017.
 */
public class LC99RecoverBinarySearchTree {
	public TreeNode recover(TreeNode root) {
		if(root == null) {
			return root;
		}
		TreeNode[] prev = new TreeNode[1];
		TreeNode[] first = new TreeNode[1];
		TreeNode[] second = new TreeNode[1];

		helper(root, prev, first, second);
		if(first[0] != null && second[0] != null) {
			swapNodes(first, second);
		}
		return root;
	}

	private void helper(TreeNode root, TreeNode[] prev, TreeNode[] first, TreeNode[] second) {
		if(root == null) {
			return;
		}
		helper(root.left, prev, first, second);
		if(prev[0] == null) {
			prev[0] = root;
		} else {
			if(root.val < prev[0].val) {
				if(first[0] == null) {
					first[0] = prev[0];
				}
				second[0] = root;
			}
			prev[0] = root;
		}
		helper(root.right, prev, first, second);
	}

	private void swapNodes(TreeNode[] first, TreeNode[] second) {
		int temp = first[0].val;
		first[0].val = second[0].val;
		second[0].val = temp;
	}


}

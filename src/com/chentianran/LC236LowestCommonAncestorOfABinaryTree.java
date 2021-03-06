package com.chentianran;

import com.chentianran.utility.TreeNode;

/**
 * Created by Tianran on 3/6/2017.
 */
public class LC236LowestCommonAncestorOfABinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if(left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}
}

package com.chentianran;

import com.chentianran.utility.TreeNode;

/**
 * Created by Tianran on 3/6/2017.
 */
public class LC235LowestCommonAncestorOfABinarySearchTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root.val > p.val && root.val < q.val) {
			return root;
		} else if(root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if(root.val < p.val && root.val < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		}
		return root;
	}
}

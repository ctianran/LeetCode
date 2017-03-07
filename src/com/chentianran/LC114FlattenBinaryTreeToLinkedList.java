package com.chentianran;

import com.chentianran.utility.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Tianran on 3/5/2017.
 */
public class LC114FlattenBinaryTreeToLinkedList {
	public TreeNode flatten(TreeNode root) {
		if(root == null) {
			return root;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		stack.offerFirst(root);
		TreeNode dummy = new TreeNode(0);
		TreeNode prev = dummy;
		while(!stack.isEmpty()) {
			TreeNode cur = stack.pollFirst();
			if(cur.right != null) {
				stack.offerFirst(cur.right);
			}
			if(cur.left != null) {
				stack.offerFirst(cur.left);
			}
			prev.right = cur;
			prev.left = null;
			prev = cur;
		}
		return dummy.right;
	}
}

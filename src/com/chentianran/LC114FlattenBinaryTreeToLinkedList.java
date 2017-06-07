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

	public TreeNode flattenRec(TreeNode root) {
		if(root == null) {
			return root;
		}
		TreeNode[] prev = new TreeNode[1];
		helper(root, prev);
		return root;
	}

	private void helper(TreeNode root, TreeNode[] prev) {
		if(root == null) {
			return;
		}
		if(prev[0] != null) {
			prev[0].right = root;
		}
		prev[0] = root;
		TreeNode temp = root.right;
		helper(root.left, prev);
		helper(temp, prev);
		root.left = null;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);

		n1.left = n2;
		n1.right = n4;
		n2.left = n3;



		LC114FlattenBinaryTreeToLinkedList sol = new LC114FlattenBinaryTreeToLinkedList();
		TreeNode res = sol.flatten(n1);

		while(res != null) {
			System.out.print(res.val + " ");
			res = res.right;
		}
	}
}

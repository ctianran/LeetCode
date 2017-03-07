package com.chentianran;

import com.chentianran.utility.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tianran on 3/5/2017.
 */
public class LC144BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		stack.offerFirst(root);
		while(!stack.isEmpty()) {
			TreeNode cur = stack.pollFirst();
			result.add(cur.val);
			if(cur.right != null) {
				stack.offerFirst(cur.right);
			}
			if(cur.left != null) {
				stack.offerFirst(cur.left);
			}
		}
		return result;
	}
}

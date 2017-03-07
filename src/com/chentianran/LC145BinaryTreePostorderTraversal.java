package com.chentianran;

import com.chentianran.utility.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tianran on 3/5/2017.
 */
public class LC145BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		stack.offerFirst(root);
		TreeNode prev = null;
		while(!stack.isEmpty()) {
			TreeNode cur = stack.peekFirst();
			if(prev == null || cur == prev.left || cur == prev.right) {
				if(cur.left != null) {
					stack.offerFirst(cur.left);
				} else if(cur.right != null) {
					stack.offerFirst(cur.right);
				} else {
					result.add(stack.pollFirst().val);
				}
			} else if (prev == cur.left) {
					if(cur.right != null) {
						stack.offerFirst(cur.right);
					} else {
						result.add(stack.pollFirst().val);
					}
			} else if (prev == cur.right) {
				result.add(stack.pollFirst().val);
			}
			prev = cur;
		}
		return result;
	}
}

package com.chentianran;

import com.chentianran.utility.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Tianran on 3/6/2017.
 */
public class LC230KthSmallestElementInABST {
	//iterative
	public int kthSmallest(TreeNode root, int k) {
		if(root == null) {
			return -1;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode cur = root;
		while(cur != null || !stack.isEmpty()) {
			if(cur != null) {
				stack.offerFirst(cur);
				cur = cur.left;
			} else {
				cur = stack.pollFirst();
				k--;
				if(k == 0) {
					return cur.val;
				}
				cur = cur.right;
			}
		}
		return -1;
	}
	//recursive
	public int kthSmallestII(TreeNode root, int k) {
		int[] result = new int[] {-1};
		int[] count = new int[] {k};
		helper(root, count, result);
		return result[0];
	}

	private void helper(TreeNode root, int[] count, int[] result) {
		if(root == null) {
			return;
		}
		helper(root.left, count, result);
		count[0]--;
		if(count[0] == 0) {
			result[0] = root.val;
			return;
		}
		helper(root.right, count, result);
	}

}

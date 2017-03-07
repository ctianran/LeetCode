package com.chentianran;

import com.chentianran.utility.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by Tianran on 3/5/2017.
 */
public class LC173BinarySearchTreeIterator {
	private TreeNode root;
	private Deque<TreeNode> stack;
	public LC173BinarySearchTreeIterator(TreeNode root) {
			if(root == null) {
				return;
			}
			this.root = root;
			stack = new LinkedList<>();
			while(root != null) {
				stack.offerFirst(root);
				root = root.left;
			}
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public int next() {
		if(!hasNext()) {
			throw new NoSuchElementException("No more element");
		}
		TreeNode cur = stack.pollFirst();
		int result = cur.val;
		if(cur.right != null) {
			cur = cur.right;
			while(cur != null) {
				stack.offerFirst(cur);
				cur = cur.left;
			}
		}
		return result;
	}
}

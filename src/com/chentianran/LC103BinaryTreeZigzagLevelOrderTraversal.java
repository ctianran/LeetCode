package com.chentianran;

import com.chentianran.utility.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tianran on 3/4/2017.
 */
public class LC103BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzag(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offerLast(root);
		int level = 1;
		while(!deque.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int size = deque.size();
			for(int i = 0; i < size; i++) {
				if(level == 1) {
					TreeNode cur = deque.pollFirst();
					list.add(cur.val);
					if(cur.left != null) {
						deque.offerLast(cur.left);
					}
					if(cur.right != null) {
						deque.offerLast(cur.right);
					}
				} else {
					TreeNode cur = deque.pollLast();
					list.add(cur.val);
					if(cur.right != null) {
						deque.offerFirst(cur.right);
					}
					if(cur.left != null) {
						deque.offerFirst(cur.left);
					}
				}
			}
			level = 1 - level;
			result.add(list);
		}
		return result;
	}
}

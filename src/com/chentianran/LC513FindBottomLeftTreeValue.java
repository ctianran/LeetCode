package com.chentianran;

import com.chentianran.utility.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Tianran on 5/22/2017.
 */
public class LC513FindBottomLeftTreeValue {
	public int findBottomLeftValue(TreeNode root) {
		if(root == null) {
			throw new IllegalArgumentException("the input can not be null");
		}
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode cur = root;
		queue.offer(cur);
		while(!queue.isEmpty()) {
			cur = queue.poll();
			if(cur.right != null) {
				queue.offer(cur.right);
			}
			if(cur.left != null) {
				queue.offer(cur.left);
			}
		}
		return cur.val;
	}
}

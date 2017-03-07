package com.chentianran;

import com.chentianran.utility.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Tianran on 3/5/2017.
 */
public class LC117PopulatingNextRightPointersInEachNodeII {
	public void connect(TreeLinkNode root) {
		if(root == null) {
			return;
		}
		Queue<TreeLinkNode> queue = new LinkedList<>();
		queue.offer(root);
		TreeLinkNode dummy = new TreeLinkNode(0);
		TreeLinkNode prev = dummy;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				TreeLinkNode cur = queue.poll();
				if(cur.left != null) {
					queue.offer(cur.left);
				}
				if(cur.right != null) {
					queue.offer(cur.right);
				}
				prev.next = cur;
				cur.next = null;
				prev = cur;
			}
		}
	}
}

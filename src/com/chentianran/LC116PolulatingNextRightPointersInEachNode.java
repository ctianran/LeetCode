package com.chentianran;

import com.chentianran.utility.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Tianran on 2/6/2017.
 */
public class LC116PolulatingNextRightPointersInEachNode {
	public TreeLinkNode connectI(TreeLinkNode root) {
		if(root == null) {
			return root;
		}
		Queue<TreeLinkNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			TreeLinkNode prev = null;
			for(int i = 0; i < size; i++) {
				TreeLinkNode cur = queue.poll();
				if(cur.left != null) {
					queue.offer(cur.left);
				}
				if(cur.right != null) {
					queue.offer(cur.right);
				}
				if(prev != null) {
					prev.next = cur;
				}
				cur.next = null;
				prev = cur;
			}
		}
		return root;
	}

	public TreeLinkNode connectII(TreeLinkNode root) {
		if (root == null) {
			return root;
		}
		TreeLinkNode lastHead = root;
		TreeLinkNode lastCur = null;
		TreeLinkNode curHead = null;
		TreeLinkNode cur = null;

		while(lastHead != null) {
			lastCur = lastHead;

			while(lastCur != null) {
				if(curHead == null) {
					curHead = lastHead.left;
					cur = lastCur.left;
				} else {
					cur.next = lastCur.left;
					cur = cur.next;
				}

				if(curHead != null) {
					cur.next = lastCur.right;
					cur = cur.next;
				}
				lastCur = lastCur.next;
			}
			lastHead = curHead;
			curHead = null;
		}
		return root;
	}
}

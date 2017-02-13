package com.chentianran;

import com.chentianran.utility.ListNode;
import com.chentianran.utility.TreeNode;

/**
 * Created by Tianran on 2/10/2017.
 */
public class LC109ConvertSortedListToBST {
	public TreeNode convert(ListNode head) {
		if(head == null) {
			return null;
		}
		ListNode[] cur = new ListNode[] {head};
		int length = getLength(head);
		return helper(cur, 0, length - 1);
	}

	private TreeNode helper(ListNode[] cur, int start, int end) {
		if(start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode left = helper(cur, start, mid - 1);

		TreeNode root = new TreeNode(cur[0].val);
		cur[0] = cur[0].next;

		TreeNode right = helper(cur, mid + 1, end);
		root.left = left;
		root.right = right;
		return root;
	}


	private int getLength(ListNode head) {
		int len = 0;
		while(head != null) {
			len++;
			head = head.next;
		}
		return len;
	}
}

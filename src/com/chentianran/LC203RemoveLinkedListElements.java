package com.chentianran;

import com.chentianran.utility.ListNode;

/**
 * Created by Tianran on 2/26/2017.
 */
public class LC203RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if(head == null) {
			return null;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode cur = head;
		while(cur != null) {
			if(cur.val == val) {
				prev.next = cur.next;
			} else {
				prev = cur;
			}
			cur = cur.next;
		}
		return dummy.next;
	}
}

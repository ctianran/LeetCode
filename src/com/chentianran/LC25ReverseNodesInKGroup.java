package com.chentianran;

import com.chentianran.utility.ListNode;

/**
 * Created by Tianran on 3/2/2017.
 */
public class LC25ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if(k == 1) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode cur = head;

		int count = k;
		while(cur != null) {
			if(count == 1) {
				ListNode next = cur.next;
				ListNode h2 = prev.next;
				ListNode temp = reverse(h2);
				prev.next = temp;
				h2.next = next;

				prev = h2;
				cur = next;
				count = 0;
			} else {
				cur = cur.next;
				k--;
			}
		}
		return dummy.next;
	}

	private ListNode reverse(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode prev = null;
		ListNode cur = head;
		while(cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
}

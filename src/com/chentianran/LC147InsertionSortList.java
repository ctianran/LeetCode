package com.chentianran;

import com.chentianran.utility.ListNode;

/**
 * Created by Tianran on 3/11/2017.
 */
public class LC147InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = head;
		while(cur.next != null) {
			ListNode next = cur.next;
			if(next.val < cur.val) {
				ListNode temp = dummy;
				while(temp.next != null && temp.next.val < next.val) {
					temp = temp.next;
				}
				cur.next = cur.next.next;
				next.next = temp.next;
				temp.next = next;
			} else {
				cur = cur.next;
			}
		}
		return dummy.next;
	}
}

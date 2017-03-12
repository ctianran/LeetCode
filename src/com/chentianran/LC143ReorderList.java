package com.chentianran;

import com.chentianran.utility.ListNode;

/**
 * Created by Tianran on 3/11/2017.
 */
public class LC143ReorderList {
	public ListNode reorderList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode mid = getMid(head);
		ListNode one = head;
		ListNode two = mid.next;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		mid.next = null;
		while(one != null || two != null) {
			cur.next = one;
			one = one.next;
			cur.next.next = two;
			two = two.next;
			cur = cur.next.next;
		}
		if(one != null) {
			cur.next = one;
		} else {
			cur.next = two;
		}
		return dummy.next;
	}

	private ListNode getMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
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

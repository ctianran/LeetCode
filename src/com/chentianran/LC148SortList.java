package com.chentianran;

import com.chentianran.utility.ListNode;

/**
 * Created by Tianran on 3/11/2017.
 */
public class LC148SortList {
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode mid = getMid(head);
		ListNode one = head;
		ListNode two = mid.next;
		mid.next = null;
		one = sortList(one);
		two = sortList(two);
		return merge(one, two);
	}

	private ListNode merge(ListNode one, ListNode two) {
		if(one == null) {
			return two;
		}
		if(two == null) {
			return one;
		}
		ListNode cur = null;
		if(one.val < two.val) {
			cur = one;
			cur.next = merge(one.next, two);
		} else {
			cur = two;
			cur.next = merge(one, two.next);
		}
		return cur;
	}

	private ListNode getMid(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}

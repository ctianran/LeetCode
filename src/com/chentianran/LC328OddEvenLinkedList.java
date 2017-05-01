package com.chentianran;

import com.chentianran.utility.ListNode;

/**
 * Created by Tianran on 5/1/2017.
 */
public class LC328OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null || head.next.next == null) {
			return head;
		}
		ListNode one = head;
		ListNode two = head.next;
		ListNode cur = one;
		ListNode next = two;

		while(cur.next != null && cur.next.next != null) {
			cur.next = cur.next.next;
			next.next = next.next.next;
			cur = cur.next;
			next = next.next;
		}
		cur.next = two;
		return one;
	}
}

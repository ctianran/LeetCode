package com.chentianran;

import com.chentianran.utility.ListNode;

/**
 * Created by Tianran on 3/11/2017.
 */
public class LC61RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null) {
			return head;
		}
		int length = 0;
		ListNode cur = head;
		while(cur != null) {
			length++;
			head = head.next;
		}
		if(length == k) {
			return head;
		}
		k = k % length;

		ListNode slow = head;
		ListNode fast = head;
		while(k > 0) {
			fast = fast.next;
			k--;
		}
		while(fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		fast.next = head;
		head = slow.next;
		slow.next = null;
		return head;
	}

}

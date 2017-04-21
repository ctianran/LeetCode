package com.chentianran;

import com.chentianran.utility.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Tianran on 4/20/2017.
 */
public class LC445AddTwoNumbersII {
	//recursive
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int size1 = getLength(l1);
		int size2 = getLength(l2);
		ListNode head = new ListNode(1);
		head.next = size1 < size2 ? helper(l2, l1, size2 - size1) : helper(l1, l2, size1 - size2);
		if(head.next.val > 9) {
			head.next.val = head.next.val % 10;
			return head;
		}
		return head.next;
	}

	private ListNode helper(ListNode l1, ListNode l2, int offset) {
		if(l1 == null) {
			return null;
		}
		ListNode result = offset == 0 ? new ListNode(l1.val + l2.val) : new ListNode(l1.val);
		ListNode post = offset == 0 ? helper(l1.next, l2.next, 0) : helper(l1.next, l2, offset - 1);
		if(post != null && post.val > 9) {
			result.val += 1;
			post.val = post.val % 10;
		}
		result.next = post;
		return result;
	}

	private int getLength(ListNode head) {
		if(head == null) {
			return 0;
		}
		int length = 0;
		while(head != null) {
			length++;
			head = head.next;
		}
		return length;
	}

	//iterative
	public ListNode addTwoNumbersII(ListNode l1, ListNode l2) {
		Deque<Integer> stack1 = new LinkedList<>();
		Deque<Integer> stack2 = new LinkedList<>();
		while(l1 != null) {
			stack1.offerFirst(l1.val);
			l1 = l1.next;
		}
		while(l2 != null) {
			stack2.offerFirst(l2.val);
			l2 = l2.next;
		}

		int sum = 0;
		ListNode list = new ListNode(0);
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			if(!stack1.isEmpty()) {
				sum += stack1.pollFirst();
			}
			if(!stack2.isEmpty()) {
				sum += stack2.pollFirst();
			}
			list.val = sum % 10;
			ListNode head = new ListNode(sum / 10);
			head.next = list;
			list = head;
			sum /= 10;
		}
		return list.val == 0 ? list.next : list;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(7);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(3);

		ListNode m1 = new ListNode(5);
		ListNode m2 = new ListNode(6);
		ListNode m3 = new ListNode(4);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		m1.next = m2;
		m2.next = m3;

		LC445AddTwoNumbersII sol = new LC445AddTwoNumbersII();
		ListNode res = sol.addTwoNumbersII(n1, m1);
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
}

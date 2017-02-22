package com.chentianran;

import com.chentianran.utility.ListNode;

/**
 * Created by Tianran on 2/20/2017.
 */
public class LC369PlusOneLinkedList {
	public ListNode plusOne(ListNode head) {
		if(head == null ) {
			return null;
		}
		ListNode temp = reverse(head);
		ListNode cur = temp;
		while(cur != null) {
			if(cur.val + 1 <= 9) {
				cur.val += 1;
				break;
			} else {
				cur.val = 0;
				if(cur.next == null) {
					cur.next = new ListNode(1);
					break;
				}
				cur = cur.next;
			}
		}
		return reverse(temp);
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


	public static void main(String[] args) {
		ListNode n1 = new ListNode(9);
		ListNode n2 = new ListNode(9);
		ListNode n3 = new ListNode(9);

		n1.next = n2;
		n2.next = n3;
		LC369PlusOneLinkedList sol = new LC369PlusOneLinkedList();
		ListNode res = sol.plusOne(n1);

		while(res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
}

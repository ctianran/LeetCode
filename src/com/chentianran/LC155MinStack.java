package com.chentianran;

import java.util.NoSuchElementException;

/**
 * Created by Tianran on 2/24/2017.
 */
public class LC155MinStack {
	static class Cell {
		public int val;
		public int min;
		public Cell next;
		public Cell(int val, int min) {
			this.val = val;
			this.min = min;
		}
	}
	private Cell top;
	//Constructor
	public LC155MinStack() {
		top = null;
	}

	public void push(int val) {
		if(top == null) {
			top = new Cell(val, val);
		} else {
			Cell temp = new Cell(val, Math.min(top.min, val));
			temp.next = top;
			top = temp;
		}
	}

	public int pop() {
		if(top == null) {
			throw new NoSuchElementException("stack is empty");
		}
		int res = top.val;
		top = top.next;
		return res;
	}

	public int top() {
		if(top == null) {
			throw new NoSuchElementException("stack is empty");
		}
		return top.val;
	}

	public int getMin() {
		if(top == null) {
			throw new NoSuchElementException("stack is empty");
		}
		return top.min;
	}
}

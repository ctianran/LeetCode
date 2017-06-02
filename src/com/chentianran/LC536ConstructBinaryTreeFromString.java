package com.chentianran;

import com.chentianran.utility.TreeNode;

/**
 * Created by Tianran on 6/2/2017.
 */
public class LC536ConstructBinaryTreeFromString {
	public TreeNode str2tree(String s) {
		//base case
		if(s == null || s.isEmpty()) {
			return null;
		}
		int firstP = s.indexOf("(");
		int val = firstP == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, firstP));
		TreeNode root = new TreeNode(val);
		if(firstP == -1) {
			return root;
		}
		int start = firstP;
		int count = 0;
		for(int i = start; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				count++;
			} else if (s.charAt(i) == ')') {
				count--;
			}
			if(count == 0 && start == firstP) {
				root.left = str2tree(s.substring(start + 1, i));
				start = i + 1;
			} else if (count == 0) {
				root.right = str2tree(s.substring(start + 1, i));
			}
		}
		return root;
	}
}

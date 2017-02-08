package com.chentianran;

import com.chentianran.utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 2/7/2017.
 */
public class LC257BinaryTreePaths {
	public List<String> paths(TreeNode root) {
		List<String> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		StringBuilder sb = new StringBuilder();
		helper(root, sb, result);
		return result;
	}

	private void helper(TreeNode root, StringBuilder sb, List<String> result) {
		if(root == null) {
			return;
		}
		int len = sb.length();
		sb.append(root.val);
		if(root.left == null && root.right == null) {
			result.add(sb.toString());
		} else {
			sb.append("->");
			helper(root.left, sb, result);
			helper(root.right, sb, result);
		}
		sb.setLength(len);
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.right = n5;
		LC257BinaryTreePaths sol = new LC257BinaryTreePaths();
		List<String> res = sol.paths(n1);
		System.out.println(res);
	}
}

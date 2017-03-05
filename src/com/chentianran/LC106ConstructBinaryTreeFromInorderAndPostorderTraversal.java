package com.chentianran;

import com.chentianran.utility.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 3/5/2017.
 */
public class LC106ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 00) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < inorder.length; i++){
			map.put(inorder[i], i);
		}
		return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
	}

	private TreeNode helper(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight, Map<Integer, Integer> map) {
		if(inLeft > inRight) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[postRight]);
		int index = map.get(root.val);
		int rightSize = inRight - index;

		root.right = helper(inorder, index + 1, inRight, postorder, postRight - rightSize, postRight - 1, map);
		root.left = helper(inorder, inLeft, index - 1, postorder, postLeft, postRight - rightSize - 1, map);
		return root;
	}
}

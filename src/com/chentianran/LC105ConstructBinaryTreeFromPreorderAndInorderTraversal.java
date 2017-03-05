package com.chentianran;

import com.chentianran.utility.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 3/5/2017.
 */
public class LC105ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder == null || inorder == null || preorder.length == 0 || inorder.length ==0) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
	}

	private TreeNode helper(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight, Map<Integer, Integer> map) {
		if(inLeft > inRight) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[inLeft]);
		int index = map.get(root.val);
		int leftSize = index - inLeft;
		root.left = helper(preorder, preLeft + 1, preLeft + leftSize, inorder, inLeft, index - 1, map);
		root.right = helper(preorder, preLeft + leftSize + 1, preRight, inorder, index + 1, inRight, map);
		return root;
	}
}

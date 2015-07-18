package problemSets.easy;

import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 */
public class KthSmallestElementInABST {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Solution {
		public int kthSmallest(TreeNode root, int k) {
			int i = k;
			Stack<TreeNode> parents = new Stack<>();
			int result = root.val;
			TreeNode current = root;
			while (i >= 0) {
				if (current != null) {
					parents.push(current);
					current = current.left;
				} else {
					--i;
					current = parents.pop();
					if (i == 0) {
						result = current.val;
					} else {
						current = current.right;
					}
				}

			}
			return result;
		}
	}

	public static void main(String[] args) {
		KthSmallestElementInABST main = new KthSmallestElementInABST();
		TreeNode root = main.new TreeNode(1);
		root.left = null;
		root.right = main.new TreeNode(2);
		System.out.println(main.new Solution().kthSmallest(root, 2));

	}

}

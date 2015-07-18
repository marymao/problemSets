package problemSets.easy;

public class InvertBinaryTree {
	// Definition for a binary treeC node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Solution {
		public TreeNode invertTree(TreeNode root) {
			if (root == null) {
				return null;
			} else {
				TreeNode temp = invertTree(root.left);
				root.left = invertTree(root.right);
				root.right = temp;
				return root;
			}
		}
	}

}

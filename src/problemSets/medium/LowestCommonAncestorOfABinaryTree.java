package problemSets.medium;

import java.util.Stack;

public class LowestCommonAncestorOfABinaryTree {

	/**
	 * Definition for a binary tree node.
	 */
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return val + "";
		}
	}

	public class Solution {
		Stack<TreeNode> pPath = new Stack<>();
		Stack<TreeNode> qPath = new Stack<>();

		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
				TreeNode q) {
			TreeNode result = null;
			if (root == null || p == null || q == null) {
				return null;
			}
			if (root == p || root == q) {
				return root;
			}
			printPath(root, p, pPath);
			System.out.println();
			printPath(root, q, qPath);
			System.out.println();
			System.out.println(pPath);
			System.out.println(qPath);
			TreeNode previous = root;
			while (result == null && !pPath.isEmpty() && !qPath.isEmpty()) {
				TreeNode pparent = pPath.pop();
				TreeNode qparent = qPath.pop();
				if (pparent != qparent) {
					result = previous;
				}
				previous = pparent;
			}
			if (result == null) {
				result = previous;
			}
			return result;

		}

		public Boolean printPath(TreeNode root, TreeNode dest,
				Stack<TreeNode> path) {
			if (root == null)
				return false;
			if (root == dest || printPath(root.left, dest, path)
					|| printPath(root.right, dest, path)) {
				System.out.print("  " + root.val);
				path.push(root);
				return true;
			}
			return false;
		}

		// wrong again!!! tree not complete, parent of rights.pop() not
		// gaurenteed to be trace.pop()
		// Stack<TreeNode> trace = new Stack<>();
		// Stack<TreeNode> rights = new Stack<>();
		// TreeNode node = root;
		// while (!rights.isEmpty() || node != null) {
		// // visit
		// System.out.println(node);
		// if (node == p) {
		// return trace.pop();
		// }
		// if (node != null) {
		// trace.push(node);
		// if (node.right != null) {
		// rights.push(node.right);
		// }
		// node = node.left;
		// } else {
		// node = rights.pop();
		// trace.pop();
		// }
		// }
		// System.out.println(trace);

		// wrong below!!!!
		// cannot tell if you have complete a subtree, forever goes to a non
		// null right tree and come back
		// boolean right = false;
		// while (!trace.isEmpty()) {
		// TreeNode node = trace.peek();
		// System.out.println(node);
		// if (node != null) {
		// if (!right) {
		// trace.push(node.left);
		// } else if (node.right != null) {
		// trace.push(node.right);
		// right = false;
		// } else {
		// trace.pop();
		// right = true;
		// }
		// } else {
		// trace.pop();
		// right = true;
		// }
		// }
		// return result;
		// }
	}

	public static void main(String[] args) {
		LowestCommonAncestorOfABinaryTree l = new LowestCommonAncestorOfABinaryTree();
		Solution sol = l.new Solution();
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		System.out.println("result="
				+ sol.lowestCommonAncestor(root, root.right, root.left));
	}

}

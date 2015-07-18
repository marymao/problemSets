package problemSets.easy;

import java.util.LinkedList;

/**
 * Given a complete binary tree, count the number of nodes.
 */
public class CountCompleteTreeNodes {

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
	}

	public interface Solution {
		public int countNodes(TreeNode root);
	}


	public class SolutionLgnSqr implements Solution {
		public int countNodes(TreeNode root) {
			if (root == null) {
				return 0;
			}
			int level = getLevel(root);
			if (level == 1) {
				return 1;
			}
			int result = 0;
			for (int i = 0; i < level-1; i++) {
				result += (1 << (i));
			}
			int count = 0;
			TreeNode current = root;
			// left level = right level, complete on left and missing on right,
			// otherwise missing on left
			while (current != null) {
				level--;
				if (getLevel(current.left) == getLevel(current.right)) {
					current = current.right;
					if (level == 0) {
						level = 1;
					}
					count += (1 << (level - 1));
				} else {
					current = current.left;
				}
			}
			return result + count;
		}

		private int getLevel(TreeNode rootp) {
			int result = 1;
			TreeNode root = rootp;
			while (root != null && root.left != null) {
				result++;
				root = root.left;
			}
			return result;
		}
	}

	public class SolutionLinear implements Solution {
		public int countNodes(TreeNode root) {
			int count = 0;
			LinkedList<TreeNode> currentLevel = new LinkedList<>();
			if (root != null) {
				currentLevel.offer(root);
				while (currentLevel.peek().left != null) {
					TreeNode node = currentLevel.pop();
					currentLevel.offer(node.left);
					if (node.right != null) {
						currentLevel.offer(node.right);
					}
					count++;
				}
			}
			return count + currentLevel.size();
		}
	}

	public static void main(String[] args) {
		CountCompleteTreeNodes c = new CountCompleteTreeNodes();
		Solution sol = c.new SolutionLgnSqr();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		System.out.println(sol.countNodes(root));
		
//		System.out.println((1<<4));

	}

}

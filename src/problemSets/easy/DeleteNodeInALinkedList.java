package problemSets.easy;

/**
 * Write a function to delete a node (except the tail) in a singly linked list,
 * given only access to that node.
 */
public class DeleteNodeInALinkedList {

	// Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public class Solution {
		public void deleteNode(ListNode node) {
			if (node != null && node.next != null) {
				ListNode temp = node;
				while (temp.next != null) {
					temp.val = temp.next.val;
					if (temp.next.next == null) {
						temp.next = null;
					} else {
						temp = temp.next;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

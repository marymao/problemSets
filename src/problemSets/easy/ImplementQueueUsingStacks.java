package problemSets.easy;

import java.util.Stack;

public class ImplementQueueUsingStacks {
	class MyQueue {
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> spare = new Stack<>();
		Integer front = null;

		// Push element x to the back of queue.
		public void push(int x) {
			while (!spare.isEmpty()) {
				stack.push(spare.pop());
			}
			if (front == null) {
				front = x;
			}
			stack.push(x);
		}

		// Removes the element from in front of queue.
		public void pop() {
			while (!stack.isEmpty()) {
				Integer i = stack.pop();
				spare.push(i);
			}
			if (!spare.isEmpty()) {
				spare.pop();
			}
			if (!spare.isEmpty()) {
				front = spare.peek();
			} else {
				front = null;
			}
		}

		// Get the front element.
		public int peek() {
			return front;
		}

		// Return whether the queue is empty.
		public boolean empty() {
			return stack.isEmpty() && spare.isEmpty();
		}
	}

	public static void main(String[] args) {
		ImplementQueueUsingStacks main = new ImplementQueueUsingStacks();
		MyQueue sol = main.new MyQueue();
		sol.push(1);
		sol.push(2);
		sol.pop();
		System.out.println(sol.peek());

	}
}

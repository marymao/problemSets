package problemSets.easy;

import java.util.LinkedList;

public class ImplementingStackUsingQueues {
	class MyStack {
		LinkedList<Integer> queue = new LinkedList<>();
		
	    // Push element x onto stack.
	    public void push(int x) {
	    	int i = queue.size();
	    	queue.add(x);
	    	while (i > 0) {
	    		queue.offer(queue.poll());
	    		i--;
	    	}
	    }

	    // Removes the element on top of the stack.
	    public void pop() {
	    	queue.pop();
	    }

	    // Get the top element.
	    public int top() {
	        return queue.getFirst();
	    }

	    // Return whether the stack is empty.
	    public boolean empty() {
	        return queue.isEmpty();
	    }
	}
}

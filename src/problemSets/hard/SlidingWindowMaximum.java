package problemSets.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

	public class Solution {
		public int[] maxSlidingWindow(int[] nums, int k) {
			int[] result = new int[nums.length - k + 1];
			Deque<Integer> maxes = new ArrayDeque<>();
			for (int i = 0; i < nums.length; i++) {
				// all entries smaller then newest entry will never be maximum
				// again
				while (maxes.size() > 0 && maxes.peekLast() < nums[i]) {
					maxes.removeLast();
				}
				maxes.offerLast(nums[i]);
				if (i < k - 1) {
					continue;
				}
				// get current largest
				result[i - k + 1] = maxes.peekFirst();
				// if the value of the one to be popped out next round ==
				// current largest, it must be the current largest itself (it
				// cannot be anyone else having the same value because it's
				// still in the window and an equal entry will not remove it
				// from the deque)
				if (nums[i - k + 1] == result[i - k + 1]) {
					maxes.removeFirst();
				}
			}
			return result;
		}
	}

	public class SolutionWrongAttempt {
		public int[] maxSlidingWindow(int[] nums, int k) {
			int max = 0;
			int nextMax = 0;
			LinkedList<Integer> maxPositions = new LinkedList<Integer>();
			LinkedList<Integer> nextMaxPositions = new LinkedList<Integer>();
			int[] result = new int[nums.length - k + 1];
			for (int i = 0; i < nums.length; i++) {
				if (i < k - 1) {
					if (nums[i] > max) {
						max = nums[i];
						maxPositions.clear();
						maxPositions.add(i);
					} else if (nums[i] == max) {
						maxPositions.add(i);
					} else if (nums[i] > nextMax) {
						nextMax = nums[i];
						nextMaxPositions.clear();
						nextMaxPositions.add(i);
					} else if (nums[i] == nextMax) {
						nextMaxPositions.add(i);
					}
				} else {
					if (i - k >= 0) {
						if (nums[i - k] == max) {

						}
					}
				}
			}
			return result;

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

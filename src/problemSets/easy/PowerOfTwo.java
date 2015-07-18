package problemSets.easy;

public class PowerOfTwo {
	public class Solution {
		public boolean isPowerOfTwo(int n) {
			return ((n & (n - 1)) == 0) && n >0;
		}
	}

	public static void main(String[] args) {
		PowerOfTwo main = new PowerOfTwo();
		Solution sol = main.new Solution();
		boolean t1 = sol.isPowerOfTwo(16);
		boolean t2 = sol.isPowerOfTwo(11);
		System.out.println(t1 && !t2);
	}

}

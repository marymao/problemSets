package problemSets.medium;

public class ProductOfArrayExceptSelf {

	public class Solution {
		public int[] productExceptSelf(int[] nums) {
			int[] result = new int[nums.length];
			for (int i = 0; i < result.length; i++) {
				result[i] = 1;
			}
			int temp = 1;
			for (int i = 0; i < nums.length - 1; i++) {
				temp *= nums[i];
				result[i + 1] = temp;
			}
			temp = 1;
			for (int i = nums.length - 1; i > 0; i--) {
				temp *= nums[i];
				result[i - 1] *= temp;
			}
			return result;
		}
	}

	public static void main(String[] args) {
		ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();
		Solution sol = p.new Solution();
		int[] nums = { 1, 2, 3, 4 };
		sol.productExceptSelf(nums);

	}

}

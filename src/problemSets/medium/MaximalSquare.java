package problemSets.medium;

public class MaximalSquare {

	public class Solution {
		public int maximalSquare(char[][] matrix) {
			if (matrix == null || matrix.length == 0) {
				return 0;
			}

			int result = 0;
			int[][] dp = new int[matrix.length][matrix[0].length];

			// initialize
			for (int i = 0; i < matrix.length; i++) {
				dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
				result = Math.max(result, dp[i][0]);
			}

			for (int i = 0; i < matrix[0].length; i++) {
				dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
				result = Math.max(result, dp[0][i]);
			}

			//
			for (int i = 1; i < matrix.length; i++) {
				for (int j = 1; j < matrix[0].length; j++) {
					if (matrix[i][j] == '0') {
						dp[i][j] = 0;
					} else if (matrix[i][j] == '1') {
						dp[i][j] = Math.min(
								Math.min(dp[i - 1][j], dp[i - 1][j - 1]),
								dp[i][j - 1]) + 1;
						result = Math.max(result, dp[i][j]);
					}
				}
			}

			return result * result;
		}
	}

	public static void main(String[] args) {
		MaximalSquare ms = new MaximalSquare();
		Solution sol = ms.new Solution();
		char[][] matrix = new char[1][1];
		matrix[0][0] = '1';
		System.out.println(sol.maximalSquare(matrix));
	}

}

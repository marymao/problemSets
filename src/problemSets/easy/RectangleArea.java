package problemSets.easy;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 *
 */
public class RectangleArea {

	public class Solution {
		public int computeArea(int A, int B, int C, int D, int E, int F, int G,
				int H) {
			int area = (C - A) * (D - B) + (G - E) * (H - F);
			long coverLen = (long) Math.min(C, G) - (long) Math.max(A, E);
			long coverHei = (long) Math.min(D, H) - (long) Math.max(B, F);
			if (coverLen <= 0 || coverHei <= 0)
				return area;
			else
				return (int) (area - coverLen * coverHei);

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

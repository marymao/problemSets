package problemSets.hard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TheSkylineProblem {

	public class Solution {
		public List<int[]> getSkyline(int[][] buildings) {
			TreeMap<Integer, Integer> keyPoints = new TreeMap<>();
			keyPoints.put(buildings[0][0], buildings[0][2]);
			keyPoints.put(buildings[0][1], 0);
			for (int i = 0; i < buildings.length; i++) {
				int[] currentBuilding = buildings[i];
				Entry<Integer, Integer> beforeStart = keyPoints
						.floorEntry(currentBuilding[0]);
				if (keyPoints.lastEntry() == beforeStart) {
					if (beforeStart.getKey() != currentBuilding[0]) {
						// new cluster
						keyPoints.put(currentBuilding[0], currentBuilding[2]);
						keyPoints.put(currentBuilding[1], 0);
					} else {
						// change endpoint
						beforeStart.setValue(currentBuilding[2]);
						keyPoints.put(currentBuilding[1], 0);
					}
				} else {
					// process start line
					Entry<Integer, Integer> afterStart = keyPoints
							.higherEntry(currentBuilding[0]);
					assert afterStart.getValue() < beforeStart.getValue();
					if (afterStart.getValue() < currentBuilding[2]) {
						if (afterStart.getKey() == currentBuilding[0]) {
							afterStart.setValue(currentBuilding[2]);
						} else {
							keyPoints.put(currentBuilding[0],
									currentBuilding[2]);
						}
					} else {
						// continue;
					}
					// process end line
					Entry<Integer, Integer> beforeEnd = keyPoints
							.floorEntry(currentBuilding[1]);
					if (beforeEnd.getValue() >= currentBuilding[2]) {
						// continue;
					} else {
						Entry<Integer, Integer> temp = beforeEnd;
						while (temp.getValue() < currentBuilding[2]) {
							keyPoints.remove(temp.getKey());
							temp = keyPoints.floorEntry(temp.getKey());
						}
						keyPoints.put(currentBuilding[1], beforeEnd.getValue());
					}
				}
			}
			List<int[]> result = new LinkedList<>();
			for (Entry<Integer, Integer> entry : keyPoints.entrySet()) {
				int[] e = { entry.getKey(), entry.getValue() };
				result.add(e);
			}
			return result;
		}
	}

	public class SolutionWrongAttempt {
		public List<int[]> getSkyline(int[][] buildings) {

			ArrayList<int[]> keyPoints = new ArrayList<>();
			TreeMap<Integer, Integer> endPoints = new TreeMap<Integer, Integer>();
			int[] currentStartPoint = { buildings[0][0], buildings[0][2] };
			int[] currentEndPoint = { buildings[0][1], buildings[0][2] };
			keyPoints.add(currentStartPoint);
			endPoints.put(currentEndPoint[0], currentEndPoint[1]);
			// keyPoints.add(secondKeyPoint);
			for (int i = 1; i < buildings.length; i++) {
				int[] currentBuilding = buildings[i];
				// if current building covering previous building, update the
				// height of the current point
				if (currentBuilding[0] == currentStartPoint[0]
						&& currentBuilding[2] > currentStartPoint[1]) {
					currentStartPoint[1] = currentBuilding[2];
					// } else if (currentBuilding[0] < endPoints.lastKey()){
					// calculate all the endpoints less than current startpoint
				} else {
					Iterator<Integer> it = endPoints.descendingKeySet()
							.iterator();
					while (it.hasNext()) {
						Integer itx = it.next();
						if (itx < currentBuilding[0]) {

						}
					}
				}
			}
			return keyPoints;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

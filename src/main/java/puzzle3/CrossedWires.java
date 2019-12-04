package puzzle3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class CrossedWires {

	private Wire wire1;
	private Wire wire2;
	
	public int findShortestCrossPoint(String[] wire1Positions, String[] wire2Positions) {
		initializeWires(wire1Positions, wire2Positions);
		
		performWireMoves();
		
		ArrayList<Point> crossPoints = findCrossPoint();
		return calculateCloserCrossPoint(crossPoints);
	}


	private void performWireMoves() {
		wire1.performMoves();
		wire2.performMoves();
	}


	private void initializeWires(String[] wire1Positions, String[] wire2Positions) {
		wire1 = new Wire(wire1Positions);
		wire2 = new Wire(wire2Positions);
	}
	

	private ArrayList<Point> findCrossPoint() {
		removeWiresDuplicatesPositions();
		return wire1.findCrossPoints(wire2);
	}


	private void removeWiresDuplicatesPositions() {
		wire1.removeDuplicates();
		wire2.removeDuplicates();
	}
	
	private int calculateCloserCrossPoint(ArrayList<Point> crossPoints) {
		ArrayList<Integer> manhattanDistances = calculateManhattanDistance(crossPoints);
		Collections.sort(manhattanDistances);
		System.out.println("manhattanDistances="+manhattanDistances);
		return manhattanDistances.get(0);
	}


	private ArrayList<Integer> calculateManhattanDistance(ArrayList<Point> crossPoints) {
		return (ArrayList<Integer>) crossPoints.stream().map(point -> point.getManhattanDistance()).collect(Collectors.toList());
	}
}

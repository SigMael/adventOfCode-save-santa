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
		
		ArrayList<Point> crossPoints = findCrossPoints();

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
	

	private ArrayList<Point> findCrossPoints() {
		removeWiresDuplicatesPositions();
		return wire1.findCrossPoints(wire2);
	}


	private void removeWiresDuplicatesPositions() {
		wire1.removeDuplicates();
		wire2.removeDuplicates();
	}
	
	private int calculateCloserCrossPoint(ArrayList<Point> crossPoints) {
		var manhattanDistances = calculateManhattanDistance(crossPoints);
		var reevaluatedDistances = getOptimisedWireDistances(crossPoints);
		Collections.sort(manhattanDistances);
		System.out.println(manhattanDistances);
		System.out.println(reevaluatedDistances);
		return manhattanDistances.get(0);
	}

	private Integer getOptimisedWireDistances(ArrayList<Point> crossPoints) {
		Integer bestCombination = wire1.getPositions().size() + wire2.getPositions().size();
		for (Point crossPoint :crossPoints) {
			int nbStepWire1 = getNumberOfSteps(crossPoint, wire1);
			int nbStepWire2 = getNumberOfSteps(crossPoint, wire2);
			if(nbStepWire1 + nbStepWire2 < bestCombination){
				bestCombination = nbStepWire1 + nbStepWire2;
			}
		}
		return  bestCombination;
	}

	private int getNumberOfSteps(Point crossPoint, Wire wire) {
		int nbStepWire = 0;
		for (Point wirePoint: wire.getPositions() ) {
			nbStepWire ++;
			if(wirePoint.equals(crossPoint)){
				break;
			}
		}
		return nbStepWire;
	}


	private ArrayList<Integer> calculateManhattanDistance(ArrayList<Point> crossPoints) {
		return (ArrayList<Integer>) crossPoints.stream().map(point -> point.getManhattanDistance()).collect(Collectors.toList());
	}
}

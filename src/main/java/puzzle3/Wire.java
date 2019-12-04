package puzzle3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class Wire {

	private ArrayList<Directions> directions;
	private ArrayList<Integer> moves;
	private ArrayList<Point> positions;
	private Point currentPosition;
	
	public Wire(String[] wirePositions){
		initLists(wirePositions);
		this.currentPosition  = new Point (0,0);
		setPositions(new ArrayList<>());
	}

	private void initLists(String[] wirePositions) {
		extractDirections(wirePositions);
		extractMoves(wirePositions);
	}

	private void extractMoves(String[] wirePositions) {
		this.moves = (ArrayList<Integer>) Arrays.asList(wirePositions).stream().map(str -> Integer.parseInt(str.substring(1, str.length()))).collect(Collectors.toList());
	}

	private void extractDirections(String[] wirePositions) {
		this.directions = (ArrayList<Directions>) Arrays.asList(wirePositions).stream().map(str -> Directions.valueOf(str.substring(0, 1))).collect(Collectors.toList());
	}

	public void performMoves() {
		for (int i = 0; i < directions.size(); i++) {
			fillWirePositions(i);
		}
	}

	private void fillWirePositions(int index) {
		int numberOfMoves = moves.get(index);
		getPositions().addAll(directions.get(index).getMoves(directions.get(index), numberOfMoves, currentPosition));
		this.setCurrentPosition(getNewCurrentPosition());
	}
	
	public LinkedHashSet<Point> removeDuplicates() {
		return new LinkedHashSet<>(this.getPositions());
	}

	private Point getNewCurrentPosition() {
		return getPositions().get(getPositions().size() -1 );
	}

	public Point getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Point currentPosition) {
		this.currentPosition = currentPosition;
	}

	public ArrayList<Point> getPositions() {
		return positions;
	}

	public void setPositions(ArrayList<Point> positions) {
		this.positions = positions;
	}

	public ArrayList<Directions> getDirections() {
		return directions;
	}

	public void setDirections(ArrayList<Directions> directions ) {
		this.directions = directions;
	}

	public ArrayList<Point> findCrossPoints(Wire wireToCompare) {
		var crossPoints = new ArrayList<Point>();
		for (Point point : this.positions) {
			for(Point pointToCompare: wireToCompare.positions) {
				if (point.equals(pointToCompare)){
					crossPoints.add(point);
				}	
			}
		}
		return crossPoints;
	}
	
}
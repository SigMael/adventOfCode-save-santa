package puzzle3;

import java.util.ArrayList;
import java.util.List;

public enum Directions {
	U,
	D,
	L,
	R;
	
	public List<Point> getMoves(Directions direction, Integer numberOfMoves, Point currentPoint){		
		switch (direction) {
		case U:
			return getUpMove(numberOfMoves, currentPoint);
		case D:
			return getDownMove(numberOfMoves, currentPoint);
		case L:
			return getLeftMove(numberOfMoves, currentPoint);
		case R:
			return getRightMove(numberOfMoves, currentPoint);
		default:
			return null;
		}
	}
	
	private List<Point> getUpMove(Integer numOfMoves, Point currentPoint) {
		var movePositions = new ArrayList<Point>();
		int x = currentPoint.getX();
		int y = currentPoint.getY();
		
		for (int i = 0; i < numOfMoves; i++) {
			y++;
			movePositions.add(new Point(x, y));
		}
		return movePositions;
	}
	
	private List<Point> getDownMove(Integer numOfMoves, Point currentPoint) {
		var movePositions = new ArrayList<Point>();
		int x = currentPoint.getX();
		int y = currentPoint.getY();
		for (int i = 0; i < numOfMoves; i++) {
			y--;
			movePositions.add(new Point(x, y));
		}
		return movePositions;
	}
	
	private List<Point> getLeftMove(Integer numOfMoves, Point currentPoint) {
		var movePositions = new ArrayList<Point>();
		int x = currentPoint.getX();
		int y = currentPoint.getY();
		
		for (int i = 0; i < numOfMoves; i++) {
			x--;
			movePositions.add(new Point(x, y));
		}
		return movePositions;
	}
	
	private List<Point> getRightMove(Integer numOfMoves, Point currentPoint) {
		var movePositions = new ArrayList<Point>();
		int x = currentPoint.getX();
		int y = currentPoint.getY();
		
		for (int i = 0; i < numOfMoves; i++) {
			x++;
			movePositions.add(new Point(x, y));
		}
		return movePositions;
	}





}

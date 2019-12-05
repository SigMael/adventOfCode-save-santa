package puzzle3;

import java.util.ArrayList;
import java.util.List;

public enum Directions {
	U,
	D,
	L,
	R;
	
	public List<Point> getMoves(Directions direction, Integer numberOfMoves, Point currentPoint){
		var movePositions = new ArrayList<Point>();
		int x = currentPoint.getX();
		int y = currentPoint.getY();

		for (int i = 0; i < numberOfMoves; i++) {
			switch (direction) {
			case U:
				y++;
				break;
			case D:
				y--;
				break;
			case L:
				x--;
				break;
			case R:
				x++;
				break;
			default:
				return null;
			}
			movePositions.add(new Point(x, y));
		}
		return movePositions;

	}

}

package puzzle3;

public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Integer getManhattanDistance() {
		return getAbsoluteValue(x)+ getAbsoluteValue(y);
	}

	private Integer getAbsoluteValue(int val) {
		Double absoluteValue = Math.sqrt(val * val);
		return absoluteValue.intValue();
	}

	public boolean equals(Point toComparePoint) {
		return toComparePoint.getX() == this.x && toComparePoint.getY() == this.y;
	}
	
	public String toString() {
		return "[" + this.x + ", " + this.y + "]";
	}
	
	public int getY() {
		return y;
	}
	public int getX() {
		return x;
	}
}

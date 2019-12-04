package puzzle3;

public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Integer getManhattanDistance() {
		System.out.println(x+y);
		return x + y;
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
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
}

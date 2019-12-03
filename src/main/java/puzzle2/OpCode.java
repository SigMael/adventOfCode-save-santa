package puzzle2;

public class OpCode {
	private int starter;
	private int position1;
	private int position2;
	private int positionToReplace;
	
	
	public OpCode(int starter, int position1, int position2, int positionToReplace) {
		this.starter = starter;
		this.setPosition1(position1);
		this.setPosition2(position2);
		this.setPositionToReplace(positionToReplace);
	}
	
	public String toString() {
		return "["+ this.starter + "," + this.position1 + "," + this.position2 + "," + this.positionToReplace  + "]";
	}

	public int getStarter() {
		return starter;
	}

	public void setStarter(int starter) {
		this.starter = starter;
	}

	public int getPosition1() {
		return position1;
	}

	public void setPosition1(int position1) {
		this.position1 = position1;
	}

	public int getPosition2() {
		return position2;
	}

	public void setPosition2(int position2) {
		this.position2 = position2;
	}

	public int getPositionToReplace() {
		return positionToReplace;
	}

	public void setPositionToReplace(int positionToReplace) {
		this.positionToReplace = positionToReplace;
	}

}

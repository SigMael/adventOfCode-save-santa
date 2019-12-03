package puzzle2;

public class OpCode {
	private int starter;
	private int leftVal;
	private int rightVal;
	private int positionToReplace;
	
	public OpCode(){}

	public OpCode(int starter, int position1, int position2, int positionToReplace) {
		this.starter = starter;
		this.setLeftVal(position1);
		this.setRightVal(position2);
		this.setPositionToReplace(positionToReplace);
	}
	
	public String toString() {
		return "["+ this.starter + "," + this.leftVal + "," + this.rightVal + "," + this.positionToReplace  + "]";
	}

	public int getStarter() {
		return starter;
	}

	public void setStarter(int starter) {
		this.starter = starter;
	}

	public int getLeftVal() {
		return leftVal;
	}

	public void setLeftVal(int leftVal) {
		this.leftVal = leftVal;
	}

	public int getRightVal() {
		return rightVal;
	}

	public void setRightVal(int rightVal) {
		this.rightVal = rightVal;
	}

	public int getPositionToReplace() {
		return positionToReplace;
	}

	public void setPositionToReplace(int positionToReplace) {
		this.positionToReplace = positionToReplace;
	}

}

package puzzle2;

public class IntCode {
	private static final int FACTOR = 2;
	private static final int SUM = 1;
	private int indexOpCode = 0;
	private OpCode currentOpCodes;
		

	public int[] process(int[] inputCode) {
		if(isValidStarter(inputCode[0])){
			do {
				this.currentOpCodes = readOpCode(inputCode);
				if(this.currentOpCodes == null)
					break;
				inputCode = processOpCode(inputCode);
				for (int i : inputCode) {
					System.out.print(","+i);
				}

				indexOpCode ++;
			} while (this.currentOpCodes != null);
		}
		else {
			return null;
		}
		return inputCode;
	}

	private OpCode readOpCode(int[] inputCode) {
		int realIndex = 0 + (4*indexOpCode);
		if(isValidIndexAndStarter(inputCode, realIndex)) {
			return new OpCode(inputCode[0 + realIndex], inputCode[1 + realIndex], inputCode[2 + realIndex], inputCode[3 + realIndex]);			
		} else {
			return null;
		}
	}

	private boolean isValidIndexAndStarter(int[] inputCode, int realIndex) {
		return realIndex < inputCode.length && isValidStarter(inputCode[0 + realIndex]);
	}


	private int[] processOpCode(int[] inputCode) {
		int starter = currentOpCodes.getStarter();
		int positionToReplace = inputCode[currentOpCodes.getPositionToReplace()];
		int leftVal = inputCode[inputCode[currentOpCodes.getPosition1()]];
		int rightVal = inputCode[inputCode[currentOpCodes.getPosition2()]];
		if(isSum(starter)) {
			inputCode[positionToReplace] = leftVal + rightVal;
		}
		else if(isFactor(starter)) {
			inputCode[positionToReplace] = leftVal * rightVal;
		}
		return inputCode;
	}

	private boolean isValidStarter(int starter) {
		return isSum(starter) || isFactor(starter);
	}

	private boolean isFactor(int starter) {
		return starter  == FACTOR;
	}

	private boolean isSum(int starter) {
		return starter == SUM;
	}

	public int getOperationType() {
		return indexOpCode;
	}

	public void setOperationType(int operationType) {
		this.indexOpCode = operationType;
	}


}

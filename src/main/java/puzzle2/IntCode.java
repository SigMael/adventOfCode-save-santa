package puzzle2;

public class IntCode {
	private static final int FACTOR = 2;
	private static final int SUM = 1;
	public static final int OP_CODE_SIZE = 4;
	public static final int HALT_OP_CODE = 99;
	private int opCodeIndex = 0;
	private int nextStarter = 0;
	private OpCode currentOpCode;
	private int [] intCode;

	public IntCode(){
		this.currentOpCode = new OpCode();
	}

	public int[] process() {
		if(isValidStarter(intCode[0])){
			fetchAndProcessOpCodes();
		}
		else {
			return null;
		}
		return intCode;
	}

	private void fetchAndProcessOpCodes() {
		do {
			processNextOpCode();
		} while (isNextStarterOk(nextStarter));
	}

	private void processNextOpCode() {
		currentOpCode = initOpCode();
		if(starterIsSum()) {
			processOpCodeSum();
		}
		else if(starterIsFactor()) {
			processOpCodeFactor();
		}
		updateIndexes();
	}

	private OpCode initOpCode() {
		return new OpCode(intCode[0 + opCodeIndex],intCode[intCode[1 + opCodeIndex]],intCode[intCode[2 + opCodeIndex]],intCode[3 + opCodeIndex] );
	}

	private void processOpCodeSum() {
		intCode[currentOpCode.getPositionToReplace()] = currentOpCode.getLeftVal() + currentOpCode.getRightVal();
	}

	private void processOpCodeFactor() {
		intCode[currentOpCode.getPositionToReplace()] = currentOpCode.getLeftVal() * currentOpCode.getRightVal();
	}

	private void updateIndexes() {
		nextStarter = intCode[opCodeIndex + OP_CODE_SIZE];
		opCodeIndex += OP_CODE_SIZE;
	}

	private boolean isNextStarterOk(int nextStarter) {
		return nextStarter != HALT_OP_CODE;
	}

	private boolean isValidStarter(int starter) {
		currentOpCode.setStarter(starter);
		return starterIsSum() || starterIsFactor();
	}

	private boolean starterIsFactor() {
		return currentOpCode.getStarter()  == FACTOR;
	}

	private boolean starterIsSum() {
		return currentOpCode.getStarter() == SUM;
	}

	public void setIntCode(int[] intCode) {
		this.intCode = intCode;
	}
}

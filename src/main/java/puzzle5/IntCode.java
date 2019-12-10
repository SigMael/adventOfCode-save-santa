package puzzle5;

public class IntCode {

	public void process(int [] initialState, Integer input) {
		int i = 0 , length = initialState.length;

		outerLoop:
		while (i<length){
			int opCode = initialState[i] % 100;
			int aMode = initialState[i] / 100 % 10;
			int bMode = initialState[i] / 1000 % 10;
			switch (opCode){
				case 1:
					initialState[initialState[i + 3]] = (aMode == 1 ? initialState[i + 1] : initialState[initialState[i + 1]]) + (bMode == 1 ? initialState[i + 2] : initialState[initialState[i + 2]]);
					i +=4;
					break;
				case 2:
					initialState[initialState[i + 3]] = (aMode == 1 ? initialState[i + 1] : initialState[initialState[i + 1]]) * (bMode == 1 ? initialState[i + 2] : initialState[initialState[i + 2]]);
					i +=4;
					break;
				case 3:
					initialState[initialState[i+1]] = input;
					i +=2;
					break;
				case 4:
					System.out.println(initialState[initialState[ i + 1]]);
					i +=2;
					break;
				case 5:
					if ((aMode == 1) ? (initialState[i + 1] != 0) : (initialState[initialState[i + 1]] != 0)){
						i = (bMode == 1 ? initialState[i + 2] : initialState[initialState[i + 2]]);
					}
					else {
						i += 3;
					}
					break;
				case 6:
					if ((aMode == 1) ? (initialState[i + 1] == 0) : (initialState[initialState[i + 1]] == 0)){
						i = (bMode == 1 ? initialState[i + 2] : initialState[initialState[i + 2]]);
					}
					else {
						i += 3;
					}
					break;
				case 7:
					if ((aMode == 1 ? initialState[i + 1] : initialState[initialState[i + 1]]) < (bMode == 1 ? initialState[i + 2] : initialState[initialState[i + 2]])){
						initialState[initialState[i + 3]] = 1;
					}
					else {
						initialState[initialState[i + 3]] = 0;
					}
					i += 4;
					break;
				case 8:
					if ((aMode == 1 ? initialState[i + 1] : initialState[initialState[i + 1]]) == (bMode == 1 ? initialState[i + 2] : initialState[initialState[i + 2]])){
						initialState[initialState[i + 3]] = 1;
					}
					else{
						initialState[initialState[i + 3]] = 0;
					}
					i += 4;
					break;
				case 99:
					break outerLoop;
				default:
					break outerLoop;
			}
		}

	}
}

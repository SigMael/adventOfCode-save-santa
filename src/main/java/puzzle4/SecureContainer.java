package puzzle4;

public class SecureContainer {

    public static final int VALID_NB_OF_DIGIT = 6;
    public boolean oneDoubleExist = false;

    public Integer processValidPasswords(String input) {
        String leftValue = input.split("-")[0];
        String rightValue = input.split("-")[1];
        Integer numberOfValidPasswords = 0;

        if(!isAValidPasswordSize(leftValue) || !isAValidPasswordSize(rightValue))
            return 0;

        for (Integer i = convertToInteger(leftValue); i <= convertToInteger(rightValue); i++) {
            numberOfValidPasswords += controlCurrentPassword(i);
        }

        return numberOfValidPasswords;
    }

    private Integer controlCurrentPassword(Integer i) {
        oneDoubleExist = false;
        Integer numberOfValidPassword = 0;

        String testedPassword = i.toString();
        if(isAValidPasswordSize(testedPassword)){
            controlPasswordConditions(testedPassword);
            if(oneDoubleExist){
                numberOfValidPassword ++;
            }
        }
        return numberOfValidPassword;
    }

    private void controlPasswordConditions(String testedPassword) {
        int occurenceChar = 1;
        for (int j = 0; j < testedPassword.length() - 1; j++) {
            String currentChar = testedPassword.substring(j,j+1);
            String nextChar = testedPassword.substring(j+1,j+2);
            if(!oneDoubleExist){
                occurenceChar = controlDoubleConditions(occurenceChar, currentChar, nextChar);
            }

            if(j == testedPassword.length() -2 && occurenceChar == 2){
                oneDoubleExist = true;
            }

            if (controlIsNextCharInferior(currentChar, nextChar)){
                oneDoubleExist = false;
                break;
            }
        }
    }

    private int controlDoubleConditions(int occurenceChar, String currentChar, String nextChar) {
        if(currentChar.equals(nextChar)){
            occurenceChar++;
        }
        else if(!currentChar.equals(nextChar) && occurenceChar == 2){
            oneDoubleExist = true;
        }
        else {
            occurenceChar = 1;
            oneDoubleExist = false;
        }
        return occurenceChar;
    }

    private boolean controlIsNextCharInferior(String currentChar, String nextChar) {
        if(Integer.parseInt(currentChar) > Integer.parseInt(nextChar)){
            return true;
        }
        return false;
    }

    private boolean isAValidPasswordSize(String value) {
        return value.length() == VALID_NB_OF_DIGIT;
    }

    private int convertToInteger(String leftValue) {
        return Integer.parseInt(leftValue);
    }

}

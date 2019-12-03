package puzzle1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

import puzzle2.IntCode;

public class OpCodeTest {

	private IntCode intCode;	
	
	@Before
	public void initTest() {
		intCode = new IntCode();
	}
	
	@org.junit.Test
    public void should_return_nothing_if_first_number_is_99()
    {    
		int[] inputCode = {99,0,0,0,99};
		Object expectedOutput = null;
		var calculatedOpCode = intCode.process(inputCode);
		
		assertEquals(expectedOutput, calculatedOpCode);
    }
	
	@org.junit.Test
    public void should_return_expected_opCode_with_input_1_0_0_0_99()
    {    
		int[] inputCode = {1,0,0,0,99};
		var expectedOutput = new int[] {2,0,0,0,99};
		var calculatedOutput = intCode.process(inputCode);
		
		for (int i = 0; i < calculatedOutput.length; i++) {
			assertEquals(expectedOutput[i], calculatedOutput[i]);			
		}
    }
	
	@org.junit.Test
    public void should_return_expected_opCode_with_input_2_3_0_3_99()
    {    
		int[] inputCode = {2,3,0,3,99};
		var expectedOutput = new int[] {2,3,0,6,99};
		var calculatedOutput = intCode.process(inputCode);
		
		for (int i = 0; i < calculatedOutput.length; i++) {
			assertEquals(expectedOutput[i], calculatedOutput[i]);			
		}
    }
	
	@org.junit.Test
    public void should_return_expected_opCode_with_input_1_1_1_4_99_5_6_0_99()
    {    
		int[] inputCode = {1,1,1,4,99,5,6,0,99 };
		var expectedOutput = new int[] {30,1,1,4,2,5,6,0,99};
		var calculatedOutput = intCode.process(inputCode);
		
		for (int i = 0; i < calculatedOutput.length; i++) {
			assertEquals(expectedOutput[i], calculatedOutput[i]);			
		}
    }
}

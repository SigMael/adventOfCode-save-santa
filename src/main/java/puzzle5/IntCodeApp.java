package puzzle5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class IntCodeApp 
{

	public static void main( String[] args ) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		var initialState = Arrays.stream(r.readLine().split(",")).mapToInt(Integer::parseInt).toArray();;
		var intCode = new IntCode();
		intCode.process(initialState, 5);
    }
}

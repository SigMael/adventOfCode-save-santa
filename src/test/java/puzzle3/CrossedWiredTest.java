package puzzle3;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CrossedWiredTest {
	
	private CrossedWires crossedWires;
	
	@Before
	public void initTest() {
		crossedWires = new CrossedWires();
	}
	
	@Test
	public void should_return_6_when_givenInput() {
		
		int expectedLength = 6;
		
		String[] wire1 = {"R8", "U5", "L5", "D3"};
		String[] wire2 = {"U7", "R6", "D4", "L4"};
		assertEquals(expectedLength, crossedWires.findShortestCrossPoint(wire1, wire2));
	}
	
	@Test
	public void should_return_159_when_givenInput() {
			int expectedLength = 159;
			String[] wire1 = {"R75","D30","R83","U83","L12","D49","R71","U7","L72"};
			String[] wire2 = {"U62","R66","U55","R34","D71","R55","D58","R83"};
			assertEquals(expectedLength, crossedWires.findShortestCrossPoint(wire1, wire2));
		}
	
	@Test
	public void should_return_135_when_givenInput() {
		
		int expectedLength = 135;
		
		String[] wire1 = {"R98","U47","R26","D63","R33","U87","L62","D20","R33","U53","R51"};
		String[] wire2 = {"U98","R91","D20","R16","D67","R40","U7","R15","U6","R7"};
		assertEquals(expectedLength, crossedWires.findShortestCrossPoint(wire1, wire2));
	}
		
}

package puzzle1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FuelEngine {
	
	public Integer processFuelQuantity(ArrayList<Mass> masses) {
		if(isMassesValid(masses)) {
			List<Integer> fuels = calculateFuels(masses);
			return calculateTotalFuel(fuels);
		}
		return 0;
	}

	private boolean isMassesValid(ArrayList<Mass> masses) {
		return masses != null && !masses.isEmpty();
	}
	
	
	private List<Integer> calculateFuels(ArrayList<Mass> masses) {
		return masses.stream().map(mass -> mass.calculateTotalFuel(mass.getValue())).collect(Collectors.toList());
	}

	private int calculateTotalFuel(List<Integer> fuels) {
		return fuels.stream().mapToInt(fuel -> fuel).sum();
	}

	
}

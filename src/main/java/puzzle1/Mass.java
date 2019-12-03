package puzzle1;

public class Mass {
	private Integer value;

	public Mass(Integer newMass) {
		this.value = newMass;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer calculateTotalFuel(Integer fuelToHandle) {
		if(fuelToHandle <= 0) {
			return 0;
		}
		if(convertMassToFuel(fuelToHandle)<0) {
			return calculateTotalFuel(convertMassToFuel(fuelToHandle));
		}
		return convertMassToFuel(fuelToHandle) + calculateTotalFuel(convertMassToFuel(fuelToHandle));
	}

	private int convertMassToFuel(Integer fuelToHandle) {
		return (int) Math.floor((fuelToHandle/ 3)) - 2;
	}
	
}

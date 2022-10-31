package Cars;

import java.util.*;

public class Park {
	private List<Car> cars;

	public List<Car> getCars(){
		return cars;
	}
	Park(){
		cars = new ArrayList<>();
	}
	Park(List<Car> cars){
		this.cars = cars;
	}
}

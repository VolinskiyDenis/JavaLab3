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

	public void addCar(Car car){
		cars.add(car);
	}
}

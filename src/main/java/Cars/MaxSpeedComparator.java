package Cars;

import java.util.Comparator;

public class MaxSpeedComparator implements Comparator<Car> {
	@Override
	public int compare(Car car1,Car car2){
		return car2.getMaxSpeed()-car1.getMaxSpeed();
	}
}

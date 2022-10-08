package Cars;

import java.util.List;

public class Main {
	public static void main(String[] args){
		Car bmw1 = new Car.Builder(Brand.BMW,"AC6776BM","X6",270)
				.setColor("red")
				.setHolder("Evgen Zaliznyak")
				.buidl();
		Car audi1 = new Car.Builder(Brand.Audi,"AA4792BO","A6",280)
				.setColor("gray")
				.setCurrentSpeed(20)
				.setHolder("Denis Volinskiy")
				.buidl();
		Car bmw2 = new Car.Builder(Brand.Mercedes_Benz,"AO6009AB","Vito",150)
				.setColor("yellow")
				.setHolder("Ivan Semenyak")
				.buidl();
		Park park = new Park();
		park.addCar(bmw1);
		park.addCar(audi1);
		park.addCar(bmw2);
		try{
			bmw2.gas(200);
			bmw1.gas(400);
		}catch(RuntimeException e){
			System.out.println("Перевищена максимальна швидкість або швидксть менша нуля");
		}
		List<Car> ourCars = park.getCars();
		for(Car car :ourCars){
			System.out.println(car.toString() + "\n");
		}
		System.out.println(bmw2.toString());
	}
}

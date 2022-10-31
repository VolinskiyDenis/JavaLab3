package Cars;

public class Main {
	public static void main(String[] args){
		Car bmw1 = new Car.Builder(Brand.BMW,"AC6776BM","X6",270)
				.setColor("red")
				.setOwner("Evgen Zaliznyak")
				.buidl();
		Car mercedes1 = new Car.Builder(Brand.Mercedes_Benz,"AO6009AB","Vito",280)
				.setColor("yellow")
				.setOwner("Ivan Semenyak")
				.buidl();
		Car audi1 = new Car.Builder(Brand.Audi,"AA4792BO","A6",260)
				.setColor("gray")
				.setCurrentSpeed(20)
				.setOwner("Denis Volinskiy")
				.buidl();
		Park park = new Park();
		ParkService parkService = new ParkService(park);
		parkService.addCar(bmw1);
		parkService.addCar(audi1);
		parkService.addCar(mercedes1);

		System.out.println("Comparable:\n" + parkService.sortByBrand());

		System.out.println("Comparator:\n"+ parkService.sortByMaxSpeed());

		Park clearPark = new Park(parkService.clearPark());
		ParkService clearParkService = new ParkService(clearPark);
		clearParkService.addCar(audi1);
		System.out.println("Clear and add one:\n" + clearParkService.getCars());
	}
}

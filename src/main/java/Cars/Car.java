package Cars;

public class Car implements Comparable<Car>{
	/**
	 * plateNumber looks like AA0000BB
	 * plateNumber and model are required fields,
	 * rest fields are optionally
	 */
	private Brand brand;
	private String plateNumber;
	private final String model;
	private String color;
	private final int maxSpeed;
	private int currentSpeed;
	private String owner;

	/**
	 * below there are static class Builder which contains two required fields and four optional
	 */
	public static class Builder {
		private Brand brand;
		private String plateNumber;
		private String model;
		private String color = "white";
		private int maxSpeed;
		private int currentSpeed = 0;
		private String owner;

		/**
		 * @param plateNumber is car identifier which doesn't repeat.
		 * @param model       is car model.
		 *                    both parameters are required.
		 */
		public Builder(Brand brand, String plateNumber, String model, int maxSpeed){
			this.brand = brand;
			this.plateNumber = plateNumber;
			this.model = model;
			this.maxSpeed = maxSpeed;
			this.owner = owner;

		}

		/**
		 * @param color is a car color
		 * @return the same object Builder class
		 */
		public Car.Builder setColor(String color){
			this.color = color;
			return this;
		}

		/**
		 * @param currentSpeed is a variable of current speed of car and equals zero at initializing
		 * @return the same object Builder class
		 */
		public Car.Builder setCurrentSpeed(int currentSpeed){
			this.currentSpeed = currentSpeed;
			return this;
		}

		/**
		 * @param owner is car owner
		 * @return the same object Builder class
		 */
		public Car.Builder setOwner(String owner){
			this.owner = owner;
			return this;
		}

		/**
		 * this method call constructor outer class
		 *
		 * @return instance our class
		 */
		public Car buidl(){
			return new Car(this);
		}
	}

	/**
	 * @param builder give values to the instance
	 */
	public Car(Car.Builder builder){
		brand = builder.brand;
		plateNumber = builder.plateNumber;
		model = builder.model;
		color = builder.color;
		maxSpeed = builder.maxSpeed;
		currentSpeed = builder.currentSpeed;
		owner = builder.owner;
	}

	public String getPlateNumber(){
		return plateNumber;
	}

	public int getMaxSpeed(){
		return maxSpeed;
	}


	/**
	 * method increases value of currentSpeed value
	 */

	public void gas(int value) throws RuntimeException{
		if(currentSpeed + value > maxSpeed){
			throw new RuntimeException();
		}
		currentSpeed = currentSpeed + value;
		//System.out.println("Прискорюємось до " + getCurrentSpeed() + " КМ/год");
	}

	/**
	 * method decrease value of currentSpeed value
	 */

	public void brake(int value) throws RuntimeException{
		if(currentSpeed - value < 0){
			throw new RuntimeException();
		}
		currentSpeed = currentSpeed - value;
		//System.out.println("Уповільнюємось до " + getCurrentSpeed() + " КМ/год");
	}


	/**
	 * needs for watching at the instance
	 *
	 * @return string with all instance fields
	 */

	public String toString(){
		return "Марка: " + brand + "\tМодель: " + model + "\tКолір: " + color + "\tМакс. Швидкість: " + maxSpeed + "\tВласник: " + owner + "\tПоточна швидкість: " + currentSpeed;
	}

	public String getOwner(){
		return owner;
	}

	/**
	 * needs for HashMap and others
	 *
	 * @return integer
	 */

	public int hashCode(){
		return 31 * (plateNumber != null ? 0 : plateNumber.hashCode());
	}

	/**
	 * check that the instances match each other
	 *
	 * @param obj is a one of matching instances. The another call this method
	 * @return true if the instances are equal and false if not
	 */

	public boolean equals(Object obj){
		if(obj == null || obj.getClass() != this.getClass()) return false;
		else if(obj == this) return true;
		Car car = (Car) obj;
		return plateNumber == car.plateNumber || (plateNumber != null && plateNumber.equals(car.plateNumber));
	}

	@Override
	public int compareTo(Car c){
		return this.brand.compareTo(c.brand);
	}
}
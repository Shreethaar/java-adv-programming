public class Car {
	private String carName;
	private String carModel;
	private int carYear;

	public Car(String carName, String carModel, int carYear) {
		this.carName=carName;
		this.carModel=carModel;
		this.carYear=carYear;
	}

	public String getCarName() {
		return carName;
	}

	public String getCarModel() {
		return carModel;
	}

	public int getCarYear() {
		return carYear;
	}

	public void setCarName(String carName) {
		this.carName=carName;
	}

	public void setCarModel(String carModel) {
		this.carModel=carModel;
	}

	public void setCarYear(int carYear) {
		this.carYear=carYear;
	}

}


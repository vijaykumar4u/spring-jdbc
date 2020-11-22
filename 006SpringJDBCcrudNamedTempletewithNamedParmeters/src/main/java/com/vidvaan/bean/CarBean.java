package com.vidvaan.bean;

public class CarBean {
	private int carId;
	private String brandName;
	private String carName;
	private double carPrice;

	public CarBean() {

	}

	public CarBean(int carId, String brandName, String carName, double carPrice) {
		super();
		this.carId = carId;
		this.brandName = brandName;
		this.carName = carName;
		this.carPrice = carPrice;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public double getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}

	@Override
	public String toString() {
		return "CarBean [carId=" + carId + ", brandName=" + brandName + ", carName=" + carName + ", carPrice="
				+ carPrice + "]";
	}

}

package com.vidvaan.dao;

import java.util.List;
import java.util.Map;

import com.vidvaan.bean.CarBean;

public interface CarsDao {
	void inser(CarBean carBean);

	List<CarBean> getAllCars();

	void update(CarBean carBean);

	void deleteById(int id);

	Map<String, Float> getCars();

	List<CarBean> getAll();
}

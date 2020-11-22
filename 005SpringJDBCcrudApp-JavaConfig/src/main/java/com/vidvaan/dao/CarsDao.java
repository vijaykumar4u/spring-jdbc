package com.vidvaan.dao;

import java.util.List;

import com.vidvaan.bean.CarBean;

public interface CarsDao {
	void inser(CarBean carBean);
  List<CarBean> getAllCars();
  void update(CarBean carBean);
  void deleteById(int id);

}

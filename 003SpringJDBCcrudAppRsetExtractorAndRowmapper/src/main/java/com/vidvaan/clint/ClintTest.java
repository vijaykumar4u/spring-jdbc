package com.vidvaan.clint;

import java.util.Iterator;
import java.util.List;
import java.util.Map;import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vidvaan.bean.CarBean;
import com.vidvaan.dao.CarsDaoImpl;

public class ClintTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		CarsDaoImpl daoImpl = (CarsDaoImpl) context.getBean("dao");
//		List<CarBean> carsList = daoImpl.getAllCars();
//		for (CarBean carBean : carsList) {
//			System.out.println(carBean);
//		}
		// daoImpl.inser(new CarBean(45, "Tayota", "innova", 800015));

		// daoImpl.deleteById(45);
//		CarBean carBean = new CarBean();
//		carBean.setBrandName("Bugatti");
//		carBean.setCarId(6);
//		daoImpl.update(carBean);
//		Map<String, Float>cars =daoImpl.getCars();
//		for (Map.Entry<String, Float> entry : cars.entrySet()) {
//			
//			System.out.println(entry.getKey()+" <--------> "+entry.getValue());
//		}
		List<CarBean> carsList = daoImpl.getAll();//while fetching with beanproperty row mapper table property
		//names and bean properties names should be same if not we wont get errors we will get default values.
		for (CarBean carBean : carsList) {
			System.out.println(carBean);
		}
		
	}

}

package com.vidvaan.clint;

import java.awt.CardLayout;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vidvaan.bean.CarBean;
import com.vidvaan.configuration.AppConfig;
import com.vidvaan.dao.CarsDaoImpl;

public class ClintTest {
	public static void main(String[] args) {
		ApplicationContext context = new  AnnotationConfigApplicationContext(AppConfig.class);
		CarsDaoImpl daoImpl = (CarsDaoImpl) context.getBean(CarsDaoImpl.class);
		List<CarBean> carsList = daoImpl.getAllCars();
		for (CarBean carBean : carsList) {
			System.out.println(carBean);
		}
		// daoImpl.inser(new CarBean(45, "Tayota", "innova", 800015));

		// daoImpl.deleteById(45);
//		CarBean carBean = new CarBean();
//		carBean.setBrandName("Bugatti");
//		carBean.setCarId(6);
//		daoImpl.update(carBean);
	}

}

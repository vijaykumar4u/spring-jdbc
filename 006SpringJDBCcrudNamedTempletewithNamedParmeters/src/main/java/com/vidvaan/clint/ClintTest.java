package com.vidvaan.clint;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vidvaan.bean.CarBean;
import com.vidvaan.dao.CarsDaoImpl;

public class ClintTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		CarsDaoImpl daoImpl = (CarsDaoImpl) context.getBean("dao");
		// daoImpl.insert(new CarBean(420, "yamha", "ranzz", 780000));
		List<CarBean> listofCars=daoImpl.getwithNamedJdbcTemplete();
		for (CarBean carBean : listofCars) {
			System.out.println(carBean);
		}

//System.out.println(daoImpl.getById(420)); 
		// daoImpl.delete(420);
//		CarBean carBean = new CarBean();
//		carBean.setBrandName("Choron");
//		carBean.setCarName("sport");
//		carBean.setCarId(2);
//		daoImpl.update(carBean);

	}
}
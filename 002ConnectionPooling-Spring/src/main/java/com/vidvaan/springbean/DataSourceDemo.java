package com.vidvaan.springbean;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataSourceDemo {
	public static void main(String[] args) throws SQLException {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		DataSource dataSource1 = (DataSource) context.getBean("basicDataSource");
		System.out.println(dataSource1.getConnection());

		DataSource dataSource2 = (DataSource) context.getBean("driverManagerDataSource");
		System.out.println(dataSource2.getConnection());

	}

}

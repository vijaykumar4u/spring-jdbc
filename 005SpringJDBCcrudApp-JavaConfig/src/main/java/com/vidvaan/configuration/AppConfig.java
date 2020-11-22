package com.vidvaan.configuration;

import java.awt.CardLayout;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.vidvaan.dao.CarsDaoImpl;

@Configuration
@ComponentScan(basePackages = "com.vidvaan.*;")
@PropertySource(value = {"classpath:db.properties"})
public class AppConfig {
	@Autowired
	private Environment environment;
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("driver"));
		dataSource.setUrl(environment.getProperty("url"));
		dataSource.setUsername(environment.getProperty("uname"));
		dataSource.setPassword(environment.getProperty("password"));
		return dataSource;
		
	}
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		return jdbcTemplate;
		
		
	}
	@Bean
	public CarsDaoImpl getCarBean() {
		CarsDaoImpl carsDaoImpl = new CarsDaoImpl();
		return carsDaoImpl;
		
	}

}
